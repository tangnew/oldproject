package com.tjj.dao;

import java.util.Date;

import org.junit.Test;

import com.tjj.bean.LoginRecord;
import com.tjj.bean.Student;
import com.tjj.dao.impl.LoginRecordDaoImpl;

public class LoginRecordDaoTest {
	@Test
	public void testSaveLoginRecord0() {
		LoginRecordDao loginRecordDao = new LoginRecordDaoImpl();
		LoginRecord lr = new LoginRecord();
		Date now = new Date();
		lr.setCreatedTime(now);
		lr.setUpdatedTime(now);
		lr.setRemoteIp("www.qq.com");
		Student student = new Student();
		student.setId(1L);
		lr.setStudent(student);
		loginRecordDao.saveLoginRecord(lr);
	}
	
	@Test
	public void testSaveLoginRecord1() {
		LoginRecordDao loginRecordDao = new LoginRecordDaoImpl();
		LoginRecord lr = new LoginRecord();
		Date now = new Date();
		lr.setCreatedTime(now);
		lr.setUpdatedTime(now);
		lr.setRemoteIp("www.aaa.com");
		
		Student s = new Student();
		s.setCreatedTime(now);
		s.setUpdatedTime(now);
		s.setIsValid(true);
		s.setName("lissasi");
		s.setGender(true);
		
		lr.setStudent(s);
		loginRecordDao.saveLoginRecord(lr);
	}
}
