package com.interfacedef;

public class C implements A, B {

	@Override
	public void sayHello() {
		System.out.println("c");

	}

	public static void main(String[] args) {
		A a = new C();
		a.sayHello();
		B b = new C();
		b.sayHello();
	}
}
