package com.army.building.manytomany.after;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.util.HibernateUtils;

public class TestAfterMany2Many {

	@Test
	public void testAdd0() {
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		trans.begin();
		Teacher t1 = new Teacher();
		t1.setName("zhanglao1");
		Teacher t2 = new Teacher();
		t2.setName("lilao1");

		Student s1 = new Student();
		s1.setName("zhangsheng1");
		Student s2 = new Student();
		s2.setName("lisheng1");

		TeacherStudent ts1 = new TeacherStudent();
		Date date = new Date();
		ts1.setDate(new java.sql.Date(date.getTime()));
		ts1.setTeacher(t1);
		ts1.setStudent(s1);

		TeacherStudent ts3 = new TeacherStudent();
		ts3.setDate(new java.sql.Date(date.getTime()));
		ts3.setTeacher(t1);
		ts3.setStudent(s2);

		TeacherStudent ts2 = new TeacherStudent();
		ts2.setDate(new java.sql.Date(date.getTime()));
		ts2.setTeacher(t2);
		ts2.setStudent(s1);

		TeacherStudent ts4 = new TeacherStudent();
		ts4.setDate(new java.sql.Date(date.getTime()));
		ts4.setTeacher(t2);
		ts4.setStudent(s2);

		session.save(ts1);
		session.save(ts2);
		session.save(ts3);
		session.save(ts4);
		trans.commit();
	}

	@Test
	public void testAdd1() {
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		trans.begin();
		Teacher t1 = new Teacher();
		t1.setName("zhoulao2");

		Student s1 = new Student();
		s1.setName("zhousheng2");

		session.save(t1);
		session.save(s1);
		trans.commit();
	}

	@Test
	public void testAdd2() {
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		trans.begin();
		Teacher t1 = (Teacher) session.get(Teacher.class, 3);

		Student s1 = (Student) session.get(Student.class, 1);

		TeacherStudent ts1 = new TeacherStudent();
		ts1.setStudent(s1);
		ts1.setTeacher(t1);

		session.save(ts1);
		trans.commit();
	}

	@Test
	public void testUpdate0() {
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		trans.begin();
		Teacher t1 = (Teacher) session.get(Teacher.class, 3);
		int i = 0;
		for (TeacherStudent temp : t1.getTeacherStudents()) {
			Teacher t = temp.getTeacher();
			if (t.getId() == t1.getId()) {
				i = temp.getId();
				break;
			}
		}
		TeacherStudent ts1 = (TeacherStudent) session.get(TeacherStudent.class,
				i);
		Student s1 = new Student();
		s1.setId(2);
		s1.setName("hoo");
		ts1.setStudent(s1);
		// ts1.setStudent(null); 去掉关系
		session.update(ts1);
		trans.commit();
	}

	@Test
	public void testList0() {
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		trans.begin();
		Teacher t1 = (Teacher) session.get(Teacher.class,2);
		System.err.println(t1.getName());
		for (TeacherStudent temp : t1.getTeacherStudents()) {
			System.err.println(" " + temp.getStudent().getName());
		}

		trans.commit();
	}
}
