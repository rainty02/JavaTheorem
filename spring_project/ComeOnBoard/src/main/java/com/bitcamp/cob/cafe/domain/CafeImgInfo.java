package com.bitcamp.cob.cafe.domain;

public class CafeImgInfo {

	private int cafeIdx;
	private String cafeName;
	private String cafeImg;
	
	public CafeImgInfo() {}

	public int getCafeIdx() {
		return cafeIdx;
	}

	public void setCafeIdx(int cafeIdx) {
		this.cafeIdx = cafeIdx;
	}

	public String getCafeName() {
		return cafeName;
	}

	public void setCafeName(String cafeName) {
		this.cafeName = cafeName;
	}

	public String getCafeImg() {
		return cafeImg;
	}

	public void setCafeImg(String cafeImg) {
		this.cafeImg = cafeImg;
	}

	@Override
	public String toString() {
		return "CafeImgInfo [cafeIdx=" + cafeIdx + ", cafeName=" + cafeName + ", cafeImg=" + cafeImg + "]";
	}



}
