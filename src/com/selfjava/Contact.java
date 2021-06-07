package com.selfjava;

import java.util.*;

public class Contact {

	private String name;
	private String num;
	private String email;
	private String address;
	private String birth;
	private String group;
	
	private Contact[] contact;
	public Contact[] getContact() {
		return contact;
	}

	public void setContact(Contact[] contact) {
		this.contact = contact;
	}

	public int getArrCnt() {
		return arrCnt;
	}

	public void setArrCnt(int arrCnt) {
		this.arrCnt = arrCnt;
	}


	private int arrCnt;

	public Contact() {}
	
	public Contact(Contact[] cantact, int arrCnt) {
		this.contact = contact;
		this.arrCnt = arrCnt;
	}
	
	public Contact(String name, String num, String email, String address, String birth, String group) {
		this.name = name;
		this.num = num;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.group = group;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}


	@Override
	public String toString() {
		return "Contact [name=" + name + ", num=" + num + ", email=" + email + ", address=" + address + ", birth="
				+ birth + ", group=" + group + "]";
	}
}