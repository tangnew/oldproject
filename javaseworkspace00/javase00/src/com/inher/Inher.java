package com.inher;

public class Inher {
	public static void main(String[] args) {
		Parent c = new Clild(1);
	}
}

class Parent {
	public Parent() {
		System.out.println("Parent");
	}
}

class Clild extends Parent {
	public Clild(int a) {
		System.out.println("Clild:" + a);
	}
}