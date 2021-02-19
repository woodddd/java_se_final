 package day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//
public class CarEx04Array02 {
   private static int SIZE = 3;
   public static void main(String[] args) throws NumberFormatException, IOException {
      //����ڰ� �Է��� ������ Car ��ü�� ����
      //Car�迭�� ����ִ� ĭ�� �ְ�
      //����ִ� ĭ�� ������ "�� ĭ�� �����ϴ�" ��� ������ ���α׷��� ������
	   
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      Car[] carArray = new Car[SIZE];// Car �� �⺻���� �ƴ� �������̱� ������ �ʱ�ȭ�� ���ָ� �ʱⰪ�� null�� ����.

      int[] a = new int[3]; // int[] �� �⺻���̱� ������ �ʱ� ���� 0�̰�,
      
      while(true) {
    	  
    	  System.out.println("1. �Է� 2. ��� 3. ����");
         int userChoice = Integer.parseInt(bufferedReader.readLine());
         //���� �Է��� ������ ��
         //��ĭ���� �ƴ����� ��� �� �� ������?
         if(userChoice == 1) {
            if(findEmptyIndex(carArray) == -1) {
            // ��ĭ�� �����Ƿ� ��� �޽����� ���
            	System.out.println("��ĭ�� �����ϴ�.");
            }else {
            	// ��ĭ�� �����ϱ� c ��ü�� ����� ����.
            	Car c = new Car();
            	
            	System.out.println("���� ��ȣ : ");
            	c.setNumber(bufferedReader.readLine());
            	
            	System.out.println("���� ���� : ");
            	c.setType(bufferedReader.readLine());
            	
            	System.out.println("���� ���� : ");
            	c.setYear(Integer.parseInt(bufferedReader.readLine()));
            	
            	System.out.println("���� ���� : ");
            	c.setPrice(Integer.parseInt(bufferedReader.readLine()));
            	
            	System.out.println("���� ���� : ");
            	c.setColor(bufferedReader.readLine());
            	
            	carArray = add(carArray, c);
            }
         }else if(userChoice == 2) {
        	 //����� �ϵ� �ش�ĭ�� null �̸� ������� �ʴ´�.
        	 printArray(carArray);
         }else if(userChoice == 3) {
        	 System.out.println("������ּż� �����մϴ�.");
        	 break;
         }
      }
   }
   
   // 1. �迭�� ��ĭ�� ã���ִ�findEmptyIndex(Car[] carArray) �޼ҵ�
   private static int findEmptyIndex(Car[] carArray) {
	   for(int i = 0; i < carArray.length; i++) {
		   if(carArray[i] == null) {
			   return i;
		   }
	   }
	   
	   return -1;
   }
   
   // 2. �Ķ���ͷ� Car �迭�� Car ��ü�� �޾Ƽ� Car ��ü�� �迭�� �־
   // �� �迭�� �����ϴ� add(Car[] carArray, Car c) �޼ҵ�
   private static Car[] add(Car[] carArray, Car c) {
	   int index = findEmptyIndex(carArray);
	   carArray[index] = c; // ��ü�� �ּҰ��� carArray[index]�� �Ѱ��־�
	   //carArray �� ��ü c �� ����� �ּ� ���� �������ν� ��ü c�� ����Ǿ��ִ� �� �޸𸮿� �����ϰ� �ȴ�.
	   // �׸��Ͽ� ex) 0x00200 ��� ��ü c�� �ּҰ��� carArray�� ���� �Ǿ� c��ü�� ����� ���� ������ �� �ִ� ���̴�.
//	   Car c {
//	        number: "00�� 0000"
//	        type: "�ҳ�Ÿ"
//	           ....
//	        color: "���"
//	        method: 
//	    }
	   // �׸��Ͽ� ��ü c�� ���� �Ǿ� �ִ� �̷� ������ carArray[index] ���� ���������� �����Ͽ�
	   // �ش� �ε��� ���� �´� �迭�� ������ְ� �Ǵ� ���̴�.
	   
	   return carArray;
   }


	private static void printArray(Car[] carArray) {
	for(int i = 0; i < carArray.length; i++) {
		if(carArray[i] != null ) {
			System.out.println(carArray[i]);
			}
		}
	}
	
	private static void showMenu() {
		System.out.println("�������� ���α׷�");
		System.out.println("1. �Է� 2. ��� 3. ����");
		System.out.println(">  ");
	}
}
// ���� 1 : ���� �Է� �ϴ� �ڵ���� 2���� �޼ҵ�� ��������
//		�޼ҵ� 1 : �Է��� index�� ã�� �޼ҵ�
//		�޼ҵ� 2 : �迭�� �ش��ϴ���ġ�� Car ��ü�� �־ �迭�� �ٽ� �������ִ� �޼ҵ�
// ���� 2 : ���� ����ϴ� �ڵ���� �޼ҵ�� �и��ϼ���
// ���� 3 : �޴��� ����ϴ� �ڵ���� �޼ҵ�� �и��ϼ���
















