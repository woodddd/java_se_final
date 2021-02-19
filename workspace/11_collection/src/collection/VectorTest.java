package collection;

import java.util.Iterator;
import java.util.Vector;

public class VectorTest {
	
	public static void main(String[] args) {
		
		Vector<String> v = new Vector<String>();
		System.out.println("벡터 크기 = " + v.size()); //0
		System.out.println("벡터 용량 = " + v.capacity());//기본용량 10개, 10개씩 증가
		System.out.println();
		
		System.out.println("항목 추가");
		for(int i = 1; i <=10; i++) {
			v.add(i + ""); // 제네릭으로 v의 안에는 String 타입만 들어갈 수 있게 해 놓았는데 i 는 정수이므로 문자열 ""를 넣어주어 문자열 타입을 추가해 준 것임.
		}
		System.out.println("벡터 크기 = " + v.size()); //10
		System.out.println("벡터 용량 = " + v.capacity());//기본용량 10개, 10개씩 증가
		System.out.println();
		
		//ex) 만약 벡터의 크기가 11개면 20개의 용량을 갖게됨. 
		
		v.addElement(5 + "");//중복허용, 순서
		System.out.println("벡터 크기 = " + v.size()); //11
		System.out.println("벡터 용량 = " + v.capacity());//20
		System.out.println();
		
		for(int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i) + "   ");// 1 2 3 4 5 6 7 8 9 10 5 //또한 백터의 객체는 인덱스 값이 존재함. 배열과 같이 0번부터 시자함.
		}
		System.out.println();
		
		//v.remove("5"); // 앞에 있는 5를 지우게됨.
		v.remove(10); // 인덱스 10번인 5 가 삭제됨.
		Iterator<String> it = v.iterator();
		while(it.hasNext()) {
			System.out.println(it.next() + "   ");
		}
		System.out.println();
		
		Vector<String> v2 = new Vector<String>(5,2); //기본용량 5개, 2개씩 증가
	}

}
