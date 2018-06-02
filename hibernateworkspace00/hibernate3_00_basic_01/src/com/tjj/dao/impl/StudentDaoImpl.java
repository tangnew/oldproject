package com.tjj.dao.impl;

import java.util.List;

import com.tjj.dao.AbstractDao;
import com.tjj.dao.StudentDao;
import com.tjj.model.Student;

public class StudentDaoImpl extends AbstractDao<Student> implements StudentDao {

	@Override
	public void addStudent(Student student) {
		super.save(student);
	}

	@Override
	public List<Student> findAllStudent() {
		return super.findAll(Student.class);
	}

	@Override
	public Student getStudentById(Long id) {
		return super.get(Student.class, id);
	}

}
