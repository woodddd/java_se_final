package util;

import day0915.Student;
import day0916.Car;
//import day0918.Board;//�̰� ���� ����Board[] �� ��� �� �� ����ϴ� import
import day0921.Board; // ����� ver �Խ��� �����

//���� ���� import �� ��Ű�� �ּҸ� �ٲ� �־ � Board �� ��� �ϴ����� ������ ��.

// �迭 ���� �޼ҵ带 ��Ƶ� Ŭ����
public class ArrayUtil {
	//3�ñ���
	//���⿡ �츮�� �����Ҵ翡�� ����ߴ� �޼ҵ��(indexOf, contains ���)��
	//Student[]�� Car[]�� ���� �� �ְ� ���弼��.
		
	//1. �ش� �迭�� ũ�⸦ Ȯ���ϴ� size() �޼ҵ�	
	//	A. Car[] ����
	public static int size(Car[] carArray) {
		return carArray.length;
	}
	
	//	B. Student[] ����
	public static int size(Student[] studentArray) {
		return studentArray.length;
	}
	
	public static int size(Board[] boardArray) {
		return boardArray.length;
	}
	
	//2. �迭�� ���ο��Ҹ� �߰��ϴ� �޼ҵ�
	
	//	A. car[] ����
	public static Car[] add(Car[] carArray, Car c) {
		//���� �迭�� �ӽ� �迭�� �����Ѵ�.
		int size = carArray.length;
		
		Car[] temp = new Car[size];
		for(int i = 0; i < size ;  i++) {
			temp[i] = carArray[i];
		}
		//carArray ũ�� ����
		carArray = new Car[size + 1];
		
		//�ӽ� �迭�� ������ ���� �ٽ� ������� �����´�.
		for(int i = 0 ; i < size; i++) {
			carArray[i] = temp[i];
		}
		//carArray�� ���� �� ������ ĭ�� c �߰�
		carArray[size] = c;
		
		return carArray;
	}
	
	//	B. Student[] ����
	public static Student[] add(Student[] studentArray, Student s) {
		//���� �迭�� �ӽ� �迭�� �����Ѵ�.
		int size = studentArray.length;
		Student[] temp = new Student[size];
		for(int i = 0; i < size; i++) {
			temp[i]= studentArray[i];
		}
		// studentArray �� ũ�⸦ 1 �ø���.
		studentArray = new Student[size + 1];
		
		// studentArray�� temp ���� �����Ѵ�.
		for(int i = 0; i < size; i++) {
			studentArray[i] = temp[i];
		}
		studentArray[size] = s; // s ��ü�� �ּҰ���  studentArray[size]�� ����
		
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
	
	//3. �迭�� �ش� ��Ұ� �����ϴ��� üũ�ϴ� contains�޼ҵ� //contain (����)
	//	A. Car[] �迭 ����
	public static boolean contains(Car[] carArray, Car c) {//Car c �� �ǹ� Car �� ��ü c
		// ���⼭ ���� �߿��� ����
		//carArray = new Car[5] �� ���� ���ΰ�?
		//carArray�� Car��� ��ü 5���� ���� ������ �ִ�.
		//Car�� �迭�� carArray �� ���ϸ�,
		//carArray[]�� CarŬ������ ��ü�� ���ϸ� ��ü�� �ּҰ��� ������ �ִ�.
		//ex) carArray = 3�� carArray[1] = 3�� 1���л�   �ǰ����̶�� ���ø� �� �� �ִ�.
		
		//  Car c = new Car;  ����
		// Car c -> ��ü
		//c = new Car(); ���� c�� �ν��Ͻ��� �ȴ�
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i].equals(c)) {//carArray[i] �� �ּҰ��� ������ ������, ��ü �� ���� �� �ϱ� ������ == �� �ƴ� equals�� ����� �־����.
				return true;
			}
		}
		return false;
	}
	
	//	B. Student[] �迭 ����
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
	//4. �迭�� �ش� ��Ұ� ��� �ε����� �����ϴ��� üũ�ϴ� indexOf �޼ҵ�
	//	A. Car[] ����
	public static int indexOf(Car[] carArray, Car c) {
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i].equals(c)) {
				return i;
			}
		}
		return -1;
	}
	
	//	B. Student[] ����
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
	
	//	5. �迭�� �ش� �ε����� �����ϴ� removeByIndex �޼ҵ�
	//	A. Car[] ����
	public static Car[] removeByIndex(Car[] carArray, int index) {
		
		// index�� ��ȿ�� ���� 
		if(index < 0 || index >= carArray.length) {
			return carArray;
		}
		
		// �ӽù迭�� ���� �迭 ����
		Car[] temp = new Car[carArray.length];
		
		for(int i = 0; i < carArray.length; i ++) {
			temp[i] = carArray[i];
		}
		
		// ���� �迭�� ũ�� ���
		carArray = new Car[carArray.length - 1];
		
		//index�� ��ġ�� ���� �߶󳻱� ����
		if(index == 0) {
			//�ε����� ���� ���� ��
			for(int i = 1; i < temp.length; i++) {
				carArray[i-1] = temp[i];
			}
		}else if(index == temp.length - 1) {
			// �ε����� ���� �������� ��
			for(int i = 0; i < temp.length -1; i++) {
				carArray[i] = temp[i];
			}
		}else {
			// �ε����� �߰��� ��
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
	
	//	B. Student[] ����
	public static Student[] removeByIndex(Student[] studentArray,int index) {
		//Student �迭�� studentArray �̰� studentArray[i] �� Student Ŭ������ ��ü�̰�,
		//studentArray[i] �� ��ü�� �ּҰ��� ������ �ִ�
		
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
	
	//6. �迭���� �Ķ���ͷ� �Ѿ�� ��ü�� �����ϴ� removeByElement �޼ҵ�
	//	A. Student[] ����
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
