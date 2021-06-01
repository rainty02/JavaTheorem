package com.collection.practice;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparablePerson {

	public static void main(String[] args) {
		
		TreeSet<Person> set = new TreeSet<>();
		// 데이터 저장
		set.add(new Person("Lee", 24));
		set.add(new Person("Kim", 21));
		set.add(new Person("Park", 27));	
		
		// 정렬, 출력
		Iterator<Person> itr = set.iterator();
		while(itr.hasNext()) {
			itr.next().showData();
		}	
	}
}

class Person implements Comparable<Person>{
	
	String name;
	int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public void showData() {
		System.out.printf("%s, %d \n", this.name, this.age);
	}

	@Override // 인터페이스 compareTo 오버라이딩을 통해 정렬기준을 정의
	public int compareTo(Person o) {
		// ojb가 작다면 양의 정수, 크다면 음의 양수, 같다면 0
//		if(this.age > o.age) { 
//			return 1;
//		} else if(this.age < o.age) {
//			return -1;
//		} else {
//			return 0;
//		}
//		return this.age - o.age;
		return o.age - this.age;
		// 음수를 반환하고 싶다면 변수의 위치 변경
		// 결과적으로 양수, 음수, 0를 반환하기 위해 작성
	}	
}