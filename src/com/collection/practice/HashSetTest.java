package com.collection.practice;

import java.util.*;

public class HashSetTest {

	public static void main(String[] args) {
		
		// HastSet 저장 공간 생성 : 인스턴스 저장, 중복X, 순서X
		HashSet<String> hSet = new HashSet<String>();
		HashSet<Integer> hSet2 = new HashSet<Integer>();
		
		// 데이터 저장
		hSet.add("First");
		hSet.add("Second");
		hSet.add("Third");
		hSet.add("First");
		hSet.add("Second");
		hSet.add("Third");
		
		hSet2.add(1);
		hSet2.add(2);
		hSet2.add(1);
		hSet2.add(2);
		hSet2.add(3);
		
		// 데이터의 일괄처리
		Iterator<String> itr = hSet.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		Iterator<Integer> itr2 = hSet2.iterator();
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}
	}

}
