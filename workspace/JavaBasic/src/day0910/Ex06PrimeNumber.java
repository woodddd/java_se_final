package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//1���� ����ڰ� �Է��ϴ� ���ڱ����� �Ҽ��� ���ϴ� ���α׷�
//�Ҽ���?
//����� 1�� �ڱ��ڽŸ� �ִ� ����
// = �� ����� ������ 2���� ����

//�����?
//a�� b�� ����� ���� ��������
//b �� a�� ��� ��� �Ѵ�.
//���� : 6 / 3 �� ���� �������� ������
//3�� 6�� ����� �ȴ�.
//�� ����� �������� 0�� ���ڸ� ������ �Ѵ�.
// �׷��ٸ� 2�� 5�� ����ΰ�?

//� ������ ���� ū ����� ���ϱ�?
//�ڱ��ڽ�.
//5�� ���� ū ����� 5��.
//1872�� ���� ū ����� 1872 �̴�.

//����
//���ڸ� �Է��ϼ��� : 10
//1���� 10������ �����
//2
//3
//5
//7
//�Դϴ�.
public class Ex06PrimeNumber  {

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���ڸ� �Է��ϼ���: ");
		int number = Integer.parseInt(br.readLine());
		//�츮�� ���⼭ ���� for���� ����� ���ǵ�
		//i�� �� ���ڰ� �Ҽ����� �ƴ��� �˻��� ���ڰ� �ȴ�.
		//j�� �� ���ڰ� i�� ������� �ƴ��� üũ�� ���ڰ� �ȴ�.
		System.out.println("1����" + number + "������ �Ҽ���");
		for(int i = 1; i <= number ; i ++) {
			//�� ���� ����� ������ ������ ������ �ϳ� �����.
			int count = 0;
			
			//j for ���� ���ؼ� j�� i�� �ེ���̸�(�� �������� 0�̸�)
			//count�� 1 ���� ��Ų��.
			for(int j = 1; j <= i; j++) {
				if(i % j == 0 ) {
					count ++;
				}
			}
		if(count == 2) {
			//����� ������ 2��
			System.out.println(i);
		}
		//number�� ���簪: 10
		
		}
		System.out.println("�Դϴ�.");

	}

}
