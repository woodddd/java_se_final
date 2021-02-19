package inheritance;

public class SubTest extends SuperTest{ //�ڽ�Ŭ������ �����ڸ� ���Ͽ� �ڱ� �ڽŰ� �θ� Ŭ������ �����ϰԵ�.
	protected String name;
	protected int age;
	
	public SubTest() {
		System.out.println("SubTest �⺻ ������");
	}
	
	public SubTest(double weight, double height, String name, int age) {// �θ�Ŭ�������� �ʵ� �� �����ڸ�protected �� ������ �־����Ƿ� �ڽ�Ŭ������ �θ��� �ʵ带 ����� �� ����.
		System.out.println("SubTest ������");
		//this.weight = weight;
		//this.height = height;
		super.weight = weight;
		super.height = height;
		this.name = name;
		this.age = age;
	}
	
	public void output() {
		System.out.println("SubTestŬ������ output()");
		System.out.println("������ = " + weight);
		System.out.println("Ű = " + height);
		System.out.println("�̸� = " + name);
		System.out.println("���� = " + age);
	}
	
	public static void main(String[] args) {
		//SuperTest aa = new SuperTest(); �θ�� �θ�͸� �⺻�����ڸ� ���� ������ ��
		//SubTest aa = new SubTest(); // �ڽ�Ŭ������ �ڽŰͰ� �θ��� �⺻�����ڸ� ���� ������ ��.
		// �θ�⺻������ + �ڱ�͵� �⺻ ������ ȣ��
		SubTest aa = new SubTest(75.3, 185.5, "ȫ�浿", 25);
		// �θ� �⺻������ + �ڱ���� �Ķ���Ͱ� �ִ� ������ ȣ��
		System.out.println();
		
		aa.output(); // output()�� SubTest���� ã�´�. ������ �θ�Ŭ������ ���� ã�´�.
		System.out.println();
		
		aa.disp(); // disp �� SubTest���� ã�´�. ������ �θ�Ŭ������ ���� ã�´�.
		System.out.println("-------------------------");
		
		SuperTest bb = new SubTest(35.8, 156.3, "�ڳ�", 13);
		bb.disp();
		//bb.output(); -The method output() is undefined for the type SuperTest ������ �߻��ϰ� �ȴ�. �ֳ��ϸ� output �޼ҵ�� SuperTestŬ������ ���ǵǾ� ���� �ʱ� ����.
		
		}
}
