package inheritance;

/*
Class Object{
	public boolean equals(Object ob){}//참조값 비교
	public String toString(){}//패키지명.클래스명@16진수
	public int hashCode(){}//10진수
}

final class String extends Object{
public boolean equals(Object ob){}//문자열 비교
	public String toString(){}
	public int hashCode(){} // 문자열을 10진수 변환
							//문자열 계싼식에 의해서 만들어진 값
							//다른 문자열이어도 같은 해시값이 발생할 수 있다.
							//int 21억개이고 문자열은 무한대라서 표시가 불가.
}
*/


class Test2{
	@Override
	public String toString() {
		return super.toString();
	}
	
}

public class ObjectMain {

	public static void main(String[] args) {

		Test2 t = new Test2();
		System.out.println("객체 t = " + t);
		System.out.println("객체 t = " + t.toString());
		System.out.println("객체 t = " + t.hashCode()); //패키지명.클래스명@16진수 ---> 16진수를 10진수로 표기해줌
		System.out.println();
		
		String str = "apple";
		System.out.println("객체 str = " + str);
		System.out.println("객체 str = " + str.toString());
		System.out.println("객체 str = " + str.hashCode());//믿으면 안된다. 값이 겹쳐질 수가 있기 때문.
		System.out.println();
		
		String aa = new String("apple");
		String bb = new String("apple");
		System.out.println("aa=bb : " + (aa==bb));//주소 값 비교
		System.out.println("aa.equals(bb) : " + aa.equals(bb));//문자열
		System.out.println();
		
		Object cc = new Object();
		Object dd = new Object();
		System.out.println("cc=dd : " + (cc==dd));//주소 값 비교
		System.out.println("cc.equals(dd) : " + cc.equals(dd));//Object클래스의 equals 메소드 이므로 주소값을 비교함. false
		System.out.println();
		
		Object ee = new String("apple");
		Object ff = new String("apple");
		System.out.println("ee=ff : " + (ee==ff));//주소 값 비교
		System.out.println("cc.equals(ff) : " + ee.equals(ff));//문자열 String 클래스의 오버라이드 된 toSTring 메소드를 실행하게됨. 
	}

}

