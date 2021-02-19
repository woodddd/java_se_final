package class_constructor;

import java.text.DecimalFormat;

/*
직원들의 월급을 계산하는 프로그램을 작성하시오
객체 배열로 작성하시오

클래스명 : SalaryDTO
필드       : name, position, basePay, benefit, taxRate, tax, salary
생성자    : 데이터를 입력(생성자 파라미터 이용)
calc() - 계산

세금 = (기본급 + 수당) * 세율;
월급 = 기본급 + 수당 - 세금;

세율은 200만원 이하 : 1%(0.01), 
     400만원 이하 : 2%(0.02), 
     400만원 초과 : 3%(0.03)으로 설정한다.

[실행결과]
이름      직급      기본급		수당		세율      세금      월급
홍길동   부장      5000000	200000
유재석   과장      3500000	150000
박명수   사원      1800000	100000
 */

public class SalaryMain {
	
	final static int SIZE = 3;
	
   public static void main(String[] args) {
	   
	   SalaryDTO[] salarydto = new SalaryDTO[SIZE];
	   DecimalFormat df = new DecimalFormat("#,###");
	   
	   salarydto[0] = new SalaryDTO("홍길동","부장",5000000,200000);
	   salarydto[1] = new SalaryDTO("유재석","과장",3500000,150000);
	   salarydto[2] = new SalaryDTO("박명수","사원",1800000,100000);
	   
	   
	   System.out.println(); // - main() 메소드 출력하시오.
	   
	   System.out.println("이름\t직급\t기본급\t\t수당\t\t세율\t세금 \t\t월급");

	   for(int i = 0; i < salarydto.length ; i ++) {
		   salarydto[i].calc();
		   System.out.println(salarydto[i].getName() + "\t" + salarydto[i].getPosition() + "\t" +
				   salarydto[i].getBasePay() + "\t\t" + salarydto[i].getBenefit() + "\t\t" + 
				   				salarydto[i].getTaxRate() + "\t" + salarydto[i].getTax() + " \t" + salarydto[i].getSalary());
	   } 
   }

}