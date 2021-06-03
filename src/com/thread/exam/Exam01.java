package com.thread.exam;

import javax.swing.JOptionPane;

public class Exam01 {

	public static void main(String[] args) {
		// 1.10초 안에 맞추는 하이로우 게임을 만들어 봅시다.
		HighLow hl = new HighLow();
		Count cut = new Count();

		hl.start();
		cut.start();
	}
}

class HighLow extends Thread {

	@Override
	public void run() {
		// ①1~100 사이의 랜덤 한 숫자를 추출합니다.
		int ranNum = (int) (Math.random() * 100 + 1);

		// ②사용자에게 숫자를 입력 받고, 랜덤 숫자와 비교하고, 높은 숫자인지 낮은 숫자인지 출력
		int result = 0;
		while (!(ranNum == result)) {
			int inputNum = Integer.parseInt(JOptionPane.showInputDialog("1~100 내 숫자를 입력해주세요."));
			if (inputNum > ranNum) {
				System.out.println("Low");
			} else if (inputNum < ranNum) {
				System.out.println("Up");
			} else {
				System.out.println("정답입니다.");
				break;
			}
		}
	}
}

class Count extends Thread {

	// ③10초 카운팅은 스레드를 이용해서 처리해봅시다.
	// ④10초 이전에 맞추면 미션 성공, 10초가 지나면 프로그램 종료하는 흐름으로 만들어봅시다.
	@Override
	public void run() {
		for (int i = 10; i > 0; i--) {
			System.out.println(i);
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("시간내에 입력하지 못해 패배했습니다.");
		System.exit(0);
	}
}