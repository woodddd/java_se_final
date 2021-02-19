 package method;

public class CompTest {
	
	public static void main(String[] args) {

		int score = 60;
		
		String result = score >= 80 && score <=100 ? "합격" : "불합격";
	
		System.out.println("결과는 = " + result);	
		System.out.println();
		
		//score의 값이 짝수이면 "짝수" 아니면 "홀수"
		
		String result1 = score % 2 == 0 ? "짝수" : "홀수";
		System.out.println(result1);
		System.out.println();
		
		// a, b 중에서 큰 값을 출력하시오
		int a = 26 , b = 125;
		
		int result2 = a > b ? a : b;
		
		System.out.println(result2);
		System.out.println();
		
		// a,b 중에서 큰 값을 출력하시오. ( 메소드를 사용 )
		
		
		System.out.println("(메소드로구한)큰 값 = " + Math.max(a, b));
		System.out.println("(메소드로구한)작은 값 = " + Math.min(a, b));
		System.out.println("제곱 값 = " + Math.pow(2.0 , 5.0));
		
		double p = Math.pow(2.0, 5.0); // Math.pow 는 인자를 double 형으로 받고 결과 또한 double 형을 반환함
		System.out.println("제곱 값 = " + p);
		System.out.println();
		
		//
		int c = 12;
		result = c % 2 == 0 && c % 3 == 0 ? "2와 3의 공배수" : "2와 3의 공배수가 아니다";
		System.out.println("결과 = " + result);
		
		
		
	}

}
