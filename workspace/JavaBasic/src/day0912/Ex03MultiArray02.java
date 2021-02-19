package day0912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//반 별로, 국영수 점수를 따로 관리하는 프로그램을 작성해보세요 (점심시간 전까지)
//반의 총 갯수는 4개입니다.
//한 반의 최대 학생수는 10명입니다.
//만약 입력이 안된 반은
//입력이 안되었다고 출력되게 하세요.

//입력을 선택하면
//몇반인지 입력을 받고
//그 반의 학생수를 입력받고
//그리고 그반 학생들의 국영수 점수를 차례 대로 입력받게 하세요.
public class Ex03MultiArray02 {
   //최대 학생 수 체크용 상수
   final static int STUDENT_SIZE = 10;
   //반의 총 갯수
   final static int CLASS_NUMBER = 4;
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      // 입력을 받을때 사용할 BufferedReader 변수 (= 객체) 생성
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      // 점수를 저장할 int[][][] scoreArray 생성
      int[][][] scoreArray = new int[CLASS_NUMBER][][];
      //위 코드의 의미는
      //scoreArray는 int의 3차원 배열인데 int 2차원 배열이 CLASS_NUMBER개 만큼 모여있다 라는 의미가 된다.
      
      //우리가 scoreArray[0]을 사용할려면
      //그 0번이 어떤 크기의 2차원 배열로 이루어져있는지를 지정해야한다.
      //scoreArray[0] = new int[stduentSize][]
      //이렇게 적으면
      //scoreArray의 0번 인덱스는 studentSize가 크기인 2차원 배열이다.
      
      //scoreArray[0] = new int[studentSize][3]
      //이렇게 적으면
      //scoreArray의 0번 인덱스는 int가 3개 모여있는 int 1차원 배열이 studentSize 만큼 모여있는 int 2차원 배열이다.
      
      
      //scoreArray[0]은 무엇을 뜻하는가?
      //scoreArray[0][3]
      //scoreArray[0][3][1] 
      
      //scoreArray[classNumber] = new int[studentNumber][3] 의 의미는
      //scoreArray의 classNumber 인덱스는 int 2차원 배열이고 크기는 2차원은 studentNumber, 1차원은 3의 크기란 의미이다.
      
      //int[4] 는 int가 4개 모여있다
      //int[2][4] 는 
      //       int가 4개 모여있는 배열이
      //       2개 모여잇다.
      
      //int [5][2][4] 는
      //      int가 4개 모여있는 배열이
      //      2개 모여서 하나의 배열이 되고
      //      그러한 배열이 5개 모여있다 라는 의미가 된다.
      // int[][][] arr = int[5][2][4] 
      //    -arr[0]: int[2][4] 
      //       arr[0][0]: int[4]
      //         arr[0][0][0]: int
      //         arr[0][0][1]: int
      //         arr[0][0][2]: int
      //         arr[0][0][3]: int
      //       arr[0][1]:  int[4]
      //         int, int, int, int
      //    -arr[1]: int[2][4]
      //       - int[4]
      //         int, int, int, int
      //       - int[4]
      //         int, int, int, int
      //    -arr[2]: int[2][4]
      //       - int[4]
      //         int, int, int, int
      //       - int[4]
      //         int, int, int, int
      //    -arr[3]: int[2][4]
      //       - int[4]
      //         int, int, int, int
      //       - int[4]
      //         int, int, int, int
      //    -arr[4]: int[2][4]
      //       - int[4]
      //         int, int, int, int
      //       - int[4]
      //         int, int, int, int
      
      
      // int[] arr = new int[5]
      // 이건 int가 5개 모인것이다.
      
      // int[][] arr = new int[3][5]
      // 이것은 int[]이 3개가 모인게 arr이다
      // 그렇다면 arr[0]은 무엇인가?
      // int[5] 이다
      // 더 자세하게 말하면 arr[0]은 int 배열의 배열이다
      
      // int[][][] arr = new int[2][3][5]
      // 이것은 int[][]이 2개 모인게 arr이다
      // 그렇다면 arr[0]은 무엇인가?
      // int[3][5]
      // 더 자세하게 말하면 arr[0]은 int 배열이 모여있는 배열이 모여있는 것이다.
      // 여기서
      // arr[0]을 가면 2차원 배열(int[3][5])이 있다.
      // arr[0][0]을 가면 1차원 배열(int[5])이 있다.
      // arr[0][0][0]을 가면 int가 있다.
      
      
      
