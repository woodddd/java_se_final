package day0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0916.Car;
import util.ArrayUtil;

//차량관리 프로그램
//1. 입력
// 입력시에는 배열에 이미 똑같은 번호가 있을 시에는 차량 번호를 다시 입력받게 하세요
//2. 목록 출력
// 목록 출력시에는  
//         1. 차량번호
//         2. 차량번호
//         3. 차량번호
// 의 형식으로 목록이 출력되고 사용자가 번호를 선택하여 상세보기로 들어갈 수 있게 하세요
//3. 상세 보기
// 목록에서 선택한 번호의 차량 상세보기로 들어가면
// 차량 번호 차량 종류 차량 색상
// 차량 연식 차량 가격
//   예시) 차량번호: 00가 0000 차량종류: 벤츠 차량색상: 검은색
//        차량연식: 2020 년형  차량가격: 20000000원 
// 이 출력되고 
// 수정 삭제 목록돌아가기 가 출력되게 만드세요
// A) 수정
//    수정에는 색상, 연식, 가격을 수정할 수 있게 만드세요.
// B) 삭제
//    삭제 시에는 사용자가 동의하면 삭제하고 목록으로 이동하고 동의하지 않을 시에는 해당 차량의 개별보기 페이지로 이동하세요
// C) 목록보기
//    다시 목록으로 이동합니다.

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
			System.out.println("비트 차량 관리 프로그램");
			System.out.println("1. 입력 2. 출력 3. 종료");
			System.out.print("> ");
			int userChoice = Integer.parseInt(br.readLine());
					
			if(userChoice == 1) {
				add();
			}else if(userChoice == 2) {
				printArray();
			}else if(userChoice == 3) {
				System.out.println("프로그램을 종료합니다.");
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	private static void add() throws IOException {
		carArray = ArrayUtil.add(carArray, carInfo());
	}
	
	private static Car carInfo() throws IOException {
		Car c = new Car();
		
		System.out.print("차량 번호 : ");
		c.setNumber(br.readLine());
		 while(ArrayUtil.contains(carArray, c)) {
	    	  System.out.println("이미 존재하는 차량번호입니다.");
	    	  System.out.print("차량 번호 : ");
	    	  c.setNumber(br.readLine());
	      }
		
		System.out.print("차량 종류 : ");
		c.setType(br.readLine());
		
		System.out.print("차량 연식 : ");
		c.setYear(validateIntegerValue(2000,2020));
		
		System.out.print("차량 가격 : ");
		c.setPrice(validateIntegerValue(0));
		
		System.out.print("차량 색상 : ");
		c.setColor(br.readLine());
		
		return c;
		
	}
	
	private static int validateIntegerValue(int minimum) throws NumberFormatException, IOException {
		int value = Integer.parseInt(br.readLine());
		while(value < minimum) {
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			System.out.print("> ");
			value = Integer.parseInt(br.readLine());
		}
		return value;
	}
	
	private static int validateIntegerValue(int minimum, int maximum) throws NumberFormatException, IOException {
		int value = Integer.parseInt(br.readLine());
		while(value < minimum || value > maximum) {
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			System.out.print("> ");
			value = Integer.parseInt(br.readLine());
		}
		return value;
	}
	
	private static void printArray() throws NumberFormatException, IOException {
		System.out.println("====================");
		System.out.println("번호\t차량 번호");
		System.out.println("====================");
		for(int i = 0; i < carArray.length ; i ++) {
			System.out.printf("%d\t%s", i + 1, carArray[i].getNumber() );
			System.out.println();
		}
		System.out.println("상세보기할 번호를 눌러주세요( 0 은 뒤로가기 ) : ");
		int userChoice = Integer.parseInt(br.readLine()) - 1;
		
		while(userChoice < -1 || userChoice > carArray.length - 1) {
			System.out.println("잘못 입력하셨습니다.");
			System.out.println("상세보기할 번호를 눌러주세요( 0 은 뒤로가기 ) : ");
			userChoice = Integer.parseInt(br.readLine()) - 1;
		}
		
		if(userChoice == -1) {
			System.out.println("메뉴로 돌아갑니다.");
		}else {
			printOne(userChoice);
		}
		
		
	}
	
	private static void printOne(int index) throws NumberFormatException, IOException {
		System.out.printf("%s 차량의 정보 :\n", carArray[index].getNumber());
		System.out.printf("차량 종류 : %s\t차량 연식 : %d\n", carArray[index].getType(), carArray[index].getYear());
		System.out.printf("차량 가격 : %d\t차량 색상 : %s\n", carArray[index].getPrice(),carArray[index].getColor());
		
		System.out.println("=====================================");
	      System.out.println("1. 수정 2. 삭제 3. 목록으로");
	      int userChoice = Integer.parseInt(br.readLine());
	      if(userChoice == 1) {
	    	  System.out.print("차량 연식 : ");
	    	  carArray[index].setYear(Integer.parseInt(br.readLine()));
	    	  System.out.print("차량 가격 : ");
	    	  carArray[index].setPrice(Integer.parseInt(br.readLine()));
	    	  System.out.print("차량 색상 : ");
	    	  carArray[index].setColor(br.readLine());
	      }else if(userChoice == 2) {
	    	  System.out.print("정말 삭제하시겠습니까? (y/n): ");
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
