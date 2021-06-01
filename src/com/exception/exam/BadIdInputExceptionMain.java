package com.exception.exam;

import java.util.*;

public class BadIdInputExceptionMain {

	public static boolean check(String name) {
		boolean result = true;
		for (int i = 0; i < name.length(); i++) {
			char ch = name.charAt(i);
			if (!(ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z')) {
				result = false;
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("영문 이름을 입력하세요 > ");
		String name = sc.nextLine();

		if (name != null && !name.trim().isEmpty()) {
			if (check(name)) {
				System.out.println("이름은 " + name + "입니다.");
			} else {
				try {
					throw new BadIdInputException("에러 발생 : 알파벳을 입력하세요.");
				} catch (BadIdInputException e) {
					System.out.println(e.getMessage());
				}
			}
		} else {
			System.out.println("값이 없거나 빈칸이 포함됐습니다.");
		}
	}}