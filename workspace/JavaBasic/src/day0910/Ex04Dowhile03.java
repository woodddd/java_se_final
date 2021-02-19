package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//do while 복습
public class Ex04Dowhile03 {
	//점수맞추기 게임
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		
		while(number < 0) {
			System.out.println("자연수를 입력해주세요");
			System.out.println("숫자를 하나 입력해주세요.");
			number = Integer.parseInt(br.readLine());
		}
		//위 while문의 경우
		//사용자가 맨 처음에 0보다 크거나 같은 수를 입력하면
		//number < 0 이라는 조건식이 false가 되므로
		//while 문이 반복되지 않게 된다.
		
		System.out.println("사용자가 입력한 숫자 : " + number);
				
		
		//그에 반해서 do while 구조에서는
		//무조건 한번은 실행이 된다.
		do {
			System.out.println("do while 첫번째 줄");
		}while(number < 0);
	}

}
