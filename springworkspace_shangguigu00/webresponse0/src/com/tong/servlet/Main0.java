package com.tong.servlet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main0 {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://127.0.0.1:8080/webresponse0/hello");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		// con.setReadTimeout(10 * 1000);
		con.connect();
		String message = con.getResponseMessage();
		System.out.println("code" + con.getResponseCode() + ",response:"
				+ message);
		Thread.sleep(10 * 1000);
		BufferedReader bfBufferedReader = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String line = null;
		while (null != (line = bfBufferedReader.readLine())) {
			System.out.println(line);
		}
	}
}
