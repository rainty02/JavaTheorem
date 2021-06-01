package com.collection.exam;

import java.util.*;

public class FootballPlayerVerT implements Comparable<FootballPlayerVerT> {

	// ListFootball 멤버
	private String name;
	private int number;
	private String team;
	private int age;

	// 생성자
	public FootballPlayerVerT(String name, int number, String team, int age) {
		this.name = name;
		this.number = number;
		this.team = team;
		this.age = age;
	}

	// 게터, 세터
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(FootballPlayerVerT o) {
		// 팀이름 - 이름 - 나이 순
		int result = this.team.compareTo(o.getTeam()) * -1; //음수, 양수, 0
		if (result == 0) {
			result = this.name.compareTo(o.name) * -1; // 역순
			if (result == 0) {
				result = this.number = o.getNumber();
			}
		}
		return result;
	}
	
	// toString 오버라이딩
	@Override
	public String toString() {
		return "이름 : " + this.name + "\t" + "번호 : " + this.number + "\t" + "팀 : " + this.team + "\t" + "나이 : "
				+ this.age;
	}

	@Override
	public boolean equals(Object obj) {
		// 팀과 이름 그리고 나이가 같으면 같은 선수
		boolean chk = false;

		if (obj != null && obj instanceof FootballPlayerVerT) {
			FootballPlayerVerT player = (FootballPlayerVerT) obj;
			if (this.team.equals(player.team) && this.name.equals(player.name) && this.age == player.age) {
				chk = true;
			}
		}
		return chk;
	}

	@Override
	public int hashCode() {
		return age % 10;
	}

	public static void main(String[] args) {

		// 1. 축구선수 인스턴스를 저장할 수 있는 List<E> 컬렉션 인스턴스를 생성해서 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
//		List<FootballPlayerVerT> players = new ArrayList<FootballPlayerVerT>();
		
		// 2. 축구선수의 인스턴스가 팀과 이름 그리고 나이가 같으면 같은 선수라 판단하고
		// 입력이 되지 않도록 Set<E> 컬렉션을 이용해서 축구선수 인스턴스를 저장하고 출력하는 프로그램을 만들어 봅시다.
//		Set<FootballPlayerVerT> players = new HashSet<FootballPlayerVerT>();

		// 3. TreeSet<E>을 이용해서 팀 이름순으로 정렬하고, 같은 팀의 선수들은 이름 순으로 정렬하고,
		// 같은 이름의 선수는 번호 순으로 저장하는 프로그램을 만들어 봅시다.
		TreeSet<FootballPlayerVerT>	 players = new TreeSet<FootballPlayerVerT>();
		
		// 데이터 저장
		players.add(new FootballPlayerVerT("손흥민", 1, "뮌헨", 25));
		players.add(new FootballPlayerVerT("이강인", 2, "첼시", 27));
		players.add(new FootballPlayerVerT("박지성", 3, "맨유", 29));
		players.add(new FootballPlayerVerT("손흥민", 1, "뮌헨", 25));
		players.add(new FootballPlayerVerT("이강인", 2, "첼시", 27));
		players.add(new FootballPlayerVerT("박지성", 3, "맨유", 29));

		System.out.println("요소의 개수 : " + players.size());

		// 정렬
		Iterator<FootballPlayerVerT> itr = players.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		// 4. 축구선수의 번호를 key로 하고 축구선수 인스턴스를 저장하는
		// Map<K,V> 인스턴스를 이용해서 프로그램을 만들어봅시다.
		HashMap<Integer, FootballPlayerVerT> players2 = new HashMap<>();
		
		players2.put(1, new FootballPlayerVerT("손흥민", 1, "뮌헨", 25));
		players2.put(2, new FootballPlayerVerT("이강인", 10, "맨유", 24));
		players2.put(3, new FootballPlayerVerT("박지성", 20, "맨유", 30));
		
		System.out.println("-------------------------");
		
		Set<Integer> set = players2.keySet();
		// *키값을 Set으로 묶을 수 있음
		
		Iterator<Integer> itr2 = set.iterator();
		while(itr2.hasNext()) {
			System.out.println(players2.get(itr2.next()));
		}
			
				
				
				
				
	}
}