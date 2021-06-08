package com.networking.practice;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {

	public static void main(String[] args) {

		try {
			ServerSocket serverSocket = new ServerSocket(9999);
			
			System.out.println("서버 실행");
			
			// socket에서 연결 요청이 올 때까지 대기
			Socket socket = serverSocket.accept();
			
			if(socket != null) {
				System.out.println("클라이언트의 접속요청 : Socket 생성");
			}
			
			DataInputStream din = new DataInputStream(socket.getInputStream());
			
			String msg = din.readUTF();
			System.out.println(msg);
			
			din.close();
			socket.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}