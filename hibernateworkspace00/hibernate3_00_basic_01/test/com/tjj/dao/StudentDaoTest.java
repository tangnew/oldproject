package com.tjj.dao;

import java.util.List;

import org.junit.Test;

import com.tjj.dao.impl.StudentDaoImpl;
import com.tjj.model.Student;

public class StudentDaoTest {

	@Test
	public void testAddStudent00() {
		StudentDao studentDao = new StudentDaoImpl();
		Student student = new Student();
		student.setName("sa");
		studentDao.addStudent(student);
	}

	@Test
	public void testGetStudentById00() {
		StudentDao studentDao = new StudentDaoImpl();
		Student student = studentDao.getStudentById(3l);
		System.out.println(student);
	}

	@Test
	public void testFindAllStudent00() {
		StudentDao studentDao = new StudentDaoImpl();
		List<Student> result = studentDao.findAllStudent();
		System.out.println(result);
	}
}
