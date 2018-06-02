package com.web.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.PasswordConveter;

public class WeiXinServlet extends HttpServlet {
	private static final long serialVersionUID = -796578770081992893L;
	private static String TOKEN = "weixin";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String signature = req.getParameter("signature");
		String timestamp = req.getParameter("timestamp");
		String nonce = req.getParameter("nonce");
		String echostr = req.getParameter("echostr");

		String[] arrs = new String[] { TOKEN, timestamp, nonce };
		Arrays.sort(arrs);
		String sorted = arrs[0] + arrs[1] + arrs[2];
		try {
			String result = PasswordConveter.sha1(sorted);
			System.out.println(result + "\n" + signature);
			if (result.equals(signature)) {
				resp.getWriter().println(echostr);
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		InputStream in = req.getInputStream();
		int i = 0;
		while ((i = in.read()) != -1) {
			System.out.print((char) i);
		}

		String result = "<xml>" +
		"<ToUserName><![CDATA[oEJPot0noCYfE0C880QAv5jlbYPM]]></ToUserName>"
				+ "<FromUserName><![CDATA[gh_26897817aa1e]]></FromUserName>"
				+ "<CreateTime>12345678</CreateTime>"
				+ "<MsgType><![CDATA[text]]></MsgType>"
				+ "<Content><![CDATA[hello world weixin!!!]]></Content>" + "</xml>";
		resp.getWriter().println(result);
	}
}
