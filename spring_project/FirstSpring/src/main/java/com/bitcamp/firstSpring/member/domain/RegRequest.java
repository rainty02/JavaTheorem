package com.bitcamp.firstSpring.member.domain;

public class RegRequest {

	private String memberid;
	private String password;
	private String membername;
	private String photo;
	
	public RegRequest() {
	}

	public String getMemberid() {
		return memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "RegRequest [memberid=" + memberid + ", password=" + password + ", membername=" + membername + ", photo="
				+ photo + "]";
	}
	
}
