package exception;

import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		//run configuration - arguments - �� �Է�
		//arguments �� �Ű����� �Է� ���� �־��ָ� args �� String �迭�� ���� ũ�Ⱑ �����̵�
		// �Ű������� ���� �ΰ� �־��ָ� �迭�� ũ��� 2 �� ��,
		//arguments�� �Ű� ������ ������ ���ؼ� ��� �������� �ν���. �� �� - 2���� ���� ��������
		// "�� ��" ���� �ϸ� �ϳ��� �Ű������� ���� �� ����.
		
		
		if(args.length > 0) //�ϳ��̻��� �����Ͱ� ������ ������ ���� 
			System.out.println(args[0]);
		try {
			Scanner scan = new Scanner(System.in);
			System.out.println("���� �Է� : ");
			int num2 = scan.nextInt();
			
			int num1 = Integer.parseInt(args[0]);
			
				System.out.println(num1 + "/" + num2 + "=" + ((double)num1/num2));
				// ���� ���� ������ double �������� ������ ������ �Ҽ������� ������ �ϱ� ������ ������ �߻����� �ʰ� Infinity �� �����Ե�.
			
		}catch(NumberFormatException e){ // body�ȿ� �ƹ��͵� �Է����� ������ �ƹ��͵� ��������� ����(�����) �ʹ�������.
			System.out.println("���ڸ� �Է��ϼ���.");//num1,2 �� int Ÿ�������� �ٸ� Ÿ���� ���ڰ� ������ �������Ŀ��� ������ �߻���
		}catch(ArithmeticException e) {
			System.out.println("0���� ���� �� �����ϴ�.");//���� double������ �ƴ� int �������� ���� ��� 0���� ��� ���� ���� �� ���� ������ double�� ����� �˱� �� ���� ��� ����� �����ϱ� ������ ������ �߻����� ����
		}finally {
			System.out.println("error�� �ְ� ���� ������ ����!!");
		}
		
		
		
	}

}
