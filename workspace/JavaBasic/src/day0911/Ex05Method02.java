package day0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//리턴타입이 없는 메소드
//그리고 메소드 중간에 리턴하는 메소드
public class Ex05Method02 {
   //1. 리턴 타입이 없는 메소드
   //   아무것도 리턴하지 않을 때에는 void라고 적어주고
   //   또한 그러한 경우엔 return 명령어를 쓰지 않는다.
   static void showMenu() {
      System.out.println("----------------------");
      System.out.println("비트고등학교 성적관리 프로그램");
      System.out.println("\t1. 입력");
      System.out.println("\t2. 출력");
      System.out.println("\t3. 종료");
   }
   public static void main(String[] args) throws NumberFormatException, IOException {
	   
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int korean = 0;
      int math = 0;
      int english = 0;
      String name = new String();
      
      while(true) {
         showMenu();
         int userChoice = Integer.parseInt(br.readLine());
         if(userChoice == 1) {
            //입력 메소드 실행
            
            // 점수를 입력받아서 유효한 점수를 리턴해주는 메소드를 만들어서
            // 국영수 점수에 입력 시키시오
            System.out.print("이름: ");
            name = br.readLine();
            
            System.out.print("국어 ");
            korean = validateScore(br);
            
            System.out.print("영어 ");
            english = validateScore(br);
            
            System.out.print("수학 ");
            math = validateScore(br);
         }else if(userChoice == 2) {
            //출력 메소드 실행
            
            // 파라미터로 넘어온 이름, 국영수 점수를 
            // 예쁘게 출력하는 메소드를 작성하시오
            printScore(name, korean, english, math);
         }else if(userChoice == 3) {
            System.out.println("사용해주셔서 감사합니다.");
            break;
         }
      }
   }
   static int validateScore(BufferedReader a) throws NumberFormatException, IOException {//BufferedReader a ---> BufferedReader 에 있는 변수 의 값을 받겠다는 의미!!! 그 변수의 이름이 a로 그냥 잡아 놓은거임. int a 와 같이.
	   						// 즉System.out.print("국어 "); korean = validateScore(br); 의 br 을 a 에 넣어 Main 메소드의 BufferedReader br을 a 에 넣어주는거임
	   						// 이렇게 되면 Main 메소드에서 BufferedReader br = new BufferedReader... 로 BufferedReader 를 선언하였으므로
	   						//  validateScore 메소드에선    BufferedReader 을 사용할 수 있는 것임.
	   System.out.print("점수를 입력하세요: ");
      int score = Integer.parseInt(a.readLine());
      
      while(score < 0 || score > 100) {
         System.out.println("잘못 입력하셨습니다.");
         System.out.print("점수를 입력하세요: ");
         score = Integer.parseInt(a.readLine());
      }
      return score;
   }
   
   static void printScore(String name, int korean, int english, int math) {
      System.out.println("=========================");
      System.out.println("\t이름: "+name);
      System.out.printf("국어: %d 영어: %d 수학: %d\n", korean, english, math);
      int sum = korean + english + math;
      double average = sum / (double)3;
      System.out.printf("총점: %d 평균: %.2f\n", sum, average);
   }
}








