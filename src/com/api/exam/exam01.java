package com.api.exam;

public class exam01 {

	public static void main(String[] args) {
		
		
		// 1. 위 Person 클래스의 equals() 메소드를 오버라이딩해서
		// 주민등록번호가 같으면 인스턴스로 판별하는 프로그램을 만들어봅시다.
		
		Person ps = new Person("Lee", "900101-1000000");
		Person ps2 = new Person("Lee", "900101-1000000");
		Person ps3 = new Person("Lee", "900101-1000001");
		System.out.println(ps.equals(ps2));
		System.out.println(ps.equals(ps3));
		
		if(ps.equals(ps2)) {
			System.out.println("ps와 ps2는 같은 사람입니다.");
		} else {
			System.out.println("ps와 ps2는 다른 사람입니다.");
		}
	}
}

class Person {

	String name;
	String personNumber;

	public Person(String name, String personNumber) {
		this.name = name;
		this.personNumber = personNumber;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if (obj != null && obj instanceof Person) { // null 이 아니고 형변환이 가능한지
			Person ps = (Person) obj; // 형변환
			if (this.personNumber.equals(ps.personNumber)) { // equals 비교
				result = true;
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", personNumber=" + personNumber + "]";
	}
}