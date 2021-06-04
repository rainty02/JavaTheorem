package com.networking.practice;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionTest {

	public static void main(String[] args) {

		try {
			URL url = new URL("http://www.google.com");
			// 서버에서 응답하는 데이터들을 가져올 수 있음. html만 아니라
			// URLConnection : url.openConnection()
			URLConnection con = url.openConnection();
			
			InputStream in = con.getInputStream();
			
			int i = 0;
			
			while(true) {
				i = in.read();
				if(i==-1) {
					break;
				}
				System.out.print((char)i);
			}
			
			
			
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

