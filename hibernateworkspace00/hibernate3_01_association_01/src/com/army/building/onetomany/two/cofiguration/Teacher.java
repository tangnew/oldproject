package com.army.building.onetomany.two.cofiguration;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
	private int id;
	private int age;
	private String name;
	private Set<Student> students = new HashSet<Student>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}
