package collection;

class GenericTest2<T>{
	private T a;
	
	public GenericTest2(T a) {
		this.a =a;
	}
	
	public void setA(T a) {
		this.a = a;
	}	
		
	public T getA() {
		return a;
	}
}
//---------------

public class GenericMain2 {

	public static void main(String[] args) {
		GenericTest2<?> aa = new GenericTest2<String>("ȫ�浿");
		//aa.setA("ȫ�浿"); - �ݵ�� �����ڸ� ���ؼ��� �����Ͱ� ���޵ȴ�.
		
		String name = (String)aa.getA(); //�ڽ� = (�ڽ�)�θ� 
		System.out.println("�̸� = "+name);
		
		GenericTest2<?> bb = new GenericTest2<Integer>(25);
		int age = (int)bb.getA(); //unAutoBoxing
	    System.out.println("���� = "+age);
	}

}
