package com.tjj.model;

public class Student {

	private Integer id;
	private String studentGuid;
	private String name;
	private Integer age;

	private Teacher teacher;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudentGuid() {
		return studentGuid;
	}

	public void setStudentGuid(String studentGuid) {
		this.studentGuid = studentGuid;
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

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentGuid=" + studentGuid + ", name="
				+ name + ", age=" + age +"]";
	}

	
}
