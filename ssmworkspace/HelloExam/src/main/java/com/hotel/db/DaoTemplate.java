package com.hotel.db;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Created by JW.
 * User: JW
 * Date: Dec 23, 2016 
 * Time: 5:42:00 PM
 *
 * com.hotel.db.DaoTemplate
 */
public final class DaoTemplate {
	
	public static void execute(Executor<?> executor) {
		Connection conn = DbUtil.getConnection();
		PreparedStatement psmt = null;
		try {
			conn.setAutoCommit(false);
			psmt = conn.prepareStatement(executor.getSql());
			executor.makeParameters(psmt);
			executor.execute(psmt);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		DbUtil.closePreparedStatement(psmt);
		DbUtil.closeConnection(conn);
	}
}
