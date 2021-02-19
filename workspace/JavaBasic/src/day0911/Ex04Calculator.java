package day0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//���� ���α׷�
//����ڰ� ù���� ������ �Է��ϰ�
//+ - * / % �� �����ϰ�
//�ι�° ������ �Է��ϸ�
//�ش� ��ɿ� ���� �޼ҵ尡 ����Ǽ� 
//������� ȭ�鿡
//����ϰ� ��������

//����
//ù��° ���� �Է����ּ���: (1�Է�)
//�����ڸ� �������ּ���: +
//�ι�° ���� �Է����ּ���: (100�Է�)
//�����: 101

public class Ex04Calculator {
	
	public int add(int a, int b) {
		return a + b;
	}
	public int sub(int a , int b) {
		return a - b;
	}
	public int mul(int a, int b) {
		return a * b;
	}
	public double avg(int a, int b) {
		return (double)a / b;
	}
	public int remainder(int a, int b) {
		return a % b;
	}
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Ex04Calculator mt = new Ex04Calculator();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("ù ���� ���� �Է����ּ��� : ");
		int first = Integer.parseInt(br.readLine());
		
		System.out.println("�����ڸ� �������ּ��� : ");
		String op = br.readLine();
		
		System.out.println("�� ���� ���� �Է����ּ��� : ");
		int second = Integer.parseInt(br.readLine());
		
		while(true) {
			if(op.equals("+")) {
				System.out.print("��� �� :");
				System.out.println(mt.add(first,second));
				break;
			}else if(op.equals("-")) {
				System.out.print("��� �� :");
				System.out.println(mt.sub(first, second));
				break;
			}else if(op.equals("*")) {
				System.out.print("��� �� :");
				System.out.println(mt.mul(first, second));
				break;
			}else if(op.equals("/")) {
				System.out.print("��� �� :");
				System.out.println(String.format("%.2f", mt.avg(first, second)));
				break;
			}else if(op.equals("%")) {
				System.out.print("��� �� :");
				System.out.println(mt.remainder(first, second));
				break;
			}else {
				System.out.println("�߸��� ������ �Դϴ�. �ٽ� �Է����ּ���.");
				op = br.readLine();
				
			}
		
		}

		
		
	}

}
