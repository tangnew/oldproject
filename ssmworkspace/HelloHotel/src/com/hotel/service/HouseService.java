package com.hotel.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hotel.db.DaoTemplate;
import com.hotel.db.DbUtil;
import com.hotel.db.Executor;
import com.hotel.model.House;

/**
 * Created by JW.
 * User: JW
 * Date: Dec 26, 2016 
 * Time: 5:38:22 PM
 *
 * com.hotel.service.HouseService
 */
public final class HouseService {
	static {
		HouseService service = new HouseService();
		ServiceFactory.addService(ServiceFactory.HOUSE_SERIVCE, service);
	}
	private static final String getHousesSql = "select * from house";

	public List<House> getHouses() {
		Executor<List<House>> executor = new Executor<List<House>>() {
			@Override
			public void execute(Connection conn) {
				PreparedStatement psmt = null;
				ResultSet resultSet = null;
				try {
					psmt = conn.prepareStatement(getHousesSql);
					resultSet = psmt.executeQuery();
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
}
