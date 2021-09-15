package com.bitcamp.cob.game.domain;

public class SearchType {
	
	private int p; // 페이징처리
	private String searchType;
	private String keyword;
	
	public SearchType(int p, String searchType, String keyword) {

		this.p = p;
		this.searchType = searchType;
		this.keyword = keyword;
	}
	
	public SearchType() {
		
		this.p = 1;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() { //데이터 확인용
		return "SearchType [p=" + p + ", searchType=" + searchType + ", keyword=" + keyword + "]";
	}
	
	
	
}
