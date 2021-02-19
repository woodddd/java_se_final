package method;

//public 전체공개 

public class MethodTest2 {
	public void disp() { // 구현  
		System.out.println("non-static method");
		
	}
	
	public static void output() {//구현
			System.out.println("static method");

	}

	public static void main(String[] args) {
		MethodTest2.output(); //호출
	
		MethodTest2 m = new MethodTest2();
		m.disp();
	}	
}
