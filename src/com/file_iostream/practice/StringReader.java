package com.file_iostream.practice;

import java.io.*;

public class StringReader {

	public static void main(String[] args) {

		try {
			BufferedReader in = new BufferedReader(new FileReader("String.txt"));
			
			String str = null;
			System.out.println("읽기 시작");
			while(true) {
				str = in.readLine();
				if(str == null) {
					break;
				}
				System.out.println(str);	
			}
			in.close();
			System.out.println("읽기 완료");
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}