package variable;

/*
 * 변수에 저장하여 320, 258의 합을 구하시오
 * 
 * [실행결과]
 * 320 + 258 = xxx (sum)
 * 320 - 258 = xxx (sub)
 * 320 * 258 = xxx (mul)
 * 320 / 258 = 1.24 (div) - 소수 이하 둘쨰자리까지
 */

public class CellTest {

	public static void main(String[] args) {
		
		short a = 320;
		short b = 258;
		//short sum = a + b; // 의 결과가 에러가 나는 이유는
		// a + b 의 계산의 결과는 기본적으로 int 형이 반환됨. 그러므로 short 에 담길 수 없음.
		int sum = a + b;
		int sub = a - b;
		int mul = a * b;
		double div = (double) a / b; // a - 강제형변환 / b - 자동형변환 // 부가설명 : 정수/정수 = 정수이지만 문제에서 소수이하 둘쨰자리까지 구하라고 했으므로 강제 형변환을 하여 double 타입으로 바꿔줌
		System.out.println(a + " + " + b + " = " + sum);
		System.out.println(a + " - " + b + " = " + sub);
		System.out.println(a + " * " + b + " = " + mul);
		System.out.println(a + " / " + b + " = " + String.format("%.2f",div ));
		
	}

}
 