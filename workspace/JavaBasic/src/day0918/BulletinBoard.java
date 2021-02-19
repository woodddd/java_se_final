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
//			System.out.println("\t      비트 게시판");
//			System.out.println("==============================");
//			
//			System.out.println();
//			System.out.println("1.작성하기\t2.목록보기\t3.게시판 종료");	
//			System.out.println("==============================");
//			System.out.print(">  ");
//			
//			int userChoice = Integer.parseInt(br.readLine());
//			if(userChoice == 1) {
//				add();
//			}else if(userChoice == 2) {
//				printArray();
//			}else if(userChoice == 3) {
//				System.out.println("게시판 프로그램을 종료합니다.");
//				break;
//			}else {
//				System.out.println("잘못 입력하였습니다.");
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
//		System.out.print("제목 : ");
//		b.setTitle(br.readLine());
//		
//		System.out.print("작성자 : ");
//		b.setName(br.readLine());
//		
//		while(ArrayUtil.contains(boardArray, b)) {
//			System.out.println("동일 작성자의 동일 제목이 존재합니다.");
//			System.out.println("제목을 다시 입력해주세요.");
//			System.out.print("제목 : ");
//			b.setTitle(br.readLine());
//			
//			System.out.print("작성자 : ");
//			b.setName(br.readLine());
//			
//		}
//		System.out.print("내용 : ");
//		b.setContent(br.readLine());
//		
//		return b;
//	}
//	
//	private static void printArray() throws NumberFormatException, IOException {
//		System.out.println("------------------------------");
//		System.out.println("|\t번호\t작성자\t제목|");
//		System.out.println("------------------------------");
//		for(int i = 0 ; i < boardArray.length ; i++) {
//			System.out.printf("|\t%d\t%s\t%s\n",(i + 1), boardArray[i].getName(),boardArray[i].getTitle());
//		}
//		System.out.println("------------------------------");
//		
//		System.out.println("상세보기 번호 입력( 입력( 0 ) - 뒤로가기 : ");
//		System.out.print(">  ");
//		int userChoice = Integer.parseInt(br.readLine()) - 1;
//		System.out.println();
//		
//		while(userChoice < -1 || userChoice > boardArray.length -1) {
//			System.out.println("잘못된 번호입니다.");
//			System.out.println("상세보기 번호 입력( 입력( 0 ) - 뒤로가기 : ");
//			System.out.print(">  ");
//			userChoice = Integer.parseInt(br.readLine()) - 1;
//			System.out.println();
//		}
//		if(userChoice == -1) {
//			System.out.println("메뉴로 돌아갑니다.");
//		}else {
//			printOne(userChoice);
//		}
//	}
//	
//	private static void printOne(int index) throws NumberFormatException, IOException {
//		System.out.printf("%s작성자의 %s 정보",boardArray[index].getName(),boardArray[index].getTitle());
//		System.out.printf("제목 : %s\n",boardArray[index].getTitle());
//		System.out.println();
//		System.out.printf("작성자 : %s\n",boardArray[index].getName());
//		System.out.printf("내용 : %s \n",boardArray[index].getContetn());
//		
//		System.out.println("=====================================");
//	      System.out.println("1. 수정 2. 삭제 3. 목록으로");
//	      int userChoice = Integer.parseInt(br.readLine());
//	      if(userChoice == 1) {
//	    	  System.out.print("내용 : ");
//	    	  boardArray[index].setContent(br.readLine());
//	      }else if(userChoice == 2) {
//	    	  System.out.println("정말 삭제하시겠습니까? (y/n): ");
//	    	  String agree = br.readLine();
//	    	  if(agree.equals("y")) {
//		            //삭제하고 학생목록 보기로 이동
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
