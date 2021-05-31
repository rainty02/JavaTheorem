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
			System.out.println("1. 고교 친구 정보 입력");
			System.out.println("2. 대학 친구 정보 입력");
			System.out.println("3. 대학 전화번호부 정보 입력");
			System.out.println("4. 직장 동료 정보 입력");
			System.out.println("5. 전체 정보 출력");
			System.out.println("6. 기본 정보 출력");
			System.out.println("7. 친구 정보 삭제");
			System.out.println("8. 프로그램 종료");
			System.out.println("*****************");
			System.out.print("메뉴를 선택하시오 > ");
				String choice = s.nextLine();
				switch (choice) {
				case "1":
				case "2":
				case "3":
				case "4":
					handler.addFriend(Integer.parseInt(choice));
					break;
				case "5":
					handler.showAllData();
					break;
				case "6":
					handler.showBasicData();
					break;
				case "7":
					handler.deleteData();
					break;
				case "8":
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("잘못 입력하셨습니다.");
					continue;
				}
		}

	}
}