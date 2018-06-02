package com.filter0;

public interface Filter {
	public String doFilter(ReqAndRespInfo req, ReqAndRespInfo resp,
			FilterChain filterChain);
}
