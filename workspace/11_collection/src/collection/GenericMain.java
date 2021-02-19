package collection;

class GenericTest<T>{
	private T a;
	
	public void setA(T a) {
		this.a = a;
	}	
		
	public T getA() {
		return a;
	}
}
//---------------
public class GenericMain {

	public static void main(String[] args) {
		GenericTest<String> aa = new GenericTest<String>();
		aa.setA("ȫ�浿");
		System.out.println("�̸� = "+aa.getA());

		//aa.setA(25); - error
		
		GenericTest<Integer> bb = new GenericTest<Integer>();
		bb.setA(25);
		System.out.println("���� = "+bb.getA());
	}

}
