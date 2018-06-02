package com.tjj.dao;

import com.tjj.model.Student;

public interface StudentDao {

	public void addStudent(Student st);
	
	public Student findStudentByGuid(String guid);
	
	public Student findStudentById(Integer id);
}
