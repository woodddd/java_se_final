package collection;

import java.util.ArrayList;

public class CollectionTest2 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("È£¶ûÀÌ");
		list.add("»çÀÚ");
		list.add("È£¶ûÀÌ");
//		list.add(25);
//		list.add(43.8);
		list.add("±â¸°");
		list.add("ÄÚ³¢¸®");
		
		for(int i=0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("-----------");
		
		for(String data : list) {
			System.out.println(data);	
		}
	}

}
