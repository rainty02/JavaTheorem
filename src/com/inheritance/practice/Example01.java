package com.inheritance.practice;

class Car {
	String color;
	int door;

	void drive() { // 운전하는 기능
		System.out.println("drive, Brrrr~");
	}

	void stop() { // 멈추는 기능
		System.out.println("stop!!!");
	}
}

class FireEngine extends Car { // 소방차
	void water() { // 물을 뿌리는 기능
		System.out.println("water!!!");
	}
}

public class Example01 {

	public static void main(String[] args) {
		
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		fe.water();
		// 자신의 타입으로 참조했기 때문에 자신의 메소드 사용가능

		car = fe;
		// car =(Car)fe;에서 형변환이 생략된 형태다.
		
//		car.water(); 
		// 오류. Car타입의 참조변수로는 water()를 호출할 수 없음
		
		fe2 = (FireEngine) car;
		// 자손타입 ← 조상타입은 명시적 형변환 필요
		fe2.water();
		// FireEngine타입이기 때문에 메소드 사용가능
	}
}
