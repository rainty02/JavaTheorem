package com.project;

public class Contact {

	// 저장 정보
	// 이름, 전화번호, 이메일, 주소, 생일, 그룹
	// 변수들은 직접 참조를 막아 캡슐화 처리를 하도록 해봅시다.
	private String name;
	private String tel;
	private String email;
	private String addr;
	private String birth;
	private String group;
	
	// 인스턴스 생성과 함께 데이터를 초기화 할 수 있도록 생성자를 정의해봅시다.
	public Contact() {}	
	public Contact(String name, String tel, String email, String addr, String birth, String group) {
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.addr = addr;
		this.birth = birth;
		this.group = group;
	}

	
	// 변수의 직접 참조는 안되지만 변수의 값을 얻을 수 있는 메소드(getter)와
	// 변수에 값을 저장할 수 있는 메소드(setter)를 정의합니다.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
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
	
	// 위 데이터를 출력하는 기능
	public void printInfo() {
		System.out.println("Contact [name=" + name + ", tel=" + tel + ", email=" + email + ", addr=" + addr + ", birth=" + birth
				+ ", group=" + group + "]");
	}
}