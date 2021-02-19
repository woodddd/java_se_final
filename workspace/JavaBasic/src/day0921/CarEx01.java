package day0921;
//자동차 관리 프로그램을 ArrayList로 작성하세요(

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;

import day0916.Car;

public class CarEx01 {
   private static ArrayList<Car> list;
   private static BufferedReader bufferedReader;
   public static void main(String[] args) throws NumberFormatException, IOException {
      bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      list = new ArrayList<>();
      showMenu();
   }
   
   // 메뉴를 보여주는 메소드
      private static void showMenu() throws NumberFormatException, IOException {
         while (true) {
            System.out.println("차량관리프로그램");
            System.out.println("1. 입력 2. 출력 3. 종료");
            int userChoice = validateIntegerValue(1, 3);
            if (userChoice == 1) {
               add();
            } else if (userChoice == 2) {
               printAll();
            } else if (userChoice == 3) {
               System.out.println("사용해주셔서 감사합니다.");
               break;
            }
         }
      }

      // 차량 추가하는 메소드
      private static void add() throws NumberFormatException, IOException {
         Car c = new Car();
         System.out.print("차량 번호: ");
         c.setNumber(bufferedReader.readLine());
         //차량번호 있으면 다시 입력을 받도록 만들어보자
         while(list.contains(c)) {
            System.out.println("이미 존재하는 차량번호입니다.");
            System.out.print("차량 번호: ");
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
         
         list.add(c);
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
         for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s\n", (i + 1), list.get(i).getNumber());
         }
         System.out.println("=========================");
         System.out.println("개별 보기할 차량의 번호를 입력해주세요 (0은 종료)");
         System.out.print("> ");
         int userChoice = validateIntegerValue(0, list.size()) - 1;
         if (userChoice == -1) {
            System.out.println("메인화면으로 돌아갑니다.");
         } else {
            printOne(userChoice);
         }
      }

      private static void printOne(int index) throws NumberFormatException, IOException {
         System.out.println("================================");
         System.out.printf("\t%s 차량 정보\n", list.get(index).getNumber());
         System.out.printf("차량 번호: %s | 차량 종류: %s | 차량 색상: %s\n", list.get(index).getNumber(), list.get(index).getType(),
               list.get(index).getColor());
         DecimalFormat format = new DecimalFormat("#,###");
         System.out.printf("차량 연식: %d년| 차량 가격: %s원\n", list.get(index).getYear(),
               format.format((long) list.get(index).getPrice()));
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
         list.get(index).setColor(bufferedReader.readLine());

         System.out.print("차량 연식: ");
         list.get(index).setYear(validateIntegerValue(2000, 2020));

         System.out.print("차량 가격: ");
         list.get(index).setPrice(validateIntegerValue(0));
         
         printOne(index);
      }
      
      private static void delete(int index) throws IOException{
         System.out.println("해당 차량을 정말 삭제하시겠습니까? (y/n)");
         System.out.print("> ");
         String yn = bufferedReader.readLine();
         if(yn.equals("y")) {
            list.remove(index);
            printAll();
         }else if(yn.equals("n")) {
            printOne(index);
         }
      }
}