      while(true) {
         //메뉴 메소드 호출
         showMenu();
         int choice = Integer.parseInt(bufferedReader.readLine());
         if(choice == 1) {
            //성적을 입력하기
            
            //1. 반을 선택한다.
            int classNumber = selectClassNumber(bufferedReader);
            //2. 학생 규모를 선택한다.
            int studentSize = selectStudentSize(bufferedReader);
            //3. for문을 이용해서 학생의 성적을 차례대로 넣어준다.
            
            //클래스넘버가 0
            //studentSize 가 4
            //scoreArray[0] 은 int가 3개 모여있는 배열이 4개가 모여있는 2차원 배열이다
            
            //클래스 넘버가 1
            //studentSize가 6
            //scoreArray[1] 은 int가 3개 모여있는 배열이 6개 모여있는 2차원 배열이다
            
            //클래스 넘버가 2
            //studentSize가 7
            //scoreArray[2] 는 int가 3개 모여있는 배열이 7개 모여있는 2차원 배열이다
            
            //클래스 넘버가 3
            //studentSize가 2
            //scoreArray[3] 은 int가 3개 모여있는 배열이 2개 모여있는 2차원 배열이다
            
            //그렇다면
            //scoreArray는 2차원 배열이 4개 모여있는 3차원 배열이 된다 -> o
            
            //int[][][] scoreArray = new int[CLASS_NUMBER][][]은
            //scoreArray는 int 2차원 배열이 CLASS_NUMBER 만큼 모여있는 3차원 배열이다
            
            //그렇다면 scoreArray[0]은 무엇인가?
            //1. int
            //2. int[]
            //3. int[][] -> o
            //4. int[][][]
            
            //int[] arr = new int[5]
            //라고 하면
            //int[0] 은 int가 된다.
            
            // scoreArray[classNumber] = new int[studentSize][3]; 
            // scoreArray의 classNumber 인덱스는
            // int 2차원 배열이다
            // 2차원 배열인데 int가 3개모여있는 배열이 studentSize개 만큼 모여있는 배열이다.
            
            // 다차원 배열 같은 경우에는
            // 남자+군필일 경우
            // 부대 구조를 생각하면 편하다!
            // 중대 소대 분대 병사
            // 병사가 모여서 분대
            // 분대가 모여서 소대
            // 소대가 모여서 중대
            
            // 쇼핑 카테고리를 생각해보자
            // 음식 - 배달 - 한식   - 아빠손야식
            //                - 엄마손야식
            //                - 김가네
            //                - 바른김밥
            //          - 중식
            //          - 일식
            //          - 양식
            //    - 컵라면
            //    - 조리
            
            
            
            
            scoreArray[classNumber] = new int[studentSize][3];
            for(int i = 0; i < scoreArray[classNumber].length; i++) {
               System.out.println((i+1)+"번 학생의 점수 입력");
               scoreArray[classNumber][i][0] = validateScore(bufferedReader, 1);
               scoreArray[classNumber][i][1] = validateScore(bufferedReader, 2);
               scoreArray[classNumber][i][2] = validateScore(bufferedReader, 3);
            }
            
         }else if(choice == 2) {
            //성적을 출력하기
            //1. 반을 입력받는다.
            int classNumber = selectClassNumber(bufferedReader);
            
            //2. 해당 반이 초기화되었는지 체크한다.
            if(scoreArray[classNumber] == null) {
               //아직 초기화 안되있으므로 경고 메시지 출력
               System.out.println("아직 입력이 되지 않은 반입니다.");
            }else {
            //3. 초기화 되어있으면 출력한다.
               for(int i = 0; i < scoreArray[classNumber].length; i++) {
                  System.out.println("=======================");
                  System.out.println((i+1)+"번 학생의 점수");
                  System.out.printf("국어: %3d점 영어: %3d점 수학: %3d점\n", 
                        scoreArray[classNumber][i][0], scoreArray[classNumber][i][1], scoreArray[classNumber][i][2]);
               }
            }
         }else if(choice == 3) {
            System.out.println("사용해주셔서 감사합니다.");
            break;
         }else {
            System.out.println("잘못입력하셨습니다.");
         }
      }
   }
   static void showMenu() {
      System.out.println("======================");
      System.out.println("비트고등학교 성적관리 프로그램");
      System.out.println("======================");
      System.out.println("|\t1. 입력\t|");
      System.out.println("|\t2. 출력\t|");
      System.out.println("|\t3. 종료\t|");
   }
   static int selectClassNumber(BufferedReader reader) throws NumberFormatException, IOException {
      System.out.println("반을 선택해주세요");
      System.out.print("> ");
      int classNumber = Integer.parseInt(reader.readLine());
      while(classNumber < 1 || classNumber > CLASS_NUMBER) {
         System.out.println("잘못입력하셨습니다.");
         System.out.println("반을 선택해주세요");
         System.out.print("> ");
         classNumber = Integer.parseInt(reader.readLine());
      }
      
      return classNumber - 1;
   }
   static int selectStudentSize(BufferedReader reader) throws NumberFormatException, IOException {
      System.out.println("학생 숫자를 선택해주세요");
      System.out.print("> ");
      int studentSize = Integer.parseInt(reader.readLine());
      
      while(studentSize < 0 || studentSize > STUDENT_SIZE) {
         System.out.println("잘못입력하셨습니다.");
         System.out.println("학생 숫자를 선택해주세요");
         System.out.print("> ");
         studentSize = Integer.parseInt(reader.readLine());
      }
      
      return studentSize;
   }
   static int validateScore(BufferedReader reader, int code) throws NumberFormatException, IOException {
      String message = new String();
      switch(code) {
      case 1:
         message = "국어";
         break;
      case 2:
         message = "영어";
         break;
      case 3:
         message = "수학";
         break;
      }
      message += " 점수를 입력해주세요.";
      System.out.println(message);
      System.out.print("> ");
      int score = Integer.parseInt(reader.readLine());
      while(score < 0 || score > 100) {
         System.out.println("잘못 입력하셨습니다.");
         System.out.println(message);
         System.out.print("> ");
         score = Integer.parseInt(reader.readLine());
      }
      
      return score;
   }
}












