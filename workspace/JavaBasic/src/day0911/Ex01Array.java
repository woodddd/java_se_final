package day0911;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//2���� �迭�� ���ÿ� ����ؼ�
//�̸��� ������ ���ÿ� �����غ���

public class Ex01Array {
	final static int SIZE = 5;

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//�̸��� ����� �迭�� �ϳ� ������
		String[] nameArray = new String[SIZE];
		//������ ����� �迭�� �ϳ� ������
		int[] sumArray = new int[SIZE];
		
		//���ʴ�� �Է��� �غ���
		for(int i = 0; i < SIZE ; i++) {
			System.out.print((i + 1) + "�� �л��� �̸�: ");
			nameArray[i] = br.readLine();
			System.out.print(nameArray[i] + " �л��� �������� : ");
			int korean = Integer.parseInt(br.readLine());
			while(korean < 0 || korean > 100) {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				System.out.print(nameArray[i] + " �л��� ��������: ");
				korean = Integer.parseInt(br.readLine());
			}
			System.out.print(nameArray[i] + " �л��� ��������: ");
			int english = Integer.parseInt(br.readLine());
			while(english < 0 || english > 100) {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				System.out.println(nameArray[i] + " �л��� �������� : ");
				english = Integer.parseInt(br.readLine());
			}
			
			System.out.print(nameArray[i] + " �л��� ��������: ");
			int math = Integer.parseInt(br.readLine());
			while(math < 0 || math > 100) {
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				System.out.print(nameArray[i] + " �л��� ��������: ");
				math = Integer.parseInt(br.readLine());
			}
			
			sumArray[i] = korean + english + math;
		}
		//������� �л��� ��ȣ�� �Է��ϸ� �� �л��� ������ ����ϰ� ������
		while(true) {
		System.out.print("������� �л��� ��ȣ�� �Է��ϼ���(1~5): ");
		int userChoice = Integer.parseInt(br.readLine()) - 1 ;// ����� 1�� ���� ���������� �迭�� 0������ ������. �׷��� - 1
			if(userChoice == -2) {
				System.out.println("������ּż� �����մϴ�.");
				break;
			}else if(userChoice < 0 || userChoice > SIZE - 1) {// SIZE �� -1 �� �ϴ� ����. SIZE �� 5������ userChoice�� ��� ������ index ���� �̹Ƿ� 0~ 4 ���� ���� ���� �Ǿ� ����. 
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}else{
				System.out.println(nameArray[userChoice] + " �л��� ����: " + sumArray[userChoice]);
			}
		
		}
	
		
		
		
	}

}
