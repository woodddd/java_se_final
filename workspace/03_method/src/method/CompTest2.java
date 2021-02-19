package method;

/*
 *
 * ch에 있는 데이터가 대문자이면 소문자로 출력하고 아니면(소문자) 대문자로 출력하시오

[실행결과]
T → t

또는

e → E
 */

public class CompTest2 {

	public static void main(String[] args) {
		
		char ch ='s';
		
		char result = ch >= 65 && ch <= 96 ? (char)(ch + 32) : (char)(ch - 32) ;
		
		System.out.println("변환 전 데이터 : " + ch);
		System.out.println("변환 후 데이터 : " + result);
		

	}

}
