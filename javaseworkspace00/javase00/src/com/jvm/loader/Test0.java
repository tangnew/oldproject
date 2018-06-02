package com.jvm.loader;

public class Test0 {
	static int a = 1;
	static {
		System.out.println("static");
	}

	public static void main(String[] args) {
		System.out.println("main");
		System.out.println(Test0.a);
	}
	
	public static int main(int[] args){
		System.out.println("a");
		return 1;
	}
	
	private void b(int ...a){
		
	}
}
