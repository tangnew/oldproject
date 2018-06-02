package com.filter1;

import java.util.HashMap;
import java.util.Map;

public class FilterChain {

	private Map<Class<? extends Filter>, Filter> map = new HashMap<>();

	public FilterChain addFilter(Class<? extends Filter> clz, Filter filter) {
		map.put(clz, filter);
		return this;
	}

	public void doFilter(Class<? extends Filter> nextClz, Request req, Response resp) {
		if (null == nextClz) {
			return;
		}
		Filter f = map.get(nextClz);
		f.doFilter(req, resp, this);
	}
}
