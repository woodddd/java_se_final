package day0916;

import java.text.DecimalFormat;

public class CarEx01 {

	public static void main(String[] args) {

		//Car ��ü�� ������ ������
		Car c1 = new Car();
		Car c2 = new Car();
		Car c3 = new Car();
		
		//c1, c2, c3�� ���͸� �̿��ؼ� ������ �Է��غ���
		
		c1.setNumber("00�� 0000");
		c1.setType("���");
		c1.setYear(2019);
		c1.setPrice(5000000);
		c1.setColor("������");
		
		c2.setNumber("11�� 1111");
		c2.setType("����");
		c2.setYear(2020);
		c2.setPrice(10000000);
		c2.setColor("����");
		
		c3.setNumber("22�� 2222");
		c3.setType("BMW");
		c3.setYear(2020);
		c3.setPrice(10000000);
		c3.setColor("������");
		
		c1.printInfo();
		c2.printInfo();
		c3.printInfo();
		
		
		// �����ֱ�..����
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println(df.format((long)c1.getPrice()));
		
		c3.setNumber("11�� 1111");
		c3.setType("����");
		c3.setYear(2020);
		c3.setPrice(10000000);
		c3.setColor("����");
		
		c2.printInfo();
		c3.printInfo();
		
		//c2�� c3���� �Ȱ��� ������ ���ִ�.
		//�׷��ٸ� c2.equals(c3)�� ��� �ɱ�?
		System.out.println("c2.equals(c3) : " + c2.equals(c3));
		System.out.println("c2.equals(abc) : " + c2.equals("abc"));
		System.out.println(c1);
	}

}
