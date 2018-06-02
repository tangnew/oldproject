package com.jiawen.tong.defaultinterface;

public class Main {
	public static void main(String[] args) {
		ParentI p = new ParentImpl();
		p.message();
		p = new ChildImpl();
		p.message();
	}
}

interface ParentI {
	public default void message() {
		System.out.println("default ParentI");
	}
	public void welcome();
}

class ParentImpl implements ParentI {
	@Override
	public void welcome() {
		System.out.println();
	}

	@Override
	public void message() {
		System.out.println("default ParentImpl");
	}
}

interface ChildI extends ParentI{
	public default void message() {
		System.out.println("default ChildI");
	}
}

class ChildImpl implements ChildI{
	@Override
	public void welcome() {
		
	}
	
	
}