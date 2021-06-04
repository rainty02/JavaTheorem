package com.networking.practice;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSocket {

	public static void main(String[] args) {
	
		// SocketServer의 IP와 PORT 번호로 연결신청 : Socket 객체 생성
		try {
			Socket socket = new Socket("localhost", 9999);
			
			if(socket != null) {
				System.out.println("서버 접속 완료");
			}
			
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			dout.writeUTF("클라이언트 : 안녕하세요.");
			dout.flush();
			dout.close();	
			socket.close();		
		
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}	
}