package com.bitcamp.cob.cafe.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CafeReservation {

	private int reservIdx;
	private int cafeIdx;
	private String reservDate;
	private int reservTime;
	private int reservTable;
	private int fourTable;
	private int grpTable;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private int regDate;

	public CafeReservation() {
	}

	public int getReservIdx() {
		return reservIdx;
	}

	public void setReservIdx(int reservIdx) {
		this.reservIdx = reservIdx;
	}

	public int getCafeIdx() {
		return cafeIdx;
	}

	public void setCafeIdx(int cafeIdx) {
		this.cafeIdx = cafeIdx;
	}

	public String getReservDate() {
		return reservDate;
	}

	public void setReservDate(String reservDate) {
		this.reservDate = reservDate;
	}

	public int getReservTime() {
		return reservTime;
	}

	public void setReservTime(int reservTime) {
		this.reservTime = reservTime;
	}

	public int getReservTable() {
		return reservTable;
	}

	public void setReservTable(int reservTable) {
		this.reservTable = reservTable;
	}

	public int getFourTable() {
		return fourTable;
	}

	public void setFourTable(int fourTable) {
		this.fourTable = fourTable;
	}

	public int getGrpTable() {
		return grpTable;
	}

	public void setGrpTable(int grpTable) {
		this.grpTable = grpTable;
	}
	
	public int getRegDate() {
		return regDate;
	}

	public void setRegDate(int regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "CafeReservation [reservIdx=" + reservIdx + ", cafeIdx=" + cafeIdx + ", reservDate=" + reservDate
				+ ", reservTime=" + reservTime + ", reservTable=" + reservTable + ", fourTable=" + fourTable
				+ ", grpTable=" + grpTable + ", regDate=" + regDate + "]";
	}


}
