package class_constructor;

//import static java.lang.Math.random; //스태틱 변수 또는 메소드를 호출할 때 사용
//import static java.lang.Math.pow;

import static java.lang.Math.*; //와일드 카드(*) Math 클래스 안의 모든 메소드.
import static java.lang.String.format;
import static java.lang.System.out;

public class ImportStatic {

	public static void main(String[] args) {//import를 하게 되면 클래스명.메소드 로 입력하지 않고 메소드 명만 입력해도됨.
		out.println("난수 = " + random());// import하지 않아도 Math.random 으로 사용  할 수 있으므로 random 은 스태틱 메소드 라는 걸 알 수 있다.
		out.println("제곱승 = " + pow(2, 10));
		out.println("소수 이하 2째자리 = " + format("%.2f", 123.456));
	}

} 
