package day0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// String Ŭ������ ���� �˾ƺ���
// String �̶�?
// �������� ���ڰ� ���ִ� char[]��
// �츮�� �ٷ�� ���� Ŭ������ ���·� �ٲ���� ��.

// String Ŭ���� �ȿ��� ��Ʈ���� �ٷ�µ� ������ �Ǵ� �پ��� �޼ҵ尡 �غ�Ǿ� �ִ�.


public class Ex01String {
	public static void main(String[] args) throws IOException {
		String string1 = new String("abc");
		String string2 = "abc";
		
		//1��: �ش� ��Ʈ���� ���° ĭ�� ���� ���ڰ� �ִ��� Ȯ���� ������
		//charAt(index)�� �����ϸ� �ȴ�.
		System.out.println("string.charAt(0): " + string1.charAt(0));
		//2�� : 2���� ���ڿ��� �����ų������ concat�� ����Ѵ�.
		System.out.println("string1.concat(string2): " + string1.concat(string2));
		//3��: �ش� ���ڿ��� �̷��� ���� ���ڿ��� �ִ����� üũ�� ������ contains()�� ����Ѵ�.
		System.out.println("string1.contains(\"ab\"): " + string1.contains("ab"));
		//4��: �ش� ���ڿ��� �ʱ�ȭ�� �Ǿ������� ����ִ� ���ڿ����� üũ�� ������ isEmpty()�� ����Ѵ�.
		
		// null != "";
		// null �� ���¿��� �ƹ��͵� �� �� ����. ���ο� �ʱ�ȭ�� �� ������
		// ""Ȥ�� new String() ���� �ʱ�ȭ�ϸ� ��� �޼ҵ���� ȣ�� �� �� ������
		// �ٸ� �ƹ��� ���ڵ� ���ڿ����� ���� ������ ���̴�.
		
		// ���̶� ���� ������ �ּҰ��� �ο��� �Ǿ�������,
		// �� ������ �ش� �ּҰ� �ƹ��� �ʱ�ȭ�� �ȵǾ��ִ� ���¸� ���̶�� �Ѵ�.
		
		// �츮�� �� Ŭ������ �ʵ� Ȥ�� �޼ҵ带 ���� �ҷ���
		// �� �������� �� ������ ã�ƾ� �ϴµ�
		// ���� ���¿����� �� ������� �����Ƿ�
		// ������ �� ���� �Ǵ� ���̴�.
		
		// �� isEmpty() �޼ҵ��
		// �ش� ��Ʈ���� ���� �ƴ� ���� ���డ���ϴ�.
		
		System.out.println("string1.isEmpty(): " + string1.isEmpty());
		System.out.println("\"\".isEmpty(): " + "".isEmpty());
		
		//5��: �ش� ��Ʈ���� ���̸� �˰� ���� ���� length()
		System.out.println("string1.length(): " + string1.length());
		
		//6��: �ش� ���ڿ��� �������ϰ� ��ġ�ϴ��� Ȯ���� ������ matches()�� ����Ѵ�.
		//	���� ������ ���������� ����ؾ��Ѵ�.
		//	�پ��� ����ǥ������ ����ؼ� �츮�� ���ڿ��� �������� ���¸� �����ϴ���
		//	�׽�Ʈ �����ϴ�.
		//	ex)�ڵ�����ȣ
		//	������ ����� �����̹Ƿ� �츮�� �ش� ���ڿ��� ���ڷθ� �̷�����°� �ƴѰ��� ��������� ����
		//	�ش� ��Ʈ���� ��� �� ��Ʈ������ �̷�������� üũ�� ������ \d* ���� �׽�Ʈ �Ѵ�.
		// 	*�� ���ڰ� �߷����� �̷�������� Ȯ���ϴ°�
		// \�� * �� \ �Ͱ��� ��ȣ�� �ν�(���)�� �� �ֵ��� �ش� ���� �տ� �ٿ��ش�.
		System.out.println("string1.matches(\\d*): " + string1.matches("\\d*"));
		System.out.println("\"12345\".matches(\\d*): " + "12345".matches("\\d*"));
	
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���ڸ� �Է����ּ���: ");
		String userInput = bufferedReader.readLine();
		while(!userInput.matches("\\d*")) {
			System.out.println("���ڸ� �Է����ּ���");
			System.out.print("> ");
			userInput = bufferedReader.readLine();
		}
		int userNumber = Integer.parseInt(userInput);
		System.out.println("����ڰ� �Է��� ����: " + userNumber);
	}
	
}
