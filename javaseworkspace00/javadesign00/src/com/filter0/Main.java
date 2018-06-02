package com.filter0;

public class Main {

	public static void main(String[] args) {
		Filter f1 = new HtmlFilter();
		Filter f2 = new SesitiveFilter();
		Filter f3 = new XmlFilter();
		FilterChain chain = new FilterChain();
		chain.addFilter(f1).addFilter(f2).addFilter(f3);
		ReqAndRespInfo req = new ReqAndRespInfo();
		ReqAndRespInfo resp = new ReqAndRespInfo();
		chain.doFilter(req, resp);
	}
}
