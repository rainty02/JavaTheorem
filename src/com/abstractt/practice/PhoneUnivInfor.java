package com.abstractt.practice;

public class PhoneUnivInfor extends UnivFriend {

	String email;
	String year;
	
	public PhoneUnivInfor(String name, String phoneNumber, String address, String major, String email, String year) {
		super(name, phoneNumber, address, major);
		this.email = email;
		this.year = year;
	}
	
	@Override
	public void showData() {
		System.out.println("대학 전화번호부");
		super.showData();
		System.out.println("이  메  일 : " + email);
		System.out.println("학       년 : " + year);
	}

	@Override
	public void showBasicInfo() {
		System.out.println("대학 전화번호부");
		System.out.println("이      름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
	}
}