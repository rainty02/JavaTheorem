package com.file_iostream.practice;

import java.io.File;

public class FileMove {

	public static void main(String[] args) {

		// File myFile = new File("D:\\myjava", "origin.pdf");
		File myFile = new File("D:"+File.separator+"myjava\\origin.pdf");
		// File.separator 다른 운영체제에서 \\ 호환
		System.out.println(myFile);
		
		if(!myFile.exists()) {
			System.out.println("파일이 존재하지 않습니다.");
			System.out.println("프로그램을 종료합니다.");
			return;
		} 
		// 새로운 폴더 생성 : 경로(파일객체) 생성 -> (디렉토리) 생성
		File newDir = new File("D:\\yourjava");
		System.out.println("1. exist ?? --> " + newDir.exists());

		if(!newDir.exists()) {
			// 폴더 생성
			newDir.mkdir();
			System.out.println("2. exist ?? --> " + newDir.exists());
		}
	 
		// 이동할 경로와 파일 이름
		File newFile = new File(newDir, myFile.getName());
		// 이동
		myFile.renameTo(newFile);
		if(newFile.exists()) {
			System.out.println("파일 이동 성공");
		} else {
			System.out.println("파일 이동 실패");
		}
		
	}

}
