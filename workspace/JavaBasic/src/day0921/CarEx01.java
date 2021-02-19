package day0921;
//�ڵ��� ���� ���α׷��� ArrayList�� �ۼ��ϼ���(

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
   
   // �޴��� �����ִ� �޼ҵ�
      private static void showMenu() throws NumberFormatException, IOException {
         while (true) {
            System.out.println("�����������α׷�");
            System.out.println("1. �Է� 2. ��� 3. ����");
            int userChoice = validateIntegerValue(1, 3);
            if (userChoice == 1) {
               add();
            } else if (userChoice == 2) {
               printAll();
            } else if (userChoice == 3) {
               System.out.println("������ּż� �����մϴ�.");
               break;
            }
         }
      }

      // ���� �߰��ϴ� �޼ҵ�
      private static void add() throws NumberFormatException, IOException {
         Car c = new Car();
         System.out.print("���� ��ȣ: ");
         c.setNumber(bufferedReader.readLine());
         //������ȣ ������ �ٽ� �Է��� �޵��� ������
         while(list.contains(c)) {
            System.out.println("�̹� �����ϴ� ������ȣ�Դϴ�.");
            System.out.print("���� ��ȣ: ");
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
         
         list.add(c);
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
         for (int i = 0; i < list.size(); i++) {
            System.out.printf("%d. %s\n", (i + 1), list.get(i).getNumber());
         }
         System.out.println("=========================");
         System.out.println("���� ������ ������ ��ȣ�� �Է����ּ��� (0�� ����)");
         System.out.print("> ");
         int userChoice = validateIntegerValue(0, list.size()) - 1;
         if (userChoice == -1) {
            System.out.println("����ȭ������ ���ư��ϴ�.");
         } else {
            printOne(userChoice);
         }
      }

      private static void printOne(int index) throws NumberFormatException, IOException {
         System.out.println("================================");
         System.out.printf("\t%s ���� ����\n", list.get(index).getNumber());
         System.out.printf("���� ��ȣ: %s | ���� ����: %s | ���� ����: %s\n", list.get(index).getNumber(), list.get(index).getType(),
               list.get(index).getColor());
         DecimalFormat format = new DecimalFormat("#,###");
         System.out.printf("���� ����: %d��| ���� ����: %s��\n", list.get(index).getYear(),
               format.format((long) list.get(index).getPrice()));
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
         list.get(index).setColor(bufferedReader.readLine());

         System.out.print("���� ����: ");
         list.get(index).setYear(validateIntegerValue(2000, 2020));

         System.out.print("���� ����: ");
         list.get(index).setPrice(validateIntegerValue(0));
         
         printOne(index);
      }
      
      private static void delete(int index) throws IOException{
         System.out.println("�ش� ������ ���� �����Ͻðڽ��ϱ�? (y/n)");
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