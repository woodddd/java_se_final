package day0911;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

//2개의 배열을 동시에 사용해서
//이름과 총점을 동시에 관리해보자

public class Ex01Array {
	final static int SIZE = 5;

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//이름을 담당할 배열을 하나 만들자
		String[] nameArray = new String[SIZE];
		//총점을 담당할 배열을 하나 만들자
		int[] sumArray = new int[SIZE];
		
		//차례대로 입력을 해보자
		for(int i = 0; i < SIZE ; i++) {
			System.out.print((i + 1) + "번 학생의 이름: ");
			nameArray[i] = br.readLine();
			System.out.print(nameArray[i] + " 학생의 국어점수 : ");
			int korean = Integer.parseInt(br.readLine());
			while(korean < 0 || korean > 100) {
				System.out.println("잘못입력하셨습니다.");
				System.out.print(nameArray[i] + " 학생의 국어점수: ");
				korean = Integer.parseInt(br.readLine());
			}
			System.out.print(nameArray[i] + " 학생의 영어점수: ");
			int english = Integer.parseInt(br.readLine());
			while(english < 0 || english > 100) {
				System.out.println("잘못 입력하셨습니다.");
				System.out.println(nameArray[i] + " 학생의 영어점수 : ");
				english = Integer.parseInt(br.readLine());
			}
			
			System.out.print(nameArray[i] + " 학생의 수학점수: ");
			int math = Integer.parseInt(br.readLine());
			while(math < 0 || math > 100) {
				System.out.println("잘못입력하셨습니다.");
				System.out.print(nameArray[i] + " 학생의 수학점수: ");
				math = Integer.parseInt(br.readLine());
			}
			
			sumArray[i] = korean + english + math;
		}
		//보고싶은 학생의 번호를 입력하면 그 학생의 정보를 출력하게 만들어보자
		while(true) {
		System.out.print("보고싶은 학생의 번호를 입력하세요(1~5): ");
		int userChoice = Integer.parseInt(br.readLine()) - 1 ;// 사람은 1번 부터 시작하지만 배열은 0번부터 시작함. 그래서 - 1
			if(userChoice == -2) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}else if(userChoice < 0 || userChoice > SIZE - 1) {// SIZE 에 -1 일 하는 이유. SIZE 는 5이지만 userChoice의 허용 범위는 index 범위 이므로 0~ 4 까지 값이 저장 되어 있음. 
				System.out.println("잘못 입력하셨습니다.");
			}else{
				System.out.println(nameArray[userChoice] + " 학생의 총점: " + sumArray[userChoice]);
			}
		
		}
	
		
		
		
	}

}
