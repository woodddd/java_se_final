package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream2 {
	
	
	public static void main(String[] args) throws IOException {
		File file = new File("data.txt");//파일 객체 생성
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		//파일 크기
		int size = (int) file.length();//file.length() 는 long 타입을 반환함
		byte[] b = new byte[size];
		
		bis.read(b, 0, size);
		
		
		
		
		String str = new String(b); //byte[] -> String로 생성
		System.out.println(str);
		bis.close();
		
		
	}
	
}
