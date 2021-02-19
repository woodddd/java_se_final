package method;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


/* 
 ���� ��� ���α׷�
�̸�, ����, �⺻��, ������ �Է��Ͽ� ���ݰ� ������ ����Ͻÿ�
������ �޿��� 4,000,000 ���� �̻��̸� 3% �ƴϸ� 2%�� �Ѵ�

���� �� ������ �� Ǯ���ٸ�
������ calcTax()
������ calcSalary()�� �̿��ؼ� ����Ͻÿ�

�޿� = �⺻�� + ����
���� = �޿� * ����
���� = �޿� - ����

[������]
�̸� �Է� : ȫ�浿
���� �Է� : ����
�⺻�� �Է� : 4500000
���� �Է� : 200000

   *** ȫ�浿 ���� ���� ***
���� : ����
�⺻��  	    ���� 	     �޿�  	 ����  	 ����   	����
4500000	200000     4700000   3%   xxxxx   xxxxxxx
����, ������ ����������
*/

public class Salary {

	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("�̸��Է� : ");
		String name = br.readLine();
		
		System.out.print("���� �Է� : ");
		String position = br.readLine();
	
		System.out.print("�⺻�� �Է� : ");
		int b_salary = Integer.parseInt(br.readLine());
		
		System.out.print("���� �Է� : ");
		int allowance = Integer.parseInt(br.readLine());
		
		int salary = b_salary + allowance;
		double tax_rate = salary >= 4000000 ? 0.03 : 0.02;
		int tax = (int) (salary * tax_rate);
		int m_salary = salary - tax;
		
		
		System.out.println("\t*** " + name + "  ***");
		System.out.println("���� : " + position);
		System.out.println("�⺻��\t����\t�޿�\t����\t����\t����\t");
		System.out.println(b_salary + "\t" + allowance + "\t" + salary + "\t" + (int)(tax_rate*100) + "%\t" + tax + "\t" + m_salary);

	}


}
