package com.army.building.manytomany.after;

import java.util.HashSet;
import java.util.Set;

public class Student {
	private int id;
	private String name;
	private Set<TeacherStudent> teacherStudents = new HashSet<TeacherStudent>();

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

	public Set<TeacherStudent> getTeacherStudents() {
		return teacherStudents;
	}

	public void setTeacherStudents(Set<TeacherStudent> teacherStudents) {
		this.teacherStudents = teacherStudents;
	}

}
