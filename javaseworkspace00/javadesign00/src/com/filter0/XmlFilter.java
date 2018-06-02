package com.filter0;

public class XmlFilter implements Filter {

	@Override
	public String doFilter(ReqAndRespInfo req, ReqAndRespInfo resp,
			FilterChain filterChain) {
		System.out.println("begin xml filter!");
		filterChain.doFilter(req, resp);
		System.out.println("end xml filter");
		return "xml ok!";
	}

}
