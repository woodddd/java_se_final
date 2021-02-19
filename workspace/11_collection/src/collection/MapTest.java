package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapTest {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("book101", "�鼳����");
		map.put("book201", "�ξ����");
		map.put("book102", "�鼳����"); //value �ߺ����
		map.put("book301", "�ǿ���");
		map.put("book101", "��������"); //key �ߺ����
		
		System.out.println(map.get("book101"));//��������
		System.out.println(map.get("book102"));//�鼳����
		System.out.println();
		
		//�ڵ� �Է�: book501
		//���� key�Դϴ�
		
		//�ڵ� �Է�: book201
		//�ξ����
		
		
		// if(map.containsKey(key))
		//    System.out.println(map.get(key));
		//else 
		//    System.out.println("����  key�Դϴ�");
		
		while(true) {
		System.out.print("�ڵ� �Է�: ");
		Scanner scan = new Scanner(System.in);
		String key = scan.next();
		
		if(map.get(key) == null) {
			System.out.println("���� key�Դϴ�");
			System.out.println();
		}else {
			System.out.println(map.get(key));
			System.out.println();
		}
	  }
		
	}

}
