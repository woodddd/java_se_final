package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//do while ����
public class Ex04Dowhile03 {
	//�������߱� ����
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		
		while(number < 0) {
			System.out.println("�ڿ����� �Է����ּ���");
			System.out.println("���ڸ� �ϳ� �Է����ּ���.");
			number = Integer.parseInt(br.readLine());
		}
		//�� while���� ���
		//����ڰ� �� ó���� 0���� ũ�ų� ���� ���� �Է��ϸ�
		//number < 0 �̶�� ���ǽ��� false�� �ǹǷ�
		//while ���� �ݺ����� �ʰ� �ȴ�.
		
		System.out.println("����ڰ� �Է��� ���� : " + number);
				
		
		//�׿� ���ؼ� do while ����������
		//������ �ѹ��� ������ �ȴ�.
		do {
			System.out.println("do while ù��° ��");
		}while(number < 0);
	}

}
