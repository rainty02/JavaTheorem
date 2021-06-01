package com.collection.exam;

import java.util.*;

public class ListFootballPlayer {	
	
	public static void main(String[] args) {
		
		// list 인스턴스 생성
		List<ListFootball> fbList = new ArrayList<ListFootball>();

		// 데이터 저장
		fbList.add(new ListFootball("손흥민", 1, "뮌헨", 25));
		fbList.add(new ListFootball("이강인", 2, "첼시", 27));
		fbList.add(new ListFootball("박지성", 3, "맨유", 29));	

		// list 데이터 출력
		Iterator<ListFootball> itr = fbList.iterator();
		while(itr.hasNext()) {
			itr.next().showData();
		}
	}
}

class ListFootball {
	
	// listfootball 멤버
	String name;
	int number;
	String team;
	int age;

	// 생성자
	public ListFootball(String name, int number, String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}
	
	// 데이터 출력 메소드
	public void showData() {
		System.out.print("이름 : " + this.name + "\t");
		System.out.print("번호 : " + this.number + "\t");
		System.out.print("팀 : " + this.team + "\t");
		System.out.print("나이 : " + this.age + "\t");
		System.out.println();
	}
}