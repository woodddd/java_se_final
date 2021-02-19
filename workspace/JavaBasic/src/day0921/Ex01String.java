package day0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// String 클래스에 대해 알아보자
// String 이란?
// 여러개의 문자가 모여있는 char[]을
// 우리가 다루기 쉽게 클래스의 형태로 바꿔놓은 것.

// String 클래스 안에는 스트링을 다루는데 도움이 되는 다양한 메소드가 준비되어 있다.


public class Ex01String {
	public static void main(String[] args) throws IOException {
		String string1 = new String("abc");
		String string2 = "abc";
		
		//1번: 해당 스트링의 몇번째 칸에 무슨 글자가 있는지 확인할 떄에는
		//charAt(index)를 실행하면 된다.
		System.out.println("string.charAt(0): " + string1.charAt(0));
		//2번 : 2개의 문자열을 연결시킬때에는 concat을 사용한다.
		System.out.println("string1.concat(string2): " + string1.concat(string2));
		//3번: 해당 문자열에 이러한 하위 문자열이 있는지를 체크할 떄에는 contains()를 사용한다.
		System.out.println("string1.contains(\"ab\"): " + string1.contains("ab"));
		//4번: 해당 문자열이 초기화는 되어있지만 비어있는 문자열인지 체크할 때에는 isEmpty()를 사용한다.
		
		// null != "";
		// null 인 상태에선 아무것도 할 수 없다. 새로운 초기화를 할 떄까지
		// ""혹은 new String() 으로 초기화하면 모든 메소드들을 호출 할 수 있지만
		// 다만 아무런 문자도 문자열에는 없는 상태인 것이다.
		
		// 널이란 스택 영역에 주소값이 부여는 되어있지만,
		// 힙 영역에 해당 주소가 아무런 초기화가 안되어있는 상태를 널이라고 한다.
		
		// 우리가 그 클래스의 필드 혹은 메소드를 접근 할려면
		// 힙 영역에서 그 내용을 찾아야 하는데
		// 널인 상태에서는 그 내용들이 없으므로
		// 접근할 수 없게 되는 것이다.
		
		// 즉 isEmpty() 메소드는
		// 해당 스트링이 널이 아닐 때만 실행가능하다.
		
		System.out.println("string1.isEmpty(): " + string1.isEmpty());
		System.out.println("\"\".isEmpty(): " + "".isEmpty());
		
		//5번: 해당 스트링의 길이를 알고 싶을 때는 length()
		System.out.println("string1.length(): " + string1.length());
		
		//6번: 해당 문자열이 문자패턴과 일치하는지 확인할 때에는 matches()을 사용한다.
		//	문자 패턴은 정귶현식을 사용해야한다.
		//	다양한 정규표현식을 사용해서 우리가 문자열이 여러가지 형태를 만족하는지
		//	테스트 가능하다.
		//	ex)핸드폰번호
		//	하지만 어려운 개념이므로 우리는 해당 문자열이 숫자로만 이루어졌는가 아닌가만 배워보도록 하자
		//	해당 스트링이 모두 다 스트링으로 이루어졌는지 체크할 때에는 \d* 으로 테스트 한다.
		// 	*는 숫자가 야러개로 이루어졌는지 확인하는것
		// \는 * 와 \ 와같은 기호를 인식(사용)할 수 있도록 해당 문자 앞에 붙여준다.
		System.out.println("string1.matches(\\d*): " + string1.matches("\\d*"));
		System.out.println("\"12345\".matches(\\d*): " + "12345".matches("\\d*"));
	
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자를 입력해주세요: ");
		String userInput = bufferedReader.readLine();
		while(!userInput.matches("\\d*")) {
			System.out.println("숫자만 입력해주세요");
			System.out.print("> ");
			userInput = bufferedReader.readLine();
		}
		int userNumber = Integer.parseInt(userInput);
		System.out.println("사용자가 입력한 숫자: " + userNumber);
	}
	
}
