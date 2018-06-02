package com.inject;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInject {
	private Map<String, String> map;
	private Set<String> set;
	private List<String> list;
	private String[] array;
	private Properties props;

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	public Set<String> getSet() {
		return set;
	}

	public void setSet(Set<String> set) {
		this.set = set;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public String[] getArray() {
		return array;
	}

	public void setArray(String[] array) {
		this.array = array;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

}
