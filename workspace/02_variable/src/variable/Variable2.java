package variable;

public class Variable2 {
	
	int a;//필드, 인스턴스 변수, 0으로 초기화 되어 있음 // main 메소드에서 new를 사용하지 않으면 사용할 수 없음
	static int b; //필드(클래스 밑에 잡힌 것들), (static)클래스 변수 , 0으로 초기화 되어 있음	
	// static - 실행시 메모리에 자동으로 생성
	int c;
	String d;// String 필드 기본값 = null
	
	int e = 5;
	int f;
	//f = 7; // 이미 만들어진 f 안에 값을 대입하는 명령문은 class 아래 올 수 없음
	
	public static void main(String[] args) {
		int a = 10; //지역변수(local variable) 모든 지역변수는 쓰레기 값을 가지고 있음. 그래서 초기화를 시켜줘야함.
		System.out.println("지역변수 a = " + a);
		System.out.println("필드 = " + b);// b 앞에 클래스명이 생략되어 있음.(static 변수로 선언했기 때문)
		System.out.println("필드 = " + Variable2.b);//Variable 클래스 안에 있는 b이다.
		System.out.println("필드 a = " + new Variable2().a); // static 이 붙지 않은 변수는 Variable2 를 생성하여 그 안에 a 를 불러와야함.
		// new 를 사용하면 한번만 쓰고 버리는 것이 됨.(일회용)
		

	}

}
