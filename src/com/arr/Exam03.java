package com.arr;

public class Exam03 {

	public static void lineChange (int[][] arr) {
		int[] temp = new int[1];
		for(int inx = arr.length - 1; inx > 0; inx--) {
			// 역산 수정
			temp = arr[inx];
			arr[inx] = arr[inx-1];
			arr[inx-1] = temp;
		}
		
		
//		for(int inx = 0; inx < arr.length - 1; inx++) {
//			temp = arr[inx];
//			arr[inx] = arr[inx+1];
//			arr[inx+1] = temp;
//		}
//		
		
		for(int inx = 0; inx <arr.length; inx++) {
			for(int inx2 = 0; inx2 <arr.length; inx2++) {
				System.out.print(arr[inx][inx2]);
			}
			System.out.println();
		}	
	}
	
	public static void main(String[] args) {
		
		int[][] arr = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};

		Exam03 ex = new Exam03();
		ex.lineChange(arr);	
	}
}