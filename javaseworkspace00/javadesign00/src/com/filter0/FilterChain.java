package com.filter0;

import java.util.ArrayList;
import java.util.List;

public class FilterChain {
	private List<Filter> filters = new ArrayList<>();

	private int index = 0;

	public FilterChain addFilter(Filter filter) {
		filters.add(filter);
		return this;
	}
	
	public String doFilter(ReqAndRespInfo req, ReqAndRespInfo resp) {
		if (index == filters.size()) {
			return null;
		}
		Filter f = filters.get(index);
		System.out.println(f.getClass().getName());
		index++;
		f.doFilter(req, resp, this);
		return "over";
	}
}
