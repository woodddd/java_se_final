package day0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0916.Car;
import util.ArrayUtil;

//�������� ���α׷�
//1. �Է�
// �Է½ÿ��� �迭�� �̹� �Ȱ��� ��ȣ�� ���� �ÿ��� ���� ��ȣ�� �ٽ� �Է¹ް� �ϼ���
//2. ��� ���
// ��� ��½ÿ���  
//         1. ������ȣ
//         2. ������ȣ
//         3. ������ȣ
// �� �������� ����� ��µǰ� ����ڰ� ��ȣ�� �����Ͽ� �󼼺���� �� �� �ְ� �ϼ���
//3. �� ����
// ��Ͽ��� ������ ��ȣ�� ���� �󼼺���� ����
// ���� ��ȣ ���� ���� ���� ����
// ���� ���� ���� ����
//   ����) ������ȣ: 00�� 0000 ��������: ���� ��������: ������
//        ��������: 2020 ����  ��������: 20000000�� 
// �� ��µǰ� 
// ���� ���� ��ϵ��ư��� �� ��µǰ� ���弼��
// A) ����
//    �������� ����, ����, ������ ������ �� �ְ� ���弼��.
// B) ����
//    ���� �ÿ��� ����ڰ� �����ϸ� �����ϰ� ������� �̵��ϰ� �������� ���� �ÿ��� �ش� ������ �������� �������� �̵��ϼ���
// C) ��Ϻ���
//    �ٽ� ������� �̵��մϴ�.

public class CarEx01 {
	
	private static BufferedReader br;
	private static Car[] carArray;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		carArray = new Car[0];
		
		showMenu();
		
	}
	
	
	private static void showMenu() throws NumberFormatException, IOException {
		while(true) {
			System.out.println("��Ʈ ���� ���� ���α׷�");
			System.out.println("1. �Է� 2. ��� 3. ����");
			System.out.print("> ");
			int userChoice = Integer.parseInt(br.readLine());
					
			if(userChoice == 1) {
				add();
			}else if(userChoice == 2) {
				printArray();
			}else if(userChoice == 3) {
				System.out.println("���α׷��� �����մϴ�.");
			}else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}
	
	private static void add() throws IOException {
		carArray = ArrayUtil.add(carArray, carInfo());
	}
	
	private static Car carInfo() throws IOException {
		Car c = new Car();
		
		System.out.print("���� ��ȣ : ");
		c.setNumber(br.readLine());
		 while(ArrayUtil.contains(carArray, c)) {
	    	  System.out.println("�̹� �����ϴ� ������ȣ�Դϴ�.");
	    	  System.out.print("���� ��ȣ : ");
	    	  c.setNumber(br.readLine());
	      }
		
		System.out.print("���� ���� : ");
		c.setType(br.readLine());
		
		System.out.print("���� ���� : ");
		c.setYear(validateIntegerValue(2000,2020));
		
		System.out.print("���� ���� : ");
		c.setPrice(validateIntegerValue(0));
		
		System.out.print("���� ���� : ");
		c.setColor(br.readLine());
		
		return c;
		
	}
	
	private static int validateIntegerValue(int minimum) throws NumberFormatException, IOException {
		int value = Integer.parseInt(br.readLine());
		while(value < minimum) {
			System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			System.out.print("> ");
			value = Integer.parseInt(br.readLine());
		}
		return value;
	}
	
	private static int validateIntegerValue(int minimum, int maximum) throws NumberFormatException, IOException {
		int value = Integer.parseInt(br.readLine());
		while(value < minimum || value > maximum) {
			System.out.println("�߸��Է��ϼ̽��ϴ�. �ٽ� �Է����ּ���.");
			System.out.print("> ");
			value = Integer.parseInt(br.readLine());
		}
		return value;
	}
	
	private static void printArray() throws NumberFormatException, IOException {
		System.out.println("====================");
		System.out.println("��ȣ\t���� ��ȣ");
		System.out.println("====================");
		for(int i = 0; i < carArray.length ; i ++) {
			System.out.printf("%d\t%s", i + 1, carArray[i].getNumber() );
			System.out.println();
		}
		System.out.println("�󼼺����� ��ȣ�� �����ּ���( 0 �� �ڷΰ��� ) : ");
		int userChoice = Integer.parseInt(br.readLine()) - 1;
		
		while(userChoice < -1 || userChoice > carArray.length - 1) {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			System.out.println("�󼼺����� ��ȣ�� �����ּ���( 0 �� �ڷΰ��� ) : ");
			userChoice = Integer.parseInt(br.readLine()) - 1;
		}
		
		if(userChoice == -1) {
			System.out.println("�޴��� ���ư��ϴ�.");
		}else {
			printOne(userChoice);
		}
		
		
	}
	
	private static void printOne(int index) throws NumberFormatException, IOException {
		System.out.printf("%s ������ ���� :\n", carArray[index].getNumber());
		System.out.printf("���� ���� : %s\t���� ���� : %d\n", carArray[index].getType(), carArray[index].getYear());
		System.out.printf("���� ���� : %d\t���� ���� : %s\n", carArray[index].getPrice(),carArray[index].getColor());
		
		System.out.println("=====================================");
	      System.out.println("1. ���� 2. ���� 3. �������");
	      int userChoice = Integer.parseInt(br.readLine());
	      if(userChoice == 1) {
	    	  System.out.print("���� ���� : ");
	    	  carArray[index].setYear(Integer.parseInt(br.readLine()));
	    	  System.out.print("���� ���� : ");
	    	  carArray[index].setPrice(Integer.parseInt(br.readLine()));
	    	  System.out.print("���� ���� : ");
	    	  carArray[index].setColor(br.readLine());
	      }else if(userChoice == 2) {
	    	  System.out.print("���� �����Ͻðڽ��ϱ�? (y/n): ");
		         String agree = br.readLine();
		         
		         if(agree.equals("y")) {
		        	 carArray = ArrayUtil.removeByIndex(carArray, index);
		        	 printArray();
		         }else if(agree.equals("n")) {
		        	 printOne(index);
		         }else {
		        	 printArray();
		         }
	      }
	}
}
