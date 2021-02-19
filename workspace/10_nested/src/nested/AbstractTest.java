package nested;

public abstract class AbstractTest { 
	//추상클래스는 new 할 수 없음.
	String name;
	
	//만약 자식이 추상클래스를 상속한다면, 자식클래스에서 추상메소드를 재정의 해 주어야 하고,
	// 자식클래스에서 재정의 하지 않으려면, 자식클래스 또한 추상클래스로 만들어 자식에게 추상메소드 오버라이딩을 떠넘긴다.
	
	//추상클래스에 있는 추상메소드는 누군가가 오버라이딩을 해주면됨.꼭 자식이 아니더라도됨.
	public abstract void setName(String name);//추상메소드
	
	public String getName() {
		return name;
	}
	
}
