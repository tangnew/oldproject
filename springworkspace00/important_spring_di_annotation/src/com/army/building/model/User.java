package com.army.building.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "user")
@Scope(value="prototype")
public class User {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
