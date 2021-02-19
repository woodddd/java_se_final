package loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 숫자맞추기 게임
1~100사이의 난수를 발생하여 맞추는 게임

[실행결과]
숫자 입력 : 50
50보다 큽니다

숫자 입력 : 90
90보다 작습니다

...

숫자 입력 : 87
딩동뎅 xx번만에 맞추셨습니다

continue(Y/N) : n
프로그램을 종료합니다
 */

public class NumberGame {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String retry ;
		int count = 0;
		int user = 0;
		int computer = 0;
		
		for(;;) {
			computer = (int)(Math.random()*100+1);
			System.out.println(computer);
			
			while(true) {
				
				System.out.print("숫자 입력 : ");
				user = Integer.parseInt(br.readLine());
				
				if(computer > user) {
					System.out.println(user + "보다 큽니다");
					count ++;
					
				}else if(computer < user) {
					System.out.println(user + "보다 작습니다");
					count ++;
					
				}else{
					count ++;
					System.out.println("딩동댕" + count + "번만에 맞추셨습니다.");
					break;
				}
				
				
			}//while
			System.out.println("--------------------");
			
			while(true) {
				System.out.println("continue(Y/N) : ");
				retry = br.readLine();
				
				if(retry.equals("y")||retry.equals("Y")||retry.equals("n")||retry.equals("N")){
						break;
				}
				
			}
			//if(retry.equals("y")||retry.equals("Y")){ continue};  만약continue를 사용하게 된다면 continue를 포함한 반복문의 머리부분으로 간다.
			if(retry.equals("n")||retry.equals("N")) {
				break;
			}
		}//for
		System.out.println("프로그램을 종료합니다.");
	}

}
