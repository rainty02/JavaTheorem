package com.collection.practice;

import java.util.*;

public class TreeSetTest {

	public static void main(String[] args) {
		
		// TreeSet : 트리알고리즘을 이용해서 저장 -> 정렬(오름,내림)
		// 순차정렬, 중복X
		// 정렬의 기준을 프로그래머 정의 가능
		TreeSet<Integer> tSet = new TreeSet<Integer>();
		
		// 데이터저장
		tSet.add(1);
		tSet.add(5);
		tSet.add(4);
		tSet.add(2);
		tSet.add(1);
		tSet.add(3);
		
		// 정렬
		Iterator itr = tSet.iterator();
		
		// 출력
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}