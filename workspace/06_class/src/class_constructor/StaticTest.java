package class_constructor;

public class StaticTest {
	
	private int a;//�ʵ�, �ν��Ͻ� ����
	private static int b;//�ʵ�, Ŭ���� ����  //����ƽ ������ ���� ��� ��ü�� �����Ѵ�.
	//static������ static �޸� ���念���� 1���� ������ ������ ���� ���� �����ϰ� ��.
	//static �� �޸� ���念���� �ѹ��� ������ ������ �ʱ�ȭ�� �ѹ��� �Ǵ� �� ��.
	
	static { // static�� �ʱ�ȭ �ϴ� ����.
		//main �޼ҵ� ���� �� �ٷ� ������ ��.
		System.out.println("�ʱ�ȭ ����");
		b = 3;
	}
	
	public StaticTest() { //�����ڴ� �ʱ�ȭ�� �������� ����
		System.out.println("�⺻ ������");
		this.a = 3;
		//b = 3; static�� �����ڸ� ���� �ʱ�ȭ�� �� �� ����
	}
	
	public void calc() {
		a++;
		b++;
	}
	
	public void disp() {
		System.out.println("a = " + this.a + "\t b=" + StaticTest.b);
	}//this �� ���� ��ü�� �ּҸ� ����Ŵ
	//b �� static ������ �����̹Ƿ� this �� �������� ����.
	//this �� ��ü ������ Ŭ���� ���� ����Ǿ��ֱ� ����.
	//super���� ������� ����.
	
	public static void output() {
		//System.out.println("a = " + this.a + "\t b=" + StaticTest.b);//����ƽ �޼ҵ�� ����ƽ ������ ��� ����. ����ƽ �޼ҵ� �ȿ��� This �� super�� �������� ����.
		System.out.println("static method... ");
	}
	
	public static void main(String[] args) {// �̽������� ����ƽ ������ ����.
		StaticTest st = new StaticTest(); 
		st.calc();
		st.disp();
		System.out.println();
		
		StaticTest st2 = new StaticTest();
		st2.calc();
		st2.disp();
		System.out.println();
		
		StaticTest st3 = new StaticTest();
		st3.calc();
		st3.disp();
		System.out.println();
		
		System.out.println("static �޼ҵ� ȣ��");
		output();//����ƽ ����, �޼ҵ� ���� new ������ �� �ʿ䰡 ����. ����ƽ ������ ����� ������ �ٷ� �ҷ����� ��
		//StaticTest.output(),st.output(),st2.output(),st3.output()
		// ����ƽ ������ ���� �ֱ� ������ ��� ������ ȣ���ص� ����� ����. 
	}
}//Class StaticTest
