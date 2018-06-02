package com.data.structure;

import java.lang.reflect.Field;

public class StringMain {

	public static void main(String[] args) {
		String a = "a";
		String b = "a";
		System.out.println(a.intern() == b.intern());

		System.out.println("------------------");
		String a1 = new String("ab");
		String b1 = new String("ab");
		System.out.println(a1 == b1);

		System.out.println(a1.hashCode());
		try {
			Field[] fileds = a1.getClass().getDeclaredFields();
			for (Field temp : fileds) {
				System.out.println(temp);
			}

			Field hash = a1.getClass().getDeclaredField("hash");
			hash.setAccessible(true);
			hash.set(a1, 11111);
			System.out.println(hash.get(a1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
