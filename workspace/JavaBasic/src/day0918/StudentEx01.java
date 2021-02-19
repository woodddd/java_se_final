package day0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0915.Student;
import util.ArrayUtil;

public class StudentEx01 {
	private static BufferedReader bufferedReader;
	private static Student[] studentArray;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		studentArray = new Student[0];
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		//BufferedReader 를 초기화, 즉 생성자를 호출하고 나서부터는
		//만약 메인 메소드가 다른 메소드를 그 이후에 호출하게 된다면
		//이미 초기화가 된 상태이기 때문에 NullPointerException이 발생하지 않고
		//정상적으로 사용할 수 있다.
		
			showMenu();
	
	}
	private static void showMenu() throws NumberFormatException, IOException {
		while(true) {
			System.out.println("비트 성적 관리 프로그램");
			System.out.println("1. 입력 2. 출력 3. 종료");
			System.out.print("> ");
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			if(userChoice == 1) {
				//입력 메소드 실행
				add();
			}else if(userChoice == 2) {
				//출력 메소드 실행
				printArray();
			}else if(userChoice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
	
	private static void printArray() {
		for(int i = 0; i < studentArray.length; i++) {
			System.out.println(studentArray[i]); // 이곳의 System.out.println 의 파라미터 값에 studentArray[i] 라는 객체가 들어가서
			//원래는 주소 값이 출력 되어야 하는데 Student 클래스에 toString 메소드를 오버라이딩 하여 값이 나오게 만들어 놓았으므로 값이 출력되게 된다.
		}
	}
	
	private static void add() throws IOException {
		studentArray = ArrayUtil.add(studentArray, setStudentInfo());
	}
	
	private static Student setStudentInfo() throws IOException {
		
		Student s = new Student();// Student()객체를 생성하고 객체의 자료형은 Student, 이름은 s가 된다.
		
		System.out.print("학생 이름: ");
		s.setName(bufferedReader.readLine());
		
		System.out.print("학생 번호: ");
		s.setId(Integer.parseInt(bufferedReader.readLine()));
		
		System.out.print("국어 점수: ");
		s.setKorean(Integer.parseInt(bufferedReader.readLine()));
		
		System.out.print("영어 점수: ");
		s.setEnglish(Integer.parseInt(bufferedReader.readLine()));
	
		System.out.print("수학 점수: ");
		s.setMath(Integer.parseInt(bufferedReader.readLine()));
		
		return s;
	}
	
}
