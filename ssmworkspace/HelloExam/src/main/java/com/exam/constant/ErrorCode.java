package com.exam.constant;

/**
 * Created by JW.
 * User: JW
 * Date: Nov 24, 2016 
 * Time: 11:06:14 AM
 *
 * com.exam.constant.ErrorCode
 */
public enum ErrorCode {
	SYSTEM_ERROR(5000, "The system has existed error, please contact the backend XiaoJia!"),
	SESSION_EXPIRED(1024, "Session has been expired!");

	private int code;
	private String message;

	private ErrorCode(int code, String msg) {
		this.code = code;
		this.message = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
