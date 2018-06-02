package com.hotel.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.hotel.db.DaoTemplate;
import com.hotel.db.DbUtil;
import com.hotel.db.Executor;
import com.hotel.model.Client;
import com.hotel.model.ClientHouse;

/**
 * Created by JW.
 * User: JW
 * Date: Dec 26, 2016 
 * Time: 10:41:51 PM
 *
 * com.hotel.service.ClientHouseService
 */
public class ClientHouseService {
	public static void loadService() {
		ClientHouseService service = new ClientHouseService();
		ServiceFactory.addService(ServiceFactory.CLIENT_HOUSE_SERIVCE, service);
	}

	private static final String getClientHouseInfoSql = "select count(*) as count from client_house where status = 1 and house_number=?";
	
	private static final String insertClientSql = "insert into client"
			+ "(id,name,identity,gender,batch_no,created_time,updated_time)"
			+ "values(?,?,?,?,?,?,?)";

	private static final String insertClientHouseSql = "insert into client_house"
			+ "(id,batch_no,house_number,house_thing,client_number,status,start_time,created_time,updated_time,house_type)"
			+ "values(?,?,?,?,?,?,?,?,?,?)";

	private static final String getClientHousesSql = "select id,batch_no,house_number,house_thing,client_number,"
			+ "status,start_time,end_time,created_time,updated_time,house_type"
			+ " from client_house where house_number like ? order by start_time desc";

	private static final String deleteClientAndHouseByHouseNumberSql = "update client_house set status=?,updated_time=?"
			+ " where house_number = ? and status != ?";

	private static final String deleteClientAndHouseById = "update client_house set status=?,updated_time=?"
			+ " where id=? and status !=?";
	
	private static final String updateClientAndHouseStatusByIdSql = "update client_house set status=?,end_time=?,updated_time=?"
			+ " where id = ?  and status = ?";
	
	private static final String updateClientAndHouseStatusByHouseNumberSql = "update client_house set status=?,end_time=?,updated_time=?"
			+ " where house_number = ?  and status = ?";
	
	private static final String getClientInfoByBatchNoSql = "select * from client where batch_no=?";

