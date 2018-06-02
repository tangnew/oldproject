package com.tjj.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tjj.dao.AbstractDao;
import com.tjj.dao.StudentDao;
import com.tjj.model.Student;
import com.tjj.util.HibernateUtil;

public class StudentDaoImpl extends AbstractDao<Student> implements StudentDao {

	@Override
	public void addStudent(Student st) {
		super.save(st);
	}

	@Override
	public Student findStudentByGuid(String guid) {
		Session session = HibernateUtil.currentSession();
		Transaction tran = session.beginTransaction();
		Query q = session
				.createQuery("from Student as s where s.teacher.guid=:guid");
		q.setParameter("guid", guid);
		Student s = (Student) q.list().get(0);
		tran.commit();
		return s;
	}

	@Override
	public Student findStudentById(Integer id) {
		return super.get(Student.class, id);
	}

	
}
