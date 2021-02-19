package method;

import java.io.IOException;
import java.text.DecimalFormat;
// 자바는 java.lang 을 기본 패키지로 사용
import java.util.Random; // Random 은 java.util 안에 있는 Random 메소드 입니다. 가져오세요


public class MethodTest4 {

	
	//메소드는 메소드 안에서 작성하면 안됨!!
	public static void main(String[] args) throws IOException{

		System.out.println(Math.abs(-25));
		
		//난수 - 컴퓨터가 무작위로 발생하는 수, ( 0 <=  난수  < 1 )
		System.out.println("난수 = " + Math.random());
		Random r = new Random(); // 랜덤 클래스 생성!
		System.out.println("난수 = " + r.nextDouble());
		
		//숫자를 3자리 마다 "," 찍기
		int num = 1234567;
		
		DecimalFormat df = new DecimalFormat("#,###원");
		System.out.println(df.format(num));
		
		//입력
		//System.in.read(); 키보드 입력 --> 데이터는 int 타입으로 출력해줌
		// !! 키보드를 통해서 입력된 것은 모두 1개의 '문자' 로 인식함
		System.out.print("데이터 a : ");
		char a = (char)System.in.read(); //지역변수
		
		// A를 입력하게 되면 A - Enter 를 콘솔에 입력하게 됨.
		//메모리 ------ buffer ------ 화면(콘솔)
		//  A <------   A   <------   A 
		//flush - 버퍼 비우기
		
		// Enter의 기능
				// 다음줄로 이동                   \n
				// (다음줄의)처음으로 이동   \r
		System.in.read(); //- \r
		System.in.read(); //- \n
		
		System.out.print("데이터 b : ");// 엔터의 \n \r 을 입력하게 되었으므로 데이터b 를 정상적으로 입력 받을 수 있게됨
		char b = (char)System.in.read(); //지역변수
		
		
		
		//예외처리 
		//throws
		// - System.in(입력) 의 예외가 발생할 때 JVM 에게 예외를 던진다.
		// 함수 뒤에 작성한다.
		
		System.out.println("결과 = " + a + "\t" + b);
		
		//사용자 정의 함수 - a와 b 중에서 큰 값을 출력하는 메소드 작성
		MethodTest4 call = new MethodTest4();
		char max = call.big(a,b);
		System.out.println("큰 값 : " + max);
		
		
	}
	
	public char big(char a,char b) { // char a, char b --- parameter(매개변수), argument(인수)
		return a >= b ? a : b;
	}
	
}
