package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {

	
	//					DataOutputStream				 FileOutputStream
	//DataStream.java -----------------------> buffer -----------------------> result.txt
	public static void main(String[] args) {
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt")); //new FileOutputStream("result.txt") -���� ������ �߻��Ǵ� ��Ȳ�� �ƴ����� ,�ش� ������ ã�� ������ ���� ���� ����ó��.
			dos.writeUTF("ȫ�浿");//String�� ��ü�� Ÿ���̶� ���Ϸ� �������� ���ؼ��� ����ȭ�� �ؾ��Ѵ�. ������ String Ŭ������ ���������� ����ȭ(Serializable)�� ����ϰ� �ֱ� ������, String�� ���������� ����� �� �ִ�.
			dos.writeInt(25);
			//dos.writeFloat(185.3);//�ڹٿ��� �Ǽ����� �⺻ Double ������ �ν��Ѵ�. �׷��� ū ���� Double�� Float�� �� �� ����.
			dos.writeFloat(185.3f);//float�� ó��
			dos.close();
			
			DataInputStream dis = new DataInputStream(new FileInputStream("result.txt"));
			System.out.println("�̸� = " + dis.readUTF()); //�о�ö� �ݵ�� write�ߴ� ��ɾ�� �Ȱ��� ���� �־����.
			System.out.println("���� = " + dis.readInt());
			System.out.println("Ű = " + dis.readFloat());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
