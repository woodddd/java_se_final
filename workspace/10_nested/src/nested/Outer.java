package nested;

public class Outer {// 중첩 클래스 종류는 대표적으로 인스턴스 멤버 클래스(static을 사용하지않은 내부class), 정적 멤버 클래스(static을 사용한 내부class)
	
	private String name;
	
	public void output() {
		System.out.println("이름 = " + this.name + "\t 나이" + new Inner().age);//기존에 다른 클래스에 있는 private 필드를 가져오려면 get필드명 으로 가져와야 했지만, 중첩클래스는 그러지 않아도됨.
	}//              Inner inner = new Inner();       or  inner.age    객체로만 접근해주면됨.
	
	
	
	class Inner{
		private int age;
		
		
		public void disp() {
			System.out.println("이름 = " + Outer.this.name + "\t 나이 " + this.age);
			
		}
	}//class Inner
	
	
	public static void main(String[] args) {
		Outer ou = new Outer();
		ou.name = "홍길동";
		ou.output();
		System.out.println();
		
		
		Outer.Inner in = ou.new Inner();//Outer객체 ou 안에 Inner클래스의 객체 in 을 생성. //인스턴스 멤버 클래스의 경우 내부클래스의 객체생성은 외부클래스의 안에 생성해주어야함.
		in.age = 25;//내부클래스는 외부클래스의 필드를 가져와 사용할 수 있음. 왜냐하면 in은 내부클래스의 객체 이지만, Outer클래스 객체 내부에 생성했기 때문에 Outer 객체의 필드를 가져올 수 있음.
		in.disp();
		//in.output(); 은 사용할 수 없음.in 객체는 Inner만을 가르키고 있기 때문이다.
		
		Outer.Inner in2 = ou.new Inner();
		in2.age = 30;
		in2.disp();
		System.out.println();
		
		Outer.Inner in3 = new Outer().new Inner(); // Outer클래스의 객체를 새로 생성하여 그 안에 Inner클래스의 객체를 생성함.
		//이렇게 되면 in3 가 가르키는건 새로 생성되는 Outer객체의 안에 생성되는 in3객체이기 때문에 Outer 객체에는 현재 저장된 값이 없어 생성자를 통해 기본값 null 이 들어가게 됨.
		in3.age = 35;
		in3.disp();
	}//Outer main

}//class Outer
