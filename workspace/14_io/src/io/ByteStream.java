package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteStream {

	public static void main(String[] args) throws IOException {
		try { 
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data.txt"));//파일을 외부에서 받아오는 것이므로 InputStream 을 이용하고, 입력으로 받고 오는 것이 파일이므로 FileInputStream 을 이용한다.
//			FileInputStream fis = new FileInputStream("data.txt");
//			BufferedInputStream bis = new BufferedInputStream(fis);
			//아래와 같이 사용할 수도있음 . 같은의미
			
			
			// ByteStream.java <-------------------- buffer <-------------------- data.txt
			
			
			//만약 read() 메소드를 사용하여 데이터를 읽어오는 경우,
			// 문자 한글자 한글자를 문자로 읽고, ASCII 코드로 변환하여 int 형으로 값을 반환해준다.
			//그 후, 다음값을 읽어오는데 다음 값이 없는 경우 null을 읽어온다. 하지만 반환형식이 int 형이므로 -1을 읽어오게 된다.
			int data;
			
			while((data = bis.read()) != -1) { //파일안에 있는 문자를 읽어와서 다음 값이 없을때까지 읽어온 후 출력한다.
				//System.out.print(data + " "); //결과를 출력해보면 중간에 13, 10 의 값이 종종 들어있다. 13과 10은 엔터의 값을 의미한다 . 엔터는 \r \n 의 기능이 있어 ASCII 코드로 나오는 것이다.
				System.out.print((char)data);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}
