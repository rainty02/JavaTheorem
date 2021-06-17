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
		if(arrNum > contactArr.length) {
			System.out.println("해당 배열이 존재하지 않습니다.");
			System.out.println("처음으로 돌아갑니다.");
			return;
		}
		switch(menuNum) {
		case 1:
			String name, tel, email, addr, birth, group;
			System.out.print("이름을 입력하세요 >");
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
			if(1 == contactArr.length || arrNum == contactArr.length) {
				contactArr[arrNum] = null;
			} else {
				for(int i=arrNum; i<contactArr.length - 1; i++) {
					delArr = contactArr[i];
					contactArr[i] = contactArr[i+1];
				}
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
		if (contactArr[0] == null) {
			System.out.println("저장된 배열이 없습니다.");
			return;
		} else {
			for(int i=0; i<contactArr.length; i++) {
				contactArr[i].printInfo();
			}
		}
	}
	
	public static void main(String[] args) {
		SmartPhone sp = new SmartPhone();
		sp.saveArr("a", "tel", "email", "addr", "birth", "group");
		sp.modifyArr();
		
	}
	
}