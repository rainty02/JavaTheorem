package com.inheritance;

public class Inheritance {

}
//		상속
//		기존에 정의된 클래스에 변수와 메소드와 변수를 추가하여
//		새로운 클래스를 정의하는 것
//		1. 재활용
//			필요한 경우 상위, 기본, 조상클래스의 멤버(변수, 메소드)를
//			하위, 자손클래스에서 재사용
//		2. 가이드(공통적인 규약) - 실질적인 목적
//			상위 클래스의 멤버를 사용해라
//		*오버라이딩, 다형성 특징 숙지
//		
//		문법
//		class 자손클래스 extends 조상클래스 {}
//		자손은 조상의 모든 멤버를 상속받음(*생성자, 초기화블럭은 제외)
		class Point { int x,y; }
		class Pint3D extends Point { int z; }
		// Point의 멤버들(int x,y)을 상속받아
		// Point3D의 멤버는 int x,y,z 를 갖음
		
//		상속관계
//		공통 부분은 조상에서 관리, 개별부분은 자손에서 관리
//		조상의 변경은 자손에게 영향을 끼치지만 자손의 변경은 조상에게 영향을 주지 않음
		class Parent {}
		class child extends Parent {}
		class child2 extends Parent {}
		class GrandChild extends child {}

//		하위클래스의 생성자 내에서 상위클래스의 생성자호출을 통해서
//		상위 클래스의 인스턴스 멤버를 초기화해야함
//		하위 클래스의 생성자는 상위 클래스의 생성자 호출을 통해서
//		상위 클래스의 인스턴스 변수를 초기화함
		
//		this - 인스턴스 자신을 가르키는 참조변수. 지역변수와 인스턴스 변수구분
//		super - 조상의 멤버와 자신의 멤버 구분.
//		상위클래스의 생성자와 메소드 호출. 주로 *생성자호출할 때 사용
		
//		*오버라이딩
//		조상클래스로부터 상속받은 메서드의 *내용을 자손클래스에 맞게 변경
//		조건
//		1. 상속의 관계
//		2. 하위클래스에서 수정
//		3. 메소드의 정의부 수정X, 구현부 수정O
//		4. 접근제어자를 좁은 범위로 변경할 수 없음 (넓은 범위로는 가능)
//		5. 조상클래스의 메서드보다 많은 수의 예외를 선언할 수 없음
				
		class Person {
			String name;
			Person(String name){
				this.name = name;
			}
				void Print() {
					System.out.println("조상클래스");
			}
				void Print2() {
					System.out.println("오버라이딩하세요");
				}
				void Print3() {}
		}
		class Male extends Person {
			int age;
			Male(String name, int age) {
				super(name);
				// 조상클래스의 변수의 초기화가 필요한 경우에는
				// *첫줄에 상위 클래스의 super로 생성자 호출
				this.age = age;
			}		
			void Print() {
				super.Print();
				// 조상 클래스의 Print 메소드를 super로 불러옴
				}
			void Print2() {
				System.out.println("오버라이딩 완료");
				// Print, Print2는 조상클래스 메소드 오버라이딩
				// 선언부는 조상클래스와 동일하지만 구현부는 원하는대로 변경해서 사용
			}

//			*반환타입 메소드이름 매개변수 중 하나라도 바뀌면 오버로딩
			void Print3(int i) {} // 매개변수가 바껴 오버로딩
			void Print2(int i) {}
//			void Print2() {} 중복으로 오류						
		}	
		
		
//		static 변수(메소드)의 상속
//		클래스 변수, 클래스 메소드는 프로그램이 시작될 때 스태틱공간에 생성
//		조상이나 자손 상관없이 사용가능
		
//		상속관계를 통해 구현해야할까
//		상속관계와 포함관계의 차이점
		
//		상속관계  = extends를 사용해 상위클래스의 멤버를 사용
//		조상의 경우 대표성이 확장되고 자손의 경우 기능이 확장될 때
//		전화기 (유선전화, 무선전화, 스마트폰) = is a
		
//		포함관계 (composite) = has a
//		new a(); 로 사용
//		작은 단위의 클래스를 먼저 만들고 이들을 조합해 하나의 커다란 클래스를 만듬
//		대표성을 갖지 않고 하나로 묶지 않고 필요할 때 가져와 쓸 때
		
	