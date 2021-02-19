package abstractMethod;

//추상클래스의 목적 ! - 자식클래스를 제어하기 위함
public abstract class AbstractTest { //POJO(Plain Old Java Object) - 우리가 알고 있는 클래스. Object에게 상속받은 클래스,오리지날클래스
//추상메소드가 있는 클래스는 반드시 추상클래스이어야 한다. abstract를 넣어주면됨.
//반대로 추상클래스이면 추상메소드가 있어야한다 y|n
//정답은 n 추상클래스여도 추상메소드가 꼭 있어야하는건 아님. 있어도 되고 없어도됨.
	protected String name;
	
	public abstract void setName(String name); //추상메소드 -- 메소드에 {}(body) 가 없고 그 자리를 ; 로 마무리 한 것을 추상메소드라 한다.
	//추상메소드는 호출 할 수 없음.
	
	public String getName() {//구현
		return name;
	}
}
