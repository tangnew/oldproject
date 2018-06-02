package com.face;

public class StringMain0 {

	public static void main(String[] args) {

			
		String a = "ab";
		String b = "ab";
		String c = a + b;
		System.out.println( a + b == "abab" );
		System.out.println( c == (a + b) );
		System.out.println(a == b);
		System.out.println(1 + 2 + "a" +( 2 + 2));
		System.out.println("c" + "a==b" + "");
		System.out.println(c == "abab");
		System.out.println(c.hashCode() + " " + "abab".hashCode());
		System.out.println("a" + 1 +6);
	}
}
