package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream2 {
	
	
	public static void main(String[] args) throws IOException {
		File file = new File("data.txt");//���� ��ü ����
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(fis);
		
		//���� ũ��
		int size = (int) file.length();//file.length() �� long Ÿ���� ��ȯ��
		byte[] b = new byte[size];
		
		bis.read(b, 0, size);
		
		
		
		
		String str = new String(b); //byte[] -> String�� ����
		System.out.println(str);
		bis.close();
		
		
	}
	
}
