package com.filter1;


public class Main {
	public static void main(String[] args) {
		Filter f1 = new HtmlFilter(null);
		Filter f2 = new XmlFilter(HtmlFilter.class);
		Filter f3 = new SesitiveFilter(XmlFilter.class);
		FilterChain chain = new FilterChain();
		chain.addFilter(HtmlFilter.class, f1);
		chain.addFilter(XmlFilter.class, f2);
		chain.addFilter(SesitiveFilter.class, f3);
		
		Request req = new Request();
		Response resp = new Response();
		chain.doFilter(SesitiveFilter.class, req, resp);
	}
}
