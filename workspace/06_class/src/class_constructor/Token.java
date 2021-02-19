package class_constructor;

import java.util.StringTokenizer;

public class Token {
	
	public static void main(String[] args) {
		String str = "학원,집,,게임방";
		
		StringTokenizer st = new StringTokenizer(str,",");//큰따옴표 안의 문자로 str을 분리해라.
		System.out.println("토큰 개수 = " + st.countTokens());
		
		//토큰은 공백 ,, 을 무시한다.
		
		//hasMoreTokens() - 현재위치 토큰 True/False
		//nextToken() - 현재 위치에서 토큰을 꺼내주고 다음 토큰으로 이동
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}//while
		System.out.println("--------------------------");
		
		String[] ar = str.split(",");//큰따옴표 안의 문자 , 로 구분하여 문자열 배열로 값을 추출함
		for(String data : ar) {//향상된 for문 . //for(변수의 자료형  변수이름 : 배열의 변수)  //배열의처음부터 끝까지 반복해줌.
			System.out.println(data); // split 은 공백을 무시하지 않는다.
		}
	}

}
