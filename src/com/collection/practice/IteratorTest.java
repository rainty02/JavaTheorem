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
	
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("------------------");
		
		for(String str : list) {
			System.out.println(str);
		}
	
		System.out.println("------------------");
		
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			String currentStr = itr.next();
			System.out.println(currentStr);
		}
	}
}
