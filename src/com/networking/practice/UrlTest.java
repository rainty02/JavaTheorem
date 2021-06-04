package com.networking.practice;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlTest {

	public static void main(String[] args) {

		String urlStr = "https://news.naver.com/main/read.nhn?mode=LS2D&mid=sec&sid1=105&sid2=228&oid=584&aid=0000008620";
		
		try {
			URL url = new URL(urlStr);
			// 어느부분을 뜻하는지 파악
			System.out.println("Protocol : " + url.getProtocol());
			System.out.println("Host Name : " + url.getHost());
			System.out.println("Port Num : " + url.getPort());
			System.out.println("Default Port Num : " + url.getDefaultPort());
			System.out.println("Query : " + url.getQuery());
			System.out.println("Path : " + url.getPath());
			System.out.println("File : " + url.getFile());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

}
