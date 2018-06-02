package com.tjj.dao;

import java.util.Date;
import java.util.Set;

import org.junit.Test;

import com.tjj.bean.LoginRecord;
import com.tjj.bean.Student;
import com.tjj.dao.impl.StudentDaoImpl;

public class StudentDaoTest {

	@Test
	public void testSaveStudent0() {
		StudentDao studentDao = new StudentDaoImpl();
		Student s = new Student();
		Date now = new Date();
		s.setCreatedTime(now);
		s.setUpdatedTime(now);
		s.setIsValid(true);
		s.setName("zhangsan");
		s.setGender(true);
		studentDao.saveStudent(s);
	}

	@Test
	public void testSaveStudent1() {
		StudentDao studentDao = new StudentDaoImpl();
		Student s = new Student();
		Date now = new Date();
		s.setCreatedTime(now);
		s.setUpdatedTime(now);
		s.setIsValid(true);
		s.setName("wangwu111");
		s.setGender(true);
		studentDao.saveStudent(s);
	}

	@Test
	public void testGetStudentById0() {
		StudentDao studentDao = new StudentDaoImpl();
		Student s = studentDao.getStudentById(1L);
		Set<LoginRecord> lrs = s.getLoginRecords();
		System.out.println(s.getName());
		for (LoginRecord temp : lrs) {
			System.out.println(temp.getRemoteIp() + ";" + temp.getCreatedTime()
					+ ";" + temp.getUpdatedTime());
		}
	}
}
