package class_constructor;

import java.util.Scanner;

/*
5������ ������ ä���ϴ� ���α׷�
1������ 5������ ��� ���� ���� 1���̴�.
1������ 20���� ����Ѵ�.

�̸� �Է� : ȫ�浿
�� �Է� : 12311

�̸�		1 2 3 4 5   ����
ȫ�浿         O X X O O  60       
----------------------
��ü �迭
�ο��� �Է�: 3

�̸� �Է� : ȫ�浿
�� �Է�    : 13211

�̸� �Է� : �ڳ�
�� �Է�    : 11111

�̸� �Է� : ��ġ
�� �Է�    : 13242

�̸�		1 2 3 4 5   ����
ȫ�浿         O X X O O  60  
�ڳ�            O O O O O  100
��ġ            O X X X X  20
 */

public class ExaminationMain {

	public static void main(String[] args) {
		String name;
		String dap;
		int person;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�ο��� �Է� : ");
		person = scan.nextInt();
		
		Examination[] ex = new Examination[person];
		
		for(int i = 0 ; i < person ; i++) {
		ex[i] = new Examination();
		ex[i].compare();
		}
		System.out.println();
		
		System.out.println("�̸�" + "\t" + "1 " + "2 " + "3 " + "4 " + "5 " + "����");
		for(int i = 0; i < person ; i++) {
			System.out.println(ex[i].getName() + "\t" + ex[i].getOx()[0] + " " + ex[i].getOx()[1] + " " + ex[i].getOx()[2] + " " + ex[i].getOx()[3] + " " + ex[i].getOx()[4] + " " + ex[i].getScore());
		}
		
	}

}
