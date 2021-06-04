package com.networking.practice;

import java.io.*;
import java.net.*;

public class Util {

	public static void close(ServerSocket ss) {
		
		if(ss != null ) {
			try {
				ss.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	public static void close(Socket s) {
		
		if(s != null ) {
			try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	
	}
	public static void close(FilterInputStream fin) {
		
		if(fin != null ) {
			try {
				fin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(FilterOutputStream fout) {
		
		if(fout != null ) {
			try {
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}