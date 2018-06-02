package com.army.building.onetomany;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.util.HibernateUtils;

public class TestOneToMany {
	// <set name="students" cascade="all">中没有添加inverse="true"的测试用例
	// 此时可以将student添加进数据库,并且赋上teacher的id.
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

	// <set name="students"
	// cascade="all">中未添加inverse="true"的测试用例,并且是是从student端添加记录.
	// 此时student能够添加进数据库,但是teacher无法添加进去
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
		Set<Student> set = new HashSet<Student>();
		set.add(s1);
		set.add(s2);

		teacher.setStudents(set);
		session.save(s1);
		session.save(s2);
		tran.commit();
	}

	// <set name="students"
	// cascade="all">中添加inverse="true"的测试用例,并且是是从student端添加记录.
	// 此时student能够添加进数据库,但是teacher无法添加进去
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
		s1.setTeacher(teacher);
		Student s2 = new Student();
		s2.setName("S_WangWu");
		s2.setAge(22);
		s2.setAddress("address2");
		s2.setTeacher(teacher);
		Set<Student> set = new HashSet<Student>();
		set.add(s1);
		set.add(s2);

		teacher.setStudents(set);
		session.save(s1);
		session.save(s2);
		tran.commit();
	}

	// <set name="students"
	// cascade="all">中添加inverse="true"的测试用例,并且是是从teacher端添加记录.
	// 此时teacher能够添加进数据库,但是student无法添加进去
	@Test
	public void testAdd3() {
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

		session.save(teacher);
		tran.commit();
	}

	// <set name="students" cascade="all" lazy="extra">
	@Test
	public void testUpdateStudentToTeacher0() {
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		Teacher t = (Teacher) session.get(Teacher.class, 1);
		Student s1 = new Student();
		s1.setId(1);
		Student s2 = new Student();
		s2.setId(2);
		Student s3 = new Student();
		s3.setId(3);
		t.getStudents().add(s1);
		t.getStudents().add(s2);
		t.getStudents().add(s3);
		session.save(t);
		tran.commit();
	}

	@Test
	public void testAdd4(){
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		
		Student s1 = new Student();
		s1.setName("lisi0");
		s1.setAge(12);
		
		Teacher t = new Teacher();
		t.setName("laoshi1");
		t.setAge(50);
		t.getStudents().add(s1);
		
		session.save(t);
		tran.commit();
	}
	
	@Test
	public void testAdd5(){
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		
		Student s1 = new Student();
		s1.setName("lisi0");
		s1.setAge(12);
		Teacher t = new Teacher();
		t.setName("laoshi1");
		t.setAge(50);
		t.getStudents().add(s1);
		s1.setTeacher(t);
		session.save(s1);
		tran.commit();
	}
	
	@Test
	public void testDeleteTeacher1(){
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		
		Teacher t = new Teacher();
		t.setId(1);
		t.setName("T_Zhangsan");
		
		session.delete(t);
		tran.commit();
	}
	
	
	@Test
	public void testDeleteTeacher2(){
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		
		Teacher t = ( Teacher)session.get(Teacher.class, 2);
		session.delete(t);
		tran.commit();
	}
	
	// <set name="students" cascade="all" lazy="extra"> 移除teacher与student关系
	@Test
	public void testUpdateStudentToTeacher1() {
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		Teacher t = (Teacher) session.get(Teacher.class, 1);
		Student s1 = new Student();
		s1.setId(1);

		t.getStudents().remove(s1);
		session.save(t);
		tran.commit();
	}

	// <set name="students" cascade="all" lazy="extra"> 移除teacher与student关系
	@Test
	public void testDeleteTeacher0() {
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		Teacher t = (Teacher) session.get(Teacher.class, 1);
		session.delete(t);
		tran.commit();
	}
}
