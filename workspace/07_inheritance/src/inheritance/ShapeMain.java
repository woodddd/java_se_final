package inheritance;

class ShapeTest{
	protected double area;
	
	public ShapeTest() {
		System.out.println("ShapeTest �⺻ ������");
	}
	
	public void calcArea() {
		System.out.println("������ ����մϴ�.");
	}
	
	public void dispArea() {
		System.out.println("������ ����մϴ�.");
	}
}

class SamTest extends ShapeTest{
	protected double base, height;
	
	public SamTest(int base, int height) {
		System.out.println("SamTest ������");
		this.base = base;
		this.height = height;
	}
	@Override//������̼� �̶�� ��. �������̵带 ����� �� ���������� ����Ǿ����� �ﰢ �˷��ִ� ��.
	public void calcArea() {
		area = base * height / 2.0;
	}
	@Override
	public void dispArea() {
		System.out.println("�ﰢ�� ���� = " + area);
	}
}

class SaTest extends ShapeTest{
	protected double width, height;
	
	public SaTest(int width, int height) {
		System.out.println("SaTest ������");
		this.width = width;
		this.height = height;
	}
	@Override
	public void calcArea() {
		area = width * height;
	}
	@Override
	public void dispArea() {
		System.out.println("�簢�� ���� = " + area);
	}
}

class SadariTest extends ShapeTest{
	protected double top,bottom,height;
	public SadariTest(int top, int bottom, int height) {
		System.out.println("SadariTest ������");
		this.top = top;
		this.bottom = bottom;
		this.height = height;
	}
	@Override
	public void calcArea() {
		area = (top + bottom)*height/2;
	}
	@Override
	public void dispArea() {
		System.out.println("��ٸ��� ���� = " + area);
	}
	
}

public class ShapeMain {
	
	public static void main(String[] args) {
		
		/*
		SamTest sam = new SamTest(5,7);// 1:1 ����, ���յ� 100%
		sam.calcArea();
		sam.dispArea();
		System.out.println();
		
		SaTest sa = new SaTest(7,9);
		sa.calcArea();
		sa.dispArea();
		System.out.println();
		
		SadariTest sd = new SadariTest(2,3,5);
		sd.calcArea();
		sd.dispArea();
		System.out.println(); 
		*/
		
		//������ - �θ� �ڽ��� �����ϴ°�. ���յ��� ����������.
		ShapeTest shape;
		shape = new SamTest(5,7); //�θ�Ŭ���� ������ ������, �ڽ�Ŭ���� �����ڸ� ����
		shape.calcArea();//��ü�� Ÿ���� �θ�Ŭ���� �̱� ������ �θ�Ŭ������ calcArea�� �����ؾ� ������ �ڽ�Ŭ�������� �������̵��� �Ͽ����Ƿ� �ڽ�Ŭ������ �޼ҵ尡 �켱������ ����.
		shape.dispArea();
		System.out.println();
		
		shape = new SaTest(7,9);
		shape.calcArea();
		shape.dispArea();
		System.out.println();
		
		shape = new SadariTest(2,3,5);
		shape.calcArea();
		shape.dispArea();
		System.out.println();
		
	}

}
