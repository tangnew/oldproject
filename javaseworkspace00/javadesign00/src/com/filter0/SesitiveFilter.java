package com.filter0;

public class SesitiveFilter implements Filter {

	@Override
	public String doFilter(ReqAndRespInfo req, ReqAndRespInfo resp,
			FilterChain filterChain) {
		System.out.println("begin sesitive filter!");
		filterChain.doFilter(req, resp);
		System.out.println("end sesitive filter");
		return "sesitive ok!";
	}

}
