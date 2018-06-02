package com.factory0;

public class Main {
	public static void main(String[] args) {
		System.out.println("简单工厂");
		Factory f = new FlightFactory();
		Moveable m = f.create();
		m.run();
		System.out.println("=================================");
	}
}
