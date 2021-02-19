package day0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//다차원 배열
//똑같은 데이터타입이 모여있는 것을 우리가 배열이라고 한다.
//그럼 배열이 모여있는건?

//대표적인 다차원 배열의 예시가
//학교의 학생들의 국어점수 배열
//[1학년][몇반][몇번의 점수]
//[2학년][몇반][몇번의 점수]
//[3학년][몇반][몇번의 점수]

public class Ex06MultiDimensionArray {
	final static int YEAR = 3;
	final static int TESTNUM = 4;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		//int 2차원 배열을 만들어보자
		int[][] array = new int[2][3];
		//이 2차원 배열은
		//int가 3개 들어갈 수 있는 배열 2개가 모여있다 라는 뜻이 된다.
		
		for(int i = 0; i < array.length; i++) {//array.length = 2 //int가 3개 들어갈 수 있는 배열 2개가 모여있다 라는 뜻이 된다.
			for(int j = 0; j < array[i].length; j++) {//array[i].length = //배열의 길이  = 3 개의 int 값
				System.out.println("i: " + i + ", j: " + j);
			}
		}

		//우리가 각 배열에 값을 넣을 때에는
		//1차원에서는
		//배열이름[인덱스] = 얼마;
		//이렇게 넣었지만
		
		//2차원배열에서는
		//배열이름[몇번째배열][인덱스] = 얼마
		//이렇게 넣어야 한다.
		
		//그럼array의 0번째 배열 2번 인덱스에 10을 넣어보세요
		array[0][2] = 10;
		
		//학생의 점수를 관리하는 배열을 만들 되
		//1,2,3학년
		//각각의 1학기 중간 1학기 기말, 2학기 중간 2학기 기말 을 관리하는
		//배열을 선언해보세요!
		
		
		
			int[][] koreanArray = new int[YEAR][TESTNUM];
			int[][] englishArray = new int[YEAR][TESTNUM];
			int[][] mathArray = new int[YEAR][TESTNUM];
			
			int year = 0;
			int number = 0;
			int korean = 0;
			int english = 0;
			int math = 0;
			int menu = 0;
			//사용자로부터 몇학년 몇번째 시험점수인지 입력받아서
			//해당 위치에 점수를 넣는 코드를 구현하시오
			//조건1. 잘못된 학년이 입력되지않게 하시오
			//조건2. 몇번쨰 시험점수를 입력받을 때 잘못된 순서가 입력되지 않게 하시오.
			//조건3. 점수가 올바른 점수만 입력되게 하시오.
			
			//예시
			//몇학년 점수입니까? (입력4)
			//올바르지 않은 학년입니다.
			//몇학년 점수입니까? (입력 2)
			//몇번쨰 시험입니까? (입력 -2)
			//올바르지 않은 순서입니다.
			//몇번쨰 시험입니까? (입력 1)
			//몇점입니까? (입력 80)
			//2학년 1학기 중간고사 국어에 80점이 입력되었습니다.
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Ex06MultiDimensionArray mt = new Ex06MultiDimensionArray();
			
			
			
		while(true) {
			
			System.out.println("1.입력");
			System.out.println("2.출력");
			menu = Integer.parseInt(br.readLine());
			
			while(menu < 1 || menu > 2) {
				System.out.println("메뉴값을 잘못 입력 하였습니다.");
				System.out.println("값을 다시 입력해주세요.");
				menu = Integer.parseInt(br.readLine());
				}
			
			if(menu == 1) {
				
			System.out.print("몇학년 점수입니까?");
			year = mt.schoolyear(br);
			
			
			System.out.print("몇 번째 시험입니까?");
			number = mt.whattest(br);
			
			
			System.out.print("국어점수 : " );
			korean = mt.Testscore(br);
			
			System.out.print("영어점수 : " );
			english = mt.Testscore(br);
			
			System.out.print("수학점수 : " );
			math = mt.Testscore(br);
			
			}else if( menu == 2) {
			
			koreanArray[year-1][number-1] = korean;
			englishArray[year-1][number-1] = korean;
			mathArray[year-1][number-1] = korean;
			System.out.print(year + "학년 ");
			switch(number) {
			case 1:
				System.out.print("1학기 중간");
				break;
			case 2:
				System.out.print("1학기 기말");
				break;
			case 3:
				System.out.print("2학기 중간");
				break;
			case 4:
				System.out.print("2학기 기말");
				break;
			}
			
			System.out.println();
			System.out.println(" 국어에" + korean + "점이 입력되었습니다.");
			System.out.println(" 영어에" + english + "점이 입력되었습니다.");
			System.out.println(" 수학에" + math + "점이 입력되었습니다.");
			//주말 숙제
		      //위 내용을 
		      //1차: 국어, 영어, 수학 순으로 관리 할 수 있게 변경하고
		      //2차: 무한루프를 이용하여 메뉴를 통해서 입력과 출력을 할 수 있게 바꾸고
		      //3차: 메소드를 분리해보세요.
		      
		      //출력 예시: 2학년 1학기 중간고사 국어에 80점이 입력되었습니다.
			
	//		[실행 결과]
	//				1학년 1학기 중간 
	//				국어 40 영어 50 수학 45
			}
		}
		
	}
		public int schoolyear(BufferedReader a) throws NumberFormatException, IOException{
			int year = Integer.parseInt(a.readLine());
			while( year < 1 || year > 3) {
				System.out.println("잘못된 학년입니다.");
				System.out.print("몇학년 점수입니까?");
				year = Integer.parseInt(a.readLine());
			}
			return year;
		}
		
		public int whattest(BufferedReader a) throws NumberFormatException, IOException {
			int number = Integer.parseInt(a.readLine());
			while(number < 1 || number > 4) {// 1. 1학기 중간	2. 1학기 기말	3. 2학기 중간	4. 2학기 기말
				System.out.println("잘못된 입력입니다");
				System.out.print("몇 번째 시험입니까?");
				number = Integer.parseInt(a.readLine());
			}
			return number;
		}
		
		public int Testscore(BufferedReader a) throws NumberFormatException, IOException {
			int score = Integer.parseInt(a.readLine());
			while(score < 0 || score > 100) {
				System.out.println("잘못된 점수입니다.");
				System.out.print("점수를 다시 입력해주세요. : " );
				score = Integer.parseInt(a.readLine());
			}
			return score;
		}
	

}
