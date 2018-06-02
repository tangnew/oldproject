package com.inject.circulate;

public class CirB {
	private String name;
	private CirC cirC;
	public CirB() {
	}
	public CirB(CirC cirC, String name) {
		this.cirC = cirC;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CirC getCirC() {
		return cirC;
	}

	public void setCirC(CirC cirC) {
		this.cirC = cirC;
	}
	public void b() {
		System.out.println("b");
		cirC.c();
		
	}

}
