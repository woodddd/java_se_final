package _interface;

public interface InterA {

	//인터페이스 안에는 
	//상수와 추상메소드 만 들어와야 한다.(변하지않는 값)

	//static final 은 생략 가능!
	//abstract 는 생략가능!
	//어차피 상수와 추상메소드만 들어올 수 있기 때문.
	
	public static final String NAME = "홍길동";
	public int AGE = 25; //이것은 변수가 아니다. 상수이다. (static final 이 생략되어 있는것)
	public abstract void aa(); //추상메소드
	public void bb(); //이것 또한 추상메소드이다.
	
//	public void cc() {
//		
//	} 일반 메소드를 사용하게 되면 에러가 발생됨. {} body 를 사용할 수 없음.
	
	//인터페이스는 틀만 존재하기 때문에 클래스 파일이 필요함.
}
