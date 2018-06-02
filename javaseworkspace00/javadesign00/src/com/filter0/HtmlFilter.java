package com.filter0;

public class HtmlFilter implements Filter {

	@Override
	public String doFilter(ReqAndRespInfo req, ReqAndRespInfo resp,
			FilterChain filterChain) {
		System.out.println("begin html filter!");
		filterChain.doFilter(req, resp);
		System.out.println("end html filter");
		return "html ok!";
	}
}
