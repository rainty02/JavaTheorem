package com.selfjava;

import java.util.Scanner;

public class ContactMain {

	public static void main(String[] args) {
		
		Contact im = new Contact();
		Scanner sc = new Scanner(System.in);	
		
		System.out.println("=====================");
		System.out.println("1. 연락처 입력");
		System.out.println("2. 연락처 검색");
		System.out.println("3. 연락처 수정");
		System.out.println("4. 연락처 삭제");
		System.out.println("5. 연락처 전체 리스트 보기");
		System.out.println("6. 종료");
		System.out.println("=====================");
		System.out.print("메뉴를 선택하세요 > ");
		int menu = Integer.parseInt(sc.nextLine());
		
		switch (menu) {
		case 1: 

		}
	}
}