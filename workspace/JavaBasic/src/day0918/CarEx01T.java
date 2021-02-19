package day0918;
// �������� ���α׷�

// 1. �Է�
//    �Է½ÿ��� �迭�� �̹� �Ȱ��� ��ȣ�� ���� �ÿ��� ���� ��ȣ�� �ٽ� �Է¹ް� �ϼ���
// 2. ��� ���
//    ��� ��½ÿ���  
//            1. ������ȣ
//            2. ������ȣ
//            3. ������ȣ
//    �� �������� ����� ��µǰ� ����ڰ� ��ȣ�� �����Ͽ� �󼼺���� �� �� �ְ� �ϼ���
// 3. �� ����
//    ��Ͽ��� ������ ��ȣ�� ���� �󼼺���� ����
//    ���� ��ȣ ���� ���� ���� ����
//    ���� ���� ���� ����
//      ����) ������ȣ: 00�� 0000 ��������: ���� ��������: ������
//           ��������: 2020 ����  ��������: 20000000�� 
//    �� ��µǰ� 
//    ���� ���� ��ϵ��ư��� �� ��µǰ� ���弼��
//    A) ����
//       �������� ����, ����, ������ ������ �� �ְ� ���弼��.
//    B) ����
//       ���� �ÿ��� ����ڰ� �����ϸ� �����ϰ� ������� �̵��ϰ� �������� ���� �ÿ��� �ش� ������ �������� �������� �̵��ϼ���
//    C) ��Ϻ���
//       �ٽ� ������� �̵��մϴ�.

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

   // �޴��� �����ִ� �޼ҵ�
   private static void showMenu() throws NumberFormatException, IOException {
      while (true) {
         System.out.println("�����������α׷�");
         System.out.println("1. �Է� 2. ��� 3. ����");
         int userChoice = Integer.parseInt(bufferedReader.readLine());
         if (userChoice == 1) {
            add();
         } else if (userChoice == 2) {
            printAll();
         } else if (userChoice == 3) {
            System.out.println("������ּż� �����մϴ�.");
            break;
         } else {
            System.out.println("�߸��Է��ϼ̽��ϴ�.");
         }
      }
   }

   // ���� �߰��ϴ� �޼ҵ�
   private static void add() throws NumberFormatException, IOException {
      carArray = ArrayUtil.add(carArray, setCarInfo());
   }

   // ī ��ü�� ������ �ִ� �޼ҵ�
   private static Car setCarInfo() throws NumberFormatException, IOException {
      Car c = new Car();

      System.out.print("���� ��ȣ: ");
      c.setNumber(bufferedReader.readLine());
      //����������ȣ ������ �ٽ� �Է��� �޵��� ������
      while(ArrayUtil.contains(carArray, c)) {
    	  System.out.println("�̹� �����ϴ� ������ȣ�Դϴ�.");
    	  System.out.print("���� ��ȣ : ");
    	  c.setNumber(bufferedReader.readLine());
      }
      System.out.print("���� ����: ");
      c.setType(bufferedReader.readLine());

      System.out.print("���� ����: ");
      c.setColor(bufferedReader.readLine());

      System.out.print("���� ����: ");
      c.setYear(validateIntegerValue(2000, 2020));

      System.out.print("���� ����: ");
      c.setPrice(validateIntegerValue(0));

      return c;
   }

   private static int validateIntegerValue(int minimum) throws NumberFormatException, IOException {
      int value = Integer.parseInt(bufferedReader.readLine());
      while (value < minimum) {
         System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");
         System.out.print("> ");
         value = Integer.parseInt(bufferedReader.readLine());
      }

      return value;
   }

   private static int validateIntegerValue(int minimum, int maximum) throws NumberFormatException, IOException {
      int value = Integer.parseInt(bufferedReader.readLine());
      while (value < minimum || value > maximum) {
         System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���");
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
      System.out.println("���� ������ ������ ��ȣ�� �Է����ּ��� (0�� ����)");
      System.out.print("> ");
      int userChoice = validateIntegerValue(0, carArray.length) - 1;
      if (userChoice == -1) {
         System.out.println("����ȭ������ ���ư��ϴ�.");
      } else {
         printOne(userChoice);
      }
   }

   private static void printOne(int index) throws NumberFormatException, IOException {
      System.out.println("================================");
      System.out.printf("\t%s ���� ����\n", carArray[index].getNumber());
      System.out.printf("���� ��ȣ: %s | ���� ����: %s | ���� ����: %s\n", carArray[index].getNumber(), carArray[index].getType(),
            carArray[index].getColor());
      DecimalFormat format = new DecimalFormat("#,###");
      System.out.printf("���� ����: %d��| ���� ����: %s��\n", carArray[index].getYear(),
            format.format((long) carArray[index].getPrice()));
      System.out.println("=========================================");
      System.out.println("1. ���� 2. ���� 3. �������");
      System.out.print("> ");
      int userChoice = validateIntegerValue(1, 3);
      if (userChoice == 1) {
         // ���� �޼ҵ� ����
         update(index);
      } else if (userChoice == 2) {
         // ���� �޼ҵ� ����
         delete(index);
      } else if (userChoice == 3) {
         // ���� �޴��� ���ư����� printAll() ����
         printAll();
      }
   }

   private static void update(int index) throws NumberFormatException, IOException {
      System.out.print("���� ����: ");
      carArray[index].setColor(bufferedReader.readLine());

      System.out.print("���� ����: ");
      carArray[index].setYear(validateIntegerValue(2000, 2020));

      System.out.print("���� ����: ");
      carArray[index].setPrice(validateIntegerValue(0));
      
      printOne(index);
   }
   
   private static void delete(int index) throws IOException{
      System.out.println("�ش� ������ ���� �����Ͻðڽ��ϱ�? (y/n)");
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










