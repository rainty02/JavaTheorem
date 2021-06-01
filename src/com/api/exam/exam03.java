package com.api.exam;

import java.util.Scanner;

public class exam03 {

	public static boolean check(String name) {
		boolean result = true;
		for(int i=0; i<name.length(); i++) {
			char ch = name.charAt(i);
			if(!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')) {
				result = false;
				break;
			}
		}
		return result;	
	}
	
	public static void main(String[] args) {

		// 3. 사용자에게 이름을 입력 받아 입력 받은 문자열을
		// 정상적인 문자열의 이름으로 표현하는지 판별하고
		// 공백으로 입력되었는지도 판별하는 프로그램을 만들어봅시다.
		
		Scanner sc = new Scanner(System.in);		
		System.out.print("영문 이름을 입력하세요 > ");
		String name = sc.nextLine();
		// 값이 있고 입력된 값 앞뒤에 공백을 지우고 공백이 아니면
		if(name!=null && !name.trim().isEmpty()) {
			if(check(name)) {
				System.out.println("이름은 " + name + "입니다.");
			} else {
				System.out.println("알파벳이 아니거나 빈칸이 포함됐습니다.");
			}
		} else {
			System.out.println("값이 없거나 빈칸이 포함됐습니다.");
		}
	}
}