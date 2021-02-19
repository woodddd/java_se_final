package day0921;
// 어레이리스트를 사용한 게시판 관리 프로그램

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BoardEx02 {
   private static ArrayList<Board> list;
   private static BufferedReader bufferedReader;
   //int 변수를 하나 만들어서
   //글을 쓸 때마다 그 번호가 올라가고
   //사용자가 글을 쓸 때 글 번호를 직접 입력하는게 아니라
   //그 변수의 값을 받아와서 쓰는 방법을 만들어보자
   private static int seq = 1;
   
   public static void main(String[] args) throws NumberFormatException, IOException {
      list = new ArrayList<>();
      bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      showMenu();
   }

   private static void showMenu() throws NumberFormatException, IOException {
      while (true) {
         System.out.println("게시판 관리 프로그램");
         System.out.println("1. 입력 2. 출력 3. 종료");
         int choice = validateNumber(1, 3);
         if (choice == 1) {
            add();
         } else if (choice == 2) {
            selectAll();
         } else if (choice == 3) {
            System.out.println("사용해주셔서 감사합니다!");
            break;
         }
      }
   }

   private static void selectAll() throws NumberFormatException, IOException {
      System.out.println("===글목록===");
      for (int i = 0; i < list.size(); i++) {
         System.out.printf("%d. %s\n", (i + 1), list.get(i).getTitle());
      }
      System.out.println("개별보기할 글 번호를 입력해주세요(0은 메인으로)");
      int choice = validateNumber(0, list.size()) - 1;
      if (choice == -1) {
         System.out.println("메인 메뉴로 이동합니다.");
      } else {
         selectOne(choice);
      }
   }

   private static void selectOne(int index) throws NumberFormatException, IOException {
      Board b = list.get(index);
      System.out.println("제목: " + b.getTitle());
      System.out.println("작성자: " + b.getWriter());
      System.out.println("내용: " + b.getContent());
      System.out.println("======================");
      System.out.println("1. 수정 2. 삭제 3. 목록으로");
      int choice = validateNumber(1, 3);
      if (choice == 1) {
         update(index);
      } else if (choice == 2) {
         delete(index);
      } else if (choice == 3) {
         selectAll();
      }
   }

   private static void update(int index) throws IOException {
      System.out.print("제목: ");
      list.get(index).setTitle(bufferedReader.readLine());
      System.out.print("작성자: ");
      list.get(index).setWriter(bufferedReader.readLine());
      System.out.print("내용: ");
      list.get(index).setContent(bufferedReader.readLine());
      selectOne(index);
   }

   private static void delete(int index) throws IOException {
      System.out.print("정말로 삭제하시겠습니까? ");
      String yn = bufferedReader.readLine();
      if (yn.equals("y")) {
         list.remove(index);
      } else if (yn.equals("n")) {
         selectOne(index);
      }
   }

   private static void add() throws NumberFormatException, IOException {
      Board b = new Board();
      System.out.print("글 번호: ");
      b.setId(seq);
      seq++;

      System.out.print("글 제목: ");
      b.setTitle(bufferedReader.readLine());

      System.out.print("글 작성자: ");
      b.setWriter(bufferedReader.readLine());

      System.out.print("글 내용: ");
      b.setContent(bufferedReader.readLine());

      list.add(b);
   }

   private static int validateNumber(int minimum, int maximum) throws NumberFormatException, IOException {
      System.out.print("> ");
      int value = Integer.parseInt(bufferedReader.readLine());
      while (value < minimum || value > maximum) {
         System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
         System.out.print("> ");
         value = Integer.parseInt(bufferedReader.readLine());
      }

      return value;
   }
}