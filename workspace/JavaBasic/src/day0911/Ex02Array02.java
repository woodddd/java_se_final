package day0911;
//Ex01 업그레이드버젼
//총점이 아니라 
//국영수 점수를 관리하는
//무한루프 프로그램을 작성하시오(20분까지)

//조건 1. 처음 입력시에는 for 반복문을 사용해서 5명의 이름과 국영수 점수를 다 입력한다.
//조건 2. 입력후에는 무한루프를 통해서
//    내가 보고 싶은 학생의 이름과 점수, 총점, 평균만 볼수 있게 한다.
//예시:
//보고 싶은 학생의 번호를 입력하세요: (1입력)
//1번 김땡땡 학생
//국어: 80점 영어: 80점 수학: 81점
//총점: 241점 평균: 80.33점
//보고 싶은 학생의 번호를 입력하세요: (20000 입력)
//잘못입력하셨습니다.
//보고 싶은 학생의 번호를 입력하세요: (2입력)
//2번 최동동 학생
//국어: 70점 영어: 69점 수학: 68점
//총점: 207점 평균: 69점
//보고 싶은 학생의 점수를 입력하세요: (-1입력)
//사용해주셔서 감사합니다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02Array02 {
	
	final static int SIZE = 5 ;
	
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//이름을 담당할 배열을 하나 만들자
		String[] nameArray = new String[SIZE];
		//총점을 담당할 배열을 하나 만들자
		int[] sumArray = new int[SIZE];
		double[] avgArray = new double[SIZE];
		int[] korean = new int[SIZE];
		int[] english = new int[SIZE];
		int[] math = new int[SIZE];
		
		for(int i = 0; i < SIZE ; i++) {
			System.out.print((i + 1) + "번 학생의 이름: ");
			nameArray[i] = br.readLine();
			
			System.out.print(nameArray[i] + " 학생의 국어점수 : ");
			korean[i] = Integer.parseInt(br.readLine());
			
			while(korean[i] < 0 || korean[i] > 100) {
				System.out.println("잘못입력하셨습니다.");
				System.out.print(nameArray[i] + " 학생의 국어점수: ");
				korean[i] = Integer.parseInt(br.readLine());
			}
			System.out.print(nameArray[i] + " 학생의 영어점수: ");
			english[i] = Integer.parseInt(br.readLine());
			
			while(english[i] < 0 || english[i] > 100) {
				System.out.println("잘못 입력하셨습니다.");
				System.out.println(nameArray[i] + " 학생의 영어점수 : ");
				english[i] = Integer.parseInt(br.readLine());
			}
			
			System.out.print(nameArray[i] + " 학생의 수학점수: ");
			math[i] = Integer.parseInt(br.readLine());
			
			while(math[i] < 0 || math[i] > 100) {
				System.out.println("잘못입력하셨습니다.");
				System.out.print(nameArray[i] + " 학생의 수학점수: ");
				math[i] = Integer.parseInt(br.readLine());
			}
			
			sumArray[i] = korean[i] + english[i] + math[i];
			avgArray[i] = (double)(korean[i] + english[i] + math[i]) / 3;
		}
		
		while(true) {
			System.out.println("보고싶은 학생의 번호를 입력하세요 : ");
			int userChoice = Integer.parseInt(br.readLine());
			if(userChoice == -1) {
				System.out.println("사용해주셔서 감사합니다.");
				break; 
			}else if(userChoice >= 1 && userChoice <= 5){
				int index = userChoice -1;
				System.out.println(userChoice + "번 " + nameArray[index] + " 학생");
				System.out.println("국어 : " + korean[index] + "\t" + "영어 : " + english[index] + "\t" + "수학 : " + math[index]);
				System.out.println("총점 : " + sumArray[index] + "\t" + "평균 : " + String.format("%.2f", avgArray[index]));
			}else {
				System.out.println("잘못 입력하였습니다.");
			}
			
		}
		
		

	}

}
