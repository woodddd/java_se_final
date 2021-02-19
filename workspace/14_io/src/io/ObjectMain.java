package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		PersonDTO dto = new PersonDTO("홍길동", 25, 185.3);
		
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result2.txt"));
		oos.writeObject(dto);//dto를 Object타입으로 내보낸다.
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("result2.txt"));
		PersonDTO dto2 = (PersonDTO)ois.readObject();//Object타입으로 파일을 가져옴// 자식 = (자식)부모
		
		System.out.println("이름 = " + dto2.getName());
		System.out.println("나이 = " + dto2.getAge());
		System.out.println("키 = " + dto2.getHeight());
		ois.close();
	
		
		

	}

}
