package method;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


/* 
 월급 계산 프로그램
이름, 직급, 기본급, 수당을 입력하여 세금과 월급을 계산하시오
세율은 급여가 4,000,000 만원 이상이면 3% 아니면 2%로 한다

만약 이 문제를 다 풀었다면
세금은 calcTax()
월급은 calcSalary()를 이용해서 계산하시오

급여 = 기본급 + 수당
세금 = 급여 * 세율
월급 = 급여 - 세금

[실행결과]
이름 입력 : 홍길동
직급 입력 : 부장
기본급 입력 : 4500000
수당 입력 : 200000

   *** 홍길동 월급 명세서 ***
직급 : 부장
기본급  	    수당 	     급여  	 세율  	 세금   	월급
4500000	200000     4700000   3%   xxxxx   xxxxxxx
세금, 월급은 정수형으로
*/

public class Salary {

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이름입력 : ");
		String name = br.readLine();
		
		System.out.print("직급 입력 : ");
		String position = br.readLine();
	
		System.out.print("기본급 입력 : ");
		int b_salary = Integer.parseInt(br.readLine());
		
		System.out.print("수당 입력 : ");
		int allowance = Integer.parseInt(br.readLine());
		
		int salary = b_salary + allowance;
		double tax_rate = salary >= 4000000 ? 0.03 : 0.02;
		int tax = (int) (salary * tax_rate);
		int m_salary = salary - tax;
		
		
		System.out.println("\t*** " + name + "  ***");
		System.out.println("직급 : " + position);
		System.out.println("기본급\t수당\t급여\t세율\t세금\t월급\t");
		System.out.println(b_salary + "\t" + allowance + "\t" + salary + "\t" + (int)(tax_rate*100) + "%\t" + tax + "\t" + m_salary);

	}


}
