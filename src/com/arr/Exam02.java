package com.arr;

public class Exam02 {

	public static void addOneDArr(int[][] arr, int add) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j <arr[0].length; j++) {
				arr[i][j] += add;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		int[][] arr = {
				{1,2,3,4,5,6,7,8,9,10},
				{1,2,3,4,5,6,7,8,9,10},
				{1,2,3,4,5,6,7,8,9,10},
				{1,2,3,4,5,6,7,8,9,10}
		};
		
		Exam02 ex = new Exam02();
		ex.addOneDArr(arr, 10);		
	}
}