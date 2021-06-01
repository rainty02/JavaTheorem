package com.collection.exam;

import java.util.*;

public class SetFootballPlayer {
	
	public static void main(String[] args) {

		// Set 인스턴스 생성
		Set<SetFootball> fbSet = new HashSet<SetFootball>();

		// 데이터 저장
		fbSet.add(new SetFootball("손흥민", 1, "뮌헨", 25));
		fbSet.add(new SetFootball("손흥민", 1, "뮌헨", 25));
		fbSet.add(new SetFootball("이강인", 2, "첼시", 27));
		fbSet.add(new SetFootball("박지성", 3, "맨유", 29));	
		fbSet.add(new SetFootball("이강인", 2, "첼시", 21));
		
		// 데이터 출력
		Iterator<SetFootball> itr = fbSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}

class SetFootball {
	
	// SetFootball 멤버
	String name;
	int number;
	String team;
	int age;

	// 생성자
	public SetFootball(String name, int number, String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}
	
	@Override // toString 오버라이딩
	public String toString() {
		return "이름 : " + this.name + "\t" +
				"번호 : " + this.number +  "\t" +
				"팀 : " + this.team +  "\t" +
				"나이 : " + this.age;
	}
	
	@Override
	public int hashCode() {
		return number%2; // 0,1,2 3개의 그룹
	}
	
	@Override 
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj != null && obj instanceof SetFootball) {
			// 인스턴스가 null이 아니고 setfootball로 형변환이 가능하다면
			SetFootball setMem = (SetFootball) obj;
			// 형변환
			if(this.name == setMem.name && this.team == setMem.team && this.age == setMem.age) {
				result = true;
				// 이름, 팀, 나이가 같다면 중복
			}
		}	
		return result;		
	}
}