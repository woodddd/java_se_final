package day0915;

import java.io.IOException;

public class StudentEx01 {
	
	public static void main(String[] args) throws IOException {
		//��ü�� ������
		//�Ķ���Ͱ� �ִ� ������
		Student s1 = new Student("���翵",1,100,90,91);
		//�Ķ���Ͱ� ���� ������
		s1 = new Student();
		//���Ͱ��� ���� �����ڸ� �ι� ��� �ϰ� �Ǹ� ������ ���� ������ ��.
		
		System.out.printf("�̸� : %s, ���� : %d�� ���� : %d�� ���� : %d�� ",s1.getName(),s1.getKorean(),s1.getEnglish(),s1.getMath());
		System.out.println();
		// ��ü�� �ʵ� Ȥ�� �޼ҵ带 ���� �� ������
		// ���ٿ����� . �� �̿��ϸ� �ȴ�.
		
		s1.setName("���翵");
		s1.setKorean(100);
		s1.setEnglish(90);
		s1.setMath(91);
		s1.setId(1);
		
		System.out.printf("�̸� : %s, ���� : %d�� ���� : %d�� ���� : %d�� ",s1.getName(),s1.getKorean(),s1.getEnglish(),s1.getMath());
		System.out.printf("%s �л��� ����: %d�� ���: %.2f��\n",s1.getName(),s1.calculateSum(),s1.calculateAverage());
		
		
		Student s2 = new Student("��ö��",2,90,90,90);
		
		s2.setName("��ö��");
		s2.setKorean(90);
		s2.setEnglish(90);
		s2.setMath(90);
		s2.setId(2);
		
		System.out.printf("�̸� : %s, ���� : %d�� ���� : %d�� ���� : %d�� ",s2.getName(),s2.getKorean(),s2.getEnglish(),s2.getMath());
		System.out.printf("%s �л��� ����: %d�� ���: %.2f��\n",s2.getName(),s2.calculateSum(),s2.calculateAverage());
		
		String str1 = new String(); // �� �ڵ�� String str1 = ""; �� ���������� �ƹ��� ���� ���� ��Ʈ�� ������ �ʱ�ȭ�� ���̴�.
		//������ String str1 = "" ���� �� �� �������� ǥ�� ����̴�.
		System.out.println("str1.length() : " + str1.length());
		
		s1.setName("���翵");
		s2.setName("��ö��");
		
		Student s3 = new Student("abc", 4, 5, 6, 7);
		Student s4 = new Student("abc", 4, 5, 6, 7);
		
		System.out.println("s3: " + s3);// println �� �����ϸ� toString() �޼ҵ带 ���������� �����Ͽ� ����� �����Ե�
		System.out.println("s4: " + s4);
		System.out.println("s3.equals(s4) : " + s3.equals(s4));
	}

}
