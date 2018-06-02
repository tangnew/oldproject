package com.hotel.db;

import java.sql.Connection;

/**
 * Created by JW.
 * User: JW
 * Date: Dec 26, 2016 
 * Time: 5:42:00 PM
 *
 * com.hotel.db.DaoTemplate
 */
public final class DaoTemplate {
	
	public static void execute(Executor<?> executor) {
		Connection conn = ConnectionPool.getConnection();
		try {
			conn.setAutoCommit(false);
			executor.execute(conn);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		DbUtil.closeConnection(conn);
	}
}
