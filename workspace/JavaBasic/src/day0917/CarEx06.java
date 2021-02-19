package day0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0916.Car;
import util.ArrayUtil;

// �����Ҵ��� �Ǵ� �迭����
public class CarEx06 {
   public static void main(String[] args) throws NumberFormatException, IOException {
      Car[] carArray = new Car[0];
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      
      while(true) {
         showMenu();
         int userChoice = Integer.parseInt(bufferedReader.readLine());
         if(userChoice == 1) {
        	 //carArray �߰� �޼ҵ� ����
        	 carArray = add(carArray, bufferedReader); // add �޼ҵ忡 static �޼ҵ带 �����Ͽ����Ƿ�, ��ü�� ���� ����� �� �ʿ䰡 ����.
         }else if(userChoice == 2) {
        	 //carArray ��� �޼ҵ� ����
        	 printArray(carArray);
         }else if(userChoice == 3) {
        	 System.out.println("������ּż� �����մϴ�.");
        	 break;
         }else {
        	 System.out.println("�߸��Է��ϼ̽��ϴ�.");
         }
      }
   }
   private static void showMenu() {
      System.out.println("1. �Է� 2. ��� 3. ����");
      System.out.print("> ");
   }
   
   private static Car[] add(Car[] carArray, BufferedReader bufferedReader) throws IOException {
	   carArray = ArrayUtil.add(carArray, setCarInfo(bufferedReader)); // setCarInfo(bufferedReader)�� ��ȯ�� �ڷ����� Car �̱� ������ Util �� add �޼ҵ带 ����� �� ����.
	   
	   return carArray;
   }
   
   private static Car setCarInfo(BufferedReader bufferedReader) throws IOException {
	   Car c = new Car();
	   
	   System.out.print("���� ��ȣ : ");
	   c.setNumber(bufferedReader.readLine());
	   
	   System.out.print("���� ���� : ");
	   c.setType(bufferedReader.readLine());
	   
	   System.out.print("���� ���� : ");
	   c.setYear(Integer.parseInt(bufferedReader.readLine()));
	   
	   System.out.print("���� ���� : ");
	   c.setPrice(Integer.parseInt(bufferedReader.readLine()));
	   
	   System.out.print("���� ��ȣ : ");
	   c.setColor(bufferedReader.readLine());
	   
	   return c;
   }
   
   private static void printArray(Car[] carArray) {
	   for(int i = 0; i < carArray.length; i++) {
		   System.out.println(carArray[i]);
	   }
   }
}