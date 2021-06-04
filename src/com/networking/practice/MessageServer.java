package com.networking.practice;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MessageServer {

	public static void main(String[] args) {

		ServerSocket ss = null;
		Socket s = null;

		DataInputStream din = null;
		DataOutputStream dout = null;

		try {
			ss = new ServerSocket(8888);
			System.out.println("서버 실행");
			System.out.println("------------------------");

			// 서버요청 대기
			s = ss.accept();
			System.out.println("Client 접속");
			System.out.println("------------------------");
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());

			Scanner sc = new Scanner(System.in);

			String msg1 = null; // 받는 메시지
			String msg2 = ""; // 보내는 메시지

			while (!msg2.equals("exit")) {

				msg1 = din.readUTF();
				System.out.println("Client Message : " + msg1);

				msg2 = sc.nextLine();
				dout.writeUTF(msg2);
				dout.flush();

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// close 메소드 오버라이딩으로 예외처리
			Util.close(din);
			Util.close(dout);
			Util.close(s);
			Util.close(ss);
			
			// 완전한 예외처리
//			if (din != null) {
//				try {
//					din.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			if (dout != null) {
//				try {
//					dout.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			if (s != null) {
//				try {
//					s.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//			if (ss != null) {
//				try {
//					ss.close();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
		}
	}
}