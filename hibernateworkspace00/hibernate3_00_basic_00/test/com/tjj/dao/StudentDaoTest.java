package com.tjj.dao;

import org.junit.Test;

import com.tjj.dao.impl.StudentDaoImpl;
import com.tjj.model.Student;
import com.tjj.model.Teacher;
import com.tjj.util.GenerateUuid;

public class StudentDaoTest {
	@Test
	public void testAddStudent00() {
		Teacher teacher = new Teacher();
		teacher.setAge(12);
		teacher.setGuid(GenerateUuid.getUuid());
		teacher.setName("zhangls");

		Student student = new Student();
		student.setAge(1222);
		student.setName("ok1");
		student.setTeacher(teacher);
		student.setStudentGuid(GenerateUuid.getUuid());
		
		StudentDao dao = new StudentDaoImpl();
		dao.addStudent(student);
	}
	
	@Test
	public void testAddStudent01() {
		Teacher teacher = new Teacher();
		teacher.setName("df");
		teacher.setGuid(GenerateUuid.getUuid());

		Student student = new Student();
		student.setAge(1222);
		student.setName("ok1a");
		student.setTeacher(teacher);
		student.setStudentGuid(GenerateUuid.getUuid());
		
		StudentDao dao = new StudentDaoImpl();
		dao.addStudent(student);
	}
	
	@Test
	public void testGetStudent00(){
		StudentDao dao = new StudentDaoImpl();
		Student s = dao.findStudentById(1);
		System.out.println(s);
		System.out.println(s.getTeacher().getStudents());
	}
}
