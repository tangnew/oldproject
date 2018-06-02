package com.jiawen.tong.collection.high;

public class Student {

	private int id;
	private String name;
	private Integer age;
	private int gradeNo;
	private int classNo;

	public Student(int id, String name, Integer age, int gradeNo, int classNo) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.gradeNo = gradeNo;
		this.classNo = classNo;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public int getGradeNo() {
		return gradeNo;
	}

	public int getClassNo() {
		return classNo;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age
				+ ", gradeNo=" + gradeNo + ", classNo=" + classNo + "]";
	}

}
