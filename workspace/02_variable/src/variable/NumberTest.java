package variable;

public class NumberTest {

	public static void main(String[] args) {

		System.out.print("안녕하세요\n");
		System.out.println(25+36);
		System.out.println("25+36");
		System.out.println("25+36 = " + 25 + 36);
		// --- "문자열" + 25 = "문자열+25" 문자열의 + 는 결합을 의미함
		System.out.println("25+36 = " + (25+36));
		// --- 우선순위를 숫자 계산을 먼저 주면 숫자 계산 후 문자열 결합!
		System.out.println("25/36 = " + (25/36));
		// --- 정수/정수 = 소숫점을 구하지 않고 정수의 부분만을 구함.
		System.out.println("25.0/36.0 = " + (25.0/36));
		// --- 실수 / 정수 는 정수를 자동으로 36을 36.0으로 바꿔 계산(캐스팅 이라고함) 그래서 실수의 결과 값을 추출
		
		//System.out.printf(format, args)
		//정수형 값을 원할 때 %d
		//실수형 값을 원할 때 %f
		//문자 값을 원할 때    %c
		//문자열 값을 원할 때 %s
		//%전체자릿수, 소수자리이하수f
		//전체자릿수 생략시 전체자릿수는 신경쓰지 말라는 말.
		System.out.printf("25/36 = %.2f\n", (25.0/36));
		//실수형 소수점 2번째 자리까지 원합니다.
		System.out.printf("25/36 = %.1f\n", (25.0/36));
		//실수형 소수점 1번째 자리까지 원합니다. 	
		System.out.printf("%d / %d = %.1f\n", 25, 36,(25.0/36) );
		
		System.out.println("25.0/36.0 = " + String.format("%.2f",(25.0/36)));
		System.out.println();
		
		//문자열이 아닌 '문자' 문자형을 입력하면 문자형은 아스키코드 값을 반환함.
		System.out.println('A'+3);
		System.out.println('A'+32);
		System.out.println((char)('A'+32));//형변화(casting)을 하겠다.
		System.out.println(2+5);
		System.out.println('2'+5);
		System.out.println('2' + '5');//103 --- '문자' + '문자' --- 아스키코드 + 아스키코드
		System.out.println('2'-48 + '5'-48);//문자 '0' 은 아스키코드 48 숫자 0 은 --- 0 문자를 숫자로 변환
		System.out.println("2"+"5");//"문자열" + "문자열" --- "25"
		System.out.println(Integer.parseInt("2") + Integer.parseInt("5")); // 문자열을 숫자로 변환  --- 7
		System.out.println("25.3"+"45.6");
		System.out.println(Double.parseDouble("25.3")+Double.parseDouble("45.6"));//문자열을 실수로 변환(만약 정수를 사용한다면 실수부분을 다 잘라버림)		
		
	//* 중요내용 *//
	//문자 는 아스키 코드의 값을 반환하지만 문자열은 값이 없음!
	//클래스의 첫 문자는 대문자!!
	}
	

}
