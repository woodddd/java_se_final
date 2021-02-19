package class_constructor;


class PersonTest{
	private String name;
	private int age;
	// name,age �� ���� �ֱ� ���ؼ��� setter �Ǵ� �����ڸ� �̿�
	// name, age ���� ���� ������ ���ؼ��� getter �� �̿�

	// ������ ����� ����: ��ü �ʱ�ȭ
	// Ŭ���� new ���� �� ������ �ڵ� ȣ��
	
	// setter ����� ���� : ������ ���� �־��� ��.
	// set�� ���� ȣ���������.
	
	public PersonTest() {
	System.out.println("default ������"); //�Ķ���Ϳ� �ƹ� ���� ���� ���� ��
	}
	
	public PersonTest(String n) {
		name = n;
	}
	
	public PersonTest(String n, int m) {
		name = n;
		age = m;
	}
	//���� �����ڰ� �ϳ��� �����Ǿ� ���� �ʴٸ� �⺻������ default �����ڰ� �ڵ����� ȣ���
	//���� �����ڰ� �ϳ��� �����Ǿ� �ִٸ� �Ķ���Ͱ� ���� �⺻ �����ڴ� ����� �� ���Ե�.
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setAge(int n) {
		age = n;
	}
	
	public void setData(String n, int m) {
		name = n;
		age = m;
	} 
	
	public void setData(){}
}

public class PersonMain {

	public static void main(String[] args) {
		PersonTest aa;// ���� aa �� Ŭ����Ÿ���� ��ü�̴�
		aa = new PersonTest("ȫ�浿",25);
		System.out.println("��ü aa = " + aa); 
		// ��ü�� ����� ����� �ּҰ��� �����µ� �� ����� �����ּ� ����ϸ�
		// Ŭ������@16����	�� ����� ����.(���� �޸𸮰� ����Ǿ��ִ� �� �ּҰ��� �ƴ� �����ּҰ���)
		
//		aa.name = "ȫ�浿";
//		aa.age = 25;
		System.out.println("�̸� = " + aa.getName() + "\t ���� = " + aa.getAge());
//		System.out.println();
		
		PersonTest bb = new PersonTest();
		System.out.println("��ü bb = " + bb); 
		bb.setData("�ڳ�",13);
//		bb.name = "�ڳ�";
//		bb.age = 13;
		System.out.println("�̸� = " + bb.getName() + "\t ���� = " + bb.getAge());
	
		PersonTest cc = new PersonTest();// �ڹ��� �⺻ �����ڴ� ��ü�� �ʵ常 �ʱ�ȭ ���ش�.// ���� �ʵ尡 �������̶�� null �� , �⺻���̶�� 0���� �ʱ�ȭ���ش�.
		cc.setData();//�׷��� ����� name = String Ÿ������ null �� ������ �ǰ�, age = int Ÿ������ 0�� ������ �ȴ�.
		System.out.println("�̸� = " + cc.getName() + "\t ���� = " + cc.getAge());
	}

}
