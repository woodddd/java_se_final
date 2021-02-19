package nested;

public abstract class AbstractExam { //추상클래스는 new 할 수 없다.
	//추상메소드가 있는 클래스는 추상 클래스 이어야 하지만, 추상클래스이면 꼭 추상메소드를 가지고 있어야 하는건 아님.
	public void cc() {} 
	public void dd() {}
	//추상클래스 안의 메소드는 대부분 빈 body로 한다.
	//추상 클래스이기 때문에 누군가가(자식, 익명Inner) 재정의 하기 떄문이다.
	//개발자가 메소드 선언해서 원하는 메소드만 Override 해주면 된다.
	
}
