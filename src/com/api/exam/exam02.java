package com.api.exam;

public class exam02 {

	public static void main(String[] args) {
		
		// 2. 1~100,000,000까지 더하기하는 연산의 실행 시간을 측정하는 프로그램을 만들어봅시다. 
		
		long start = System.currentTimeMillis(); // 1970년 1월 1일 0시 0분 0초
		long sum = 0;
		for(int i = 1; i <= 100000000; i++) {
			sum += i;
		}
		long end = System.currentTimeMillis();
		
		System.out.println("합 : " + sum);
		System.out.println(end - start + "ms");
	}
}