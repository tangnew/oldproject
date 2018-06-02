package com.tjj.dao.util;

import org.junit.Test;

public class HibernateUtilTest {

	@Test
	public void testGetCurrentSession(){
		System.out.println(HibernateUtil.currentSession());
	}
}
