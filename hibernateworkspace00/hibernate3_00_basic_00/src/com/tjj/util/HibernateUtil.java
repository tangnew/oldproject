package com.tjj.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

	private static final SessionFactory sf = new Configuration().configure()
			.addResource("hibernate.cfg.xml").buildSessionFactory();

	public static Session currentSession() {
		Session session = threadLocal.get();
		if (null == session) {
			session = sf.openSession();
			threadLocal.set(session);
		}
		return session;
	}

	public static void closeSession() {
		Session session = threadLocal.get();
		if (null != session) {
			session.close();
		}
		threadLocal.set(null);
	}
}
