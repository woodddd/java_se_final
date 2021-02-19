package class_constructor;

//class EnumColor{
//	//상수만 정의
//	public static final String RED = "빨강";
//	public static final String GREEN = "초록";
//	public static final String BLUE = "파랑";
//	public static final String MAGENTA = "보라";
//}

enum EnumColor{
	RED, GREEN, BLUE, MAGENTA
}

public class EnumMain {
	String colorName;
	EnumColor color;

	public static void main(String[] args) {
		System.out.println(EnumColor.RED);
		System.out.println();
		
		EnumMain em = new EnumMain();
		em.colorName = "빨강";
		em.color = EnumColor.RED;
		System.out.println(em.colorName + "\t" + em.color);
		System.out.println(); 
		
		em.colorName = "보라";
		EnumColor VIOLET = EnumColor.MAGENTA;
		System.out.println(em.colorName + "\t" + VIOLET);
		System.out.println();
		
		for(EnumColor data : EnumColor.values()) { //EnumColor.values() 에서 EnumColor 를 배열로 추출해주게 됨.
			System.out.println(data + "\t"
								+ data.ordinal() + "\t"
								+ data.valueOf(data + "")); //"" 는 문자열이므로 문자열 + 값 은 문자열이됨. valueof는 해당 값을 data. 에서 찾아서 값을 가져옴 
								//+ data.valueOf("BLACK")); // BLACK을 enum에 가서 찾아라.
		}
		
	}

}

