package method;

public class Operator2 {

	public static void main(String[] args) {

		boolean a = 25 > 36;
		System.out.println("a = " + a); // a = false
		System.out.println("!a = " + !a); // a = true
		System.out.println();
		
		String b = "apple"; // String b �� apple �� ���� �϶�� ���� �ƴ϶� String Ŭ������ ����Ǿ� �ִ� apple �� �ּҸ� ���� �ϴ� ��.
		String c = new String("apple");// String c �� apple �� ���� �ϴ� ���� �ƴ϶� String Ŭ������ ����Ǿ� �ִ� apple �� �ּҸ� ����
		
		String result = b == c ? "��" : "����";
		System.out.println("b == c ����� " + result);
		
		result = b != c ? "��" : "����";// �����񱳹�
		System.out.println("b != c ����� " + result);
		
		result = b.equals(c) ? "��" : "����"; // �ּҰ��� �ƴ� String Ŭ��������  ���� ���������� b. ���� �Ͽ� ���� ���� ������ �� ����.
		System.out.println("b.equals(c) ����� " + result);
		
		result = !b.equals(c) ? "��" : "����";// ������
		System.out.println("b.equals(c) ����� " + result);
	}

}
