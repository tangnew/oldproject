package com.tjj.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tjj.dao.util.HibernateUtil;

public abstract class HibernateDao<T> {

	public void save(T t) {
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		session.save(t);
		transaction.commit();
		HibernateUtil.closeSession();
	}
	
	@SuppressWarnings("unchecked")
	public T getObject(Class<T> classz, Serializable id){
		Session session = HibernateUtil.currentSession();
		Transaction transaction = session.beginTransaction();
		transaction.begin();
		T t = (T)session.get(classz, id);
		return t;
	}
}
