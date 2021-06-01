package com.collection.exam;

import java.util.*;

public class MapFootballPlayer {

	public static void main(String[] args) {
		
		HashMap<Integer, MapFootball> fbMap = new HashMap<>();
		fbMap.put(1, new MapFootball("손", "뮌헨", 25));
		fbMap.put(2, new MapFootball("이", "밀란", 22));
		fbMap.put(3, new MapFootball("박", "맨유", 28));
		
		System.out.println(fbMap.get(1));
		System.out.println(fbMap.get(2));
		System.out.println(fbMap.get(3));
	}

}

class MapFootball {
	
	String name;
	String team;
	int age;

	public MapFootball(String name, String team, int age) {
		this.name = name;
		this.team = team;
		this.age = age;
	}
	
	public String toString() {
		return "이름 : " + this.name + "\t" +
				"팀 : " + this.team + "\t" +
				"나이 : " + this.age;
	}
}