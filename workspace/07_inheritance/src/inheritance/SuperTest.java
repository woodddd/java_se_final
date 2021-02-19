package inheritance;

public class SuperTest {
	protected double weight;
	protected double height;

	public SuperTest() {
		System.out.println("SuperTest 기본 생성자");
	}
	
	public SuperTest(double weight, double height) {
		System.out.println("SuperTest 생성자");
		this.weight = weight;
		this.height = height;
	}
	
	public void disp() {
		System.out.println("SuperTest클래스의 disp()");
		System.out.println("몸무게 = " + weight);
		System.out.println("키 = height" + height);
	}
}

//접근제한자
// private < protected < public
// protected 부모와 자식만 사용할 수 있음