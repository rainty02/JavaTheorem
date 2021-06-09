package com.project;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		String name, tel, email, addr, birth, group;
		
		Scanner sc = new Scanner(System.in);
		Contact contact = new Contact();
		
		// 저장할 데이터를 콘솔에서 사용자의 입력 값으로 인스턴스를 생성해봅시다.
		System.out.print("이름을 입력하세요 > ");
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
		
		// 연락처 데이터를 저장하는 인스턴스를 생성합니다
		contact = new Contact(name, tel, email, addr, birth, group);
		
		// 변수 값을 반환하는 각각의 메소드를 호출해서 각 데이터를 출력문으로 출력합니다.
		System.out.println(contact.getName());
		System.out.println(contact.getTel());
		System.out.println(contact.getEmail());
		System.out.println(contact.getAddr());
		System.out.println(contact.getBirth());
		System.out.println(contact.getGroup());
		
		// 생성된 인스턴스의 정보 출력 메소드를 호출합니다
		contact.printInfo();
		
		// 인스턴스의 각 변수에 값을 바꾸는 메소드를 이용해서 데이터를 수정합니다.
		System.out.print("이름을 입력하세요 > ");
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
		
		contact = new Contact(name, tel, email, addr, birth, group);

		// 인스턴스의 출력메소드를 다시 실행합니다
		contact.printInfo();
	}
}
