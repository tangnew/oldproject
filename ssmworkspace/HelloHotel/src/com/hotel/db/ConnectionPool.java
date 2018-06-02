package com.hotel.db;

import java.sql.Connection;

/**
 * Created by JW.
 * User: JW
 * Date: Dec 26, 2016 
 * Time: 3:40:49 PM
 *
 * com.hotel.db.ConnectionPool
 */
public class ConnectionPool {
	public static Connection getConnection(){
		return DbUtil.getConnection();
	}
}
