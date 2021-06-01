package com.collection.practice;

import java.util.*;

public class HashMapTest {

	public static void main(String[] args) {
		
		// Map : key-value 형식으로 저장
		// key - 저장한 데이터를 식별하기 위한 값, 중복X (중복된다면 기존값이 변경됨)
		// value - 저장하고자 하는 값, 중복O
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		HashMap<String, Person> map2 = new HashMap<>();
		// 타입에는 식별하고자 하는 값들을 계획
		
		// 데이터 저장 : put(e)
		map.put(new Integer(1), "Num.1");
		map.put(6, "Num.6");
		map.put(4, "Num.4");
		
		// 데이터 탐색
		System.out.println(map.get(new Integer(4)));
		System.out.println(map.get(1));
		System.out.println(map.get(6));
		System.out.println(map.get(100));
	}

}
 