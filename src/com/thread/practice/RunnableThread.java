package com.thread.practice;

public class RunnableThread {

	public static void main(String[] args) {

		// Runnable 타입의 인스턴스 생성
		AdderThread at1 = new AdderThread(1, 50);
		AdderThread at2 = new AdderThread(51, 100);
		
		// Thread 인스턴스 생성
		// new Thread(Runnable target)
		Thread t1 = new Thread(at1);
		Thread t2 = new Thread(at2);
		
		// Thread start()
		t1.start();
		t2.start();
		
		try {
			t1.join(); // t1만 실행하도록
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("1~100의 합 : " + (at1.getNum() + at2.getNum()));

	}

}

class AdderThread extends Sum implements Runnable {

	int startNum, endNum;
	
	public AdderThread(int startNum, int endNum) {
		this.startNum = startNum;
		this.endNum = endNum;
	}

	@Override
	public void run() {
		
		for(int i=startNum; i<=endNum; i++) {
			addNum(i);
		}
	}
}

class Sum {
	
	int num;
	
	public void addNum(int n) {
		num += n;
	}
	
	public int getNum() {
		return num;
	}
}