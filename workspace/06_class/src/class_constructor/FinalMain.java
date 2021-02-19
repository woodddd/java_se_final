package class_constructor;

public class FinalMain {
	private final String FRUIT = "���";
	private final String FRUIT2;
	
	public static final String ANIMAL = "����";
	public static final String ANIMAL2;
	
	
	static {	//static�ʵ�� static ���������� �ʱ�ȭ �� �־�� �Ѵ�.
		ANIMAL2 = "�⸰";
	}
	
	public FinalMain() {
		FRUIT2 = "����";
	}
	
	public static void main(String[] args) {
		final int AGE = 10;
		//AGE++; AGE�� final �����̱� ������ ���� ���� ������ �� ����. error
		System.out.println("��� = " + AGE);
		
		final int AGE2;
		AGE2 = 20;
		//AGE2 = 30; - error
		
		FinalMain fm = new FinalMain();
		System.out.println("FRUIT = " + fm.FRUIT);
		System.out.println("FRUIT2 = " + fm.FRUIT2);
		
		System.out.println("ANIMAL = " + FinalMain.ANIMAL);
		System.out.println("ANIMAL2 = " + ANIMAL2);
	}

}
