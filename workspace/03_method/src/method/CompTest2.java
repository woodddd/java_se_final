package method;

/*
 *
 * ch�� �ִ� �����Ͱ� �빮���̸� �ҹ��ڷ� ����ϰ� �ƴϸ�(�ҹ���) �빮�ڷ� ����Ͻÿ�

[������]
T �� t

�Ǵ�

e �� E
 */

public class CompTest2 {

	public static void main(String[] args) {
		
		char ch ='s';
		
		char result = ch >= 65 && ch <= 96 ? (char)(ch + 32) : (char)(ch - 32) ;
		
		System.out.println("��ȯ �� ������ : " + ch);
		System.out.println("��ȯ �� ������ : " + result);
		

	}

}
