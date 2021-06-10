package com.project;

import java.util.Scanner;

public class SmartPhone {

	Contact[] contactArr = new Contact[10];
	private int cnt = 0;
	
	// 저장
	void saveArr(String name, String tel, String email, String addr, String birth, String group) {
		for(int i=cnt; i<contactArr.length; i++) {
			contactArr[i] = new Contact(name, tel, email, addr, birth, group);
			cnt++;
		}
	}
	// 수정, 삭제
	void modifyArr() {
		print();
		System.out.print("배열을 선택하세요 > ");
		Scanner sc = new Scanner(System.in);
		int arrNum = Integer.parseInt(sc.nextLine());
		System.out.print("수정하려면 1, 삭제하려면 2을 입력하세요 > ");
		int menuNum = Integer.parseInt(sc.nextLine());
		switch(menuNum) {
		case 1:
			String name, tel, email, addr, birth, group;
			name = sc.nextLine();
			System.out.print("전화번호을 입력하세요 > ");
			tel = sc.nextLine();
			System.out.print("이메일을 입력하세요 > ");
			email = sc.nextLine();
			System.out.print("주소을 입력하세요 > ");
			addr = sc.nextLine();
			System.out.print("생일을 입력하세요 > ");
			birth = sc.nextLine();
			System.out.print("그룹을 입력하세요 > ");
			group = sc.nextLine();
			contactArr[arrNum] = new Contact(name, tel, email, addr, birth, group);
			break;
		case 2:
			Contact delArr;
			for(int i=arrNum; i<contactArr.length; i++) {
				delArr = contactArr[i];
				contactArr[i] = contactArr[i+1];
			}
			cnt--;
			break;
		default:
			System.out.println("잘못 눌렀습니다.");
			break;
		}	
	}
	
	// 데이터 출력
	void print() {
		for(int i=0; i<contactArr.length; i++) {
			contactArr[i].printInfo();
		}
	}
}