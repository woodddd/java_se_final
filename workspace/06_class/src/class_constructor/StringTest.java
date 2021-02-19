package class_constructor;

public class StringTest {

	public static void main(String[] args) {
		//literal 이란 자료형의종류(데이터의 종류)를 말함.
		//정수형 literal
		//실수형 literal
		//문자형 literal
		//literal은 heap 영역에 같은 문자를 여러번 잡지 않음. 아래와 같이 저장 되어 있으면
		// "apple" 이 저장이 되면, 이 값이 저장된 주소값을 a에게 주고
		// String 객체 b 도 "apple" 을 저장하게 되면 새로운 "apple"을 저장하는 것이 아니라
		// heap 영역에 저장되어 있는 "apple" 의 주소값을 내보내 주게 됨.
		// 그래서 둘의 주소값(참조값)이 같다고 나옴.
		String a = "apple";//"" 로 생성해줄 수 있는 것을 문자열 literal 생성 이라 한다.
		String b = "apple";
		if(a==b) {
			System.out.println("a와 b의 참조값은 같다");
		}else {
			System.out.println("a와 b의 참조값은 다르다");
		}
		if(a.equals(b)) {
			System.out.println("a와 b의 문자열은 같다");
		}else {
			System.out.println("a와 b의 문자열은 다르다");
		}
		System.out.println();
		//참조값이 같고 문자열 값이 같으면 저장영역에 1개만 저장되었다라고 말할수있다.
		
		
		// new 로 사용하게 되면 heap 영역에 계속 새로운 영역을 생성하게됨
		// 그래서 문자열 "apple" 을 만들어 저장하여 c에게 주소값을 주고
		// 또 new 가 발생되면 같은 문자라 하더라도 새로 "apple"을 저장하여
		// 새로운 주소값을 d 에게 주게됨
		// 결과적으로 메모리의 낭비가 발생되게 된다.
		
		// 이 둘의 차이를 확실히 알아야함.
		String c = new String("apple");
		String d = new String("apple");
		if(c==d) {
			System.out.println("a와 b의 참조값은 같다"); 
		}else {
			System.out.println("a와 b의 참조값은 다르다");
		}
		if(c.equals(d)) {
			System.out.println("c와 d의 문자열은 같다");
		}else {
			System.out.println("c와 d의 문자열은 다르다");
		}
		//참조값이다르고 문자열이 같다면 각각 다른 영역에 저장되었다고 말할 수 있다.

		
		String e = "오늘 날짜는" + 2020 + 9 + 25;
		System.out.println("e = " + e);
		//문자열은 편집이 안되므로 메모리에 4번 생성된다.
		// "오늘 날짜는"
		// "오늘 날짜는 2020"
		// "오늘 날짜는 20209"
		// e ---> "오늘 날짜는 2020925"
		// 이렇게 되면 저장역역의 낭비가 발생함
		// 그래서 JVM 은 저장위치가 없는 일시적 문자열들을 가비지 컬렉터(휴지통이라고 생각)에 저장해놨다가
		// 가비지컬렉터의 용량이 꽉 차게 되면 오래된 것부터 하나씩 지워버림
		// Garbage Collector 가 실행되면 컴퓨터가 멈춘다.
		// 단, 그 시간이 매우매우 짧기 때문에 눈에 보이지는 않음.
		System.out.println("문자열의 크기 = " + e.length());
		
		for(int i = 0 ; i < e.length() ; i++) {
			System.out.println(i + " : " + e.charAt(i));//charAt 은 해당 문자열의 몇번째 값을 알고싶을 때 사용.인덱스넘버와 같이 0번부터 시작함.
		}
		System.out.println();
		
		System.out.println("부분 문자열 추출 = " + e.substring(7));// 7번부터~ 끝까지
		System.out.println("부분 문자열 추출 = " + e.substring(7,11));// 7번부터 11이전까지 
		
		System.out.println("대문자 변경 = " + "Hello".toUpperCase());
		System.out.println("소문자 변경 = " + "Hello".toLowerCase());
		
		System.out.println("문자열 검색 = " + e.indexOf("짜"));//해당 값이 몇번째 인덱스에 있는지 반환
		System.out.println("문자열 검색 = " + e.indexOf("날짜"));
		System.out.println("문자열 검색 = " + e.indexOf("개바부"));// 해다결과가 없다면 -1 반환
	}

}
