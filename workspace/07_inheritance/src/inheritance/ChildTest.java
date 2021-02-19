package inheritance;

//				�ڽ�		����Ѵ�	   �θ�
public class ChildTest extends SuperTest{
	protected String name;
	protected int age;
	
	public ChildTest(){
		System.out.println("ChildTest �⺻ ������");
	}
	
	public ChildTest(double weight, double height, String name, int age) {// �θ�Ŭ�������� �ʵ� �� �����ڸ�protected �� ������ �־����Ƿ� �ڽ�Ŭ������ �θ��� �ʵ带 ����� �� ����.
		super(weight,height); // �θ������ ȣ��
		System.out.println("ChildTest ������"); 
		//this.weight = weight;
		//this.height = height;
		this.name = name;
		this.age = age;
	}
	
	public void disp() {
		System.out.println("ChildTestŬ������ disp()");
		System.out.println("������ = " + weight);
		System.out.println("Ű = " + height);
		System.out.println("�̸� = " + name);
		System.out.println("���� = " + age);
	}
	
	public static void main(String[] args) {
		ChildTest aa = new ChildTest(75.3, 185.5, "ȫ�浿", 25); // ChildTest �� ��ü ���� �� �����ڸ� ���Ͽ� ChildTest�� �⺻�����ڿ� �θ� Ŭ������ SuperTest �⺻�����ڸ� �����ϰԵ�.
		//�����ڸ� ���ؼ� �޸𸮸� ���� ��, �θ�Ŭ���� �޸𸮸� ���� �Ҵ��ϰ� �� �� �ڽ�Ŭ������ �޸𸮸� �Ҵ���.
		//�׷��� ����� �θ�Ŭ������ �����ڰ� ���� ȣ��ǰ�, �� �� �ڽ�Ŭ������ �����ڸ� ȣ���ϴ°���.
		System.out.println();
		aa.disp(); // disp()�� ChildTest���� ã�´�. ������ �θ� Ŭ������ ���� ã�´�.
		System.out.println();
		
		System.out.println("-------------------------");
		SuperTest bb = new ChildTest(35.8, 156.3, "�ڳ�", 13);
		bb.disp();// �������̵�(�θ�Ŭ������ �ִ� �޼ҵ带 ��������)�� �ڽ�Ŭ������ �޼ҵ尡 ���� �� ��� ������ �ڽ�Ŭ������ �޼ҵ常�� ȣ����.
		System.out.println();
	}
}
