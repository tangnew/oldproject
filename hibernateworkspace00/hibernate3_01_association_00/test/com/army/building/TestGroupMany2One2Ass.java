package com.army.building;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.util.HibernateUtil;

public class TestGroupMany2One2Ass {

	@Test
	public void listFromGroup0() {
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		Group group = new Group();
		group = (Group) session.get(Group.class, 2);
		System.out.println(group.getPersons().size());
		tran.commit();
	}

	@Test
	public void listFromContactPerson0() {
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		ContactPerson p1 = new ContactPerson();
		p1 = (ContactPerson) session.load(ContactPerson.class, 2);
		System.out.println(p1.getGroup().getName());
		tran.commit();
	}

	@Test
	public void add1() {
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		Group group = (Group) session.get(Group.class, 14);
		ContactPerson p1 = (ContactPerson) session.get(ContactPerson.class, 18);
		group.getPersons().remove(p1);
		session.save(group);
		tran.commit();
	}

	@Test
	public void remove0() {
		Session session = HibernateUtil.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		Group group = (Group) session.get(Group.class, 6);
		ContactPerson p1 = new ContactPerson();
		p1.setId(6);
		session.update(p1);
		// ContactPerson p1 = (ContactPerson) session.get(ContactPerson.class,
		// 16);
		group.getPersons().remove(p1);
		session.save(group);
		tran.commit();
	}
}
