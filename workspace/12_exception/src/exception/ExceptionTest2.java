package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionTest2 {
	private int dan;
	//							최상위 부모.
	public void input() throws IOException { //NumberFormatException, IOException 는 상속관계 라서 하나를 지워도 상관이 없음
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("원하는 단을 입력: ");
		dan = Integer.parseInt(br.readLine());//throws 를 사용하라는건 에러가 발생하는게 아니라 에러가 발생할 상황을 대비하라는 것.
	}
	
	//IO Stream
	// 입력 : Reader	추상클래스
	// 출력 : Writer 	추상클래스
	// Reader , Writer 는 추상클래스 이기 때문에 직접적으로 new 할 수 없고, 자식클래스를 이용해야함.

	//					      BufferedReader 		      InputStreamReader
	// ExceptionTest2.java <-------------------- buffer <-------------------- 키보드(System.in)
	
	// ExceptionTest2.java --------------------> buffer -------------------->  
	
	
	public void output() {
		if(dan >= 2 && dan <= 9) {
			for(int i = 1; i < 10 ; i++) {
				System.out.println(dan + " * " + i + " = " + (dan*i));	
			}//for
		}else {
			//System.out.println("범위 초과");
			try {
				throw new MakeException("범위 초과");//강제로 Exception 발생 //만약 문자열도 에러로 나오게 하고 싶다면 new MakeException() 괄호 안에 메세지를 입력해주면 된다.
			//  throw 는 에러를 발생시킬 때 사용한다. 반면 뒤에 s 를 붙이면 throws 로 에러를 잡을 때 사용한다.
			}catch(Exception e) {
				e.printStackTrace(); //Stack에 있는 에러메세지를 찍어라.
			}
			 
		}//if
	}
	public static void main(String[] args) throws NumberFormatException, IOException { //구현부에서 예외 상황이 발생할여지가 있으면 호출부에서도 꼭 예외처리를 해 주어야 한다.
		ExceptionTest2 ex = new ExceptionTest2();
			ex.input();
			ex.output();	
		
	}

}


//throw --바이러스 - 에러를 발생시킬것이다.
//throws --백신    - 에러를 잡을것이다.
//오버라이딩 한 메소드는 절대절대절대로 throws를 해 줄 수 없다.



//원하는 단을 입력: 5	input()
//-----------------------
//5*1=5			output
//5*2=10
//..단을.
//5*9=45