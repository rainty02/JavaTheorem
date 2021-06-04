package com.networking.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionTest {

	public static void main(String[] args) {
		
		String urlStr = "https://news.naver.com/main/read.nhn?mode=LS2D&mid=sec&sid1=105&sid2=228&oid=584&aid=0000008620";
		try {
			URL url = new URL(urlStr);
			
			//HttpUrlConnection : url.openConnection()
			HttpURLConnection hcon = (HttpURLConnection) url.openConnection();
			
			for(int i=1; i<=8; i++) {
				System.out.print(hcon.getHeaderFieldKey(i));
				System.out.println(" : " + hcon.getHeaderField(i));
			}
			
			hcon.disconnect();		
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
