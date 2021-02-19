package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PersonSort {

	public static void main(String[] args) {
		String[] ar = {"orange","apple","banana","pear","peach","applemango"};
		
		System.out.println("정렬 전 = ");
		for(String data : ar) {
			System.out.print(data + " ");
		}
		System.out.println();
		
		//sort명령은 우리가 알 수 없음. 프로그램 내부에서 알아서 계산해서 답을 주기 때문에..
		Arrays.sort(ar); //sort에 들어오는 매개변수 ar이 String[] 타입 이므로 Arrays 클래스에있는 sort 메소드를 사용해 준 것임.
		//Arrays클래스의 sort메소드에 파라미터를 기본자료형의 배열을 넣어면
		//알아서 정렬을 해서 추출해줌.
		
		//sort 메소드는 compareTo 메소드를 호출해줌.
		//대표적으로 sort뒤에 배열이 들어간다면 Arrays 클래스의 sort를 이용함.
		
		
		System.out.println("정렬 후 = ");
		for(String data : ar) {
			System.out.print(data + " ");
		}
		System.out.println("\n");
		
		PersonDTO aa = new PersonDTO("홍길동", 25);
		PersonDTO bb = new PersonDTO("또치", 40);
		PersonDTO cc = new PersonDTO("도우너", 30);
		
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		System.out.println("정렬 전 = " + list);
		
		System.out.println("\n나이로 정렬");
		Collections.sort(list); //sort메소드의 매개변수 list가  ArrayList<PersonDTo> 타입 이므로, Collections클래스에 있는 sort 메소드를 사용해야함.
		//일반적으로 어레이 리스트는 Collections클래스의 sort 메소드를 이용함.
		
		
		System.out.println("정렬 후 = " + list);
		System.out.println();
		
		//정렬 기준을 이름으로 변경
		Comparator<PersonDTO> com = new Comparator<PersonDTO>() {//Comparator 는 인터페이스라서 new 할 수 없어 중첩이너 클래스를 이용한것
			@Override
			public int compare(PersonDTO p1, PersonDTO p2) {
				
				return p1.getName().compareTo(p2.getName())*(-1); // 1 , 0 , -1 을 compareTo 메소드가 자체적으로 계산해줌
				//(-1)을 붙이면 내림차순정렬이됨. 1이 -1로 -1이 1로 0은 0으로
			}
		};
		
		System.out.println("\n이름으로 정렬");
		Collections.sort(list, com); //1.두 대상을 비교 2.두대상을 비교 후 자리바꿈
		System.out.println("정렬 후 = " + list);
		System.out.println();
		
	}
	

}
