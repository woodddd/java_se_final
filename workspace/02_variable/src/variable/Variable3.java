package variable;

public class Variable3 {
	
	int a;//�ʵ�, �ν��Ͻ�����
	static int b;//�ʵ� , Ŭ��������
	

	public static void main(String[] args) {
		
		int a = 10;//��������(Local Variable)
		System.out.println("�������� a = " + a);
		
		Variable3 v; //��ü - Ŭ������ �ּҰ��� ������ ����
		v = new Variable3(); //Ŭ���� ���� + �������Լ� ("()")
		System.out.println("�ʵ� a = " + v.a);
		v.a= 20;
		System.out.println("�ʵ� a = " + v.a);

		Variable3 v2;//��ü
		v2 = new Variable3(); // v2 ��� ��ü�� Variable3 Ŭ������ ����.(�Ǵٸ� Variable3 Ŭ������ ������ ��. �׷��� a�� ���� ����)
		System.out.println("v2 Ŭ���� �ʵ� a = " + v2.a);
		
		int sum = v.a + v2.a;
		System.out.println("�� = " + sum);
		
		System.out.println("�ʵ� b = " + Variable3.b);//�̷��� �ۼ� �ص� ������ static ������ ���� �����Ƿ�
		System.out.println("�ʵ� b = " + b); //�̷��� �Է� �� �൵ �ȴ�.
		System.out.println("�ʵ� b = " + v.b);
		System.out.println("�ʵ� b = " + v2.b);
	}

}
