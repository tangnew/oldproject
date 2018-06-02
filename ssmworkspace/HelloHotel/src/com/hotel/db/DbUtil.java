package com.hotel.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;


/**
 * Created by JW.
 * User: JW
 * Date: Dec 26, 2016 
 * Time: 12:38:58 PM
 *
 * com.hotel.dao.DbUtil
 */
public class DbUtil {

	private static String dbFile = "db.properties";
	private static String jdbcDriverKey = "jdbc.driver";
	private static String jdbcUrlKey = "jdbc.url";
	private static String userKek = "jdbc.username";
	private static String passwordKey = "jdbc.password";
	private static String jdbcDriver = null;
	private static String jdbcUrl = null;
	private static String user = null;
	private static String password= null;

	static {
		loadDbInfo();
	}

	private static void loadDbInfo() {
		Properties dbInfo = new Properties();
		try {
			dbInfo.load(DbUtil.class.getClassLoader().getResourceAsStream(dbFile));
			jdbcDriver = dbInfo.getProperty(jdbcDriverKey);
			jdbcUrl = dbInfo.getProperty(jdbcUrlKey);
			user = dbInfo.getProperty(userKek);
			password = dbInfo.getProperty(passwordKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getUUID(){
		return UUID.randomUUID().toString();
	}

	public final static Date getNowTime(){
		return new Date();
	}
	public static Connection getConnection() {
		try {
			Class.forName(jdbcDriver);
			Connection conn = DriverManager.getConnection(jdbcUrl, user,
					password);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeConnection(Connection conn) {
		if (null != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closePreparedStatement(PreparedStatement psmt) {
		if (null != psmt) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void closeResultSet(ResultSet rset) {
		if (null != rset) {
			try {
				rset.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
