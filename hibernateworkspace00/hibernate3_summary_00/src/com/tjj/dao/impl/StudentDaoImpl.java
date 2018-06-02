package com.tjj.dao.impl;

import com.tjj.bean.Student;
import com.tjj.dao.HibernateDao;
import com.tjj.dao.StudentDao;

public class StudentDaoImpl extends HibernateDao<Student> implements StudentDao {

	@Override
	public void saveStudent(Student student) {
		super.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return super.getObject(Student.class, id);
	}

}
