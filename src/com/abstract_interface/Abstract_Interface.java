package com.abstract_interface;

public class Abstract_Interface {

//		abstract(상속), interface(구현)
//		클래스의 일종으로 새로운 클래스를 정의할 때 가이드와 규칙을 목적으로 사용함
//		상속관계
	
//		abstract
//		추상메서드(선언부만 있고 구현부는 없는 메서드)를 포함하고 있는 클래스
//		정상적인 메소드 + 추상메소드
//		*미완성된 클래스이므로 인스턴스 생성 불가
//		다른 클래스를 작성하는데 도움을 줄 목적(상속)이라면 추상클래스를 사용하는 것이 효과적
//		새로운 클래스는 반드시 추상메소드를 *오버라이딩해야함(구현)
//		구현하지 않는다면 새로운 클래스도 추상 클래스가 되므로 주의
//		추상클래스는 인스턴스화의 목적이 없음
//		만약 인스턴스화 된다면 추상클래스가 아니거나 실수
//		인스턴스 생성은 불가하나 참조변수 선언과 오버라이딩 가능
	
		abstract class Player{
			int currentPos;
			Player() {currentPos = 0;}
			abstract void play(int pos); 
			// abstract 리턴타입 메서드이름 *{} 중괄호 없음, 세미콜론으로 마무리
//			void play(currentPos);
			// 추상메서드의 구현부를 만들어야 사용할 수 있음
		}
	
//		interface
//		추상 클래스의 일종으로 추상화정도가 더 높음. *구현된 것이 전혀 없음.
//		미리 정해진 규칙에 맞게 구현하도록 표준을 제시 (*메소드의 정의 - 반환타입, 이름, 매개변수)
//		*추상메소드, 상수(public static 사용)만 멤버로 갖음
//		상속의 개념 동일. *오버라이딩, *다형성 (인터페이스도 클래스기 때문)
//		역시 인스턴스 생성 불가
//		자바는 단일 상속만 가능 (C++은 다중 상속 가능)
//		... extends ... implements ... 상속과 인터페이스를 통해서 다중 상속 효과를 낼 수 있음
//		*인터페이스는 , 로 다중 상속 가능
//		클래스명Impl 특정클래스를 상속받은 클래스라는 걸 표기? (확인할 것)
		
		interface interfaceName { // 인터페이스는 반드시 상수, 추상메소드만 들어가므로
			public static final int NUM = 10;
			int NUM2 = 10; // public static final 생략가능
			public abstract int method(int a, int b);
			int method2(int a, int b); // public abstract 생략가능
		}
		
		 class ClassName implements interfaceName {
			@Override
			public int method(int a, int b) {return 0;}
			@Override
			public int method2(int a, int b) {return 0;}
			// 오버라이딩을 하거나 클래스를 추상클래스로 변경해야함
		 } 
		 
//		 *마킹의 효과 ~able - 멤버가 없음
//		 가이드나 규칙 X, 형변환을 통해 클래스의 특성을 표시하는 기능으로 사용할 수 있음
//		 instanceof 연산자를 통해서 클래스의 특성 파악
		 
//		 인터페이스의 장점
//		 1. 개발시간 단축
//		 	인터페이스를 통해 양쪽에서 동시에 개발가능
//		 2. 표준화
//		 	규칙, 가이드를 제공
//		 3. 관계없는 클래스들에게 관계를 맺어 줄 수 있음
//		 	서로 상속관계에 있지 않아도 인터페이스를 통해 공통적으로 구현하도록 함으로써 관계를 맺음
//		 4. 독립적인 프로그래밍 가능
//			직적접인 클래스 관계를 간접적으로 변경하여 클래스의 변경이 관련된 다른 클래스의 영향을 미치지 않게끔 독립적으로 프로그래밍 가능
		 
//		 클래스 구분(성격)
//		 1. 데이터 저장
//		 2. 기능
//		 3. 상속을 목적으로 하는 클래스 (가이드, 규칙)
//		 	일반, 추상, 인터페이스	
}