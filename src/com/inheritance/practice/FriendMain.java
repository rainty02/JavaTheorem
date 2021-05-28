package com.inheritance.practice;

public class FriendMain {

	public static void main(String[] args) {
			
		Friend f1 = new Friend("Lee");
		Friend f2 = new Friend("Kim");
		Friend f3 = new Friend("Lee");
	
		System.out.println(f1); // f1.toString()
		System.out.println(f2); // f2.toString()
		System.out.println(f3); // f2.toString()
		
		System.out.println(f1 == f3); // 참조값 주소를 비교하므로 false
		System.out.println(f1.equals(f3)); // equals는 매개변수타입이 Object이어야 함
	}
}

class Friend {
	String myName;
	
	Friend(String name){
		myName = name;
	}
	
	public String toString() {
		return "나의 이름은 " + myName + "입니다.";
	}
	
	
	// equals를 오버라이딩할 때는 각각의 특징을 제대로 특정해야함
	public boolean equals(Object o) {
		boolean result = false;
		if(o != null && o instanceof Friend) {
			Friend f = (Friend) o;
			if(myName.equals(f.myName)) {
				result = true;	
			}
		} 
		return result;
	}
}