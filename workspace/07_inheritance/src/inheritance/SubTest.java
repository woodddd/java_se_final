package inheritance;

public class SubTest extends SuperTest{ //자식클래스는 생성자를 통하여 자기 자신과 부모 클래스를 생성하게됨.
	protected String name;
	protected int age;
	
	public SubTest() {
		System.out.println("SubTest 기본 생성자");
	}
	
	public SubTest(double weight, double height, String name, int age) {// 부모클래스에서 필드 의 접근자를protected 로 설정해 주었으므로 자식클래스는 부모의 필드를 사용할 수 있음.
		System.out.println("SubTest 생성자");
		//this.weight = weight;
		//this.height = height;
		super.weight = weight;
		super.height = height;
		this.name = name;
		this.age = age;
	}
	
	public void output() {
		System.out.println("SubTest클래스의 output()");
		System.out.println("몸무게 = " + weight);
		System.out.println("키 = " + height);
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
	}
	
	public static void main(String[] args) {
		//SuperTest aa = new SuperTest(); 부모는 부모것만 기본생성자를 통해 생성을 함
		//SubTest aa = new SubTest(); // 자식클래스는 자신것과 부모의 기본생성자를 통해 생성을 함.
		// 부모기본생성자 + 자기것도 기본 생성자 호출
		SubTest aa = new SubTest(75.3, 185.5, "홍길동", 25);
		// 부모 기본생성자 + 자기것은 파라미터가 있는 생성자 호출
		System.out.println();
		
		aa.output(); // output()를 SubTest에서 찾는다. 없으면 부모클래스에 가서 찾는다.
		System.out.println();
		
		aa.disp(); // disp 를 SubTest에서 찾는다. 없으면 부모클래스에 가서 찾는다.
		System.out.println("-------------------------");
		
		SuperTest bb = new SubTest(35.8, 156.3, "코난", 13);
		bb.disp();
		//bb.output(); -The method output() is undefined for the type SuperTest 에러가 발생하게 된다. 왜냐하면 output 메소드는 SuperTest클래스에 정의되어 있지 않기 때문.
		
		}
}
