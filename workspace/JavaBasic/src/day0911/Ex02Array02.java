package day0911;
//Ex01 ���׷��̵����
//������ �ƴ϶� 
//������ ������ �����ϴ�
//���ѷ��� ���α׷��� �ۼ��Ͻÿ�(20�б���)

//���� 1. ó�� �Է½ÿ��� for �ݺ����� ����ؼ� 5���� �̸��� ������ ������ �� �Է��Ѵ�.
//���� 2. �Է��Ŀ��� ���ѷ����� ���ؼ�
//    ���� ���� ���� �л��� �̸��� ����, ����, ��ո� ���� �ְ� �Ѵ�.
//����:
//���� ���� �л��� ��ȣ�� �Է��ϼ���: (1�Է�)
//1�� �趯�� �л�
//����: 80�� ����: 80�� ����: 81��
//����: 241�� ���: 80.33��
//���� ���� �л��� ��ȣ�� �Է��ϼ���: (20000 �Է�)
//�߸��Է��ϼ̽��ϴ�.
//���� ���� �л��� ��ȣ�� �Է��ϼ���: (2�Է�)
//2�� �ֵ��� �л�
//����: 70�� ����: 69�� ����: 68��
//����: 207�� ���: 69��
//���� ���� �л��� ������ �Է��ϼ���: (-1�Է�)
//������ּż� �����մϴ�.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02Array02 {
	
	final static int SIZE = 5 ;
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//�̸��� ����� �迭�� �ϳ� ������
		String[] nameArray = new String[SIZE];
		//������ ����� �迭�� �ϳ� ������
		int[] sumArray = new int[SIZE];
		double[] avgArray = new double[SIZE];
		int[] korean = new int[SIZE];
		int[] english = new int[SIZE];
		int[] math = new int[SIZE];
		
		for(int i = 0; i < SIZE ; i++) {
			System.out.print((i + 1) + "�� �л��� �̸�: ");
			nameArray[i] = br.readLine();
			
			System.out.print(nameArray[i] + " �л��� �������� : ");
			korean[i] = Integer.parseInt(br.readLine());
			
			while(korean[i] < 0 || korean[i] > 100) {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				System.out.print(nameArray[i] + " �л��� ��������: ");
				korean[i] = Integer.parseInt(br.readLine());
			}
			System.out.print(nameArray[i] + " �л��� ��������: ");
			english[i] = Integer.parseInt(br.readLine());
			
			while(english[i] < 0 || english[i] > 100) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				System.out.println(nameArray[i] + " �л��� �������� : ");
				english[i] = Integer.parseInt(br.readLine());
			}
			
			System.out.print(nameArray[i] + " �л��� ��������: ");
			math[i] = Integer.parseInt(br.readLine());
			
			while(math[i] < 0 || math[i] > 100) {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				System.out.print(nameArray[i] + " �л��� ��������: ");
				math[i] = Integer.parseInt(br.readLine());
			}
			
			sumArray[i] = korean[i] + english[i] + math[i];
			avgArray[i] = (double)(korean[i] + english[i] + math[i]) / 3;
		}
		
		while(true) {
			System.out.println("������� �л��� ��ȣ�� �Է��ϼ��� : ");
			int userChoice = Integer.parseInt(br.readLine());
			if(userChoice == -1) {
				System.out.println("������ּż� �����մϴ�.");
				break; 
			}else if(userChoice >= 1 && userChoice <= 5){
				int index = userChoice -1;
				System.out.println(userChoice + "�� " + nameArray[index] + " �л�");
				System.out.println("���� : " + korean[index] + "\t" + "���� : " + english[index] + "\t" + "���� : " + math[index]);
				System.out.println("���� : " + sumArray[index] + "\t" + "��� : " + String.format("%.2f", avgArray[index]));
			}else {
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
			}
			
		}
		
		

	}

}
