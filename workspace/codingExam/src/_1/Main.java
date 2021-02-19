package _1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Student st1 = new Student("�տ���","1682");
		Student st2 = new Student("���Ȱ�","1672");
		Student st3 = new Student("�����","1813");
		
		ArrayList<Student> list = new ArrayList<Student>();
		
		list.add(st1);
		list.add(st2);
		list.add(st3);
		
		for(Student stu : list) {
			System.out.println(stu.getName());
			System.out.println(stu.getNo());
			System.out.println();
		}
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("��� �˻��� �ϰ������ y, �����ϰ������ n");
			String input = scan.next();
			boolean flag = false; 
			
			if(input.equals("y")) {
				System.out.println("�˻��� �����մϴ�.");
				String name = scan.next();
				
				for(Student stu : list) {
					if(stu.getName().equals(name)) {
						System.out.println("�ش��ϴ� �л��� �й��� : " + stu.getNo());
						flag = true;
					}
				}
				
				if(!flag) {
					System.out.println("�ش��ϴ� �л� �̸��� �����ϴ�.");
				}
			}else if(input.equals("n")) {
				break;
			}else {
				System.out.println("�߸��Է��Ͽ����ϴ�.");
			}
		}
		
		System.out.println("����Ǿ����ϴ�.");
		
		
		

	}

}
