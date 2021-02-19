package exception;

import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		//run configuration - arguments - 값 입력
		//arguments 에 매개변수 입력 값을 넣어주면 args 의 String 배열의 방의 크기가 결정이됨
		// 매개변수로 값을 두개 넣어주면 배열의 크기는 2 가 됨,
		//arguments는 매개 변수를 공백을 통해서 몇개가 들어오는지 인식함. 기 린 - 2개의 값이 들어오지만
		// "기 린" 으로 하면 하나의 매개변수로 묶을 수 있음.
		
		
		if(args.length > 0) //하나이상의 데이터갇 들어오고 있을때 수행 
			System.out.println(args[0]);
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("숫자 입력 : ");
			int num2 = scan.nextInt();
			
			int num1 = Integer.parseInt(args[0]);
			
				System.out.println(num1 + "/" + num2 + "=" + ((double)num1/num2));
				// 만약 나눌 수들을 double 형식으로 잡으면 끝까지 소숫점으로 나누려 하기 때문에 에러가 발생되지 않고 Infinity 가 나오게됨.
			
		}catch(NumberFormatException e){ // body안에 아무것도 입력하지 않으면 아무것도 출력해주지 않음(묵비권) 너무안좋음.
			System.out.println("숫자만 입력하세요.");//num1,2 는 int 타입이지만 다른 타입의 문자가 들어오면 숫자형식예외 에러가 발생됨
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없습니다.");//만약 double형식이 아닌 int 형식으로 나눌 경우 0으로 어떠한 수를 나눌 수 없음 하지만 double은 결과를 알기 전 부터 계속 계산을 진행하기 때문에 에러가 발생하지 않음
		}finally {
			System.out.println("error가 있건 없건 무조건 실행!!");
		}
		
		
		
	}

}
