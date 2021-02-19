package variable;

/*
이름이 L(name)인 사람의 기본급(basePay)이 2500000일때 3.3% 세금(tax)과 월급(salary)을 계산하시오

세금 = 기본급 * 3.3%(0.033)
월급 = 기본급 - 세금
      
[실행결과]
*** L의 월급 ***
기본급 : 2500000원
세금   : 82500원
월급   : 2417500원
 
 
 */

public class PayTest {

	public static void main(String[] args) {
		
		char name = 'L';
		int basePay = 2500000;
		int tax = (int) (basePay * 0.033);
		int salary = basePay - tax;
		
		System.out.println("*** " + name + "의 월급 ***" );
		System.out.println("기본급 : " + basePay + "원");
		System.out.println("세금 : " + tax + "원");
		System.out.println("월급 : " + salary + "원");

		
		
	}

}
