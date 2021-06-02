package com.file_iostream.practice;

import java.io.*;

public class FileWriterStream {

	public static void main(String[] args) {
		

		try {
			
			System.out.println("문자 스트림 생성");
			// 문자단위 저장을 위한 출력 스트림
			// Writer -> FileWriter
			Writer out = new FileWriter("hyper.txt");
			
			char c1 = 'A';
			char c2 = 'B';
			String str = "CD";
			
			// 쓰기
			out.write(c1);
			out.write(c2);
			out.write(str);
			out.write('E');
			out.write("FG");
			
			out.close();
			System.out.println("쓰기작업 완료");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
