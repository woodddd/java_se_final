package variable;

public class Variable2 {
	
	int a;//�ʵ�, �ν��Ͻ� ����, 0���� �ʱ�ȭ �Ǿ� ���� // main �޼ҵ忡�� new�� ������� ������ ����� �� ����
	static int b; //�ʵ�(Ŭ���� �ؿ� ���� �͵�), (static)Ŭ���� ���� , 0���� �ʱ�ȭ �Ǿ� ����	
	// static - ����� �޸𸮿� �ڵ����� ����
	int c;
	String d;// String �ʵ� �⺻�� = null
	
	int e = 5;
	int f;
	//f = 7; // �̹� ������� f �ȿ� ���� �����ϴ� ��ɹ��� class �Ʒ� �� �� ����
	
	public static void main(String[] args) {
		int a = 10; //��������(local variable) ��� ���������� ������ ���� ������ ����. �׷��� �ʱ�ȭ�� ���������.
		System.out.println("�������� a = " + a);
		System.out.println("�ʵ� = " + b);// b �տ� Ŭ�������� �����Ǿ� ����.(static ������ �����߱� ����)
		System.out.println("�ʵ� = " + Variable2.b);//Variable Ŭ���� �ȿ� �ִ� b�̴�.
		System.out.println("�ʵ� a = " + new Variable2().a); // static �� ���� ���� ������ Variable2 �� �����Ͽ� �� �ȿ� a �� �ҷ��;���.
		// new �� ����ϸ� �ѹ��� ���� ������ ���� ��.(��ȸ��)
		

	}

}