	public boolean addClientAndHouse(final List<Client> clients,
			final ClientHouse clientHouse) {
		final String batchNo = DbUtil.getUUID();
		final Date now = DbUtil.getNowTime();
		Executor<Boolean> executor = new Executor<Boolean>() {
			@Override
			public void execute(Connection conn) {
				PreparedStatement psmt = null;
				try {
					psmt = conn.prepareStatement(getClientHouseInfoSql);
					psmt.setString(1, clientHouse.getHouseNumber());
					ResultSet resultRest = psmt.executeQuery();
					resultRest.next();
					int count = resultRest.getInt("count");
					if(count > 0){
						this.setResult(false);
						JOptionPane.showMessageDialog(null,
								"登记失败,该房间已经被使用了！", "登记失败",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
					DbUtil.closeResultSet(resultRest);
					
					psmt = conn.prepareStatement(insertClientSql);
					int lenght = clients.size();
					for (int i = 0; i < lenght; i++) {
						Client client = clients.get(i);
						psmt.setString(1, DbUtil.getUUID());
						psmt.setString(2, client.getName());
						psmt.setString(3, client.getIdentity());
						psmt.setString(4, client.getGender());
						psmt.setString(5, batchNo);
						psmt.setTimestamp(6, new Timestamp(now.getTime()));
						psmt.setTimestamp(7, new Timestamp(now.getTime()));
						psmt.addBatch();
					}
					psmt.executeBatch();

					psmt = conn.prepareStatement(insertClientHouseSql);
					psmt.setString(1, DbUtil.getUUID());
					psmt.setString(2, batchNo);
					psmt.setString(3, clientHouse.getHouseNumber());
					psmt.setString(4, clientHouse.getHouseThing());
					psmt.setInt(5, clientHouse.getClientNumber());
					psmt.setInt(6, ClientHouse.STATUS.USED);
					psmt.setTimestamp(7, new Timestamp(now.getTime()));
					psmt.setTimestamp(8, new Timestamp(now.getTime()));
					psmt.setTimestamp(9, new Timestamp(now.getTime()));
					psmt.setString(10, clientHouse.getHouseType());
					psmt.execute();

					this.setResult(true);
				}catch (Exception e) {
					e.printStackTrace();
				}
				DbUtil.closePreparedStatement(psmt);
			}
		};

		DaoTemplate.execute(executor);

		return executor.getResult();
	}

	/**
	 * @param houseNumber
	 * @return
	 */
	public List<ClientHouse> getClientAndHouseByHouseNumber(
			final String houseNumber) {
		final List<ClientHouse> chs = new ArrayList<ClientHouse>();
		Executor<List<ClientHouse>> executor = new Executor<List<ClientHouse>>() {
			@Override
			public void execute(Connection conn) {
				PreparedStatement psmt = null;
				ResultSet resultSet = null;
				try {
					psmt = conn.prepareStatement(getClientHousesSql);
					psmt.setString(1, "%" + houseNumber + "%");
					resultSet = psmt.executeQuery();
					while (resultSet.next()) {
						String id = resultSet.getString("id");
						String batchNo = resultSet.getString("batch_no");
						String houseNumber = resultSet
								.getString("house_number");
						String houseThing = resultSet.getString("house_thing");
						int clientNumber = resultSet.getInt("client_number");
						int status = resultSet.getInt("status");
						String startTime = resultSet.getString("start_time");
						String endTime = resultSet.getString("end_time");
						String houseType = resultSet.getString("house_type");
						ClientHouse ch = new ClientHouse();
						ch.setId(id);
						ch.setBatchNo(batchNo);
						ch.setHouseNumber(houseNumber);
						ch.setHouseThing(houseThing);
						ch.setClientNumber(clientNumber);
						ch.setStartTime(startTime);
						ch.setEndTime(endTime);
						ch.setStatus(status);
						ch.setHouseType(houseType);
						chs.add(ch);
					}
					
					for(int i = 0; i < chs.size();i++){
						String batchNo = chs.get(i).getBatchNo();
						psmt = conn.prepareStatement(getClientInfoByBatchNoSql);
						psmt.setString(1, batchNo);
						resultSet = psmt.executeQuery();
						while(resultSet.next()){
							String name = resultSet.getString("name");
							String identity  = resultSet.getString("identity"); 
							String gender  = resultSet.getString("gender"); 
							Client client = new Client();
							client.setName(name);
							client.setIdentity(identity);
							client.setGender(gender);
							chs.get(i).getClients().add(client);
						}
					}
					
					this.setResult(chs);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				DbUtil.closeResultSet(resultSet);
				DbUtil.closePreparedStatement(psmt);
			}
		};

		DaoTemplate.execute(executor);

		return executor.getResult();
	}

	/**
	 * @param valueAt
	 */
	public boolean deleteClientAndHouseByHouseNumber(final String houseNumber) {
		Executor<Boolean> executor = new Executor<Boolean>() {
			@Override
			public void execute(Connection conn) {
				PreparedStatement psmt = null;
				try {
					psmt = conn
							.prepareStatement(deleteClientAndHouseByHouseNumberSql);
					psmt.setInt(1, ClientHouse.STATUS.DELETED);
					psmt.setTimestamp(2, new Timestamp(DbUtil.getNowTime().getTime()));
					psmt.setString(3, houseNumber);
					psmt.setInt(4, ClientHouse.STATUS.DELETED);
					psmt.execute();
					this.setResult(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				DbUtil.closePreparedStatement(psmt);
			}
		};

		DaoTemplate.execute(executor);

		return executor.getResult();
	}

	public boolean deleteClientAndHouseById(final String id) {
		Executor<Boolean> executor = new Executor<Boolean>() {
			@Override
			public void execute(Connection conn) {
				PreparedStatement psmt = null;
				try {
					psmt = conn
							.prepareStatement(deleteClientAndHouseById);
					psmt.setInt(1, ClientHouse.STATUS.DELETED);
					psmt.setTimestamp(2, new Timestamp(DbUtil.getNowTime().getTime()));
					psmt.setString(3, id);
					psmt.setInt(4, ClientHouse.STATUS.DELETED);
					psmt.execute();
					this.setResult(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				DbUtil.closePreparedStatement(psmt);
			}
		};

		DaoTemplate.execute(executor);

		return executor.getResult();
	}

	
	/**
	 * @param valueAt
	 * @return
	 */
	public boolean updateClientAndHouseStatusByHouseNumber(
			final String houseNumber) {
		Date now = DbUtil.getNowTime();
		Executor<Boolean> executor = new Executor<Boolean>() {
			@Override
			public void execute(Connection conn) {
				PreparedStatement psmt = null;
				try {
					psmt = conn
							.prepareStatement(updateClientAndHouseStatusByHouseNumberSql);
					psmt.setInt(1, ClientHouse.STATUS.NOT_USED);
					psmt.setTimestamp(2, new Timestamp(now.getTime()));
					psmt.setTimestamp(3, new Timestamp(now.getTime()));
					psmt.setString(4, houseNumber);
					psmt.setInt(5, ClientHouse.STATUS.USED);
					psmt.execute();
					this.setResult(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				DbUtil.closePreparedStatement(psmt);
			}
		};

		DaoTemplate.execute(executor);

		return executor.getResult();
	}
	
	
	public boolean updateClientAndHouseStatusById(
			final String id) {
		Date now = DbUtil.getNowTime();
		Executor<Boolean> executor = new Executor<Boolean>() {
			@Override
			public void execute(Connection conn) {
				PreparedStatement psmt = null;
				try {
					psmt = conn
							.prepareStatement(updateClientAndHouseStatusByIdSql);
					psmt.setInt(1, ClientHouse.STATUS.NOT_USED);
					psmt.setTimestamp(2, new Timestamp(now.getTime()));
					psmt.setTimestamp(3, new Timestamp(now.getTime()));
					psmt.setString(4, id);
					psmt.setInt(5, ClientHouse.STATUS.USED);
					psmt.execute();
					this.setResult(true);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				DbUtil.closePreparedStatement(psmt);
			}
		};

		DaoTemplate.execute(executor);

		return executor.getResult();
	}
}
