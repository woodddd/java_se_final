package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

//14K�� ��� ���Դ����� ���ϴ� ���α׷�
//��ҹ��� �������� ã��.
public class URLTest2 {
	private static ArrayList<String> list = new ArrayList<String>();
	private static int count;
	
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.liebli.com/");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));//openStream �� InputStream Ÿ������ �����͸� �����´�.
		
		
	//  URLTest2.java <---------- buffer <---------- ����ǻ�� <---------- ��������
	//  													url.openStream()
	//														InputStream Ÿ��
		//����
		
//		int count = 0;
//		String line = null;
//		
//		while((line = br.readLine()) != null) {
//
//			
//			line = line.toLowerCase();
//
//			for(int i = 0; i < line.length() ; i++) {
//				if(i = line.indexOf("14k",i) != -1) {//indexOf(ã������, �������ε�����ȣ)
//					count++;
//					i = i + 2;
//					System.out.println(i);
//				}
//			}
//		}//while
			
			//����Բ�
		 String line = null;
	       int count =0; //count ���� ����־�� �ؿ��� ������ֹǷ� ���⿡�� �ʱⰪ �ֱ�
	       int index ;
	       while( (line = br.readLine()) != null) {
	         line = line.toLowerCase();
	         
	         index = 0;
	         while( (index = line.indexOf("14k", index)) != -1){  //������ ġȯ�ϴ� ���� �����ϱ�
	                  
	               index += ("14k".length());
	               count++;
	            }//while
	         }//while
	               System.out.println("14K��� �ܾ "+ count +"�� �ֽ��ϴ�");
	               System.out.println();


		
		br.close();
		System.out.println("14k �� ���� : " + count);
	}
}
