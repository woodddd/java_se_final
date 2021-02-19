package day0918;
// 차량관리 프로그램

// 1. 입력
//    입력시에는 배열에 이미 똑같은 번호가 있을 시에는 차량 번호를 다시 입력받게 하세요
// 2. 목록 출력
//    목록 출력시에는  
//            1. 차량번호
//            2. 차량번호
//            3. 차량번호
//    의 형식으로 목록이 출력되고 사용자가 번호를 선택하여 상세보기로 들어갈 수 있게 하세요
// 3. 상세 보기
//    목록에서 선택한 번호의 차량 상세보기로 들어가면
//    차량 번호 차량 종류 차량 색상
//    차량 연식 차량 가격
//      예시) 차량번호: 00가 0000 차량종류: 벤츠 차량색상: 검은색
//           차량연식: 2020 년형  차량가격: 20000000원 
//    이 출력되고 
//    수정 삭제 목록돌아가기 가 출력되게 만드세요
//    A) 수정
//       수정에는 색상, 연식, 가격을 수정할 수 있게 만드세요.
//    B) 삭제
//       삭제 시에는 사용자가 동의하면 삭제하고 목록으로 이동하고 동의하지 않을 시에는 해당 차량의 개별보기 페이지로 이동하세요
//    C) 목록보기
//       다시 목록으로 이동합니다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

import day0916.Car;
import util.ArrayUtil;

public class CarEx01T {
   private static BufferedReader bufferedReader;
   private static Car[] carArray;

   public static void main(String[] args) throws NumberFormatException, IOException {
      bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      carArray = new Car[0];
      showMenu();
   }

   // 메뉴를 보여주는 메소드
   private static void showMenu() throws NumberFormatException, IOException {
      while (true) {
         System.out.println("차량관리프로그램");
         System.out.println("1. 입력 2. 출력 3. 종료");
         int userChoice = Integer.parseInt(bufferedReader.readLine());
         if (userChoice == 1) {
            add();
         } else if (userChoice == 2) {
            printAll();
         } else if (userChoice == 3) {
            System.out.println("사용해주셔서 감사합니다.");
            break;
         } else {
            System.out.println("잘못입력하셨습니다.");
         }
      }
   }

   // 차량 추가하는 메소드
   private static void add() throws NumberFormatException, IOException {
      carArray = ArrayUtil.add(carArray, setCarInfo());
   }

   // 카 객체에 정보를 넣는 메소드
   private static Car setCarInfo() throws NumberFormatException, IOException {
      Car c = new Car();

      System.out.print("차량 번호: ");
      c.setNumber(bufferedReader.readLine());
      //동일차량번호 있으면 다시 입력을 받도록 만들어보자
      while(ArrayUtil.contains(carArray, c)) {
    	  System.out.println("이미 존재하는 차량번호입니다.");
    	  System.out.print("차량 번호 : ");
    	  c.setNumber(bufferedReader.readLine());
      }
      System.out.print("차량 종류: ");
      c.setType(bufferedReader.readLine());

      System.out.print("차량 색상: ");
      c.setColor(bufferedReader.readLine());

      System.out.print("차량 연식: ");
      c.setYear(validateIntegerValue(2000, 2020));

      System.out.print("차량 가격: ");
      c.setPrice(validateIntegerValue(0));

      return c;
   }

   private static int validateIntegerValue(int minimum) throws NumberFormatException, IOException {
      int value = Integer.parseInt(bufferedReader.readLine());
      while (value < minimum) {
         System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
         System.out.print("> ");
         value = Integer.parseInt(bufferedReader.readLine());
      }

      return value;
   }

   private static int validateIntegerValue(int minimum, int maximum) throws NumberFormatException, IOException {
      int value = Integer.parseInt(bufferedReader.readLine());
      while (value < minimum || value > maximum) {
         System.out.println("잘못입력하셨습니다. 다시 입력해주세요");
         System.out.print("> ");
         value = Integer.parseInt(bufferedReader.readLine());
      }

      return value;
   }

   private static void printAll() throws NumberFormatException, IOException {
      System.out.println("=========================");
      for (int i = 0; i < carArray.length; i++) {
         System.out.printf("%d. %s\n", (i + 1), carArray[i].getNumber());
      }
      System.out.println("=========================");
      System.out.println("개별 보기할 차량의 번호를 입력해주세요 (0은 종료)");
      System.out.print("> ");
      int userChoice = validateIntegerValue(0, carArray.length) - 1;
      if (userChoice == -1) {
         System.out.println("메인화면으로 돌아갑니다.");
      } else {
         printOne(userChoice);
      }
   }

   private static void printOne(int index) throws NumberFormatException, IOException {
      System.out.println("================================");
      System.out.printf("\t%s 차량 정보\n", carArray[index].getNumber());
      System.out.printf("차량 번호: %s | 차량 종류: %s | 차량 색상: %s\n", carArray[index].getNumber(), carArray[index].getType(),
            carArray[index].getColor());
      DecimalFormat format = new DecimalFormat("#,###");
      System.out.printf("차량 연식: %d년| 차량 가격: %s원\n", carArray[index].getYear(),
            format.format((long) carArray[index].getPrice()));
      System.out.println("=========================================");
      System.out.println("1. 수정 2. 삭제 3. 목록으로");
      System.out.print("> ");
      int userChoice = validateIntegerValue(1, 3);
      if (userChoice == 1) {
         // 수정 메소드 실행
         update(index);
      } else if (userChoice == 2) {
         // 삭제 메소드 실행
         delete(index);
      } else if (userChoice == 3) {
         // 메인 메뉴로 돌아가도록 printAll() 실행
         printAll();
      }
   }

   private static void update(int index) throws NumberFormatException, IOException {
      System.out.print("차량 색상: ");
      carArray[index].setColor(bufferedReader.readLine());

      System.out.print("차량 연식: ");
      carArray[index].setYear(validateIntegerValue(2000, 2020));

      System.out.print("차량 가격: ");
      carArray[index].setPrice(validateIntegerValue(0));
      
      printOne(index);
   }
   
   private static void delete(int index) throws IOException{
      System.out.println("해당 차량을 정말 삭제하시겠습니까? (y/n)");
      System.out.print("> ");
      String yn = bufferedReader.readLine();
      if(yn.equals("y")) {
         carArray = ArrayUtil.removeByIndex(carArray, index);
         printAll();
      }else if(yn.equals("n")) {
         printOne(index);
      }
   }
}










