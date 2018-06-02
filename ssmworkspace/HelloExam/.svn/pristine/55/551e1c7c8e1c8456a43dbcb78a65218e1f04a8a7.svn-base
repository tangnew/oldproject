package com.exam.manager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by JW.
 * User: JW
 * Date: Nov 25, 2016 
 * Time: 5:51:18 PM
 *
 * com.exam.manager.ErrorCodeManager
 */
public final class ErrorCodeManager {

	private static String errorCodeFile = "error-code.properties";
	private static Properties cache = new Properties();

	private static void loadErrorCodeMessage() {
		try {
			InputStream in = ErrorCodeManager.class.getClassLoader()
					.getResource(errorCodeFile).openStream();
			cache.load(in);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Load "+errorCodeFile+ " into properties error!　Ｓystem will be exit!" );
			System.out.println(-1);
		}
	}

	static {
		loadErrorCodeMessage();
	}
	
	public static void main(String[] args) {
		System.out.println(cache);
	}
}
