package com.file_iostream.practice;

import java.io.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferFileCopy {

	public static void main(String[] args) {
		
		
		try {
			
			// 1. 파일을 바이너리 데이터를 읽어올 스트림 생성 : FileInputStram
			//FileInputStream in = new FileInputStream("origin.pdf");
			InputStream in =  new FileInputStream("origin.pdf");
			// 2. 파일을 쓰기위한 스트림 생성 : FileOutputstream
			FileOutputStream out = new FileOutputStream("copy2.pdf");
	
			// 카피한 데이터의 크기
			int copyByte = 0;
			// 파일에서 읽어올 바이트 데이터 배열
			byte[] buf = new byte[1024]; // 1kb 사이즈의 배열, 약 4kb가 성능이 가장 좋음
			// 읽어온 데이터 배열의 갯수
			int readLen	= 0;
			
			while(true) {
				readLen  = in.read(buf); // 완료시점 -> -1 반환
				
				// 탈출의 조건 : 파일의 모든 데이터를 읽은 경우
				if(readLen==-1) {
					break;
				}
				// 출력 : 파일에 데이터를 쓴다
				out.write(buf, 0, readLen);
				copyByte += readLen;
			}

			// 스트림 닫기
			in.close();
			out.close();
			
			System.out.println("복사 완료 ("+copyByte+"byte)");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}