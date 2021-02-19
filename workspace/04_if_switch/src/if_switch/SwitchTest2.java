package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/*
2개의 정수형 숫자와 연산자(+,-,*,/)를 입력하여 계산하시오

[실행결과]
a 입력 : 25
b 입력 : 36
연산자(+,-,*,/) 입력 : +
25 + 36 = xx

a 입력 : 25
b 입력 : 36
연산자(+,-,*,/) 입력 : /
25 / 36 = 0.xxx

a 입력 : 25
b 입력 : 36
연산자(+,-,*,/) 입력 : $
연산자 error
 */

public class SwitchTest2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("#,###");
		//DecimalFormat는 유효숫자이면 숫자가 그대로 나오고 유효숫자가 아니면 표시를 하지 않는다.
		//ex) 13.000 은 .000 이 유효숫자가 아니라 제거되고 13이 나옴
		//ex) 0.647 이 나오면 유효숫자 이므로 그대로 나옴
		
		System.out.print("a 입력 : ");
		int a = Integer.parseInt(br.readLine());
		
		System.out.print("b 입력 : ");
		int b = Integer.parseInt(br.readLine());
		
		System.out.print("연산자(+, -, *, /) 입력 : ");
		String op = br.readLine();
		
		switch(op) {
		case "+" : System.out.println(a + " + " + b + " = " + (a + b));
		break;
		case "-" : System.out.println(a + " - " + b + " = " + (a - b));
		break;
		case "*" : System.out.println(a + " * " + b + " = " + (a * b));
		break;
		case "/" : System.out.println(a + " / " + b + " = " + String.format("%.3f",((double)a / b)));
		break;
		default : System.out.println("연산자 error");
		
			//만약 이 부분에서 프로그램을 바로 끝내야 할 경우 	System.exit(0); --- 프로그램 강제 종료		를 사용할 수 있음.
		}
		
		//System.out.println("끝나면 일로 오시오.");       ↑ 			를 실행하면 현재 문장을 출력하지 않고 바로 종료하게됨.
		
		
		
	}

}
