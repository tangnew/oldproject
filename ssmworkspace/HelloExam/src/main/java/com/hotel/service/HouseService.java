package com.hotel.service;

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
 * Date: Dec 23, 2016 
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
		Executor<List<House>> executor = new Executor<List<House>>(getHousesSql) {
			@Override
			public void execute(PreparedStatement psmt) {
				ResultSet resultSet = null;
				try {
					resultSet = psmt.executeQuery();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				DbUtil.closeResultSet(resultSet);
			}
		};

		DaoTemplate.execute(executor);

		return executor.getResult();
	}
}
