package method;

public class Operator2 {

	public static void main(String[] args) {

		boolean a = 25 > 36;
		System.out.println("a = " + a); // a = false
		System.out.println("!a = " + !a); // a = true
		System.out.println();
		
		String b = "apple"; // String b 에 apple 을 저장 하라는 것이 아니라 String 클래스에 저장되어 있는 apple 의 주소를 저장 하는 것.
		String c = new String("apple");// String c 에 apple 을 저장 하는 것이 아니라 String 클래스에 저장되어 있는 apple 의 주소를 저장
		
		String result = b == c ? "참" : "거짓";
		System.out.println("b == c 결과는 " + result);
		
		result = b != c ? "참" : "거짓";// 부정비교문
		System.out.println("b != c 결과는 " + result);
		
		result = b.equals(c) ? "참" : "거짓"; // 주소값이 아닌 String 클래스에서  값을 가져오려면 b. 으로 하여 값을 직접 가져올 수 있음.
		System.out.println("b.equals(c) 결과는 " + result);
		
		result = !b.equals(c) ? "참" : "거짓";// 부정문
		System.out.println("b.equals(c) 결과는 " + result);
	}

}
