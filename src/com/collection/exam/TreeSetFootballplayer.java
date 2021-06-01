package com.collection.exam;

import java.util.*;

public class TreeSetFootballplayer {

	public static void main(String[] args) {
		
		// treeset 인스턴스 생성
		TreeSet<TreeSetFootball> fbTreeSet = new TreeSet<TreeSetFootball>();
		
		// 데이터 저장
		fbTreeSet.add(new TreeSetFootball("손", 1, "뮌헨", 25));
		fbTreeSet.add(new TreeSetFootball("손", 2, "첼시", 27));
		fbTreeSet.add(new TreeSetFootball("이", 3, "뮌헨", 29));	
		fbTreeSet.add(new TreeSetFootball("박", 2, "맨유", 29));
		fbTreeSet.add(new TreeSetFootball("박", 3, "맨유", 24));
		
		// 데이터 출력
		Iterator<TreeSetFootball> itr = fbTreeSet.iterator();
		while(itr.hasNext()) {
			itr.next().showData();
		}	
	}
}

class TreeSetFootball implements Comparable<TreeSetFootball>{
	// Comparable 인터페이스 구현
	
	// 멤버
	String name;
	int number;
	String team;
	int age;

	// 생성자
	public TreeSetFootball(String name, int number, String team, int age) {
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
	
	@Override
	public int compareTo(TreeSetFootball o) {
		//팀, 이름, 번호 순
		int result = this.team.compareTo(o.team);
		if (result == 0) {
			result = this.name.compareTo(o.name);
			if(result == 0) {
				if(this.age > o.age) {
					result = 1;
				} else {
					result = -1;
				}
			}		 	
		}
		return result;
	}	
}