package method;

/*
 * 10 진수의 250을 2진수, 8진수 ,16진수로 변환하시오.
 * 단) Integer의 메소드를 이용하여 구하시오
 */

public class MethodTest {

	public static void main(String[] args) {
		int dec = 250;
		
		int bin = 0b1010;	// 2진수는 숫자 앞에 0b 를 붙임
		System.out.println("bin = " + bin);
		int oct = 012;		// 8 진수는 숫자 앞에 0 을 붙임
		System.out.println("oct = " + oct);
		int hex = 0xa;;	// 16진수는 숫자 앞에 0x를 붙임
		System.out.println("hex = " + hex);
		
		String binary = Integer.toBinaryString(dec);
		String octical = Integer.toOctalString(dec);
		String hexa = Integer.toHexString(dec);
		
				
		
		System.out.println("2진수 = " + binary);
		System.out.println("8진수 = " + octical);
		System.out.println("16진수 = " + hexa);
		

		
		
	}

}
