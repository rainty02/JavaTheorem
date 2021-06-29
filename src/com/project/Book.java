package com.project;

public class Book {

	private String bookName;
	private String bookNum;
	private String wirtter;
	private String publisher;

	public Book(String bookName, String bookNum, String wirtter, String publisher) {
		super();
		this.bookName = bookName;
		this.bookNum = bookNum;
		this.wirtter = wirtter;
		this.publisher = publisher;
	}


	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookNum() {
		return bookNum;
	}

	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}

	public String getWirtter() {
		return wirtter;
	}

	public void setWirtter(String wirtter) {
		this.wirtter = wirtter;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	@Override
	public String toString() {
		return "Book [bookName=" + bookName + ", bookNum=" + bookNum + ", wirtter=" + wirtter + ", publisher="
				+ publisher + "]";
	}
}