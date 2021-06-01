package com.collection.exam;

import java.util.*;

public class ListFootballPlayer {	
	
	public static void main(String[] args) {
		
		// List 인스턴스 생성
		List<ListFootball> fbList = new ArrayList<ListFootball>();

		// 데이터 저장
		fbList.add(new ListFootball("손흥민", 1, "뮌헨", 25));
		fbList.add(new ListFootball("이강인", 2, "첼시", 27));
		fbList.add(new ListFootball("박지성", 3, "맨유", 29));	
		fbList.add(new ListFootball("손흥민", 1, "뮌헨", 25));
		fbList.add(new ListFootball("이강인", 2, "첼시", 27));
		fbList.add(new ListFootball("박지성", 3, "맨유", 29));	

		// list 데이터 출력
		Iterator<ListFootball> itr = fbList.iterator();
		while(itr.hasNext()) {
//			itr.next().showData();
			// 출력 메소드 호출
			System.out.println(itr.next());
			// toString 출력
		}
	}
}

class ListFootball {
	
	// ListFootball 멤버
	private String name;
	private int number;
	private String team;
	private int age;

	
	// 생성자
	public ListFootball(String name, int number, String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}
	
	// 게터, 세터
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	// toString 오버라이딩
	@Override
	public String toString() {
		return "이름 : " + this.name + "\t" +
				"번호 : " + this.number + "\t" + 
				"팀 : " + this.team + "\t" +
				"나이 : " + this.age;
	}
	
	// 데이터 출력 메소드
	public void showData() {
		System.out.print("이름 : " + this.name + "\t");
		System.out.print("번호 : " + this.number + "\t");
		System.out.print("팀 : " + this.team + "\t");
		System.out.print("나이 : " + this.age);
		System.out.println();
	}
}