package loop;

import java.io.IOException;

/*
 * 거듭제곱을 구하시오
 * x의 y승을 계산하시오
 * 
 * [실행결과]
 * x값 입력 : 2
 * y값 입력 : 5
 * 2의 5승 xx
 * 
 * x값 입력 : 3
 * y값 입력 : 4
 * 3의 4승 xx
 * 
 */

public class ForTest5 {

	public static void main(String[] args) throws IOException {
		
		for(int j = 1; j <=3; j++) {
			int result = 1;
			
			System.out.print("x값 입력 : ");
			int x = System.in.read() - 48; //read() 는 한개의 문자를 입력받음 기본반환은 int형(입력문자의 아스키코드값)
			
			System.in.read();// 버퍼에서 엔터값(\r,\n) 비워주기 flush
			System.in.read();
			
			System.out.print("y값 입력 : ");
			int y = System.in.read() -48; 
			
			System.in.read();
			System.in.read();
			for(int i = 1 ; i<= y; i++) {
				result *=x;
			}
			System.out.println(x + "의 " + y + "승 " + result);
		}
	}

}
