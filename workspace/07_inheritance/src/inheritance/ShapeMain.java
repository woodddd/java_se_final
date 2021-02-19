package inheritance;

class ShapeTest{
	protected double area;
	
	public ShapeTest() {
		System.out.println("ShapeTest 기본 생성자");
	}
	
	public void calcArea() {
		System.out.println("도형을 계산합니다.");
	}
	
	public void dispArea() {
		System.out.println("도형을 출력합니다.");
	}
}

class SamTest extends ShapeTest{
	protected double base, height;
	
	public SamTest(int base, int height) {
		System.out.println("SamTest 생성자");
		this.base = base;
		this.height = height;
	}
	@Override//어노테이션 이라고 함. 오버라이드를 사용할 때 정상적으로 수행되었는지 즉각 알려주는 것.
	public void calcArea() {
		area = base * height / 2.0;
	}
	@Override
	public void dispArea() {
		System.out.println("삼각형 넓이 = " + area);
	}
}

class SaTest extends ShapeTest{
	protected double width, height;
	
	public SaTest(int width, int height) {
		System.out.println("SaTest 생성자");
		this.width = width;
		this.height = height;
	}
	@Override
	public void calcArea() {
		area = width * height;
	}
	@Override
	public void dispArea() {
		System.out.println("사각형 넓이 = " + area);
	}
}

class SadariTest extends ShapeTest{
	protected double top,bottom,height;
	public SadariTest(int top, int bottom, int height) {
		System.out.println("SadariTest 생성자");
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
		System.out.println("사다리꼴 넓이 = " + area);
	}
	
}

public class ShapeMain {
	
	public static void main(String[] args) {
		
		/*
		SamTest sam = new SamTest(5,7);// 1:1 관계, 결합도 100%
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
		
		//다형성 - 부모가 자식을 참조하는것. 결합도가 느슨해진다.
		ShapeTest shape;
		shape = new SamTest(5,7); //부모클래스 생성자 생성후, 자식클래스 생성자를 실행
		shape.calcArea();//객체의 타입이 부모클래스 이기 때문에 부모클래스의 calcArea를 실행해야 하지만 자식클래스에서 오버라이딩을 하였으므로 자식클래스의 메소드가 우선순위를 가짐.
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
