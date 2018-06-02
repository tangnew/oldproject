package com.tjj;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	// 读取配置文件,一个应用就该只有一个配置，并且读取到内存中。较快。属于线程安全
	private static Configuration cfg = new Configuration().configure();
	// 建立连接池，也是在应用启动时建立。里面管理了连接池。属于线程安全
	private static SessionFactory factory = cfg.buildSessionFactory();

	// 属于线程不安全
	public static Session getSession() {
		return factory.openSession();
	}

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
