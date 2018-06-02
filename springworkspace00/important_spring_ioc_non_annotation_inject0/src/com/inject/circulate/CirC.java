package com.inject.circulate;

public class CirC {
	private String name;
	private CirA cirA;

	public CirC() {
	}

	public CirC(CirA cirA, String name) {
		this.cirA = cirA;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CirA getCirA() {
		return cirA;
	}

	public void setCirA(CirA cirA) {
		this.cirA = cirA;
	}

	public void c() {
		System.out.println("c");
		cirA.a();
	}

}
