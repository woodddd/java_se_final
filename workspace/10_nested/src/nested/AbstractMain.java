package nested;

//현재의 파일에서는 익명클래스가 3번 사용 되었으므로
//AbstractMain$1.class
//AbstractMain$2.class
//AbstractMain$3.class
//익명 클래스는 생성 순서대로 1, 2, 3 이 $뒤에 나타나게 되어 파일명을 생성함
public class AbstractMain {
	
	//만약 상속 관계일 경우, 자식클래스는 부모클래스가 추상클래스라면 부모클래스의 추상메소드를 오버라이딩 해야 한다.
	//public class AbstractMain extends AbstractTest{
	//	public void setName(String name) {
	//		this.name = name;
	//	}
	//}
	
	public static void main(String[] args) {
		//AbstractTest at = new AbstractTest(); //추상클래스는 new 할 수 없음.
		//추상클래스는 new 를 할 수 없다.
		
		//at.setName("홍길동");
		//System.out.println("이름 = " + at.getName());
		
		
		
		
		//원래는 상속을 해주고 추상메소드를 오버라이딩 해 줘야 하지만 익명클래스가 그역할을 대신 해준다
		AbstractTest at = new AbstractTest() {//{} - 익명 Inner 클래스. 왜냐하면 구현은 클래스만 할 수 있기 떄문이다.
			//그래서 {} body 는 이름이 없는 익명의 클래스 역할을 하게 되는것임.
			
			//추상클래스는 new 를 할 수 없다. 그래서 익명자식객체를 이용하여 익명 클래스를 이용해서 부모의 추상메소드를 대신 오버라이딩 해준 것이다.
			//부모클래스(AbstractTest)에 있는 추상메소드를 오버라이딩 해주게 되었다.
			//그러므로 부모클래스의 객체를 생성하게 되는 것이 아니다.
			//익명클래스의 객체를 생성하게 된 것이다.
			
			//추상클래스에 있는 추상메소드는 누군가가 오버라이딩을 해주면됨.꼭 자식이 아니더라도됨.
			//그래서 익명클래스로 오버라이딩을 해 준것임.
			//하지만 위의 개념에서는 익명클래스를 new 부모클래스 -> 의 자식객체를 생성한 것이라 이해를 해도 됨.
			//그래서 상속받은 익명(자식)객체가 대신 오버라이딩 하여 setName 을 사용할 수 있는 것임.

			public void setName(String name) {//구현
				this.name = name; 
				// 익명클래스가 객체를 생성하여 부모(AbstractTest)의 추상클래스를 오버라이딩 해 주었음.
			}
		};
		
		
		//인터페이스 안에는 상수와 추상메소드만 추가 되어 있음
		InterA in = new InterA() {//인터페이스는 추상이므로 new를 할 수 없음 여기서 new 는 익명 클래스를 new해준것임.
			//익명(자식)클래스 의 이름모를 객체가 대신 추상메소드를 오버라이딩 해 주었음.
			public void aa() {
				System.out.println("오늘은 목요일");
			}
			public void bb() {}
		};
		
		AbstractExam ae = new AbstractExam() {
			public void cc() {}
			public void dd() {}//얘네들은 추상메소드로 선언하지 않았기 떄문에 오버라이딩을 해도되고안해도됨. 
		};

	}

}
