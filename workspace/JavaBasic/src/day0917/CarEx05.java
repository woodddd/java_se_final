package day0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0916.Car;

// 만약 꽉차면
// 가장 앞에것 부터 제거하고
// 한칸씩 떙겨서 맨 마지막에 덮어씌우는 형식으로
// 배열을 관리하는 프로그램

public class CarEx05 {
	private static int SIZE = 3;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Car[] carArray = new Car[SIZE];
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			showMenu();
			int userchoice = Integer.parseInt(br.readLine());
			
			if(userchoice == 1) {
				//입력 메소드 실행
				
				carArray = add(carArray);
			}else if(userchoice == 2) {
				//출력 메소드 실행
				printArray(carArray);
			}else if(userchoice == 3) {
				//메시지 출력 후 종료
				System.out.println("사용해주셔서 감사합니다.");
				break;
				
			}else {
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}
	
	private static void printArray(Car[] carArray) {// Car클래스 배열의 carArray 를 파라미터로 받아옴.(Car[] 는 파라미터의 데이터 타입을 말함)
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i] != null) {
				System.out.println("carArray[i] : " + carArray[i]);
			}
		}
	}
	
	private static Car[] add(Car[] carArray) throws IOException {
		int index = findEmptyIndex(carArray);
		if(index != -1) {
			//빈칸이 존재하므로 index 빈 칸에
			//Car 객체를 넣어준다.
			carArray[index] = setCarInfo();
		}else {
			// 배열이 모두 다 꽉 찼으므로 배열을 한 칸씩 땡겨서
			// 맨 마지막 칸에 새로운 입력된 c를 넣게 맏늘어주자
			for(int i = 1; i < carArray.length; i++ ) {
				carArray[i-1] = carArray[i];
			}
			carArray[SIZE - 1] = setCarInfo();
		}
		return carArray;
	}
	
	private static Car setCarInfo() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Car c = new Car(); // 여기서 생성된 c 는 메소드 내부에서 값을 저장하고 그 주소값을 가지고 있다가
							//carArray[SIZE - 1] = setCarInfo(); 이곳에 값을 return 해주고 c는 소멸된다.
							// 그러므로 setCarInfo() 가 다시 실행될 때, 이전 값과 동일한 주소 값이 아닌
							// 새로운 c 객체를 생성하여 새로운 주소값을 넘겨주게 되는 것임.
		
		System.out.println("차량 종류 : ");
		c.setNumber(br.readLine());
		System.out.println("차량 종류 : ");
		c.setType(br.readLine());
		System.out.println("차량 연식 : ");
		c.setYear(Integer.parseInt(br.readLine()));
		System.out.println("차량 가격 : ");
		c.setPrice(Integer.parseInt(br.readLine()));
		System.out.println("차량 색상 : ");
		c.setColor(br.readLine());
		
		return c; // 리턴타입이 Car 이므로 Car클래스의 c 객체를 반환하겠다는 의미임
		
	}
	
	private static int findEmptyIndex(Car[] carArray) {
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	private static void showMenu() {
		System.out.println("비트 차량관리 프로그램 ver 2.0");
		System.out.println("1. 입력 2. 출력 3. 종료");
		System.out.print("> ");
	}

}
