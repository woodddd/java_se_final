package class_constructor;

public class StringTest {

	public static void main(String[] args) {
		//literal �̶� �ڷ���������(�������� ����)�� ����.
		//������ literal
		//�Ǽ��� literal
		//������ literal
		//literal�� heap ������ ���� ���ڸ� ������ ���� ����. �Ʒ��� ���� ���� �Ǿ� ������
		// "apple" �� ������ �Ǹ�, �� ���� ����� �ּҰ��� a���� �ְ�
		// String ��ü b �� "apple" �� �����ϰ� �Ǹ� ���ο� "apple"�� �����ϴ� ���� �ƴ϶�
		// heap ������ ����Ǿ� �ִ� "apple" �� �ּҰ��� ������ �ְ� ��.
		// �׷��� ���� �ּҰ�(������)�� ���ٰ� ����.
		String a = "apple";//"" �� �������� �� �ִ� ���� ���ڿ� literal ���� �̶� �Ѵ�.
		String b = "apple";
		if(a==b) {
			System.out.println("a�� b�� �������� ����");
		}else {
			System.out.println("a�� b�� �������� �ٸ���");
		}
		if(a.equals(b)) {
			System.out.println("a�� b�� ���ڿ��� ����");
		}else {
			System.out.println("a�� b�� ���ڿ��� �ٸ���");
		}
		System.out.println();
		//�������� ���� ���ڿ� ���� ������ ���念���� 1���� ����Ǿ��ٶ�� ���Ҽ��ִ�.
		
		
		// new �� ����ϰ� �Ǹ� heap ������ ��� ���ο� ������ �����ϰԵ�
		// �׷��� ���ڿ� "apple" �� ����� �����Ͽ� c���� �ּҰ��� �ְ�
		// �� new �� �߻��Ǹ� ���� ���ڶ� �ϴ��� ���� "apple"�� �����Ͽ�
		// ���ο� �ּҰ��� d ���� �ְԵ�
		// ��������� �޸��� ���� �߻��ǰ� �ȴ�.
		
		// �� ���� ���̸� Ȯ���� �˾ƾ���.
		String c = new String("apple");
		String d = new String("apple");
		if(c==d) {
			System.out.println("a�� b�� �������� ����"); 
		}else {
			System.out.println("a�� b�� �������� �ٸ���");
		}
		if(c.equals(d)) {
			System.out.println("c�� d�� ���ڿ��� ����");
		}else {
			System.out.println("c�� d�� ���ڿ��� �ٸ���");
		}
		//�������̴ٸ��� ���ڿ��� ���ٸ� ���� �ٸ� ������ ����Ǿ��ٰ� ���� �� �ִ�.

		
		String e = "���� ��¥��" + 2020 + 9 + 25;
		System.out.println("e = " + e);
		//���ڿ��� ������ �ȵǹǷ� �޸𸮿� 4�� �����ȴ�.
		// "���� ��¥��"
		// "���� ��¥�� 2020"
		// "���� ��¥�� 20209"
		// e ---> "���� ��¥�� 2020925"
		// �̷��� �Ǹ� ���忪���� ���� �߻���
		// �׷��� JVM �� ������ġ�� ���� �Ͻ��� ���ڿ����� ������ �÷���(�������̶�� ����)�� �����س��ٰ�
		// �������÷����� �뷮�� �� ���� �Ǹ� ������ �ͺ��� �ϳ��� ��������
		// Garbage Collector �� ����Ǹ� ��ǻ�Ͱ� �����.
		// ��, �� �ð��� �ſ�ſ� ª�� ������ ���� �������� ����.
		System.out.println("���ڿ��� ũ�� = " + e.length());
		
		for(int i = 0 ; i < e.length() ; i++) {
			System.out.println(i + " : " + e.charAt(i));//charAt �� �ش� ���ڿ��� ���° ���� �˰���� �� ���.�ε����ѹ��� ���� 0������ ������.
		}
		System.out.println();
		
		System.out.println("�κ� ���ڿ� ���� = " + e.substring(7));// 7������~ ������
		System.out.println("�κ� ���ڿ� ���� = " + e.substring(7,11));// 7������ 11�������� 
		
		System.out.println("�빮�� ���� = " + "Hello".toUpperCase());
		System.out.println("�ҹ��� ���� = " + "Hello".toLowerCase());
		
		System.out.println("���ڿ� �˻� = " + e.indexOf("¥"));//�ش� ���� ���° �ε����� �ִ��� ��ȯ
		System.out.println("���ڿ� �˻� = " + e.indexOf("��¥"));
		System.out.println("���ڿ� �˻� = " + e.indexOf("���ٺ�"));// �شٰ���� ���ٸ� -1 ��ȯ
	}

}
