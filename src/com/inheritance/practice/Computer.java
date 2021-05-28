package com.inheritance.practice;

public class Computer extends Product {

	public Computer(int price) {
		super(price);
	}

	@Override  // 어노테이션 사용시 실수를 줄일 수 있음
	public String toString() {
		return "Computer";
//		return "Computer [price=" + price + ", bonusPoint=" + bonusPoint + "]";
	}
}