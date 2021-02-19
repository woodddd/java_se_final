package class_constructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
치환하는 프로그램을 작성하시오
String 클래스의 메소드를 이용하시오
대소문자 상관없이 개수를 계산하시오

[실행결과]
문자열 입력 : aabba
현재 문자열 입력 : aa
바꿀 문자열 입력 : cc
ccbba
1번 치환

문자열 입력 : aAbbA
현재 문자열 입력 : aa
바꿀 문자열 입력 : cc
ccbba
1번 치환

문자열 입력 : aabbaa
현재 문자열 입력 : aa
바꿀 문자열 입력 : cc
ccbbcc
2번 치환

문자열 입력 : AAccaabbaaaaatt
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddccddbbddddatt
4개 치환

문자열 입력 : aabb
현재 문자열 입력 : aaaaa
바꿀 문자열 입력 : ddddd
입력한 문자열의 크기가 작습니다

indexOf()
replace(??, ??)
 */

public class StringTest2 {

	public static void main(String[] args) throws IOException {
//		String str = "aabbaa";
//		System.out.println(str.replace("aa", "tt"));//replace 는 원본을 바꾸는게 아님. 출력 결과만 바꿔줌.
//		System.out.println("str = " + str);
//		
//		System.out.println(str.indexOf("a")); // 0번째 위치부터 찾기 시작
//		System.out.println(str.indexOf("a",2)); // 2번째 위치부터 찾기 시작
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str,target,replaceing;
		int index;
		int count;
		
		System.out.print("문자열 입력 : ");
		str = br.readLine();
		
		System.out.print("찾을 문자열 입력 : ");
		target = br.readLine();
		
		System.out.print("바꿀 문자열 입력 : ");
		replaceing = br.readLine();

		if(str.length() < target.length()) {
			System.out.println("입력한 문자열의 크기가 작습니다.");
		}else {
			str = str.toLowerCase(); //toLowerCase 메소드 또한 원본의 값을 바꾸지 않기 때문에 다시 저장을 해 주어야 함.
			target = target.toLowerCase();
			
			index = count = 0;
			
			while((index = str.indexOf(target, index)) != -1) {
				
				index += target.length();
				count ++;
			}
			System.out.println(str.replace(target,replaceing));
			System.out.println(count + "개 치환");
		}
		
	}

}









