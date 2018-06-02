package com.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static Configuration cfg = new Configuration().configure();
	private static SessionFactory factory = cfg.buildSessionFactory();

	public static Session getSession() {
		return factory.openSession();
	}
}
