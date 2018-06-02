package com.tjj.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tjj.dao.util.HibernateUtil;

public class AbstractDao<T> {

	public List<T> findAll(Class<T> clz) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tran = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<T> result = session.createQuery("from " + clz.getName()).list();
		tran.commit();
		HibernateUtil.closeSession();
		return result;
	}

	public void save(T t) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tran = session.beginTransaction();
		session.save(t);
		tran.commit();
		HibernateUtil.closeSession();
	}

	public T get(Class<T> clz, Serializable id) {
		Session session = HibernateUtil.getCurrentSession();
		Transaction tran = session.beginTransaction();
		Object o = session.get(clz, id);
		tran.commit();
		HibernateUtil.closeSession();
		return (T)o;
	}

	public T load(Class<T> clz, Serializable id) {
		Session session = HibernateUtil.getCurrentSession();
		session.beginTransaction();
		Object o = session.load(clz, id);
		return (T)o;
	}
}
