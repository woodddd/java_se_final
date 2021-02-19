package _interface;

//public class InterMain implements InterA, InterB{
public class InterMain implements InterC{ // 결국 이것과 위의 것은 동일한 것이 됨. C는 A와 B를 상속하기 떄문
	//implements를 사용하려면 interface의 추상메소드를 전부 오버라이드 해줘야함
	//하지만 오버라이드를 사용하지 않으려면 추상클래스로 만들면 됨.
	//그렇게 되면 자식메소드로 오버라이드를 미뤄버릴 수 있음.
	//public abstract class InterMain implements InterC{
	
	//인터페이스는 추상의 개념이므로 new로 생성할 수 없음.
	
	public void aa() {
		
	}
	
	public void bb() {
		
	}
	
	public void cc() {
		
	}
	
	public void dd() {
		
	}
	
	public static void main(String[] args) {
		

	}

}
