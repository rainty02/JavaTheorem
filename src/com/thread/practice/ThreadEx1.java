package com.thread.practice;

import javax.swing.JOptionPane;

public class ThreadEx1 {

	public static boolean chk = false;

	public static void main(String[] args) {

		CountDownThread ct = new CountDownThread();
		InputThread it = new InputThread();
		ct.start();
		it.start();	
	}
}

class InputThread extends Thread {

	@Override
	public void run() {
		String name = JOptionPane.showInputDialog("이름을 입력해주세요");
		// 입력을 받지 않는다면 22줄에서 대기
		ThreadEx1.chk = true;
		// 입력을 받았다면 24줄로 진행
		System.out.println("안녕하세요. " + name + "님");
	}
}

class CountDownThread extends Thread {

	@Override
	public void run() {
		for(int i=10; i>0; i--) {
			
			if(ThreadEx1.chk) {
				return;
			}
			System.out.println(i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
		System.out.println("입력시간이 지나 프로그램을 종료합니다.");
		System.exit(0);
	}	
}