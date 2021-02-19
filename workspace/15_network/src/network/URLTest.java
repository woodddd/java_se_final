package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class URLTest {

	public static void main(String[] args) throws IOException {
		URL url = new URL("https://www.google.com/index.html");
		System.out.println("�������� = " + url.getProtocol());
		System.out.println("ȣ��Ʈ = " + url.getHost());
		System.out.println("��Ʈ = " + url.getPort()); // ���� ��Ʈ���� �Է����� �ʾұ� ������ -1 �� ����
		System.out.println("�⺻ ��Ʈ = " + url.getDefaultPort()); // port number : HTTPS - 443
		System.out.println("���� = " + url.getFile());
		System.out.println();
		
		//IOStream - �Է� ��Ʈ��
		
		//					BufferedReader					InputStreamReader					URL.openStream()
		//URLTest.java <------------------------ buffer <------------------------ ����ǻ�� <------------------------ ��
		//																						inputStream
		
		//openStream() ��ȯ Ÿ�� InputStream . Byte������ ����� �� �ְ� ���ش�.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream())); // ���� ������ URL�ּҷ� ���� inputStream Ÿ������ �����͸� ������ ����
		String line;
		while((line=br.readLine()) != null ) {
			System.out.println(line + "\n");
		}//while
		
		br.close();
	}
	
}
