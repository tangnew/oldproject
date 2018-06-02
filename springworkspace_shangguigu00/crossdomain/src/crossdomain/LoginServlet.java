package crossdomain;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final String ACCESS_CONTROL_ALLOW_ORIGIN_HEADER = "Access-Control-Allow-Origin";
	private static final String ACCESS_CONTROL_ALLOW_METHODS_HEADER = "Access-Control-Allow-Methods";
	private static final String ACCESS_CONTROL_ALLOW_HEADERS_HEADER = "Access-Control-Allow-Headers";
	private static final String ACCESS_CONTROL_MAX_AGE_HEADER = "Access-Control-Max-Age";
	private static final String ACCESS_CONTROL_ALLOW_CREDENTIALS_HEADER = "Access-Control-Allow-Credentials";
	private static final String ALLOWED_ORIGINS_PARAM = "allowedOrigins";
	private static final String ALLOWED_METHODS_PARAM = "allowedMethods";
	private static final String ALLOWED_HEADERS_PARAM = "allowedHeaders";
	private static final String PREFLIGHT_MAX_AGE_PARAM = "preflightMaxAge";
	private static final String ALLOWED_CREDENTIALS_PARAM = "allowCredentials";


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		System.out.println("exit seesion id:" + session.getId());

		session.invalidate();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
		resp.setHeader(ACCESS_CONTROL_ALLOW_METHODS_HEADER, "*");
		resp.setHeader(ACCESS_CONTROL_ALLOW_HEADERS_HEADER, "*");
		resp.setHeader(ACCESS_CONTROL_MAX_AGE_HEADER, "*");
		resp.setHeader(ACCESS_CONTROL_ALLOW_CREDENTIALS_HEADER, "*");

		resp.setHeader(ALLOWED_ORIGINS_PARAM, "*");
		resp.setHeader(ALLOWED_METHODS_PARAM, "*");
		resp.setHeader(ALLOWED_HEADERS_PARAM, "*");
		
		resp.setHeader(PREFLIGHT_MAX_AGE_PARAM, "*");
		resp.setHeader(ALLOWED_CREDENTIALS_PARAM, "*");
		resp.setHeader(PREFLIGHT_MAX_AGE_PARAM, "*");
		resp.setHeader("P3P", "CP=CAO PSA OUR");
		String loginName = req.getParameter("loginName");
		HttpSession session = req.getSession();
		session.setAttribute("user", loginName);
		System.out.println("seesion id:" + session.getId());
		
//		resp.addHeader("refresh","1");
//		resp.setDateHeader("expries", -1);
//		resp.setHeader("Cache-Control", "no-cache");
//		resp.setHeader("Pragma", "no-cache");
	//	resp.setHeader("Location", "/crossdomain/main.html");
		
		//resp.sendRedirect("/crossdomain/for.html");
		resp.setHeader("refresh","2;url=/crossdomain/main.html");
		//resp.setHeader("refresh","0;URL=/crossdomain/main.html");
		//resp.setHeader("refresh","0;URL=/crossdomain/main.html");
//		resp.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = resp.getWriter();
//		out.write("<result>" + session.getId() + "</result><jessionid>"
//				+ session.getId()
//				+ "</jessionid><login>LoginServlet</login>");
//		out.flush();
//		out.close();
	}
}
