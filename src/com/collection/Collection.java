package com.collection;

public class Collection {

//		제네릭 클래스 <T>
//		자료형의 안정성, 구현의 편의성
//		예로 object타입으로 값을 받을 경우 원치 않은 타입이 입력될 경우 런타임오류 발생
//		수정하기 어려움
	
	class Orange {int item;}
	class FruitBox <T> {
		T item;
		public void store(T item) {this.item = item;}
		public T pullOut() {return item;}
	}
//	  		  <T>						    <T>	
	FruitBox<Orange> orBox = new FruitBox<Orange>();
//	타입은 인스턴스를 생성할 때 지정
	

//		컬렉션 프레임워크
//		컬렉션 - *객체를 집합의 개념으로 저장	
//		프레임워크 - 특정 기능(자료구조, 알고리즘)을 하기 위해 이미 만들어져 있는 구조
//		인스턴스의 저장과 참조를 위해 잘 정의된 클래스들의 구조
	
//		List
//		동일한 인스턴스의 중복 저장 허용, 인스턴스의 저장순서 유지
	
//		ArrayList<E>
//		단점 - 저장소의 용량을 늘리는 과정 (데이터를 다시 옮겨야함)에서 시간 소요
//		데이터의 삭제에 필요한 연산과정이 매우 김
//		장점 - 데이터의 참조가 용이해서 빠른 참조 가능
//		최근 index 참조가 좋고 마지막 index 저장속도가 빠름
	
//		LinkedList<E>
//		단점 - 저장소 용량을 늘리는 과정이 간단
//		데이터 삭제가 매우 간단
//		데이터의 참조가 다소 불편
	
//		iterator
//		인스턴스를 순차적으로 접근할 수 있게 해주는 메소드
//		컬렉션 클래스의 종류에 상관없이 동일한 형태의 데이터 참조방식을 유지
//		컬렉션 클래스별 데이터 참조 방식을 별도로 확인할 필요가 없음
	
//		Iterator<E> itr = list.iterator();
//		while(itr.hasNext) { 값이 있으면 true 반환
//			<E>str = itr.next(); // str에 값 대입
//		}	
	
//		Set - HashSet<E>
//		중복 X, 저장순서 유지 X
//		Map - HashMap<K, V>
	
//		collection<E>
	
//		컬렉션 클래스를 이용한 정수의 저장
//		ArrayList<int> arr = new ArrayList<int>();
//		기본 자료형 정보를 이용해서 제네릭 인스턴스 생성 불가
//		따라서 Wrapper클래스를 기반으로 컬렉션 인스턴스를 생성
//		Integer, Double 등
//		ArrayList<Integer> arr = new ArrayList<Integer>();
//		arr.add(10); // auto Boxing
//		int num = itr.next(); // auto Unboxing
//		기본적으로 객체를 저장하기 위함이지만 기본형 값도 저장할수도 있음
	
	
	
	
	
}