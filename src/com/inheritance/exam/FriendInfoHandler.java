package com.inheritance.exam;

import java.util.Scanner;

public class FriendInfoHandler {

	// 저장 데이터(객체)를 배열로 저장하고  관리하는 기능을 가진 클래스
	// 성격에 따라 클래스를 나누는 것이 좋음
	
	Friend[] friends;
	int numOfFriend; // *배열의 입력 index 역할, 정보의 개수
	
	// 생성자
	public FriendInfoHandler(int num) { // 배열의 사이즈 -> 배열 인스턴스 생성
		this.friends = new Friend[num];
		this.numOfFriend = 0;
	}
	
	// 데이터의 입력 처리
	// 1. 사용자로부터 친구의 정보를 입력받고
	// 2. 인스턴스를 생성
	// 3. 배열에 저장
	public void addFriend(int choice) { // choice - 1(고교) or 2(대학)
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("이름을 입력해주세요 > ");
		String name = s.nextLine();
		System.out.print("전화번호를 입력해주세요 > ");
		String phoneNumber = s.nextLine();
		System.out.print("주소를 입력해주세요 > ");
		String address = s.nextLine();
		
		if(choice == 1) { // 고교
			System.out.print("직업을 입력해주세요 > ");
			String work = s.nextLine();
			
			// 인스턴스 생성
//			HighFriend hFriend = new HighFriend(name, phoneNumber, address, work);		
//			addFriendInfo(hFriend);
			
			addFriendInfo(new HighFriend(name, phoneNumber, address, work));
			// 위 두 줄의 코드를 한줄로 수정
			// 변수의 이름을 동일하게 만들어준다면 효율적, 실수를 줄이도록
			
			// 배열에 요소 추가
//			friends[numOfFriend] = hFriend;
//			numOfFriend++;
			// 중복되는 코드를 메소드로 생성
		} else /*if (choice == 2) */{ // 1 아니면 항상 2이므로 else로 처리가능
			System.out.print("전공을 입력해주세요 > ");
			String major = s.nextLine();
			
			// 인스턴스 생성
//			UnivFriend uFriend = new UnivFriend(name, phoneNumber, address, major);
			addFriendInfo(new UnivFriend(name, phoneNumber, address, major));
			// 배열에 요소 추가
//			friends[numOfFriend] = uFriend;
//			numOfFriend++;
			// 중복되는 코드를 메소드로 생성
		}
		
	}
	// Friend 클래스를 상속하는 타입의 인스턴스를 받아 배열에 저장
	public void addFriendInfo(Friend f) {
		friends[numOfFriend++] = f;
		System.out.println("정보가 저장되었습니다.");
	}
	
	// 모든 데이터를 출력하는 메소드
	public void showAllData() {
		System.out.println("친구의 모든 정보를 출력합니다.");
		System.out.println("----------------------");
		if(numOfFriend > 0) {
			for(int i = 0; i < numOfFriend; i++) {
				friends[i].showData();
				System.out.println("----------------------");
			}
		} else {
			System.out.println("입력된 정보가 없습니다.");
		}
		System.out.println("----------------------");
	}
	
	public void showBasicData() {
		System.out.println("친구의 기본 정보를 출력합니다.");
		System.out.println("----------------------");
		
		if(numOfFriend > 0) {
			for(int i = 0; i < numOfFriend; i++) {
				friends[i].showBasicInfo();
				System.out.println("----------------------");
			}
		} else {
			System.out.println("입력된 정보가 없습니다.");
		}
		System.out.println("----------------------");
	}
	
	// 데이터 삭제
//	public void deleteData() {
//		Scanner s = new Scanner(System.in);
//		System.out.print("지우려는 친구의 이름을 입력하세요 > ");
//		String name = s.nextLine();
//		for(int i = 0; i < numOfFriend; i++) {
//			if(friends[numOfFriend].name == name) {
//				
//			}
//		}
//	}
}