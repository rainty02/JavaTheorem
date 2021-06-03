package com.thread.exam;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

import jdk.internal.org.xml.sax.InputSource;

public class Exam02 {

	public static void main(String[] args) {

		// 2.복사하고자 하는 파일 경로와 복사할 파일의 디렉토리 주소를 받아
		// 파일을 복사하는 프로그램을 만들어봅시다.
		// ①복사할 대상 파일의 경로와 복사해올 위치 경로를 받는 메인 스레드는 멈춤 없이 실행하고

		String origin;
		String copyPath;
		String copyName;
		Scanner sc = new Scanner(System.in);
		
		// 원본파일의 경로를 받아 해당 경로의 파일이 있는지 확인
		System.out.print("원본 파일의 이름과 경로를 입력해주세요 > ");
		origin = sc.nextLine();
		File originPath = new File(origin);
		System.out.println(originPath);
		if (!originPath.exists()) {
			System.out.println("파일이 존재하지 않습니다.");
			System.out.println("경로를 확인해주세요.");
		}
		
		// 복사될 파일의 경로를 확인 후 디렉토리 생성
		System.out.print("복사될 파일의 경로를 입력해주세요 > ");
		copyPath = sc.nextLine();
		File copy = new File(copyPath);
		System.out.println(copyPath);
		if (!copy.exists()) {
			copy.mkdir();
			System.out.println("디렉토리를 생성했습니다.");
		}
		
		// 복사될 파일의  이름을 받아 경로 입력
		System.out.print("복사될 파일의 이름를 입력해주세요 > ");
		copyName = copyPath + "\\" + "\\" + sc.nextLine();
		System.out.println(copyName);
		
		// 데이터의 복사는 스레드로 처리하는 프로그램을 만들어 봅시다.
		CopyThread ct = new CopyThread(origin, copyName);
		ct.start();	
	}
}

class CopyThread extends Thread {

	String origin;
	String copy;

	public CopyThread(String origin, String copy) {
		this.origin = origin;
		this.copy = copy;
	}

	public void run() {
		try {
			// 원본과 복사할 파일의 경로 입력
			InputStream in = new FileInputStream(this.origin);
			OutputStream out = new FileOutputStream(this.copy);

			BufferedInputStream fin = new BufferedInputStream(in);
			BufferedOutputStream fout = new BufferedOutputStream(out);
					
			// 카피한 데이터의 크기
			int copyByte = 0;
			// 파일에서 읽어올 바이트 데이터
			int bData = -1;
			
			while(true) {
				bData  = fin.read();
				
				// 파일의 모든 데이터를 읽으면 -1 반환하며 반복탈출
				if(bData==-1) {
					break;
				}
				
				// 데이터 저장
				fout.write(bData);
				copyByte++;
			}
			
			// ②파일이 복사가 완료되면 완료 메시지를 콘솔에 출력합시다.
			System.out.println("복사 완료 ("+copyByte+"byte)");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}