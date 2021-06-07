package com.selfjava;

public class Calculator {

	public static void main(String[] args) {
		
	Calc calc = new Calc();
	System.out.println(calc.plus(5, 5));
	System.out.println(calc.sub(5, 5));
	System.out.println(calc.multi(5, 5));
	System.out.println(calc.div(5, 5));	
	System.out.println(calc.pieR(5));	
	System.out.println(calc.pieRR(5));	
	}
}

class Calc {
	
	long plus(int a, int b) {
		return a + b;		
	}
	long sub(int a, int b) {
		return a - b;
	}
	long multi(int a, int b) {
		return a * b;
	}
	float div(int a, int b) {
		return (float)(a / b);
	}
	double pieR (int a) {
		return 2 * a * Math.PI;
	}
	double pieRR (int a) {
		return a * a * Math.PI;
	}
}

interface Calulator {
	long add(long a, long b);
	long sub(long a, long b);
	long multi(long a, long b);
	double div(long a, long b);
}

class Calc2 implements Calulator {

	@Override
	public long add(long a, long b) {
		return a + b;
	}

	@Override
	public long sub(long a, long b) {
		return a - b;
	}

	@Override
	public long multi(long a, long b) {
		return a * b;
	}

	@Override
	public double div(long a, long b) {
		return a / b;
	}
}