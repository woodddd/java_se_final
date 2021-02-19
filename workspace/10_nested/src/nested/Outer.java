package nested;

public class Outer {// ��ø Ŭ���� ������ ��ǥ������ �ν��Ͻ� ��� Ŭ����(static�� ����������� ����class), ���� ��� Ŭ����(static�� ����� ����class)
	
	private String name;
	
	public void output() {
		System.out.println("�̸� = " + this.name + "\t ����" + new Inner().age);//������ �ٸ� Ŭ������ �ִ� private �ʵ带 ���������� get�ʵ�� ���� �����;� ������, ��øŬ������ �׷��� �ʾƵ���.
	}//              Inner inner = new Inner();       or  inner.age    ��ü�θ� �������ָ��.
	
	
	
	class Inner{
		private int age;
		
		
		public void disp() {
			System.out.println("�̸� = " + Outer.this.name + "\t ���� " + this.age);
			
		}
	}//class Inner
	
	
	public static void main(String[] args) {
		Outer ou = new Outer();
		ou.name = "ȫ�浿";
		ou.output();
		System.out.println();
		
		
		Outer.Inner in = ou.new Inner();//Outer��ü ou �ȿ� InnerŬ������ ��ü in �� ����. //�ν��Ͻ� ��� Ŭ������ ��� ����Ŭ������ ��ü������ �ܺ�Ŭ������ �ȿ� �������־����.
		in.age = 25;//����Ŭ������ �ܺ�Ŭ������ �ʵ带 ������ ����� �� ����. �ֳ��ϸ� in�� ����Ŭ������ ��ü ������, OuterŬ���� ��ü ���ο� �����߱� ������ Outer ��ü�� �ʵ带 ������ �� ����.
		in.disp();
		//in.output(); �� ����� �� ����.in ��ü�� Inner���� ����Ű�� �ֱ� �����̴�.
		
		Outer.Inner in2 = ou.new Inner();
		in2.age = 30;
		in2.disp();
		System.out.println();
		
		Outer.Inner in3 = new Outer().new Inner(); // OuterŬ������ ��ü�� ���� �����Ͽ� �� �ȿ� InnerŬ������ ��ü�� ������.
		//�̷��� �Ǹ� in3 �� ����Ű�°� ���� �����Ǵ� Outer��ü�� �ȿ� �����Ǵ� in3��ü�̱� ������ Outer ��ü���� ���� ����� ���� ���� �����ڸ� ���� �⺻�� null �� ���� ��.
		in3.age = 35;
		in3.disp();
	}//Outer main

}//class Outer
