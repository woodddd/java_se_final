package variable;

public class NumberTest {

	public static void main(String[] args) {

		System.out.print("�ȳ��ϼ���\n");
		System.out.println(25+36);
		System.out.println("25+36");
		System.out.println("25+36 = " + 25 + 36);
		// --- "���ڿ�" + 25 = "���ڿ�+25" ���ڿ��� + �� ������ �ǹ���
		System.out.println("25+36 = " + (25+36));
		// --- �켱������ ���� ����� ���� �ָ� ���� ��� �� ���ڿ� ����!
		System.out.println("25/36 = " + (25/36));
		// --- ����/���� = �Ҽ����� ������ �ʰ� ������ �κи��� ����.
		System.out.println("25.0/36.0 = " + (25.0/36));
		// --- �Ǽ� / ���� �� ������ �ڵ����� 36�� 36.0���� �ٲ� ���(ĳ���� �̶����) �׷��� �Ǽ��� ��� ���� ����
		
		//System.out.printf(format, args)
		//������ ���� ���� �� %d
		//�Ǽ��� ���� ���� �� %f
		//���� ���� ���� ��    %c
		//���ڿ� ���� ���� �� %s
		//%��ü�ڸ���, �Ҽ��ڸ����ϼ�f
		//��ü�ڸ��� ������ ��ü�ڸ����� �Ű澲�� ����� ��.
		System.out.printf("25/36 = %.2f\n", (25.0/36));
		//�Ǽ��� �Ҽ��� 2��° �ڸ����� ���մϴ�.
		System.out.printf("25/36 = %.1f\n", (25.0/36));
		//�Ǽ��� �Ҽ��� 1��° �ڸ����� ���մϴ�. 	
		System.out.printf("%d / %d = %.1f\n", 25, 36,(25.0/36) );
		
		System.out.println("25.0/36.0 = " + String.format("%.2f",(25.0/36)));
		System.out.println();
		
		//���ڿ��� �ƴ� '����' �������� �Է��ϸ� �������� �ƽ�Ű�ڵ� ���� ��ȯ��.
		System.out.println('A'+3);
		System.out.println('A'+32);
		System.out.println((char)('A'+32));//����ȭ(casting)�� �ϰڴ�.
		System.out.println(2+5);
		System.out.println('2'+5);
		System.out.println('2' + '5');//103 --- '����' + '����' --- �ƽ�Ű�ڵ� + �ƽ�Ű�ڵ�
		System.out.println('2'-48 + '5'-48);//���� '0' �� �ƽ�Ű�ڵ� 48 ���� 0 �� --- 0 ���ڸ� ���ڷ� ��ȯ
		System.out.println("2"+"5");//"���ڿ�" + "���ڿ�" --- "25"
		System.out.println(Integer.parseInt("2") + Integer.parseInt("5")); // ���ڿ��� ���ڷ� ��ȯ  --- 7
		System.out.println("25.3"+"45.6");
		System.out.println(Double.parseDouble("25.3")+Double.parseDouble("45.6"));//���ڿ��� �Ǽ��� ��ȯ(���� ������ ����Ѵٸ� �Ǽ��κ��� �� �߶����)		
		
	//* �߿䳻�� *//
	//���� �� �ƽ�Ű �ڵ��� ���� ��ȯ������ ���ڿ��� ���� ����!
	//Ŭ������ ù ���ڴ� �빮��!!
	}
	

}
