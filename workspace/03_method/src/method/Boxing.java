package method;

public class Boxing {

	public static void main(String[] args) {

		int a = 25;
		double b = (double) a / 3; // 강제형변환/자동형변환 (Casting, Cast 연산)
		
		int c = 5;
		Integer d = c; // JDK 5.0 이상, AutoBoxing(자동으로 박싱한다.) -> 기본형을 자동으로 Wrapper Class로 바꿔준다.
		//객체			int(기본형)
		//Integer d = new Integer(c);
		
		Integer e = 5;
		int f = e; //JDK 5.0 이상, unAutoBoxing -> Wrapper Class를 기본형으로 자동 변환하겠다.
		//기본형 = 객체형
		//int f = e.intValue();
		
		
		
	}

}
