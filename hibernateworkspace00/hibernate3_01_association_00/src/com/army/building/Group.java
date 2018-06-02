package com.army.building;

import java.util.HashSet;
import java.util.Set;

public class Group {
	private int id;
	private String name;
	private Set<ContactPerson> persons = new HashSet<ContactPerson>();

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

	public Set<ContactPerson> getPersons() {
		return persons;
	}

	public void setPersons(Set<ContactPerson> persons) {
		this.persons = persons;
	}

}
