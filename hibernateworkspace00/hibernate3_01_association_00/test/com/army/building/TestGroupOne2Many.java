package com.army.building;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.util.HibernateUtil;

public class TestGroupOne2Many {
	@Test
	public void add1() {
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		Group group = new Group();
		group.setName("chengdu");

		ContactPerson p1 = new ContactPerson();
		p1.setName("zhangsan1");
		p1.setAge(12);

		ContactPerson p2 = new ContactPerson();
		p2.setName("zhangsan2");
		p2.setAge(13);

		group.getPersons().add(p1);
		group.getPersons().add(p2);

		session.save(group);
		tran.commit();
	}

	/* 未级联的关系 */
	@Test
	public void add2() {
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		Group group = new Group();
		group.setName("chengdu1");

		ContactPerson p1 = new ContactPerson();
		p1.setName("zhangsan11");
		p1.setAge(12);

		p1.setGroup(group);
		session.save(p1);
		session.save(group);

		tran.commit();
	}
}
