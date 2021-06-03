package com.file_iostream.exam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		
		// 1.콘솔기반으로 메모장 기능을 만들어 봅시다.
		
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		
		// 메모 프로그램 반복
		while (run) {
			System.out.println("1. 새 메모");
			System.out.println("2. 메모 확인");
			System.out.println("3. 종료");
			System.out.print("메뉴를 선택하세요 > ");
			int menu = Integer.parseInt(sc.nextLine());
			File file = new File("D:\\memo");
			switch (menu) {
				case 1:	
					// ①File 클래스를 이용해서 저장 폴더 생성
					// 디렉토리 생성
					if(!file.exists()) {
						file.mkdir();
					} 	
					// ②문자기반 스트림을 이용해서 날짜와 제목, 메모를 파일에 저장
					System.out.print("제목을 입력하세요 > ");
					String name = sc.nextLine();
					// 메모 날짜입력
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
					String now = "(" + sdf.format(cal.getTime())  + ")";
					String memoName = name + now;
					System.out.println(memoName);
					try {
						// ③파일의 이름은 날짜와 메모의 제목을 이용해서 생성
						BufferedWriter outMemo = new BufferedWriter(new FileWriter("D:\\memo\\"+ memoName +".txt"));
						while(true) {
							System.out.print("내용을 입력해주세요 (저장하려면 저장 / save 입력) > ");
							String write = sc.nextLine();
							if(write.equals("저장") || write.equals("save") || write.equals("SAVE")) {
								System.out.println("저장되었습니다.");
								System.out.println();
								outMemo.close();
								break;
							}
							outMemo.write(write);
							outMemo.newLine();	
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
					
				case 2: 
					// ④메모리스트와 파일 읽기 기능을 구현해봅시다.
					// 메모 유무 확인
					if(!file.exists()) {
						System.out.println("파일이 없습니다.");
						continue;
					}
					// 메모 리스트 출력
					String[] fileList = file.list();
					int i = 0;
					for(i=0; i<fileList.length; i++) {
						System.out.println((i+1)+". " + fileList[i]);
					}
					System.out.print("파일을 선택하세요 > ");
					int fileName = Integer.parseInt(sc.nextLine());
					try {
						// 파일내용 출력
						BufferedReader inMemo = new BufferedReader(new FileReader("D:\\memo\\"+ fileList[fileName-1]));
						String str = null;
						while(true) {
							str = inMemo.readLine();
							if (str == null) {
								break;
							}
							System.out.println(str);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println();
					break;
					
				case 3:
					System.out.println("종료합니다.");
					run = false;
					break;
					
				default:
					System.out.println("잘못 입력하셨습니다.");
					System.out.println();
					continue;
			}
		}
	}
}