package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		PersonDTO dto = new PersonDTO("ȫ�浿", 25, 185.3);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result2.txt"));
		oos.writeObject(dto);//dto�� ObjectŸ������ ��������.
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("result2.txt"));
		PersonDTO dto2 = (PersonDTO)ois.readObject();//ObjectŸ������ ������ ������// �ڽ� = (�ڽ�)�θ�
		
		System.out.println("�̸� = " + dto2.getName());
		System.out.println("���� = " + dto2.getAge());
		System.out.println("Ű = " + dto2.getHeight());
		ois.close();
	
		
		

	}

}
