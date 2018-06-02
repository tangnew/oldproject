package com.army.building.manytoone;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.util.HibernateUtils;

public class TestManyToOne {
	// 能够将student\teacher添加进数据库,同时赋予teacher与student的关系
	@Test
	public void testAdd0() {
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		Teacher teacher = new Teacher();
		teacher.setAge(22);
		teacher.setName("T_ZhangSan");

		Student s1 = new Student();
		s1.setName("S_LiSi");
		s1.setAge(12);
		s1.setAddress("address1");
		s1.setTeacher(teacher);

		Student s2 = new Student();
		s2.setName("S_WangWu");
		s2.setAge(22);
		s2.setAddress("address2");
		s2.setTeacher(teacher);

		// 由student主控
		session.save(s1);
		session.save(s2);
		tran.commit();
	}

	@Test
	public void testAdd1() {
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		Teacher teacher = new Teacher();
		teacher.setAge(22);
		teacher.setName("T_ZhangSan");

		Student s1 = new Student();
		s1.setName("S_LiSi");
		s1.setAge(12);
		s1.setAddress("address1");
		s1.setTeacher(teacher);

		Student s2 = new Student();
		s2.setName("S_WangWu");
		s2.setAge(22);
		s2.setAddress("address2");
		s2.setTeacher(teacher);

		// 由student主控
		session.save(teacher);
		tran.commit();
	}
	
	// 删除teacher
	@Test
	public void testDeleteTeacher0() {
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		Teacher teacher = new Teacher();
		teacher.setId(2);
		session.delete(teacher);
		tran.commit();
	}

	// 删除Student
	@Test
	public void testDeleteStudent0() {
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		Student s1 = new Student();
		s1.setId(1);
		session.delete(s1);
		tran.commit();
	}

}
