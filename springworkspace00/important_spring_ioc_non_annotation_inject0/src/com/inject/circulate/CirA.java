package com.inject.circulate;

public class CirA {
	private String name;
	private CirB cirB;

	public CirA() {
	}
	public CirA(CirB cirB, String name) {
		this.cirB = cirB;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CirB getCirB() {
		return cirB;
	}

	public void setCirB(CirB cirB) {
		this.cirB = cirB;
	}
	
	public void a() { 
		System.out.println("a");
		cirB.b();  
		}  

}
