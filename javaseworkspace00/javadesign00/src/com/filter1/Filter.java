package com.filter1;

public interface Filter {

	public void doFilter(Request req, Response resp, FilterChain fc);
}
