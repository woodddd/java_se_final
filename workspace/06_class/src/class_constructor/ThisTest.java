package class_constructor;

public class ThisTest { // 현재 클래스에서는 필드를 private로 선언했지만 private는 같은 클래스 내에서만 사용 가능하므로 게터 세터를 생성할 필요가 없음
	private String name; // new 생성자 활용 시 기본값 null(String 은 참조형)
	private int age; // new 생성자 활용 시 기본값 0(int 는 기본형)
	
	public ThisTest() {
		System.out.println("defualt생성자");
		System.out.println("this = " + this);
	}
	
	public ThisTest(String name) {
		this();
		this.name = name;
		System.out.println("this = " + this);
	}
	
	public ThisTest(int age) {
		this("코난");//단! 생성자 안에서 생서자를 호출할 시 생성자호출을 첫번째 줄에 삽입해야함. 그렇지 않으면 에러 발생
		this.age = age;
		//생성자는 new 없이 개별 호출이 불가능 하지만  생성자 끼리는 호출이 가능함.
		//this 명령어를 사용하게 되면 ThisTest생성자가 되고 () 안에 들어가는 파라미터 값에 따라 어떤 생성자를 호출하는지가 결정됨
		//또한 This 를 이용해서 다른 생성자를 호출하고 싶은 경우 무조건 현재 사용하려는 생성자 안에서 첫번쨰 줄에 입력해야함. 그렇지 않으면 에러가 발생됨. 
	}
	
	public static void main(String[] args) {
		
		ThisTest aa = new ThisTest();
		System.out.println("객체 aa = " + aa);
		System.out.println("이름  = " + aa.name + " 나이 = " + aa.age);
		System.out.println();
		
		ThisTest bb = new ThisTest("홍길동");
		System.out.println("객체 bb = " + bb);
		System.out.println("이름  = " + bb.name + " 나이 = " + bb.age);
		System.out.println();
		
		ThisTest cc = new ThisTest(25);
		System.out.println("객체 bb = " + cc);
		System.out.println("이름  = " + cc.name + " 나이 = " + cc.age);
		System.out.println();
	}

}
