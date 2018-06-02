package com.tjj.dao;

import com.tjj.bean.Student;

public interface StudentDao {
	public void saveStudent(Student student);
	
	public Student getStudentById(Long id);
}
