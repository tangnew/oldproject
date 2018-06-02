package com.hotel.db;

import java.sql.PreparedStatement;

/**
 * Created by JW.
 * User: JW
 * Date: Dec 23, 2016 
 * Time: 5:42:07 PM
 *
 * com.hotel.db.Executor
 */
public abstract class Executor<T> {
    private String sql;
    private T result;

    public void makeParameters(PreparedStatement psmt) {
    }

    public abstract void execute(PreparedStatement psmt);

    public Executor(String sql) {
        this.sql = sql;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
