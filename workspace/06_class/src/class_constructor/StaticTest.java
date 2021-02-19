package class_constructor;

public class StaticTest {
	
	private int a;//필드, 인스턴스 변수
	private static int b;//필드, 클래스 변수  //스태틱 변수의 값은 모든 객체가 공유한다.
	//static변수는 static 메모리 저장영역에 1번만 잡히기 때문에 값을 서로 공유하게 됨.
	//static 은 메모리 저장영역에 한번만 잡히기 떄문에 초기화도 한번만 되는 것 임.
	
	static { // static을 초기화 하는 영역.
		//main 메소드 실행 시 바로 실행이 됨.
		System.out.println("초기화 영역");
		b = 3;
	}
	
	public StaticTest() { //생성자는 초기화할 목적으로 사용됨
		System.out.println("기본 생성자");
		this.a = 3;
		//b = 3; static은 생성자를 통한 초기화를 할 수 없음
	}
	
	public void calc() {
		a++;
		b++;
	}
	
	public void disp() {
		System.out.println("a = " + this.a + "\t b=" + StaticTest.b);
	}//this 는 현재 객체의 주소를 가르킴
	//b 는 static 영역의 변수이므로 this 를 참조하지 못함.
	//this 는 객체 생성시 클래스 내에 내장되어있기 떄문.
	//super또한 사용하지 못함.
	
	public static void output() {
		//System.out.println("a = " + this.a + "\t b=" + StaticTest.b);//스태틱 메소드는 스태틱 변수만 사용 가능. 스태틱 메소드 안에서 This 및 super는 참조되지 못함.
		System.out.println("static method... ");
	}
	
	public static void main(String[] args) {// 이시점부터 스태틱 영역이 잡힘.
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
		
		System.out.println("static 메소드 호출");
		output();//스태틱 변수, 메소드 들은 new 생성을 할 필요가 없음. 스태틱 영역에 저장됙 떄문에 바로 불러오면 됨
		//StaticTest.output(),st.output(),st2.output(),st3.output()
		// 스태틱 영역에 잡혀 있기 때문에 어떠한 것으로 호출해도 상관이 없음. 
	}
}//Class StaticTest
