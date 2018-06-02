package com.tong.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HelloServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		long before = System.currentTimeMillis();
		System.out.println("=========before========" + before);
		try {
			Thread.sleep(5 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		//System.exit(10);

		out.write("<result>123</result><br/><jessionid>12</jessionid><br/><fileUD>FileUpAndDownloadServelt</fileUD>");
		out.flush();
		out.close();
		
		int i = resp.getStatus();
		long after = System.currentTimeMillis();
		System.out.println("=========after========" + after);
		System.out.println("=========total ========" + (after - before));
		System.out.println("respone:" + i);
	}
}
