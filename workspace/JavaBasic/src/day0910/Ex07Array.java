package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//배열
//배열이란 똑같은 자료형이 모여있는 것을
//배열이라고 한다.

//예시 : 
//int 배열이라고 하면
//int가 사용자가 지정한 만큼 모여있고
//그 전체를 하나의 배열이라고 한다.

public class Ex07Array {

	public static void main(String[] args) throws IOException {
		//배열을 선언하는 방법
		//배열의 자료형[] 배열이름 = new 자료형[크기]
		
		//만약 우리가 int배열을 만들게 된다면
		int[] arr = new int[5];
		//이렇게 만든다.
		
		//배열은 우리가 항상 크기를 지정해 주어야 한다.
		//그 크기를 벗어날 수 없다.
		//위의 arr은 해당 배열이 5개의 int 변수를 다룰 수 있다는 것을 말한다.
		
		//배열에 있는 각 변수를 접근할 떄에는
		//배열이름[해당 위치]를 적어서 접근하게 된다.
		
		//해당 위치는 우리가 index라고 표현한다.
		//그리고 index는
		//0~ 크기 -1 까지이다.
		//즉 크기가 5인 배열은
		//인덱스가 0번부터 4번까지 있다.
		
		//우리가 기존의
		//변수같은 경우에는
		int a;
		a = 20;
		System.out.println("a : " + a);
		//와 같이 변수의 이름으로 접근을 했지만
		
		//배열 같은 경우에는   	// 배열의 초기값은 0임.
		arr[0] = 15;
		System.out.println("arr[0]: " + arr[0]);
		//배열이름[인덱스] 
		
		//그럼 배열에 각 요소에 값을 한번 입력해보자
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//0번부터 4번까지 차례대로 입력을 해보자
		System.out.print("0번 인덱스의 입력할 값: ");
		arr[0] = Integer.parseInt(br.readLine());
		
		System.out.print("1번 인덱스의 입력할 값: ");
		arr[1] = Integer.parseInt(br.readLine());
		
		System.out.print("2번 인덱스의 입력할 값: ");
		arr[2] = Integer.parseInt(br.readLine());
		
		System.out.print("3번 인덱스의 입력할 값: ");
		arr[3] = Integer.parseInt(br.readLine());
		
		System.out.print("4번 인덱스의 입력할 값: ");
		arr[4] = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= 4 ; i++) {
		System.out.println("arr[" + i + "]" + " = "+ arr[i]);
		
		//배열을 다룰 떄 알아두면 좋은 점
		//1. 크기는 변수가 될 수 있다.
		int size = 10;
		arr = new int[size];
		//2. index는 벗어나는 순간 에러가 난다.
		//System.out.println(arr[-1]); --- 에러
		System.out.println(arr[10]);
		//3. index도 변수를 넣어줄 수 있다.
		}
		
	}

}
