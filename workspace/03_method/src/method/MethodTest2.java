package method;

//public ��ü���� 

public class MethodTest2 {
	public void disp() { // ����  
		System.out.println("non-static method");
		
	}
	
	public static void output() {//����
			System.out.println("static method");

	}

	public static void main(String[] args) {
		MethodTest2.output(); //ȣ��
	
		MethodTest2 m = new MethodTest2();
		m.disp();
	}	
}
