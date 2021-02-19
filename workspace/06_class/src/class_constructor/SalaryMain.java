package class_constructor;

import java.text.DecimalFormat;

/*
�������� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�
��ü �迭�� �ۼ��Ͻÿ�

Ŭ������ : SalaryDTO
�ʵ�       : name, position, basePay, benefit, taxRate, tax, salary
������    : �����͸� �Է�(������ �Ķ���� �̿�)
calc() - ���

���� = (�⺻�� + ����) * ����;
���� = �⺻�� + ���� - ����;

������ 200���� ���� : 1%(0.01), 
     400���� ���� : 2%(0.02), 
     400���� �ʰ� : 3%(0.03)���� �����Ѵ�.

[������]
�̸�      ����      �⺻��		����		����      ����      ����
ȫ�浿   ����      5000000	200000
���缮   ����      3500000	150000
�ڸ��   ���      1800000	100000
 */

public class SalaryMain {
	
	final static int SIZE = 3;
	
   public static void main(String[] args) {
	   
	   SalaryDTO[] salarydto = new SalaryDTO[SIZE];
	   DecimalFormat df = new DecimalFormat("#,###");
	   
	   salarydto[0] = new SalaryDTO("ȫ�浿","����",5000000,200000);
	   salarydto[1] = new SalaryDTO("���缮","����",3500000,150000);
	   salarydto[2] = new SalaryDTO("�ڸ��","���",1800000,100000);
	   
	   
	   System.out.println(); // - main() �޼ҵ� ����Ͻÿ�.
	   
	   System.out.println("�̸�\t����\t�⺻��\t\t����\t\t����\t���� \t\t����");

	   for(int i = 0; i < salarydto.length ; i ++) {
		   salarydto[i].calc();
		   System.out.println(salarydto[i].getName() + "\t" + salarydto[i].getPosition() + "\t" +
				   salarydto[i].getBasePay() + "\t\t" + salarydto[i].getBenefit() + "\t\t" + 
				   				salarydto[i].getTaxRate() + "\t" + salarydto[i].getTax() + " \t" + salarydto[i].getSalary());
	   } 
   }

}