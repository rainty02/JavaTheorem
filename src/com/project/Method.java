package com.project;

import java.util.ArrayList;
import java.util.Scanner;

public class Method {

	private Scanner sc;	
	private Member mem;
	private ArrayList<Member> meminfo;
	private boolean loginState = false;
	
	// 1. 회원가입
	void addMem() {
		System.out.print("아이디 > ");
		String id = sc.nextLine();
		System.out.print("패스워드 > ");
		String pw = sc.nextLine();
		System.out.print("이름");
		String name = sc.nextLine();
		System.out.print("전화번호 > ");
		String tel = sc.nextLine();
		System.out.print("주소 > ");
		String addr = sc.nextLine();
		
		mem = new Member(id, pw, name, tel, addr);		
		meminfo.add(mem);

	}
	
	// 2. 로그인
	void login() {
		System.out.print("아이디 > ");
		String id = sc.nextLine();
		System.out.print("패스워드 > ");
		String pw = sc.nextLine();
		
		int logCnt = 0;
		while (true) {
			if (id == mem.getId() && pw == mem.getPw()) {
				System.out.println("로그인하셨습니다.");
				loginState = true;
				logCnt = 0;
				break;
			} else {
				logCnt++;
				System.out.println("아이디 혹은 패스워드가 틀렸습니다.");
				System.out.println("로그인 횟수가 " + (3 - logCnt) + "회 남았습니다.");
				if (logCnt == 3) {
					System.out.println("로그인 횟수를 초과했습니다.");
					System.out.println("초기화면으로 돌아갑니다.");
					return;
				}
			}
		}		
	}
	
	// 3. 책 대여
	void rentBook() {
		
	}
	
	
	// 4. 책 반납

	
	// 5. 내 정보
}