package method;

public class CompTest3 {

	public static void main(String[] args) {
		int num1 = 0, num2 = 0;
		boolean result;
		
		result = ( (num1+=10) < 0 && (num2+=10) > 0); // && 는 앞에 연산이 참일 경우 뒤에 연산을 하지만 앞에 연산이 거짓이면 뒤에 연산을 하지 않음
		System.out.println("result = " + result);
		System.out.println("num1 = " + num1 + " num2 = " + num2);
		System.out.println();

		result = ( (num1+=10) > 0 || (num2+=10) > 0); // || 연산은 앞에 연산이 참이면 어차피 참이므로 뒤에 연산을 하지 않음
		System.out.println("result = " + result);
		System.out.println("num1 = " + num1 + " num2 = " + num2);
		System.out.println();
		
	}

}
