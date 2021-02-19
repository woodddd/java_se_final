 package day0916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//
public class CarEx04Array02 {
   private static int SIZE = 3;
   public static void main(String[] args) throws NumberFormatException, IOException {
      //사용자가 입력한 값으로 Car 객체를 만들어서
      //Car배열에 비어있는 칸에 넣고
      //비어있는 칸이 없으면 "빈 칸이 없습니다" 라고 나오는 프로그램을 만들어보자
	   
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      Car[] carArray = new Car[SIZE];// Car 는 기본형이 아닌 참조형이기 때문에 초기화를 해주면 초기값은 null을 가짐.

      int[] a = new int[3]; // int[] 은 기본형이기 때문에 초기 값이 0이고,
      
      while(true) {
    	  
    	  System.out.println("1. 입력 2. 출력 3. 종료");
         int userChoice = Integer.parseInt(bufferedReader.readLine());
         //만약 입력을 눌렀을 때
         //빈칸인지 아닌지는 어떻게 알 수 있을까?
         if(userChoice == 1) {
            if(findEmptyIndex(carArray) == -1) {
            // 빈칸이 없으므로 경고 메시지만 출력
            	System.out.println("빈칸이 없습니다.");
            }else {
            	// 빈칸이 있으니까 c 객체를 만들어 주자.
            	Car c = new Car();
            	
            	System.out.println("차량 번호 : ");
            	c.setNumber(bufferedReader.readLine());
            	
            	System.out.println("차량 종류 : ");
            	c.setType(bufferedReader.readLine());
            	
            	System.out.println("차량 연식 : ");
            	c.setYear(Integer.parseInt(bufferedReader.readLine()));
            	
            	System.out.println("차량 가격 : ");
            	c.setPrice(Integer.parseInt(bufferedReader.readLine()));
            	
            	System.out.println("차량 색상 : ");
            	c.setColor(bufferedReader.readLine());
            	
            	carArray = add(carArray, c);
            }
         }else if(userChoice == 2) {
        	 //출력을 하되 해당칸이 null 이면 출력하지 않는다.
        	 printArray(carArray);
         }else if(userChoice == 3) {
        	 System.out.println("사용해주셔서 감사합니다.");
        	 break;
         }
      }
   }
   
   // 1. 배열의 빈칸을 찾아주는findEmptyIndex(Car[] carArray) 메소드
   private static int findEmptyIndex(Car[] carArray) {
	   for(int i = 0; i < carArray.length; i++) {
		   if(carArray[i] == null) {
			   return i;
		   }
	   }
	   
	   return -1;
   }
   
   // 2. 파라미터로 Car 배열과 Car 객체를 받아서 Car 객체를 배열에 넣어서
   // 그 배열을 리턴하는 add(Car[] carArray, Car c) 메소드
   private static Car[] add(Car[] carArray, Car c) {
	   int index = findEmptyIndex(carArray);
	   carArray[index] = c; // 객체의 주소값을 carArray[index]에 넘겨주어
	   //carArray 가 객체 c 에 저장된 주소 값을 받음으로써 객체 c가 저장되어있는 힙 메모리에 접근하게 된다.
	   // 그리하여 ex) 0x00200 라는 객체 c의 주소값을 carArray가 갖게 되어 c객체의 저장된 값에 접근할 수 있는 것이다.
//	   Car c {
//	        number: "00가 0000"
//	        type: "소나타"
//	           ....
//	        color: "노랑"
//	        method: 
//	    }
	   // 그리하여 객체 c에 저장 되어 있는 이런 값들을 carArray[index] 번에 순차적으로 저장하여
	   // 해당 인덱스 값에 맞는 배열을 출력해주게 되는 것이다.
	   
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
		System.out.println("차량관리 프로그램");
		System.out.println("1. 입력 2. 출력 3. 종료");
		System.out.println(">  ");
	}
}
// 예제 1 : 현재 입력 하는 코드들을 2개의 메소드로 나누세요
//		메소드 1 : 입력할 index를 찾는 메소드
//		메소드 2 : 배열에 해당하는위치에 Car 객체를 넣어서 배열을 다시 리턴해주는 메소드
// 예제 2 : 현재 출력하는 코드들을 메소드로 분리하세요
// 예제 3 : 메뉴를 출력하는 코드들을 메소드로 분리하세요
















