package com.data.structure;

public class ArraySort {
	public static void main(String[] args) {
		int[][] a0 = new int[2][3];
		System.out.println(a0[0] instanceof int[]);
		int[] a = new int[] { 5, 3, 12, 4, 2 };
		maoPaoSort(a);
		System.out.println("------二分查找--------");

	}

	private static void maoPaoSort(int[] arrays) {
		int length = arrays.length;
		for (int temp : arrays) {
			System.out.print(temp + "\t");
		}

		System.out.println("\n------------------");

		for (int i = 0; i < length - 1; i++) {// 减去1，表示几个数比较的最大次数。比如说一个数组有5个数，那么最大的比较次数为4次，次数从0开始（0，1，2，3）
			for (int j = 0; j < length - i - 1; j++) {
				if (arrays[j] > arrays[j + 1]) {
					int temp = arrays[j];
					arrays[j] = arrays[j + 1];
					arrays[j + 1] = temp;
				}
			}
			System.out.print(i + ":");
			for (int temp : arrays) {
				System.out.print(temp + "\t");
			}
			System.out.print("\n");
		}

		System.out.println("\n-------after-----------");
		for (int temp : arrays) {
			System.out.print(temp + "\t");
		}
	}

	private static int binarySearch(int[] sortedArrays, int searchValue) {
		int low = 0 ; 

		
		
		
		
		return -1;
	}
}
