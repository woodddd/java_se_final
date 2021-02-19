package inheritance;

//				자식		상속한다	   부모
public class ChildTest extends SuperTest{
	protected String name;
	protected int age;
	
	public ChildTest(){
		System.out.println("ChildTest 기본 생성자");
	}
	
	public ChildTest(double weight, double height, String name, int age) {// 부모클래스에서 필드 의 접근자를protected 로 설정해 주었으므로 자식클래스는 부모의 필드를 사용할 수 있음.
		super(weight,height); // 부모생성자 호출
		System.out.println("ChildTest 생성자"); 
		//this.weight = weight;
		//this.height = height;
		this.name = name;
		this.age = age;
	}
	
	public void disp() {
		System.out.println("ChildTest클래스의 disp()");
		System.out.println("몸무게 = " + weight);
		System.out.println("키 = " + height);
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
	}
	
	public static void main(String[] args) {
		ChildTest aa = new ChildTest(75.3, 185.5, "홍길동", 25); // ChildTest 의 객체 생성 시 생성자를 통하여 ChildTest의 기본생성자와 부모 클래스의 SuperTest 기본생성자를 실행하게됨.
		//생성자를 통해서 메모리를 잡을 때, 부모클래스 메모리를 먼저 할당하고 그 후 자식클래스의 메모리를 할당함.
		//그래서 결과로 부모클래스의 생성자가 먼저 호출되고, 그 후 자식클래스의 생성자를 호출하는것임.
		System.out.println();
		aa.disp(); // disp()를 ChildTest에서 찾는다. 없으면 부모 클래스에 가서 찾는다.
		System.out.println();
		
		System.out.println("-------------------------");
		SuperTest bb = new ChildTest(35.8, 156.3, "코난", 13);
		bb.disp();// 오버라이드(부모클래스에 있는 메소드를 재정의함)한 자식클래스의 메소드가 존재 할 경우 무조건 자식클래스의 메소드만을 호출함.
		System.out.println();
	}
}
