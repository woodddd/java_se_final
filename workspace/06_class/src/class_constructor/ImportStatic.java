package class_constructor;

//import static java.lang.Math.random; //����ƽ ���� �Ǵ� �޼ҵ带 ȣ���� �� ���
//import static java.lang.Math.pow;

import static java.lang.Math.*; //���ϵ� ī��(*) Math Ŭ���� ���� ��� �޼ҵ�.
import static java.lang.String.format;
import static java.lang.System.out;

public class ImportStatic {

	public static void main(String[] args) {//import�� �ϰ� �Ǹ� Ŭ������.�޼ҵ� �� �Է����� �ʰ� �޼ҵ� �� �Է��ص���.
		out.println("���� = " + random());// import���� �ʾƵ� Math.random ���� ���  �� �� �����Ƿ� random �� ����ƽ �޼ҵ� ��� �� �� �� �ִ�.
		out.println("������ = " + pow(2, 10));
		out.println("�Ҽ� ���� 2°�ڸ� = " + format("%.2f", 123.456));
	}

} 
