package com.army.building.manytomany.before;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.util.HibernateUtils;

public class TestBadTwo2Two {
	// 双向关联
	@Test
	public void testAdd0() {
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		trans.begin();
		Teacher t1 = new Teacher();
		t1.setName("lilao1");
		Teacher t2 = new Teacher();
		t2.setName("zhanglao1");

		Student s1 = new Student();
		s1.setName("zhangsheng1");

		Student s2 = new Student();
		s2.setName("lisheng1");

		t1.getStudents().add(s1);
		t1.getStudents().add(s2);
		t2.getStudents().add(s1);
		t2.getStudents().add(s2);

		s1.getTeachers().add(t1);
		s1.getTeachers().add(t2);

		s2.getTeachers().add(t1);
		s2.getTeachers().add(t2);
		session.save(s1);
		session.save(s2);
		trans.commit();

	}

	@Test
	public void testList0() {
		Session session = HibernateUtils.getSession();
		Transaction trans = session.beginTransaction();
		trans.begin();
		Teacher t1 = (Teacher) session.get(Teacher.class, 3);
		System.err.println(t1.getName());
		for (Student s : t1.getStudents()) {
			System.err.println("  " + s.getName());
			for (Teacher t : s.getTeachers()) {
				System.err.println("    " + t.getName());
			}
		}
		trans.commit();

	}
}
