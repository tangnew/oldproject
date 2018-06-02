package com.tjj.model;

import java.util.HashSet;
import java.util.Set;

public class Teacher {
	private Integer id;
	private String guid;
	private String name;
	private Integer age;
	private Set<Student> students = new HashSet<>();

	public Teacher() {
	}

	public Integer getId() {
		return id;
	}

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	@SuppressWarnings("unused")
	private void setId(Integer id) {
		this.id = id;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", guid=" + guid + ", name=" + name
				+ ", age=" + age + ", students=" + students + "]";
	}

}
