package class_constructor;

public class ThisTest { // ���� Ŭ���������� �ʵ带 private�� ���������� private�� ���� Ŭ���� �������� ��� �����ϹǷ� ���� ���͸� ������ �ʿ䰡 ����
	private String name; // new ������ Ȱ�� �� �⺻�� null(String �� ������)
	private int age; // new ������ Ȱ�� �� �⺻�� 0(int �� �⺻��)
	
	public ThisTest() {
		System.out.println("defualt������");
		System.out.println("this = " + this);
	}
	
	public ThisTest(String name) {
		this();
		this.name = name;
		System.out.println("this = " + this);
	}
	
	public ThisTest(int age) {
		this("�ڳ�");//��! ������ �ȿ��� �����ڸ� ȣ���� �� ������ȣ���� ù��° �ٿ� �����ؾ���. �׷��� ������ ���� �߻�
		this.age = age;
		//�����ڴ� new ���� ���� ȣ���� �Ұ��� ������  ������ ������ ȣ���� ������.
		//this ��ɾ ����ϰ� �Ǹ� ThisTest�����ڰ� �ǰ� () �ȿ� ���� �Ķ���� ���� ���� � �����ڸ� ȣ���ϴ����� ������
		//���� This �� �̿��ؼ� �ٸ� �����ڸ� ȣ���ϰ� ���� ��� ������ ���� ����Ϸ��� ������ �ȿ��� ù���� �ٿ� �Է��ؾ���. �׷��� ������ ������ �߻���. 
	}
	
	public static void main(String[] args) {
		
		ThisTest aa = new ThisTest();
		System.out.println("��ü aa = " + aa);
		System.out.println("�̸�  = " + aa.name + " ���� = " + aa.age);
		System.out.println();
		
		ThisTest bb = new ThisTest("ȫ�浿");
		System.out.println("��ü bb = " + bb);
		System.out.println("�̸�  = " + bb.name + " ���� = " + bb.age);
		System.out.println();
		
		ThisTest cc = new ThisTest(25);
		System.out.println("��ü bb = " + cc);
		System.out.println("�̸�  = " + cc.name + " ���� = " + cc.age);
		System.out.println();
	}

}
