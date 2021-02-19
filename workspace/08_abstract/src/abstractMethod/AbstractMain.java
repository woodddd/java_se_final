package abstractMethod;

public class AbstractMain extends AbstractTest{
	// public (abstract) class AbstractMain extends AbstractTest
	// abstract 를 사용하게 되면 원래추상메소드를 자식클래스에서 오버라이드 해 주어야 하지만
	// 그 역할을 다음 세대의 자식클래스에게 미뤄버린것.
	
	public void setName(String name) { //이와같이 부모클래스를 가지려면 모든 자식들은 추상메소드를 오버라이딩 해야함.(제약조건을 만들어 준것. 부모의 클래스를 상속하려면 이 메소드를 꼭 오버라이딩해라.(즉.자식 클래스를 제어하는것))
		this.name = name;				// 추상메소드를 사용하지 않으면 오버라이드를 하더라도 모든 클래스의 메소드명을 각각의 이름을 사용했지만
	}									//추상메소드를 이용하게 되면 자식클래스에서 재정의할 때, 모두 같은 메소드(부모클래스의 추상메소드명)이름을 사용할 수 있어  이용이 쉽다.
	//ex) 부모클래스에서 만약 disp 라는 추상메소드를 가지고 있다면 이 부모클래스를 상속받으려면
	//모든 자식 메소드가 disp 메소드를 오버라이딩 해야 이용이 가능하다.
	//하지만 상속관계에서도 오버라이딩을 하지 않을 경우 또한 존재하는데, 그 경우는 자식클래스를 추상클래스로 만드는 방법이다.
	// 그렇게 되면 자식클래스는 부모에게 상속받은 추상메소드를 오버라이딩 하지 않아도 되지만, 자식클래스를 상속받는 자식클래스에서
	// 추상메소드를 오버라이딩 해주어야 한다.
	
	public static void main(String[] args) {

		//AbstractTest at = new AbstractTest();//추상클래스는 절대!!! 자신의 클래스로 메모리를 생성할 수없다.(new할 수 없다).
		// 그래서 자식 클래스를 생성해야 한다. 자식클래스 생성자를 이용하면 상속관계에서 부모생성자를 실행하고 자식클래스를 실행한다.
		// 단! 반드시 자식클래스는 추상메소드를 Override를 해 주어야 한다.
		
		AbstractTest at = new AbstractMain();
		at.setName("홍길동");
		System.out.println(at.getName());
	}

}
