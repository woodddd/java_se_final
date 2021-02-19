package day0916;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0915.Student;//package day0915.Student 클래스를 참조

public class Ex01Student02 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Student sd = new Student();
		
		while(true) {
			System.out.println("비트 학생 관리 프로그램");
			System.out.println("1. 입력 2. 출력 3. 종료");
			int choice = Integer.parseInt(br.readLine());
			
			if(choice == 1) {
				System.out.print("이름: ");
				sd.setName(br.readLine());
				System.out.print("국어점수: ");
				sd.setKorean(Integer.parseInt(br.readLine()));
				System.out.print("영어점수: ");
				sd.setEnglish(Integer.parseInt(br.readLine()));
				System.out.print("수학점수: ");
				sd.setMath(Integer.parseInt(br.readLine()));
				System.out.print("id: ");
				sd.setId(Integer.parseInt(br.readLine()));
			}else if(choice == 2 ) {
				
				if(sd.getName().equals("")) { //sd.getName().isEmpty() 를 사용해 줘도 됨. 값이 없으면 true 값이 있으면 false
					System.out.println("아직 입력된 정보가 없습니다.");
				}else {
					System.out.printf("이름 : %s\t국어점수 : %d\t영어점수 : %d\t수학점수 : %d\tid : %d\n", sd.getName(),sd.getKorean(), sd.getEnglish(), sd.getMath(), sd.getId());
					System.out.printf("%s 학생의 총점 : %d점 평균 : %.2f점\n",sd.getName(),sd.calculateSum(),sd.calculateAverage());
				}
			}else if (choice == 3){
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}

}
