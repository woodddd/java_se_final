package day0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import util.ArrayUtil;

public class BulletinBoard {
//	
//	private static BufferedReader br;
//	private static Board[] boardArray;
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		
//		br = new BufferedReader(new InputStreamReader(System.in));
//		boardArray = new Board[0];
//		
//		
//		showMenu();
//		
//	}
//
//	private static void showMenu() throws NumberFormatException, IOException {
//		while(true) {
//			System.out.println("==============================");
//			System.out.println("\t      ��Ʈ �Խ���");
//			System.out.println("==============================");
//			
//			System.out.println();
//			System.out.println("1.�ۼ��ϱ�\t2.��Ϻ���\t3.�Խ��� ����");	
//			System.out.println("==============================");
//			System.out.print(">  ");
//			
//			int userChoice = Integer.parseInt(br.readLine());
//			if(userChoice == 1) {
//				add();
//			}else if(userChoice == 2) {
//				printArray();
//			}else if(userChoice == 3) {
//				System.out.println("�Խ��� ���α׷��� �����մϴ�.");
//				break;
//			}else {
//				System.out.println("�߸� �Է��Ͽ����ϴ�.");
//			}
//		}
//		
//	}
//	private static void add() throws IOException {
//		boardArray = ArrayUtil.add(boardArray, setBoardInfo());
//	}
//	
//	private static Board setBoardInfo() throws IOException {
//
//		Board b = new Board();
//		
//		System.out.print("���� : ");
//		b.setTitle(br.readLine());
//		
//		System.out.print("�ۼ��� : ");
//		b.setName(br.readLine());
//		
//		while(ArrayUtil.contains(boardArray, b)) {
//			System.out.println("���� �ۼ����� ���� ������ �����մϴ�.");
//			System.out.println("������ �ٽ� �Է����ּ���.");
//			System.out.print("���� : ");
//			b.setTitle(br.readLine());
//			
//			System.out.print("�ۼ��� : ");
//			b.setName(br.readLine());
//			
//		}
//		System.out.print("���� : ");
//		b.setContent(br.readLine());
//		
//		return b;
//	}
//	
//	private static void printArray() throws NumberFormatException, IOException {
//		System.out.println("------------------------------");
//		System.out.println("|\t��ȣ\t�ۼ���\t����|");
//		System.out.println("------------------------------");
//		for(int i = 0 ; i < boardArray.length ; i++) {
//			System.out.printf("|\t%d\t%s\t%s\n",(i + 1), boardArray[i].getName(),boardArray[i].getTitle());
//		}
//		System.out.println("------------------------------");
//		
//		System.out.println("�󼼺��� ��ȣ �Է�( �Է�( 0 ) - �ڷΰ��� : ");
//		System.out.print(">  ");
//		int userChoice = Integer.parseInt(br.readLine()) - 1;
//		System.out.println();
//		
//		while(userChoice < -1 || userChoice > boardArray.length -1) {
//			System.out.println("�߸��� ��ȣ�Դϴ�.");
//			System.out.println("�󼼺��� ��ȣ �Է�( �Է�( 0 ) - �ڷΰ��� : ");
//			System.out.print(">  ");
//			userChoice = Integer.parseInt(br.readLine()) - 1;
//			System.out.println();
//		}
//		if(userChoice == -1) {
//			System.out.println("�޴��� ���ư��ϴ�.");
//		}else {
//			printOne(userChoice);
//		}
//	}
//	
//	private static void printOne(int index) throws NumberFormatException, IOException {
//		System.out.printf("%s�ۼ����� %s ����",boardArray[index].getName(),boardArray[index].getTitle());
//		System.out.printf("���� : %s\n",boardArray[index].getTitle());
//		System.out.println();
//		System.out.printf("�ۼ��� : %s\n",boardArray[index].getName());
//		System.out.printf("���� : %s \n",boardArray[index].getContetn());
//		
//		System.out.println("=====================================");
//	      System.out.println("1. ���� 2. ���� 3. �������");
//	      int userChoice = Integer.parseInt(br.readLine());
//	      if(userChoice == 1) {
//	    	  System.out.print("���� : ");
//	    	  boardArray[index].setContent(br.readLine());
//	      }else if(userChoice == 2) {
//	    	  System.out.println("���� �����Ͻðڽ��ϱ�? (y/n): ");
//	    	  String agree = br.readLine();
//	    	  if(agree.equals("y")) {
//		            //�����ϰ� �л���� ����� �̵�
//		            boardArray = ArrayUtil.removeByIndex(boardArray, index);
//		            printArray();
//		         }else if(agree.equals("n")) {
//		            printOne(index);
//		         }else if(userChoice == 3) {
//		        	 printArray();
//		         }
//	    	  
//	      }
//		
//	}
//	
}
