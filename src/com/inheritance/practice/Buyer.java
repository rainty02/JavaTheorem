package com.inheritance.practice;

public class Buyer {
	
	int money;
	int bonusPoint;
	Product[] item;
	int cnt; // 구매제품의 갯수 -> 배열의 입력 index값
	
	public Buyer() {
		this.money = 10000;
		this.bonusPoint = 0;
		this.item = new Product[10];
		this.cnt = 0;
	}
	
	// 다형성을 활용하지 않으면
//	void buy(Tv tv) {}
//	void buy(Computer com) {}
	// 제품마다 buy 메소드를 계속 추가해야함
	
	// 다형성 사용 - 상위타입 매개변수
	void buy(Product p) {
		
		// 보유 금액을 확인하고 구매하여부 체크
		if(this.money < p.price) {
			System.out.println("잔액이 부족합니다.");
			return; // 메소드의 종료, 값의 반환
		}
		this.money -= p.price;
		this.bonusPoint += p.bonusPoint;
		
		// 구매내역에 제품을 추가
		item[cnt++] = p; 
		// *중요 - 값이 null인 배열까지 찾을 필요없이 값을 넣어준 cnt까지의 배열만 찾으면 되므로 효율적 
		
		
		System.out.println(p + " 구매");
		
	}
	
	void summary() {
		// 구매리스트, 구매금액의 총합
		int sum = 0; // 구매 총액
		int bonusPoint = 0;
		String itemList = "";
		
		// 배열을 반복문을 이용해 구매내역을 완성
		for(int i = 0; i < cnt; i++) {
			// 금액의 합
			sum += item[i].price;
			// 구매 상품 이름
			itemList += item[i] + ", ";
			// 보너스포인트의 합
			bonusPoint += item[i].bonusPoint;
		}
		System.out.println("구매하신 제품은 " + itemList + " 입니다.");
		System.out.println("구매하신 제품의 총 금액은 " + sum + "원 입니다.");
		System.out.println("구매하신 제품의 적립 포인트는 " + bonusPoint + "점 입니다.");
	}

}