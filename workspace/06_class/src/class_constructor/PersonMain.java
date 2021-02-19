package class_constructor;


class PersonTest{
	private String name;
	private int age;
	// name,age 에 값을 넣기 위해서는 setter 또는 생성자를 이용
	// name, age 에서 값을 빼내기 위해서는 getter 를 이용

	// 생성자 사용의 목적: 객체 초기화
	// 클래스 new 생성 시 생성자 자동 호출
	
	// setter 사용의 목적 : 여러번 값을 넣어줄 때.
	// set는 강제 호출해줘야함.
	
	public PersonTest() {
	System.out.println("default 생성자"); //파라미터에 아무 값도 들어가지 않은 것
	}
	
	public PersonTest(String n) {
		name = n;
	}
	
	public PersonTest(String n, int m) {
		name = n;
		age = m;
	}
	//만약 생성자가 하나도 생성되어 있지 않다면 기본적으로 default 생성자가 자동으로 호출됨
	//만약 생성자가 하나라도 생성되어 있다면 파라미터가 없는 기본 생성자는 사용할 수 없게됨.
	
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
		PersonTest aa;// 현재 aa 는 클래스타입의 객체이다
		aa = new PersonTest("홍길동",25);
		System.out.println("객체 aa = " + aa); 
		// 객체를 출력한 결과는 주소값이 나오는데 그 결과는 참조주소 라고하며
		// 클래스명@16진수	의 결과가 나옴.(실제 메모리가 저장되어있는 실 주소값이 아닌 참조주소값임)
		
//		aa.name = "홍길동";
//		aa.age = 25;
		System.out.println("이름 = " + aa.getName() + "\t 나이 = " + aa.getAge());
//		System.out.println();
		
		PersonTest bb = new PersonTest();
		System.out.println("객체 bb = " + bb); 
		bb.setData("코난",13);
//		bb.name = "코난";
//		bb.age = 13;
		System.out.println("이름 = " + bb.getName() + "\t 나이 = " + bb.getAge());
	
		PersonTest cc = new PersonTest();// 자바의 기본 생성자는 객체의 필드만 초기화 해준다.// 만약 필드가 참조형이라면 null 로 , 기본형이라면 0으로 초기화해준다.
		cc.setData();//그래서 결과는 name = String 타입으로 null 이 나오게 되고, age = int 타입으로 0이 나오게 된다.
		System.out.println("이름 = " + cc.getName() + "\t 나이 = " + cc.getAge());
	}

}
