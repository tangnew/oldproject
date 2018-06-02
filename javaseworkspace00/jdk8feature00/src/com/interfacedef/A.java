package com.interfacedef;

public interface A {
	public default void sayHello() {
		System.out.println("a");
	}
}
