package com.generic;

public class Main {
	public static void main(String[] args) {
		ParentInterface<String, Integer> pInterface = new ChildClass<String, Integer, Boolean>();
		pInterface.setT1("12");
		pInterface.setT2(1);
		System.out.println(pInterface.getT1());
	}
}
