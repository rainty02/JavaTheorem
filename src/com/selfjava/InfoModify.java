package com.selfjava;

import java.util.Scanner;

public class InfoModify {

	void addInfo() {

		Scanner sc = new Scanner(System.in);

			System.out.print("이름을 입력하세요 > ");
			String name = sc.nextLine();
			System.out.println(name);
			System.out.print("전화번호을 입력하세요 > ");
			String num = sc.nextLine();
			System.out.println(num);
			System.out.print("이메일을 입력하세요 > ");
			String email = sc.nextLine();
			System.out.println(email);
			System.out.print("주소을 입력하세요 > ");
			String address = sc.nextLine();
			System.out.println(address);
			System.out.print("생일을 입력하세요 > ");
			String birth = sc.nextLine();
			System.out.println(birth);
			System.out.print("그룹을 입력하세요 > ");
			String group = sc.nextLine();
			System.out.print(group);

	}
}
