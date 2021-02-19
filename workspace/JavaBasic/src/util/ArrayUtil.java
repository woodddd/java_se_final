package util;

import day0915.Student;
import day0916.Car;
//import day0918.Board;//이건 내가 만든Board[] 를 사용 할 때 사용하는 import
import day0921.Board; // 강사님 ver 게시판 만들기

//위와 같이 import 의 패키지 주소만 바꿔 주어도 어떤 Board 를 사용 하는지가 결정이 됨.

// 배열 관련 메소드를 모아둔 클래스
public class ArrayUtil {
	//3시까지
	//여기에 우리가 동적할당에서 사용했던 메소드들(indexOf, contains 등등)을
	//Student[]과 Car[]에 사용될 수 있게 만드세요.
		
	//1. 해당 배열의 크기를 확인하는 size() 메소드	
	//	A. Car[] 버전
	public static int size(Car[] carArray) {
		return carArray.length;
	}
	
	//	B. Student[] 버전
	public static int size(Student[] studentArray) {
		return studentArray.length;
	}
	
	public static int size(Board[] boardArray) {
		return boardArray.length;
	}
	
	//2. 배열의 새로운요소를 추가하는 메소드
	
	//	A. car[] 버전
	public static Car[] add(Car[] carArray, Car c) {
		//현재 배열을 임시 배열에 복사한다.
		int size = carArray.length;
		
		Car[] temp = new Car[size];
		for(int i = 0; i < size ;  i++) {
			temp[i] = carArray[i];
		}
		//carArray 크기 증가
		carArray = new Car[size + 1];
		
		//임시 배열에 저장한 값을 다시 원래대로 가져온다.
		for(int i = 0 ; i < size; i++) {
			carArray[i] = temp[i];
		}
		//carArray의 가장 맨 마지막 칸에 c 추가
		carArray[size] = c;
		
		return carArray;
	}
	
	//	B. Student[] 버전
	public static Student[] add(Student[] studentArray, Student s) {
		//현재 배열을 임시 배열에 복사한다.
		int size = studentArray.length;
		Student[] temp = new Student[size];
		for(int i = 0; i < size; i++) {
			temp[i]= studentArray[i];
		}
		// studentArray 의 크기를 1 늘린다.
		studentArray = new Student[size + 1];
		
		// studentArray에 temp 값을 복사한다.
		for(int i = 0; i < size; i++) {
			studentArray[i] = temp[i];
		}
		studentArray[size] = s; // s 객체의 주소값을  studentArray[size]에 저장
		
		return studentArray;
	}
	
	public static Board[] add(Board[] boardArray, Board b) {
		
		int size = boardArray.length;
		Board[] temp = new Board[size];
		for(int i = 0; i < size; i++) {
			temp[i] = boardArray[i];
		}
		boardArray = new Board[size + 1];
		
		for(int i = 0; i < size; i++) {
			boardArray[i] = temp[i];
		}
		boardArray[size] = b;
		
		return boardArray;
	}
	
