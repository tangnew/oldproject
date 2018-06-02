package com.jw.hs.management.exception;
/**
 * 
 * @author Jianjun Tang
 *
 * 2017年9月16日 下午11:22:51
 *
 */
public class BaseSupportException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6305539722153823850L;

	private String code;
	private String message;

	public BaseSupportException(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
