package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 가위(1), 바위(2), 보(3) 게임

[실행결과]
가위(1),바위(2),보(3) 중 번호 입력 : 3 (user)
컴퓨터 : 바위   나 : 보자기
You Win!!

가위(1),바위(2),보(3) 중 번호 입력 : 3 (user)
컴퓨터 : 가위   나 : 보자기
You Lose!!

가위(1),바위(2),보(3) 중 번호 입력 : 2 (user)
컴퓨터 : 가위   나 : 가위
You Draw!!
 */

public class RPSGame {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("가위(1),바위(2),보(3) 중 번호 입력 : ");
		int user = Integer.parseInt(br.readLine());
		
		//난수 - 컴퓨터가 무작위로 발생하는 수, 0<= 난수 < 1
				// a~b사이의 난수 발생 => (int)(Math.random()*(b-a+1)+a);1~3 --- a = 1 b = 3

		int computer = (int)(Math.random()*3 + 1); //컴퓨터가 1~3 의 값을 반환
		
		
		if(computer == 1) 
		{
			if(user == 1)
			{
				System.out.println("컴퓨터 : 가위 \t나 : 가위" );
				System.out.println("You Draw!!");
			}else if(user == 2)
			{
				System.out.println("컴퓨터 : 가위 \t나 : 바위");
				System.out.println("You Win!!");
			}else
			{
				System.out.println("컴퓨터 : 가위 \t나 : 보");
				System.out.println("You Lose!!");
			}
		}else if(computer ==2)
		{
			if(user == 1)
			{
				System.out.println("컴퓨터 : 바위 \t나 : 가위");
				System.out.println("You Lose!!");
			}else if(user == 2)
			{
				System.out.println("컴퓨터 : 바위 \t나 : 바위");
				System.out.println("You Draw!!");
			}else
			{
				System.out.println("컴퓨터 : 바위 \t나 : 보");
				System.out.println("You Win!!");
			}
		}else
		{
			if(user == 1)
			{
				System.out.println("컴퓨터 : 보 \t나 : 가위");
				System.out.println("You Win!!");
			}else if(user == 2)
			{
				System.out.println("컴퓨터 : 보 \t나 : 바위");
				System.out.println("You Lose!!");
			}else
			{
				System.out.println("컴퓨터 : 보 \t나 : 보");
				System.out.println("You Draw!!");
			}
		}
		
	}

}
