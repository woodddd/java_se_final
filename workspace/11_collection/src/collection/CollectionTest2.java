package collection;

import java.util.ArrayList;

public class CollectionTest2 {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("ȣ����");
		list.add("����");
		list.add("ȣ����");
//		list.add(25);
//		list.add(43.8);
		list.add("�⸰");
		list.add("�ڳ���");
		
		for(int i=0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		System.out.println("-----------");
		
		for(String data : list) {
			System.out.println(data);	
		}
	}

}
