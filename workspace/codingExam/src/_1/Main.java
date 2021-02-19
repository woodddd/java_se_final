package _1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Student st1 = new Student("손오공","1682");
		Student st2 = new Student("저팔계","1672");
		Student st3 = new Student("사오정","1813");
		
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
			System.out.println("계속 검색을 하고싶으면 y, 종료하고싶으면 n");
			String input = scan.next();
			boolean flag = false; 
			
			if(input.equals("y")) {
				System.out.println("검색을 시작합니다.");
				String name = scan.next();
				
				for(Student stu : list) {
					if(stu.getName().equals(name)) {
						System.out.println("해당하는 학생의 학번은 : " + stu.getNo());
						flag = true;
					}
				}
				
				if(!flag) {
					System.out.println("해당하는 학생 이름이 없습니다.");
				}
			}else if(input.equals("n")) {
				break;
			}else {
				System.out.println("잘못입력하였습니다.");
			}
		}
		
		System.out.println("종료되었습니다.");
		
		
		

	}

}
