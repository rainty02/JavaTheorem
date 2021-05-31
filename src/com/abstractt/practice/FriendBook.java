package com.abstractt.practice;

import java.util.Scanner;

public class FriendBook {

	public static void main(String[] args) {

//		Friend friend = new Friend("","","");
		// 추상클래스로 변경되면 인스턴스화 불가
		
		FriendInfoHandler handler = new FriendInfoHandler(100);

		Scanner s = new Scanner(System.in);

		while (true) {
			System.out.println("**** 메뉴  선택 ****");
			System.out.println(Menu.HIGH_FRI + ". 고교 친구 정보 입력");
			System.out.println(Menu.UNIV_FRI+ ". 대학 친구 정보 입력");
			System.out.println(Menu.PHONE_UNIV+ ". 대학 전화번호부 정보 입력");
			System.out.println(Menu.COMPANY_FRI+ ". 직장 동료 정보 입력");
			System.out.println(Menu.SHOW_ALL+ ". 전체 정보 출력");
			System.out.println(Menu.SHOW_BASIC+ ". 기본 정보 출력");
			System.out.println(Menu.DELETE_DATA+ ". 친구 정보 삭제");
			System.out.println(Menu.EXIT+ ". 프로그램 종료");
			System.out.println("*****************");
			System.out.print("메뉴를 선택하시오 > ");
				String choice = s.nextLine();
				switch (choice) {
				case Menu.HIGH_FRI:
				case Menu.UNIV_FRI:
				case Menu.PHONE_UNIV:
				case Menu.COMPANY_FRI:
					handler.addFriend(Integer.parseInt(choice));
					break;
				case Menu.SHOW_ALL:
					handler.showAllData();
					break;
				case Menu.SHOW_BASIC:
					handler.showBasicData();
					break;
				case Menu.DELETE_DATA:
					handler.deleteData();
					break;
				case Menu.EXIT:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("잘못 입력하셨습니다.");
					continue;
				}
		}

	}
}

interface Menu {
	String HIGH_FRI = "1"; // public static final 생략가능
	String UNIV_FRI = "2";
	String PHONE_UNIV = "3";
	String COMPANY_FRI = "4";
	String SHOW_ALL = "5";
	String SHOW_BASIC = "6";
	String DELETE_DATA = "7";
	String EXIT = "8";
}