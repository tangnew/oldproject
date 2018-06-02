package com.face;

public class StringMain {
	private static void change(String str) {
		str = "welcome";
		System.out.println(str.hashCode());
	}

	public static void main(String[] args) {
		String str = "1234";
		change(str);
		System.out.println(str.hashCode());
		System.out.println(str);
	}
}
