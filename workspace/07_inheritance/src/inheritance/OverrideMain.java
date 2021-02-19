package inheritance;


//접근제어자
//private < default < protected < public

//private
//같은 클래스 내 
//default
//다른 패키지에 접근 X 같은 패키지 내에서 허용
//protected
//다른 패키지 접근 가능,단 자식클래스일 경우 접근가능


class Test{
	int a = 3;
	
	public void disp() {
		a += 5;
		System.out.println("Test 클래스의 disp() 실행 ---");
		System.out.println("Test : a = " + a);
	}
}

class Sample extends Test{
	int a = 8;
	
	@Override
	public void disp() {
		a += 5;
		System.out.println("Sample 클래스의 disp() 실행 ---");
		System.out.println("Sample : a = " + a);
	}
	
}

public class OverrideMain {
	public static void main(String[] args) {
		Sample aa = new Sample(); //Test 기본생성자 , Sample 의 기본생성자
		aa.disp(); //Sample 클래스의 disp() 호출
		System.out.println("aa.a : " + aa.a);
		System.out.println();
		
		Test bb = new Sample(); // 부모 = 자식 을 참조할 수 있다.
		bb.disp(); // 오버라이드 된 메소드가 있다면 자식클래스의 메소드가 실행됨 (Sample 클래스의 disp()실행)
		//자식클래스에 있는 Sampe클래스의 disp를 실행하게 되어 Sample 클래스로 들어왔으므로  a의 값은 Sample 메소드의 a = 8 이 된다.
		System.out.println("bb.a : " + bb.a);//Test클래스의  객체 bb 의 필드 a가 된다.
		System.out.println();
		
		Sample dd = (Sample) bb; // 자식 = (자식)부모 // 강제형변환(캐스팅) 
		//생성자를 통한 초기화가 아닌 bb 데이터가 저장된 객체 bb 를 형변환하여 dd 에 저장하였음.
		dd.disp();
		System.out.println("dd.a : " + dd.a);
		
		Test cc = new Test();
		cc.disp(); // //Test 클래스의 disp() 호출
		System.out.println("cc.a : " + cc.a);
		System.out.println();
		
		//Sample ee = (Sample)cc; // 문법상 문제는 없지만 실행 시 error 를 실행하게됨.
		//cc 는 생성자를 통하여 Test 만 메모리에 생성해 놓은 상태이므로 Sample 이 메모리에 잡혀있지 않아 형변환을 할 수 없음.
		
		
		
	}
}
