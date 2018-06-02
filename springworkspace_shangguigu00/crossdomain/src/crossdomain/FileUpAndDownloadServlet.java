package crossdomain;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FileUpAndDownloadServlet extends HttpServlet {
	private static final String ACCESS_CONTROL_ALLOW_ORIGIN_HEADER = "Access-Control-Allow-Origin";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setHeader(ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");

		HttpSession session = req.getSession();
		Object loginName = session.getAttribute("user");
		System.out.println("seesion id:" + session.getId() + ", user="
				+ loginName);
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();
		out.write("<result>" + loginName + "</result><br/><jessionid>"
				+ session.getId() + "</jessionid><br/><fileUD>FileUpAndDownloadServelt</fileUD>");
		out.flush();
		out.close();
		resp.getStatus();
	}
}