	//3. 배열에 해당 요소가 존재하는지 체크하는 contains메소드 //contain (포함)
	//	A. Car[] 배열 버전
	public static boolean contains(Car[] carArray, Car c) {//Car c 의 의미 Car 의 객체 c
		// 여기서 가장 중요한 설명
		//carArray = new Car[5] 는 무슨 뜻인가?
		//carArray는 Car라는 객체 5개를 위한 공간이 있다.
		//Car의 배열은 carArray 를 말하며,
		//carArray[]는 Car클래스의 객체를 말하며 객체의 주소값을 가지고 있다.
		//ex) carArray = 3반 carArray[1] = 3반 1번학생   의개념이라고 예시를 들 수 있다.
		
		//  Car c = new Car;  에서
		// Car c -> 객체
		//c = new Car(); 이후 c는 인스턴스가 된다
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i].equals(c)) {//carArray[i] 는 주소값을 가지고 있으며, 객체 랑 값을 비교 하기 때문에 == 이 아닌 equals를 사용해 주어야함.
				return true;
			}
		}
		return false;
	}
	
	//	B. Student[] 배열 버전
	public static boolean contains(Student[] studentArray, Student s) {
		for(int i = 0 ; i < studentArray.length; i ++) {
			if(studentArray[i].equals(s)) {
				return true;	
			}
		}
		return false;
	}
	
	public static boolean contains(Board[] boardArray, Board b) {
		for(int i = 0; i <boardArray.length;i++) {
			if(boardArray[i].equals(b)) {
				return true;
			}
		}
		return false;
	}
	//4. 배열에 해당 요소가 몇번 인덱스에 존재하는지 체크하는 indexOf 메소드
	//	A. Car[] 버전
	public static int indexOf(Car[] carArray, Car c) {
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i].equals(c)) {
				return i;
			}
		}
		return -1;
	}
	
	//	B. Student[] 버전
	public static int indexOf(Student[] studentArray, Student s) {
		for(int i = 0; i < studentArray.length; i++) {
			if(studentArray[i].equals(s)) {
				return i;
			}
		}
	return -1;
	}
	
	public static int indexOf(Board[] boardArray, Board b) {
		for(int i = 0; i < boardArray.length; i++) {
			if(boardArray[i].equals(b)) {
				return i;
			}
		}
		return -1;
	}
	
	//	5. 배열에 해당 인덱스를 삭제하는 removeByIndex 메소드
	//	A. Car[] 버전
	public static Car[] removeByIndex(Car[] carArray, int index) {
		
		// index의 유효성 검증 
		if(index < 0 || index >= carArray.length) {
			return carArray;
		}
		
		// 임시배열에 현재 배열 복사
		Car[] temp = new Car[carArray.length];
		
		for(int i = 0; i < carArray.length; i ++) {
			temp[i] = carArray[i];
		}
		
		// 원본 배열의 크기 축소
		carArray = new Car[carArray.length - 1];
		
		//index의 위치에 따른 잘라내기 실행
		if(index == 0) {
			//인덱스가 제일 앞일 때
			for(int i = 1; i < temp.length; i++) {
				carArray[i-1] = temp[i];
			}
		}else if(index == temp.length - 1) {
			// 인덱스가 제일 마지막일 때
			for(int i = 0; i < temp.length -1; i++) {
				carArray[i] = temp[i];
			}
		}else {
			// 인덱스가 중간일 때
			for(int i = 0; i < temp.length; i++) {
				if(i < index) {
					carArray[i] = temp[i];
				}else if( i > index) {
					carArray[i - 1] = temp[i];
				}
			}
		}
		return carArray;
	}
	
	//	B. Student[] 버전
	public static Student[] removeByIndex(Student[] studentArray,int index) {
		//Student 배열은 studentArray 이고 studentArray[i] 는 Student 클래스의 객체이고,
		//studentArray[i] 는 객체의 주소값을 가지고 있다
		
		if(index < 0 || index >= studentArray.length) {
			return studentArray;
		}
		
		Student[] temp = new Student[studentArray.length] ;
		
		for(int i = 0 ; i < studentArray.length ; i++) {
			temp[i] = studentArray[i];
		}
		
		studentArray = new Student[studentArray.length -1];
		
		if(index == 0) {
			for(int i = 1; i < temp.length; i++ ) {
				studentArray[i-1] = temp[i];
			}
			
		}else if( index == temp.length -1) {
			for(int i = 0; i < temp.length -1 ; i++) {
				studentArray[i] = temp[i];
			}
			
		}else {
			for(int i = 0; i < temp.length; i++) {
				if( i < index) {
					studentArray[i] = temp[i];
				}else if( i > index) {
					studentArray[i-1] = temp[i];
				}
			}
			
		}
		return studentArray;
	}
	
	public static Board[] removeByIndex(Board[] boardArray,int index) {
		
		if(index < 0 || index >= boardArray.length) {
			return boardArray;
		}
		
		Board[] temp = new Board[boardArray.length];
		
		for(int i = 0 ; i < boardArray.length ; i++) {
			temp[i] = boardArray[i];
		}
		
		boardArray = new Board[boardArray.length - 1];
		
		if(index == 0) {
			for(int i = 1; i < temp.length; i++ ) {
				boardArray[i-1] = temp[i];
			}
			
		}else if( index == temp.length -1) {
			for(int i = 0; i < temp.length -1 ; i++) {
				boardArray[i] = temp[i];
			}
			
		}else {
			for(int i = 0; i < temp.length; i++) {
				if( i < index) {
					boardArray[i] = temp[i];
				}else if( i > index) {
					boardArray[i-1] = temp[i];
				}
			}
		}
		return boardArray;
			
	}
	
	//6. 배열에서 파라미터로 넘어온 객체를 삭제하는 removeByElement 메소드
	//	A. Student[] 버전
	public static Student[] removeByElement(Student[] studentArray, Student s) {
		return removeByIndex(studentArray, indexOf(studentArray, s));
	}
	
	public static Car[] removeByElement(Car[] carArray, Car c) {
		return removeByIndex(carArray, indexOf(carArray, c));
	}
	
	public static Board[] removeByElement(Board[] boardArray, Board b) {
		return removeByIndex(boardArray, indexOf(boardArray, b));
	}
}
