package com.army.building.onetomany.two.cofiguration;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.util.HibernateUtils;

public class TestOneToManyTwoConfig {
	// 可以将teacher\student填进数据库,并且赋予关系
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

		session.save(s1);
		session.save(s2);
		tran.commit();
	}

	// 可以将teacher填进数据库,student无法添加
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

		teacher.getStudents().add(s1);
		teacher.getStudents().add(s2);
		
		session.save(teacher);
		tran.commit();
	}

	// 可以将teacher\student填进数据库,但是无赋予关系
	@Test
	public void testAdd2() {
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

		Student s2 = new Student();
		s2.setName("S_WangWu");
		s2.setAge(22);
		s2.setAddress("address2");

		Set<Student> set = new HashSet<Student>();
		set.add(s1);
		set.add(s2);
		teacher.setStudents(set);

		session.save(teacher);
		tran.commit();
	}

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

	// 去除student与teacher关系
	@Test
	public void testUpdateStudent0() {
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();

		Student s1 = new Student();
		s1.setId(2);

		s1.setTeacher(null);
		session.update(s1);
		tran.commit();
	}

	// 填进student与teacher关系
	@Test
	public void testUpdateStudent1() {
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();

		Student s1 = new Student();
		s1.setId(5);
		Teacher t = (Teacher) session.get(Teacher.class, 2);

		s1.setTeacher(t);
		session.update(s1);
		tran.commit();
	}

	// student直接得到teacher
	@Test
	public void testListStudent0() {
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();

		Student s1 = (Student) session.get(Student.class, 5);
		System.out.println(s1.getTeacher().getName());
		tran.commit();
	}

	// student直接得到teacher,然后teacher得到student
	@Test
	public void testListStudent1() {
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();

		Student s1 = (Student) session.get(Student.class, 2);
		System.out.println(s1.getTeacher().getStudents().size());
		tran.commit();
	}
	
	@Test
	public void testDeleteStudent1() {
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();

		Student s1 = (Student) session.get(Student.class, 2);
		session.delete(s1);
		tran.commit();
	}
	
	
	@Test
	public void testDeleteTeacher() {
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();

		Teacher s1 = (Teacher) session.get(Teacher.class, 1);
		session.delete(s1);
		tran.commit();
	}
}
