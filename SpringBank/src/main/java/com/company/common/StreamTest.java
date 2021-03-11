package com.company.common;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class StreamTest {
	public static void main(String[] args) throws Exception {
		/*
		FileReader fr = new FileReader("C:\\tmp\\sample.txt");
		int c;
		while ((c = fr.read()) != -1) {
			System.out.println((char)c);
		}
		fr.close();
		 * */
		
		//BufferedReader br = new BufferedReader(new FileReader("C:\\tmp\\sample.txt"));
		//BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\tmp\\sample2.txt"));
		//String line;
		BufferedInputStream br = new BufferedInputStream(new FileInputStream("C:\\tmp\\Koala.jpg"));
		BufferedOutputStream bw = new BufferedOutputStream(new FileOutputStream("C:\\tmp\\Koala2.jpg"));
		int cnt;
		byte[] b= new byte[100];
		while(true) {
//			line = br.readLine();
//			if(line == null) break;
//			bw.write(line+"\n");
			cnt = br.read(b);
			if(cnt == -1) break;
			bw.write(b);
		}
		br.close();
		bw.close();
	}
}
