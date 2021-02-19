package day0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0916.Car;
import util.ArrayUtil;

// 동적할당이 되는 배열버젼
public class CarEx06 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      Car[] carArray = new Car[0];
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      
      while(true) {
         showMenu();
         int userChoice = Integer.parseInt(bufferedReader.readLine());
         if(userChoice == 1) {
        	 //carArray 추가 메소드 실행
        	 carArray = add(carArray, bufferedReader); // add 메소드에 static 메소드를 선언하였으므로, 객체로 따로 만들어 줄 필요가 없음.
         }else if(userChoice == 2) {
        	 //carArray 출력 메소드 실행
        	 printArray(carArray);
         }else if(userChoice == 3) {
        	 System.out.println("사용해주셔서 감사합니다.");
        	 break;
         }else {
        	 System.out.println("잘못입력하셨습니다.");
         }
      }
   }
   private static void showMenu() {
      System.out.println("1. 입력 2. 출력 3. 종료");
      System.out.print("> ");
   }
   
   private static Car[] add(Car[] carArray, BufferedReader bufferedReader) throws IOException {
	   carArray = ArrayUtil.add(carArray, setCarInfo(bufferedReader)); // setCarInfo(bufferedReader)의 반환값 자료형은 Car 이기 때문에 Util 의 add 메소드를 사용할 수 있음.
	   
	   return carArray;
   }
   
   private static Car setCarInfo(BufferedReader bufferedReader) throws IOException {
	   Car c = new Car();
	   
	   System.out.print("차량 번호 : ");
	   c.setNumber(bufferedReader.readLine());
	   
	   System.out.print("차량 종류 : ");
	   c.setType(bufferedReader.readLine());
	   
	   System.out.print("차량 연식 : ");
	   c.setYear(Integer.parseInt(bufferedReader.readLine()));
	   
	   System.out.print("차량 가격 : ");
	   c.setPrice(Integer.parseInt(bufferedReader.readLine()));
	   
	   System.out.print("차량 번호 : ");
	   c.setColor(bufferedReader.readLine());
	   
	   return c;
   }
   
   private static void printArray(Car[] carArray) {
	   for(int i = 0; i < carArray.length; i++) {
		   System.out.println(carArray[i]);
	   }
   }
}