package loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
더하기 연습 프로그램
10~99 사이의 난수를 2개(a, b) 발생하여 합을 구하는 프로그램
문제수는 총 5문제를 제공한다 - for
1문제당 점수 20점씩 계산

[실행결과]
[1] 25 + 36 = 45
틀렸다

[2] 78 + 10 = 88
딩동뎅
...

[5] 12 + 25 = 37
딩동뎅

당신의 총 x문제를 맞추어서 xx점 입니다
또 할래(Y/N)
 */

public class AddGame {
	

	public static void main(String[] args) throws  IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = 0;
		int b = 0;
		int user;
		int count = 0;
		String result;
		
		while(true) {
			count = 0;
			for(int i = 1 ; i <= 5; i++) {
				
				a = (int)(Math.random()*90+10);
				b = (int)(Math.random()*90+10);
				
				System.out.print("[" + i + "] " + a + " + " + b + " = " );
				user = Integer.parseInt(br.readLine());
				
				if(a + b == user) {
					System.out.println("딩동댕");
					count++;
				}else {
			 		System.out.println("틀렸다");
				}
				
			}//for
			
			System.out.println("당신은 총 " + count + " 문제를 맞추어서 " + count*20 + "점 입니다");
			
			while(true) {
				System.out.println("또 할래(Y/N)");
				result = br.readLine();
				
				
				
				if(result.equals("y")||result.equals("Y")||result.equals("n")||result.equals("N")) {
					break;
				}else {
					System.out.println("잘못된 문자입니다.");
				}
			
		}//while
			
		if(result.equals("N")||result.equals("n")) {
			break;
		}
	}//while
		System.out.println("프로그램을 종료합니다.");
}
}
