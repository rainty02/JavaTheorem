package com.thread.practice;

public class ShowTheadMain {

	public static void main(String[] args) {
		
		// 스레드 인스턴스 생성
		ShowThread t1 = new ShowThread("1번 스레드");
		ShowThread t2 = new ShowThread("2번 스레드");
		
		// 스레드의 실행
		t1.start();
		t2.start();
	}

}
