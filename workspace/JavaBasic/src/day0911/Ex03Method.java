package day0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//메소드
//메소드란 해당 클래스에 선언과 정의되어있는 기능을
//우리가 메소드 라고 한다.

//우리가 수학시간에 배웠떤 함수를 생각해보자
// f(x) = 3x;
//우리가 넣는숫자에 3이 곱해진 값이 결과가 나오게 된다.

//자바 메소드도 마찬가지
//우리가 어떤 타입의 값을 넣을지를 말해주고
//그 값을 통해서 어떤기능이 실행이 될지를 적어주고
//그 결과값을 호출된 곳으로 보낼 때 자료형을 적어주면 된다.

// 메소드를 선언해보자
// 메소드를 선언할 때에는
// 리턴타입 메소드를 이름(파라미터)
// 로 선언할 수 있다.

//리턴타입: 해당 메소드가 호출된 곳으로 보내줄 값의 데이터 타입
//		  만약 호출된 곳으로 보내줄 값이 있는 경우에는 메소드 내부에서
// 		 반드시!!! return 이라는 명령어를 통해서 값을 되돌려줘야 한다!
//		 만약 아무런 값도 보내주지 않을것이라면 리턴 타입은 void가 된다.
//메소드 이름 : 소문자로 시작하는 동사(ㅌ=낙타등 표기법)
// 파라미터: 해당 메소드가 실행할때 필요로 하는 외부의 값. 매소드 내부에서 변수처럼 쓰이기 때문에 매개변수라고도 한다.
public class Ex03Method {
	
	//사용자로부터 정수 2개를 받아서 그 합을 보내주는 메소드
	static int add(int a , int b) {
		int sum = a + b;
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		int userNumber1 = 10;
		int userNumber2 = 150;
		
		int result = add(userNumber1, userNumber2);
		System.out.println("result: " + result);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("국어");
		int korean = validateScore(br);
		System.out.println("영어");
		int english = validateScore(br);
		System.out.println("수학");
		int math = validateScore(br);
	}
	
	//사용자로부터 숫자를 입력 받아서
	//만약 해당 숫자가 0~100 의 범위를 벗어나면
	//다시 입력을 하게 만들어서
	//범위내이 숫자가 입력됐을때만 그 숫자를 return 하는 메소드
	
	static int validateScore(BufferedReader br) throws IOException {
		System.out.print("점수를 입력해주세요: ");
		int score = Integer.parseInt(br.readLine());
		while(score < 0 || score > 100) {
			System.out.println("잘못입력하셨습니다.");
			score = Integer.parseInt(br.readLine());
		}
		return score;
	}

}
