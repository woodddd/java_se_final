package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteStream {

	public static void main(String[] args) throws IOException {
		try { 
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data.txt"));//������ �ܺο��� �޾ƿ��� ���̹Ƿ� InputStream �� �̿��ϰ�, �Է����� �ް� ���� ���� �����̹Ƿ� FileInputStream �� �̿��Ѵ�.
//			FileInputStream fis = new FileInputStream("data.txt");
//			BufferedInputStream bis = new BufferedInputStream(fis);
			//�Ʒ��� ���� ����� �������� . �����ǹ�
			
			
			// ByteStream.java <-------------------- buffer <-------------------- data.txt
			
			
			//���� read() �޼ҵ带 ����Ͽ� �����͸� �о���� ���,
			// ���� �ѱ��� �ѱ��ڸ� ���ڷ� �а�, ASCII �ڵ�� ��ȯ�Ͽ� int ������ ���� ��ȯ���ش�.
			//�� ��, �������� �о���µ� ���� ���� ���� ��� null�� �о�´�. ������ ��ȯ������ int ���̹Ƿ� -1�� �о���� �ȴ�.
			int data;
			
			while((data = bis.read()) != -1) { //���Ͼȿ� �ִ� ���ڸ� �о�ͼ� ���� ���� ���������� �о�� �� ����Ѵ�.
				//System.out.print(data + " "); //����� ����غ��� �߰��� 13, 10 �� ���� ���� ����ִ�. 13�� 10�� ������ ���� �ǹ��Ѵ� . ���ʹ� \r \n �� ����� �־� ASCII �ڵ�� ������ ���̴�.
				System.out.print((char)data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
