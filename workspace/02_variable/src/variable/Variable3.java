package variable;

public class Variable3 {
	
	int a;//필드, 인스턴스변수
	static int b;//필드 , 클래스변수
	

	public static void main(String[] args) {
		
		int a = 10;//지역변수(Local Variable)
		System.out.println("지역변수 a = " + a);
		
		Variable3 v; //객체 - 클래스의 주소값을 가지고 있음
		v = new Variable3(); //클래스 생성 + 생성자함수 ("()")
		System.out.println("필드 a = " + v.a);
		v.a= 20;
		System.out.println("필드 a = " + v.a);

		Variable3 v2;//객체
		v2 = new Variable3(); // v2 라는 객체가 Variable3 클래스를 생성.(또다른 Variable3 클래스가 생성된 것. 그래서 a에 값이 없음)
		System.out.println("v2 클래스 필드 a = " + v2.a);
		
		int sum = v.a + v2.a;
		System.out.println("합 = " + sum);
		
		System.out.println("필드 b = " + Variable3.b);//이렇게 작성 해도 되지만 static 변수로 선언 했으므로
		System.out.println("필드 b = " + b); //이렇게 입력 해 줘도 된다.
		System.out.println("필드 b = " + v.b);
		System.out.println("필드 b = " + v2.b);
	}

}
