package com.filter1;

public class HtmlFilter implements Filter {
	private Class<? extends Filter> nextFilter;

	public HtmlFilter(Class<? extends Filter> nextFilter) {
		this.nextFilter = nextFilter;
	}

	@Override
	public void doFilter(Request req, Response resp, FilterChain fc) {
		System.out.println("html begin");
		fc.doFilter(nextFilter, req, resp);
		System.out.println("html end");
	}

}
