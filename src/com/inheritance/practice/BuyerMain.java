package com.inheritance.practice;

public class BuyerMain {

	public static void main(String[] args) {
		
		// 구매자 인스턴스 생성
		Buyer buyer = new Buyer();
		
		// 제품 인스턴스 생성
		Tv tv = new Tv(1000);
		Computer com = new Computer(300);
		
		// 구매
		buyer.buy(tv);
		buyer.buy(com);
		buyer.buy(tv);
		buyer.buy(com);
		
		
		// 결과 지표
//		System.out.println("현재 소지 금액 : " + buyer.money + "원");
//		System.out.println("현재 보너스 포인트 : " + buyer.bonusPoint + "원");
		
		// summary 출력
		buyer.summary();
		
	}

}
