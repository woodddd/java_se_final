package day0916;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0915.Student;//package day0915.Student Ŭ������ ����

public class Ex01Student02 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Student sd = new Student();
		
		while(true) {
			System.out.println("��Ʈ �л� ���� ���α׷�");
			System.out.println("1. �Է� 2. ��� 3. ����");
			int choice = Integer.parseInt(br.readLine());
			
			if(choice == 1) {
				System.out.print("�̸�: ");
				sd.setName(br.readLine());
				System.out.print("��������: ");
				sd.setKorean(Integer.parseInt(br.readLine()));
				System.out.print("��������: ");
				sd.setEnglish(Integer.parseInt(br.readLine()));
				System.out.print("��������: ");
				sd.setMath(Integer.parseInt(br.readLine()));
				System.out.print("id: ");
				sd.setId(Integer.parseInt(br.readLine()));
			}else if(choice == 2 ) {
				
				if(sd.getName().equals("")) { //sd.getName().isEmpty() �� ����� �൵ ��. ���� ������ true ���� ������ false
					System.out.println("���� �Էµ� ������ �����ϴ�.");
				}else {
					System.out.printf("�̸� : %s\t�������� : %d\t�������� : %d\t�������� : %d\tid : %d\n", sd.getName(),sd.getKorean(), sd.getEnglish(), sd.getMath(), sd.getId());
					System.out.printf("%s �л��� ���� : %d�� ��� : %.2f��\n",sd.getName(),sd.calculateSum(),sd.calculateAverage());
				}
			}else if (choice == 3){
				System.out.println("������ּż� �����մϴ�.");
				break;
			}else {
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
			}
		}
	}

}
