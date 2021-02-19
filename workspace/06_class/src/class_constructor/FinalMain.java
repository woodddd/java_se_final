package class_constructor;

public class FinalMain {
	private final String FRUIT = "사과";
	private final String FRUIT2;
	
	public static final String ANIMAL = "사자";
	public static final String ANIMAL2;
	
	
	static {	//static필드는 static 영역에서만 초기화 해 주어야 한다.
		ANIMAL2 = "기린";
	}
	
	public FinalMain() {
		FRUIT2 = "딸기";
	}
	
	public static void main(String[] args) {
		final int AGE = 10;
		//AGE++; AGE는 final 변수이기 떄문에 절대 값을 변경할 수 없다. error
		System.out.println("상수 = " + AGE);
		
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
