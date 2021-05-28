package com.array;

import java.util.Scanner;

public class Exam02 {

	public static void addOneDArr(int[][] arr, int add) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] += add;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}		
	}
	
	void input() {
		Scanner sc = new Scanner(System.in);

		System.out.println("배열을 생성합니다.");
		System.out.print("배열의 행를 입력해주세요 > ");
		int num = sc.nextInt();
		System.out.print("배열의 열을 입력해주세요 > ");
		int num2 = sc.nextInt();
		int[][] arr = new int[num][num2];
		for (int inx = 0; inx < arr.length; inx++) {
			for (int inx2 = 0; inx2 < arr[0].length; inx2++) {
				System.out.print((inx + 1) + "행의 " + (inx2 + 1) + "번째 값을 입력해주세요  > ");
				num = sc.nextInt();
				arr[inx][inx2] = num;
			}

		}
		System.out.print("배열의 더할 숫자를 입력해주세요 > ");
		num = sc.nextInt();
		addOneDArr(arr, num);
	}
	

	public static void main(String[] args) {

		int[][] arr2 = { 
						{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 
						{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
						{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 
						{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }
		};

		Exam02 ex = new Exam02();
		ex.input();
	}
}