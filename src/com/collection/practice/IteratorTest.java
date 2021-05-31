package com.collection.practice;

import java.util.*;

public class IteratorTest {

	
	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>(); // 상위타입 List로 참조가능
		ArrayList<String> list3 = new ArrayList<>();  // 타입 생략가능

		// 요소 저장 : add(T t)
		list.add("First");
		list.add("Second");
		list.add("Third");
		list.add("Forth");
		
		// length나 카운트용 변수 대신 size() 을 사용
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("------------------");
		
		// for each문
		for(String str : list) {
			System.out.println(str);
		}
	
		System.out.println("------------------");
		
		// iterator 사용
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) { // 다음 값이 있다면 true, 없다면 false
			String currentStr = itr.next(); // 다음 값을 변수에 대입
			System.out.println(currentStr);
		}
	}
}
