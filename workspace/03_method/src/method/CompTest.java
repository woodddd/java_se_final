 package method;

public class CompTest {
	
	public static void main(String[] args) {

		int score = 60;
		
		String result = score >= 80 && score <=100 ? "�հ�" : "���հ�";
	
		System.out.println("����� = " + result);	
		System.out.println();
		
		//score�� ���� ¦���̸� "¦��" �ƴϸ� "Ȧ��"
		
		String result1 = score % 2 == 0 ? "¦��" : "Ȧ��";
		System.out.println(result1);
		System.out.println();
		
		// a, b �߿��� ū ���� ����Ͻÿ�
		int a = 26 , b = 125;
		
		int result2 = a > b ? a : b;
		
		System.out.println(result2);
		System.out.println();
		
		// a,b �߿��� ū ���� ����Ͻÿ�. ( �޼ҵ带 ��� )
		
		
		System.out.println("(�޼ҵ�α���)ū �� = " + Math.max(a, b));
		System.out.println("(�޼ҵ�α���)���� �� = " + Math.min(a, b));
		System.out.println("���� �� = " + Math.pow(2.0 , 5.0));
		
		double p = Math.pow(2.0, 5.0); // Math.pow �� ���ڸ� double ������ �ް� ��� ���� double ���� ��ȯ��
		System.out.println("���� �� = " + p);
		System.out.println();
		
		//
		int c = 12;
		result = c % 2 == 0 && c % 3 == 0 ? "2�� 3�� �����" : "2�� 3�� ������� �ƴϴ�";
		System.out.println("��� = " + result);
		
		
		
	}

}
