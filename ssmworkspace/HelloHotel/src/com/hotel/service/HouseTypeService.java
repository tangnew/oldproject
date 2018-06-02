package com.hotel.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hotel.db.DaoTemplate;
import com.hotel.db.DbUtil;
import com.hotel.db.Executor;
import com.hotel.model.HouseType;

/**
 * Created by JW.
 * User: JW
 * Date: Dec 26, 2016 
 * Time: 6:15:09 PM
 *
 * com.hotel.service.HouseTypeService
 */
public final class HouseTypeService {
	public static void loadService() {
		HouseTypeService service = new HouseTypeService();
		ServiceFactory.addService(ServiceFactory.HOUSE_TYPE_SERVICE, service);
	}
	
	private static final String getHouseTypesByNameSql = "select id,created_time,updated_time,name,description,status"
			+ " from house_type where name like ? order by updated_time desc";
	
	private static final String addHouseTypeSql = "insert house_type(id,created_time,updated_time,name,description,status)"
			+ "values(?,?,?,?,?,?)";
	
	private static final String updateHouseTypeStatusByIdSql = "update house_type set status=?,updated_time=? where id=?";
	
	public List<HouseType> getHouseTypes(String name){
		List<HouseType> hts = new ArrayList<HouseType>();
		Executor<List<HouseType>> executor = new Executor<List<HouseType>>(
				) {
			@Override
			public void execute(Connection conn) {
				PreparedStatement psmt = null;
				ResultSet resultSet = null;
				try {
					psmt = conn.prepareStatement(getHouseTypesByNameSql);
					psmt.setString(1, "%"+name+"%");
					resultSet = psmt.executeQuery();
					while(resultSet.next()){
						String id = resultSet.getString("id");
						String name = resultSet.getString("name");
						String description = resultSet.getString("description");
						String createdTime = resultSet.getString("created_time");
						String updatedTime = resultSet.getString("updated_time");
						int status = resultSet.getInt("status");
						HouseType ht = new HouseType();
						ht.setId(id);
						ht.setName(name);
						ht.setDescription(description);
						ht.setStatus(status);
						ht.setCreatedTimeStr(createdTime);
						ht.setUpdatedTimeStr(updatedTime);
						
						hts.add(ht);
					}
					this.setResult(hts);
					
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
	 * @param houseType
	 */
	public boolean addHouseType(HouseType houseType) {
		Date now = DbUtil.getNowTime();
		Executor<Boolean> executor = new Executor<Boolean>() {

			@Override
			public void execute(Connection conn) {
				this.setResult(true);

				PreparedStatement psmt = null;
				try {
					psmt = conn.prepareStatement(addHouseTypeSql);
					// id,created_time,updated_time,name,description,status
					psmt.setString(1, DbUtil.getUUID());
					psmt.setTimestamp(2, new java.sql.Timestamp(now.getTime()));
					psmt.setTimestamp(3, new java.sql.Timestamp(now.getTime()));
					psmt.setString(4, houseType.getName());
					psmt.setString(5, houseType.getDescription());
					psmt.setInt(6, houseType.getStatus());
					psmt.execute();
				} catch (SQLException e) {
					e.printStackTrace();
					this.setResult(false);
					return;
				} finally {
					DbUtil.closePreparedStatement(psmt);
				}
			}
		};

		DaoTemplate.execute(executor);
		return executor.getResult();
	}

	/**
	 * @param id
	 * @return
	 */
	public boolean deleteHouseTypeById(String id) {
		Date now = DbUtil.getNowTime();
		Executor<Boolean> executor = new Executor<Boolean>() {

			@Override
			public void execute(Connection conn) {
				this.setResult(true);

				PreparedStatement psmt = null;
				try {
					psmt = conn.prepareStatement(updateHouseTypeStatusByIdSql);
					psmt.setInt(1, HouseType.STATUS.DELETED);
					psmt.setTimestamp(2, new java.sql.Timestamp(now.getTime()));
					psmt.setString(3,id);
					psmt.execute();
				} catch (SQLException e) {
					e.printStackTrace();
					this.setResult(false);
					return;
				} finally {
					DbUtil.closePreparedStatement(psmt);
				}
			}
		};

		DaoTemplate.execute(executor);
		return executor.getResult();
	}
}
