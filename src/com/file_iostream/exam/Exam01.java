package com.file_iostream.exam;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class Exam01 {

	public static void main(String[] args) {
		
//		1.콘솔기반으로 메모장 기능을 만들어 봅시다.
//		①File 클래스를 이용해서 저장 폴더 생성
		File newFile = new File("D:\\java");
		newFile.mkdir();
		
//		②문자기반 스트림을 이용해서 날짜와 제목, 메모를 파일에 저장
//		③파일의 이름은 날짜와 메모의 제목을 이용해서 생성
		try {
			Writer memo  = new FileWriter("2021.6.2 자바.txt");		
			String str1 = "2021.6.2";
			String str2 = "자바";
			memo.write(str1);
			memo.write(str2);
			
			memo.close();				
			
//		④메모리스트와 파일 읽기 기능을 구현해봅시다.
			Reader in = new FileReader("2021.6.2 자바.txt");
			
			char[] cbuf = new char[10];
			int readLen = 0;
			readLen = in.read(cbuf, 0, cbuf.length);
			
//			for(int i=0; i<readLen; i++) {
//				System.out.println(cbuf[i]);
//			}
			System.out.println(new String(cbuf));
			
			in.close();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}