package com.collection.practice;

import java.util.*;

public class HashSetTest2 {

	public static void main(String[] args) {
		
		// HastSet 저장 공간 생성 : 인스턴스 저장, 중복X, 순서X
		Set<SimpleNumber> hSet2 = new HashSet<SimpleNumber>();
		
		// 데이터 저장
		hSet2.add(new SimpleNumber(10));
		hSet2.add(new SimpleNumber(20));
		hSet2.add(new SimpleNumber(20));
		
		// 데이터의 일괄처리	
		Iterator<SimpleNumber> itr2 = hSet2.iterator();
		while(itr2.hasNext()) {
			System.out.println(itr2.next());
		}
	}

}

class SimpleNumber{
	
	int num;
	
	SimpleNumber(int num){
		this.num = num;
	}
	
	public String toString() {
		return String.valueOf(num);
	}
	
	@Override
	public int hashCode() {
		return num%3; // 0,1,2 3개의 그룹
	}
	
	@Override
	public boolean equals(Object obj) {
		
		boolean result = false;
		// obj는 null이 아니고, obj는 SimpleNumber타입으로 형변환 가능
		if(obj != null && obj instanceof SimpleNumber) {
			SimpleNumber sNum = (SimpleNumber) obj;
			if(this.num == sNum.num) {
				result = true;
			}
		}		
		return result;
	}
}