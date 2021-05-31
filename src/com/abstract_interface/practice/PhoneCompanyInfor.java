package com.abstract_interface.practice;

public class PhoneCompanyInfor extends Friend {

	String company;
	
	public PhoneCompanyInfor(String name, String phoneNumber, String address, String company) {
		super(name, phoneNumber, address);
		this.company = company;
	}

	@Override
	public void showData() {
		System.out.println("직장 동료");
		super.showData();
		System.out.println("회      사 : " + company);
	}

	@Override
	public void showBasicInfo() {
		System.out.println("직장 동료");
		System.out.println("이      름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
	}	
}