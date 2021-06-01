package com.exception.exam;

import java.util.*;

public class ExceptionPrac2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("태어난 연도를 입력해주세요 > ");
		try {
			int year = sc.nextInt();
			System.out.println("태어난 연도는 " + year +"년입니다");
		} catch (InputMismatchException e) {
			// 숫자가 아닌 값 입력시 예외발생
			System.out.println("숫자를 입력해주세요.");
		}
	}
}