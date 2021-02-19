package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//사용자로부터 국어, 영어 , 수학 점수를 입력받아서
//총점을 계산해주는 프로그램
//단 사용자가 입력한 점수가 잘못된 형식(0보다 작거나 100보다 큰 경우)
//일 때에는
//올바른 점수가 들어올 때 까지
//다시 입력을 받는다.
//입력을 할 떄에는 do while을 사용하도록 한다.

public class Ex02DoWhile02 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int kor = 0;
		int eng = 0;
		int math = 0;
		
		do {
			if(kor < 0 || kor > 100) {
				System.out.println("잘못 입력하였습니다.");
			}
		
		System.out.print("국어 점수를 입력 : ");
		kor = Integer.parseInt(br.readLine());
		
		}while(kor < 0 || kor > 100);
		
		do {
			if(eng < 0 || eng > 100) {
				System.out.println("잘못 입력하였습니다.");
			}
			
		System.out.print("영어 점수를 입력 : ");
		eng = Integer.parseInt(br.readLine());
			
			}while(eng < 0 || eng > 100);
		
		do {
			if(math < 0 || math > 100) {
				System.out.println("잘못 입력하였습니다.");
			}
			
		System.out.print("수학 점수를 입력 : ");
		math = Integer.parseInt(br.readLine());
		
		}while(math < 0 || math > 100);
		
		System.out.println("국어, 영어 , 수학 의 총점은 : " + (kor + eng + math));
		
		
		
		
	}

}
