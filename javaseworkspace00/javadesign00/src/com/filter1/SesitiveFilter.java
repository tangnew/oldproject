package com.filter1;

public class SesitiveFilter implements Filter {

	private Class<? extends Filter> nextFilter;

	public SesitiveFilter(Class<? extends Filter> nextFilter) {
		this.nextFilter = nextFilter;
	}

	@Override
	public void doFilter(Request req, Response resp, FilterChain fc) {
		System.out.println("sesitive begin");
		fc.doFilter(nextFilter, req, resp);
		System.out.println("sesitive end");
	}

}
