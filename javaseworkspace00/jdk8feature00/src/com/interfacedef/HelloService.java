package com.interfacedef;

public interface HelloService {
	static void sayHello(String name) {
		System.out.println("interface:" + name);
	}

	public default void sayHello(){
		System.out.println("def");
	}
	public static void main(String[] args) {
		sayHello("ok");
	}
}
