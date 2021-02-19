package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.google.com/index.html");
		System.out.println("프로토콜 = " + url.getProtocol());
		System.out.println("호스트 = " + url.getHost());
		System.out.println("포트 = " + url.getPort()); // 현재 포트값을 입력하지 않았기 때문에 -1 이 나옴
		System.out.println("기본 포트 = " + url.getDefaultPort()); // port number : HTTPS - 443
		System.out.println("파일 = " + url.getFile());
		System.out.println();
		
		//IOStream - 입력 스트림
		
		//					BufferedReader					InputStreamReader					URL.openStream()
		//URLTest.java <------------------------ buffer <------------------------ 내컴퓨터 <------------------------ 웹
		//																						inputStream
		
		//openStream() 반환 타입 InputStream . Byte단위로 사용할 수 있게 해준다.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream())); // 위에 저장한 URL주소로 부터 inputStream 타입으로 데이터를 가지고 들어옴
		String line;
		while((line=br.readLine()) != null ) {
			System.out.println(line + "\n");
		}//while
		
		br.close();
	}
	
}
