package com.hotel.db;

import java.sql.Connection;

/**
 * Created by JW.
 * User: JW
 * Date: Dec 26, 2016 
 * Time: 5:42:07 PM
 *
 * com.hotel.db.Executor
 */
public abstract class Executor<T> {
	private T result;
	
	public abstract void execute(Connection conn);
	
	public T getResult() {
		return result;
	}

	public void setResult(T result) {
		this.result = result;
	}
}
