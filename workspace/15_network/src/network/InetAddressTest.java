package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {

	public static void main(String[] args) throws UnknownHostException {
		//InetAddress naver = new InetAddress();//InetAddress는 추상클래스가 아니다.//InetAddress는 기본 생성자가 없어서 에러가 발생한다.
		InetAddress naver = InetAddress.getByName("www.naver.com");
		System.out.println("NAVER IP = " + naver.getHostAddress());
		System.out.println();
		
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("localhost IP = " + local.getHostAddress());
		System.out.println();
		
		InetAddress[] daum = InetAddress.getAllByName("www.daum.net");
		for(InetAddress data : daum) {
			System.out.println("Daum IP = " + data.getHostAddress());
		}
	}
	
}
