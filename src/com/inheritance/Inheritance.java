package com.inheritance;

public class Inheritance {}


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

//		*상위 클래스의 생성자가 있는지  우선 확인
//		하위클래스의 생성자 내에서 상위클래스의 생성자호출을 통해
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
					System.out.println("오버라이딩 변경 전");
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
				System.out.println("오버라이딩 변경 후");
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
		
//		*다형성 (상속관계에서만 가능)
//		하나의 참조변수로 여러 타입의 객체를 참조할 수 있는 것
//		조상타입의 참조변수로 자손타입의 객체를 다룰 수 있는 것이 다형성이다
		class Father {}
		class Son extends Father {}
		class Daughter extends Father {
			public static void main(String[] args) {
				Father father = new Son();
				Father father2 = new Daughter();
				//조상 = 자손 - 형변환 생략가능 (명시적 형변환 가능 - 오류를 줄이기 위함)
				//상위 클래스의 메소드만 사용가능
				//*하위 클래스의 메소드 사용불가 (오버라이딩은 정의부는 같고 구현부의 재정의이므로 사용가능)
				
				Son son = (Son)new Father();
				//*자손 = 조상 - 명시적 형변환 필요				
				
//				Son son2 = new Daughter();
//				Son son2 = (Son)new Daughter();
				//자손끼리 형변환은 불가 (명시적 형변환도 불가. 상위타입이나 같은 참조형타입 가능)
		
//		연산자 - 참조형변수명 instanceof 인스턴스타입
//		참조변수 형변환 여부 판별
//		참조변수가 참조하는 인스턴스의 실제 타입으로 체크하는데 사용
//		이항연산자이며 피연산자는 참조형 변수와 타입, 연산결과는 true, false.
		if(son instanceof Father) {
			System.out.println("son은 Father 인스턴스타입입니다");
		}

//		매개변수의 다형성
//		참조형 매개변수는 메서드 호출시, 자신과 같은 타입 또는 자손타입의 인스턴스를 넘겨줄 수 있음
//		매개변수의 타입마다 새로운 메서드를 생성하지 않고
//		상속관계에 있는 조상과 자손타입을 사용할 수 있으므로 하나의 메소드를 효율적으로 사용할 수 있음
			}
		}
		
//		*객체배열
//		여러 종류의 객체를 하나의 배열로 다루기
//		조상타입의 배열에 자손들의 객체를 담을 수 있음
		
//		모든 클래스는 Object클래스를 상속하므로
//		Object타입의 메소드와 형변환을 할 수 있음		
//		toString, equals, hashCode 등 총 11개의 메소드
		
		
		
		
		