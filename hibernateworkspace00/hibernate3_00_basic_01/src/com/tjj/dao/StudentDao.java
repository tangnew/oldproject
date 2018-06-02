package com.tjj.dao;

import java.util.List;

import com.tjj.model.Student;

public interface StudentDao {

	public void addStudent(Student student);

	public List<Student> findAllStudent();

	public Student getStudentById(Long id);
}
