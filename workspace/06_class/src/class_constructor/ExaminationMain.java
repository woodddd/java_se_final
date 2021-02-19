package class_constructor;

import java.util.Scanner;

/*
5문제의 시험지 채점하는 프로그램
1번부터 5번까지 모든 답은 전부 1번이다.
1문제당 20점씩 계산한다.

이름 입력 : 홍길동
답 입력 : 12311

이름		1 2 3 4 5   점수
홍길동         O X X O O  60       
----------------------
객체 배열
인원수 입력: 3

이름 입력 : 홍길동
답 입력    : 13211

이름 입력 : 코난
답 입력    : 11111

이름 입력 : 또치
답 입력    : 13242

이름		1 2 3 4 5   점수
홍길동         O X X O O  60  
코난            O O O O O  100
또치            O X X X X  20
 */

public class ExaminationMain {

	public static void main(String[] args) {
		String name;
		String dap;
		int person;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("인원수 입력 : ");
		person = scan.nextInt();
		
		Examination[] ex = new Examination[person];
		
		for(int i = 0 ; i < person ; i++) {
		ex[i] = new Examination();
		ex[i].compare();
		}
		System.out.println();
		
		System.out.println("이름" + "\t" + "1 " + "2 " + "3 " + "4 " + "5 " + "점수");
		for(int i = 0; i < person ; i++) {
			System.out.println(ex[i].getName() + "\t" + ex[i].getOx()[0] + " " + ex[i].getOx()[1] + " " + ex[i].getOx()[2] + " " + ex[i].getOx()[3] + " " + ex[i].getOx()[4] + " " + ex[i].getScore());
		}
		
	}

}
