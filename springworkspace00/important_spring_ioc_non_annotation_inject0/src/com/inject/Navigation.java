package com.inject;

import java.util.List;
import java.util.Map;

public class Navigation {
	private String name;
	private List<Navigation> list;
	private Navigation[] arrays;
	private Map<String, Navigation> maps;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Navigation> getList() {
		return list;
	}

	public void setList(List<Navigation> list) {
		this.list = list;
	}

	public Navigation[] getArrays() {
		return arrays;
	}

	public void setArrays(Navigation[] arrays) {
		this.arrays = arrays;
	}

	public Map<String, Navigation> getMaps() {
		return maps;
	}

	public void setMaps(Map<String, Navigation> maps) {
		this.maps = maps;
	}

}
