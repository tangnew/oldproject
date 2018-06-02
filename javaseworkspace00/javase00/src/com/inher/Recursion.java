package com.inher;

public class Recursion {
 public static int computer(int n){
	 if(1 == n){
		 return 1;
	 }else{
		return computer(n -1) * n; 
	  }
 }
 public static void main(String[] args) {
	int a = computer(5);
	System.out.println(a);
}
}
