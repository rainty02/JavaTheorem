package com.abstract_interface.practice;

public class HighFriend extends Friend {
	
	// 고교 친구는 직장정보를 추가
	String work;

	public HighFriend(String name, String phoneNumber, String address, String work) {
		super(name, phoneNumber, address);
		this.work = work;
	}

	@Override
	public void showData() {
		System.out.println("고교 친구");
		super.showData();
		System.out.println("직      업 : " + work);
	}

	@Override
	public void showBasicInfo() {
		System.out.println("고교 친구");
		System.out.println("이      름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
	}
}