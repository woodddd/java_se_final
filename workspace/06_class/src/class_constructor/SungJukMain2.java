package class_constructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
SungJuk Ŭ���� �̿��Ͻÿ�
��ü �迭

[������]
�ο��� �Է� : 2

�̸� �Է� : ȫ�浿
���� �Է� : 85
���� �Է� : 93
���� �Է� : 100

�̸� �Է� : �ڳ�
���� �Է� : 75
���� �Է� : 86
���� �Է� : 92

----------------------------------------------------
�̸�      ����      ����      ����      ����      ���      ����
----------------------------------------------------
ȫ�浿   85      93      100
�ڳ�      75      86      92
 */

public class SungJukMain2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String name;
		int kor;
		int eng;
		int math;
		
		System.out.print("�ο��� �Է�: ");
		int userCount = Integer.parseInt(br.readLine());
		
		SungJuk[] sj = new SungJuk[userCount];
		
		
		
		for(int i = 0; i < sj.length ; i ++) {
			
			System.out.print("�̸� �Է�: ");
			name = br.readLine();
			System.out.print("���� �Է�: ");
			kor = Integer.parseInt(br.readLine());
			System.out.print("���� �Է�: ");
			eng = Integer.parseInt(br.readLine());
			System.out.print("���� �Է�: ");
			math = Integer.parseInt(br.readLine());
			System.out.println();
			 
			sj[i] =  new SungJuk(name,kor,eng,math);
		}
		
		System.out.println("----------------------------------------------------");
		System.out.println("�̸�\t����\t����\t����\t����\t���\t����");
		System.out.println("----------------------------------------------------");
		System.out.println();
		for(int i = 0; i < sj.length ; i ++) {
			sj[i].calc();
			System.out.println(sj[i].getName() + "\t" + sj[i].getKor() + "\t" + sj[i].getEng() + "\t" + sj[i].getMath() + "\t" + sj[i].getTot() + "\t" + sj[i].getAvg() + "\t" + sj[i].getGrade());
		}
	}

}
