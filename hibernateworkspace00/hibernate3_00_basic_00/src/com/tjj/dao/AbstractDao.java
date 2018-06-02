package com.tjj.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tjj.util.HibernateUtil;

public abstract class AbstractDao<T> {

	public void save(T t) {
		Session session = HibernateUtil.currentSession();
		Transaction tran = session.beginTransaction();
		session.save(t);
		tran.commit();
	}

	public void saveOrUpdate(T t) {
		Session session = HibernateUtil.currentSession();
		Transaction tran = session.beginTransaction();
		session.saveOrUpdate(t);
		tran.commit();
	}

	public void delete(T t) {
		Session session = HibernateUtil.currentSession();
		Transaction tran = session.beginTransaction();
		session.delete(t);
		tran.commit();
	}

	public T get(Class<T> clz, Serializable id) {
		Session session = HibernateUtil.currentSession();
		Transaction tran = session.beginTransaction();
		@SuppressWarnings("unchecked")
		T t = (T) session.get(clz, id);
		return t;
	}
}
