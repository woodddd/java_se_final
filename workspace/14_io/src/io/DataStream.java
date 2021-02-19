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
			DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt")); //new FileOutputStream("result.txt") -현재 에러가 발생되는 상황은 아니지만 ,해당 파일을 찾지 못했을 때에 대한 예외처리.
			dos.writeUTF("홍길동");//String은 객체형 타입이라서 파일로 내보내기 위해서는 직렬화를 해야한다. 하지만 String 클래스는 내부적으로 직렬화(Serializable)을 사용하고 있기 때문에, String은 정상적으로 사용할 수 있다.
			dos.writeInt(25);
			//dos.writeFloat(185.3);//자바에서 실수형은 기본 Double 형으로 인식한다. 그래서 큰 값인 Double이 Float에 들어갈 수 없다.
			dos.writeFloat(185.3f);//float형 처리
			dos.close();
			
			DataInputStream dis = new DataInputStream(new FileInputStream("result.txt"));
			System.out.println("이름 = " + dis.readUTF()); //읽어올땐 반드시 write했던 명령어와 똑같은 명렁을 주어야함.
			System.out.println("나이 = " + dis.readInt());
			System.out.println("키 = " + dis.readFloat());
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
