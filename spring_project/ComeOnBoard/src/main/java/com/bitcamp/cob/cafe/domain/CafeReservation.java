package com.bitcamp.cob.cafe.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CafeReservation {

	private int reservIdx;
	private int cafeIdx;
	private int memIdx;
	private String memName;
	private String reservDate;
	private int reservTime;
	private int reservTable;
	private int reservFourTable;
	private int reservGrpTable;
	private String requestTable;
	private int fixedFourTable;
	private int fixedGrpTable;
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

	public int getMemIdx() {
		return memIdx;
	}

	public void setMemIdx(int memIdx) {
		this.memIdx = memIdx;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
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

	public int getReservFourTable() {
		return reservFourTable;
	}

	public void setReservFourTable(int reservFourTable) {
		this.reservFourTable = reservFourTable;
	}

	public int getReservGrpTable() {
		return reservGrpTable;
	}

	public void setReservGrpTable(int reservGrpTable) {
		this.reservGrpTable = reservGrpTable;
	}

	public String getRequestTable() {
		return requestTable;
	}

	public void setRequestTable(String requestTable) {
		this.requestTable = requestTable;
	}

	public int getFixedFourTable() {
		return fixedFourTable;
	}

	public void setFixedFourTable(int fixedFourTable) {
		this.fixedFourTable = fixedFourTable;
	}

	public int getFixedGrpTable() {
		return fixedGrpTable;
	}

	public void setFixedGrpTable(int fixedGrpTable) {
		this.fixedGrpTable = fixedGrpTable;
	}

	public int getRegDate() {
		return regDate;
	}

	public void setRegDate(int regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "CafeReservation [reservIdx=" + reservIdx + ", cafeIdx=" + cafeIdx + ", memIdx=" + memIdx + ", memName="
				+ memName + ", reservDate=" + reservDate + ", reservTime=" + reservTime + ", reservTable=" + reservTable
				+ ", reservFourTable=" + reservFourTable + ", reservGrpTable=" + reservGrpTable + ", requestTable="
				+ requestTable + ", fixedFourTable=" + fixedFourTable + ", fixedGrpTable=" + fixedGrpTable
				+ ", regDate=" + regDate + "]";
	}

	
}
