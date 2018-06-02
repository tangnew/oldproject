package com.interfacedef;

public interface B {
	public default void sayHello(){
		System.out.println("b");
	}
}
