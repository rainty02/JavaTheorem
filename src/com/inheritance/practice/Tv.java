package com.inheritance.practice;

public class Tv extends Product {

	public Tv(int price) {
		super(price);	
	}
	
	@Override
	public String toString() {
		return "TV";
	}
}