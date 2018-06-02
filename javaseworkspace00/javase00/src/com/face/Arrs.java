package com.face;

public class Arrs {
	public static void main(String[] args) {
		String[][] strs = { { "a", "b" } };
		int[][] bits = { { 1, 2, 2 }, { 2, 223 } };
		int[][] c = new int[][] { { 1, 2, 2 }, { 2, 223 } };

		int[][] d = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 },
				{ 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				System.out.print(d[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("===================");

		for (int i = 0; i < d.length; i++) {
			for (int j = i + 1; j < d.length; j++) {
				int temp = d[i][j];
				d[i][j] = d[j][i];
				d[j][i] = temp;
			}
		}

		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				System.out.print(d[i][j] + "\t");
			}
			System.out.println();
		}
		//
		// int a = 1, b = 3;
		// String e = "*";
		// System.out.println(a + e + b);
		// System.out.printf("%d%s%d", a,e,b);
	}
}
