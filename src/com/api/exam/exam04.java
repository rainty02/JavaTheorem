package com.api.exam;

import java.util.*;

public class exam04 {

	public static void main(String[] args) {
		
		// 4. 자신의 생일을 기준으로 오늘까지 몇 일을 살았는지
		// 출력하는 프로그램을 만들어봅시다. 
		Calendar birthDay = Calendar.getInstance();	
		// 캘린더 인스턴스 생성
		birthDay.set(2000, 1-1, 1, 0, 0, 0);
		// set으로 특정값 입력
		Calendar now = Calendar.getInstance();
		
		long calculate = now.getTimeInMillis() - birthDay.getTimeInMillis();
		// 해당 시간 밀리초 연산
		long result = calculate / (1000L * 60 * 60 * 24);
		// 밀리초 날짜 연산
		System.out.println(result + "일");
	}
}