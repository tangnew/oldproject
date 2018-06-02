package com.filter1;

public class XmlFilter implements Filter {
	private Class<? extends Filter> nextFilter;

	public XmlFilter(Class<? extends Filter> nextFilter) {
		this.nextFilter = nextFilter;
	}

	@Override
	public void doFilter(Request req, Response resp, FilterChain fc) {
		System.out.println("xml begin");
		fc.doFilter(nextFilter, req, resp);
		System.out.println("xml end");
	}

}
