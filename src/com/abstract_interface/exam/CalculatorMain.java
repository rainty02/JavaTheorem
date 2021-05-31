package com.abstract_interface.exam;

public class CalculatorMain {

	public static void main(String[] args) {
		
		Calculator calc = new CalculatorC();
		System.out.println(calc.add(5, 5));
		System.out.println(calc.substract(5, 5));
		System.out.println(calc.multiply(5, 5));
		System.out.println(calc.divide(5, 5));				
	}
}