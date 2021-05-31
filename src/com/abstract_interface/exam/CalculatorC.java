package com.abstract_interface.exam;

class CalculatorC extends CalculatorAbs {
	public long multiply(long n1, long n2 ) { // 추상클래스 오버라이딩
		return n1 * n2;
	}
	public double divide(double n1, double n2 ) {
		return n1 / n2;
	}
}