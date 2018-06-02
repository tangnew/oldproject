package com.army.building.selft.onetomany.two.configuration;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.util.HibernateUtils;

public class TestSelfOneToManyTwoConfiguration {
	// 插入记录，并且记录关系
	@Test
	public void testAdd0() {
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		Employee root = new Employee();
		root.setName("root");

		Employee e = new Employee();
		e.setName("manager");
		e.setManger(root);
		root.setStaffs(new HashSet<Employee>());
		root.getStaffs().add(e);

		Employee staff1 = new Employee();
		staff1.setName("staff1");
		staff1.setManger(e);

		Employee staff2 = new Employee();
		staff2.setName("staff2");
		staff2.setManger(e);

		e.setStaffs(new HashSet<Employee>());
		e.getStaffs().add(staff1);
		e.getStaffs().add(staff2);

		session.save(root);
		tran.commit();
	}

	@Test
	public void testList0() {
		Session session = HibernateUtils.getSession();
		Transaction tran = session.beginTransaction();
		tran.begin();
		Employee root = (Employee) session.get(Employee.class, 1);
		outResult(root, 0);
		tran.commit();
	}

	private void outResult(Employee e, int level) {
		if (e != null) {
			for (int i = 0; i < level; i++) {
				System.out.print(" ");
			}
			System.out.println(level + " level " + e.getName());

			if (e.getStaffs() != null && e.getStaffs().size() > 0) {
				for (Employee temp : e.getStaffs()) {
					outResult(temp, level + 1);
				}
			}
		}

	}
}
