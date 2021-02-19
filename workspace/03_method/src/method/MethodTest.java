package method;

/*
 * 10 ������ 250�� 2����, 8���� ,16������ ��ȯ�Ͻÿ�.
 * ��) Integer�� �޼ҵ带 �̿��Ͽ� ���Ͻÿ�
 */

public class MethodTest {

	public static void main(String[] args) {
		int dec = 250;
		
		int bin = 0b1010;	// 2������ ���� �տ� 0b �� ����
		System.out.println("bin = " + bin);
		int oct = 012;		// 8 ������ ���� �տ� 0 �� ����
		System.out.println("oct = " + oct);
		int hex = 0xa;;	// 16������ ���� �տ� 0x�� ����
		System.out.println("hex = " + hex);
		
		String binary = Integer.toBinaryString(dec);
		String octical = Integer.toOctalString(dec);
		String hexa = Integer.toHexString(dec);
		
				
		
		System.out.println("2���� = " + binary);
		System.out.println("8���� = " + octical);
		System.out.println("16���� = " + hexa);
		

		
		
	}

}
