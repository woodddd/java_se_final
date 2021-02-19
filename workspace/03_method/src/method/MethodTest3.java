package method;

public class MethodTest3 {
	int a; //필드
	
	
	public int sum(int a, int b){//덧셈 메소드-구현, 메소드(parameter, argument)
		return a + b;
		
	}
	
	public int sub(int a, int b) {
		return a - b;
	}
	
	public int mul(int a, int b) {
		return a * b;
	}
	
	public double div(int a,int b) {
		return (double) a / b;
		
	}

	public static void main(String[] args) {
		int a; //지역변수
		
		//호출
		
		MethodTest3 mt = new MethodTest3();
		System.out.println("합 = " + mt.sum(25, 36));
		System.out.println("차 = " + mt.sub(57, 32));
		System.out.println("곱 = " + mt.mul(10, 15));
		System.out.println("몫 = " + String.format("%.2f",mt.div(25, 36)));
		//위와 같음//System.out.printf("몫 = %.2f",mt.div(25, 36));
		
	}

}
