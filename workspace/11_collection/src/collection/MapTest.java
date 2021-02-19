package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("book101", "백설공주");
		map.put("book201", "인어공주");
		map.put("book102", "백설공주"); //value 중복허용
		map.put("book301", "피오나");
		map.put("book101", "엄지공주"); //key 중복허용
		
		System.out.println(map.get("book101"));//엄지공주
		System.out.println(map.get("book102"));//백설공주
		System.out.println();
		
		//코드 입력: book501
		//없는 key입니다
		
		//코드 입력: book201
		//인어공주
		
		
		// if(map.containsKey(key))
		//    System.out.println(map.get(key));
		//else 
		//    System.out.println("없는  key입니다");
		
		while(true) {
		System.out.print("코드 입력: ");
		Scanner scan = new Scanner(System.in);
		String key = scan.next();
		
		if(map.get(key) == null) {
			System.out.println("없는 key입니다");
			System.out.println();
		}else {
			System.out.println(map.get(key));
			System.out.println();
		}
	  }
		
	}

}
