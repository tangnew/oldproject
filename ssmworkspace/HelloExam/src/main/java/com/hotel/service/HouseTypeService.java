package com.hotel.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.hotel.db.DaoTemplate;
import com.hotel.db.DbUtil;
import com.hotel.db.Executor;
import com.hotel.model.HouseType;

/**
 * Created by JW.
 * User: JW
 * Date: Dec 23, 2016 
 * Time: 6:15:09 PM
 *
 * com.hotel.service.HouseTypeService
 */
public final class HouseTypeService {
	static {
		HouseTypeService service = new HouseTypeService();
		ServiceFactory.addService(ServiceFactory.HOUSE_TYPE_SERVICE, service);
	}
	private static final String getHouseTypesSql = "select * from house_type";
	
	public List<HouseType> getHouseTypes(){
		Executor<List<HouseType>> executor = new Executor<List<HouseType>>(
				getHouseTypesSql) {
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
