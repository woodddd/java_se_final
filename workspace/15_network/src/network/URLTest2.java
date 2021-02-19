package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

//14K가 몇번 나왔는지를 구하는 프로그램
//대소문자 구별없이 찾기.
public class URLTest2 {
	private static ArrayList<String> list = new ArrayList<String>();
	private static int count;
	
	public static void main(String[] args) throws IOException {
		URL url = new URL("http://www.liebli.com/");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));//openStream 은 InputStream 타입으로 데이터를 가져온다.
		
		
	//  URLTest2.java <---------- buffer <---------- 내컴퓨터 <---------- 웹브라우저
	//  													url.openStream()
	//														InputStream 타입
		//내꺼
		
//		int count = 0;
//		String line = null;
//		
//		while((line = br.readLine()) != null) {
//
//			
//			line = line.toLowerCase();
//
//			for(int i = 0; i < line.length() ; i++) {
//				if(i = line.indexOf("14k",i) != -1) {//indexOf(찾을문자, 시작할인덱스번호)
//					count++;
//					i = i + 2;
//					System.out.println(i);
//				}
//			}
//		}//while
			
			//강사님꺼
		 String line = null;
	       int count =0; //count 값이 살아있어야 밑에서 출력해주므로 여기에서 초기값 주기
	       int index ;
	       while( (line = br.readLine()) != null) {
	         line = line.toLowerCase();
	         
	         index = 0;
	         while( (index = line.indexOf("14k", index)) != -1){  //예전에 치환하던 문제 참고하기
	                  
	               index += ("14k".length());
	               count++;
	            }//while
	         }//while
	               System.out.println("14K라는 단어가 "+ count +"개 있습니다");
	               System.out.println();


		
		br.close();
		System.out.println("14k 의 개수 : " + count);
	}
}
