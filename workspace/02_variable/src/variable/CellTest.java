package variable;

/*
 * ������ �����Ͽ� 320, 258�� ���� ���Ͻÿ�
 * 
 * [������]
 * 320 + 258 = xxx (sum)
 * 320 - 258 = xxx (sub)
 * 320 * 258 = xxx (mul)
 * 320 / 258 = 1.24 (div) - �Ҽ� ���� �Ѥ��ڸ�����
 */

public class CellTest {

	public static void main(String[] args) {
		
		short a = 320;
		short b = 258;
		//short sum = a + b; // �� ����� ������ ���� ������
		// a + b �� ����� ����� �⺻������ int ���� ��ȯ��. �׷��Ƿ� short �� ��� �� ����.
		int sum = a + b;
		int sub = a - b;
		int mul = a * b;
		double div = (double) a / b; // a - ��������ȯ / b - �ڵ�����ȯ // �ΰ����� : ����/���� = ���������� �������� �Ҽ����� �Ѥ��ڸ����� ���϶�� �����Ƿ� ���� ����ȯ�� �Ͽ� double Ÿ������ �ٲ���
		System.out.println(a + " + " + b + " = " + sum);
		System.out.println(a + " - " + b + " = " + sub);
		System.out.println(a + " * " + b + " = " + mul);
		System.out.println(a + " / " + b + " = " + String.format("%.2f",div ));
		
	}

}
 