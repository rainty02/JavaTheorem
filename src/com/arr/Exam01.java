package com.arr;

import java.util.Scanner;

public class Exam01 {

	public static int miniValue(int[] arr) {
		int temp = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(temp > arr[i]) {
				temp = arr[i];				
			}
		}
		return temp;
	}
	
	public static int maxValue(int[] arr) {
		int temp = arr[0];
		for(int i = 1; i < arr.length; i++) {
			if(temp < arr[i]) {
				temp = arr[i];
			}
		}
		return temp;
	}
		
	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
			
		System.out.println("배열을 생성합니다.");
		System.out.print("배열의 크기를 입력해주세요 > ");
		int num = sc.nextInt();
		int[] arr = new int[num];
		for(int inx = 0; inx < arr.length; inx++) {
			System.out.print((inx + 1) +"번째 값을 입력해주세요  > ");
			num = sc.nextInt();
			arr[inx] = num;
		}
		Exam01 ex = new Exam01();
		System.out.println("입력하신 값 중 가장 작은 값은 " + ex.miniValue(arr) + "입니다");
		System.out.println("입력하신 값 중 가장 큰 값은 " + ex.maxValue(arr) + "입니다");
	}
}