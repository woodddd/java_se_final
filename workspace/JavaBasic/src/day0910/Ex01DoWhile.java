package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//while�� Do While�� �������� �˾ƺ���

public class Ex01DoWhile {

	public static void main(String[] args)throws IOException {
		
		
		
		
		int number = 5;
		while( number > 5) {
			System.out.println("�ݺ��� �ɱ��?");
		}
		// ó������ while(false) �̹Ƿ� �ƹ��͵� ��µ��� �ʴ´�.
		
		//�׿� ���ؼ� do while�� ������ �ѹ��� ������ �ȴ�.
		//do ������ ����� �� while ���� ������ ���� ������ ��� do �ٽ� ������ �������� �ʰ� while ���� ����
		//���ΰ�� do ���� ������ �ٽ� �����ϰ� while ���� ������ Ȯ���Ѵ�
		do {
			System.out.println("�ݺ��� �ɱ��?");
		}while(number > 5);
		
		//����1. ����ڷκ��� ���ڸ� �Է� �޵�
		//10���� ū ���� �ԷµǸ� �ٽ� �Է��ϵ��� ������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//while�� ���
		System.out.print("���ڸ� �Է��ϼ��� : ");
		int num = Integer.parseInt(br.readLine());
		
		while(num > 10) {
			System.out.println("�ٽ� �Է����ּ���");
			num = Integer.parseInt(br.readLine());
			
		}
		System.out.println("����ڰ� �Է��� �� : " + num);
		
		//do while�� ���
		int num1 = 0;
		do {
			if(num1 > 10) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
			System.out.print("���ڸ� �Է����ּ���: ");
			num1 = Integer.parseInt(br.readLine());
		}while(num1 > 10);//�� ������ ���̸� ���� �ö󰡼� do ������ �ٽ� ������. ���� �� ������ false �� �ȴٸ�  do while ���� �����.
		
			System.out.println("����ڰ� �Է��� �� : " + num1);
	}

}
