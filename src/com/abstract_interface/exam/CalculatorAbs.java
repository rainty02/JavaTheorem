package com.abstract_interface.exam;

public abstract class CalculatorAbs implements Calculator {

	public long add(long n1, long n2) { // 인터페이스 오버라이딩
		return n1 + n2;
	}
	public long substract(long n1, long n2) {
		return n1 - n2;
	}
//	public abstract long multiply(long n1, long n2); // 추상클래스
//	public abstract double divide(double n1, double n2); // 인터페이스를 상속받아 추상 메소드는 없어도 됨
}