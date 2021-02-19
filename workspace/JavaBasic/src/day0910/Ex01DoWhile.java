package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//while과 Do While의 차이점을 알아보자

public class Ex01DoWhile {

	public static void main(String[] args)throws IOException {
		
		
		
		
		int number = 5;
		while( number > 5) {
			System.out.println("반복이 될까요?");
		}
		// 처음부터 while(false) 이므로 아무것도 출력되지 않는다.
		
		//그에 반해서 do while은 무조건 한번은 실행이 된다.
		//do 문장이 실행된 후 while 문의 조건을 보고 거짓일 경우 do 다시 문장을 실행하지 않고 while 문을 종료
		//참인경우 do 안의 문장을 다시 실행하고 while 문의 조건을 확인한다
		do {
			System.out.println("반복이 될까요?");
		}while(number > 5);
		
		//예제1. 사용자로부터 숫자를 입력 받되
		//10보다 큰 수가 입력되면 다시 입력하도록 만들어보자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//while을 사용
		System.out.print("숫자를 입력하세요 : ");
		int num = Integer.parseInt(br.readLine());
		
		while(num > 10) {
			System.out.println("다시 입력해주세요");
			num = Integer.parseInt(br.readLine());
			
		}
		System.out.println("사용자가 입력한 수 : " + num);
		
		//do while를 사용
		int num1 = 0;
		do {
			if(num1 > 10) {
				System.out.println("잘못 입력하셨습니다.");
			}
			System.out.print("숫자를 입력해주세요: ");
			num1 = Integer.parseInt(br.readLine());
		}while(num1 > 10);//이 조건이 참이면 위로 올라가서 do 문장을 다시 실행함. 만약 이 조건이 false 가 된다면  do while 문이 종료됨.
		
			System.out.println("사용자가 입력한 수 : " + num1);
	}

}
