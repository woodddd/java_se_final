package day0912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//가변형 배열
//가변형 배열이란 다차원 배열을 선언할 때
//가장 위의 크기만 선언해주고
//거기에 속하는 배열의 크기는 사용할 때 정해주는 방법이다.

//예시 : 1학년 1반은 30명, 2반은 29명, 3반은 32명일때
//배 선언을 어떻게 해야할까?
//int[][] scoreArray = int[3][];
//scoreArray[0] = new int[30];
//scoreArray[1] = new int[29];
//scoreArray[2] = new int[32];

public class Ex02MultiArray {
	
	static final int SIZE = 3;

	public static void main(String[] args) throws NumberFormatException, IOException {
		//1학년 각반의 학생수를 입력 받고
		//그 학생들의 이름을 반마다 넣어주는 프로그램
		String[][] nameArray = new String[SIZE][];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("비트고등학교 이름 관리 프로그램");
			System.out.println("1. 입력 2. 출력 3. 종료");
			System.out.print("> ");
			int choice = Integer.parseInt(br.readLine());
			if(choice == 1) {
				//반을 선택하는 메소드 실행
				int ban = banchoice(br); // 반 선택
				
				//이름을 입력하는 메소드 실행
				//단 배열의 크기를 결정해야하므로
				//학생 숫자를 입력 받도록 한다.
				int studentSize = insertStudentSize(br); // 학생의 숫자 입력
				
				//입력받은 반과 학생숫자로 해당 배열을 초기화해준다.
				nameArray[ban-1] = new String[studentSize];// 만약 1반을 선택하고 학생을 30 명 이라고 하면, nameArray[0] = new String[30] 이므로 nameArray 배열 0번지 에는 String 타입 1차원배열이 30개가 생성된다.
				//학생의 이름을 입력받는다.
				for( int i = 0; i < nameArray[ban - 1].length; i++) {
					System.out.print((i + 1) + "번 학생의 이름 : ");
					nameArray[ban -1][i] = br.readLine(); // 위에 설명한 예시로 말을 하자면 nameArray 의 0 번지 주소에 30개의 String 1차원 배열을 생성하였으므로 그 곳에 값을 넣어주는 작업. nameArray[0][0],nameArray[0][1],nameArray[0][2]...nameArray[0][29] = "김우석"
				}
			}else if(choice == 2) {
				//반 선택하는 메소드 실행
				int ban = banchoice(br);
				//이름을 출력하는 메소드 실행
				//단 여기서 주의해야할 것은
				//해당 배열이 초기화가 되어 있는지 체크를 해야 한다.
				//만약 해당 배열이 초기화 되어있지 않다면
				//그 공간은 현재 null인 상태이므로
				//우리가 접근할 수 없다.
				//따라서 그 배열이 null인지부터 체크하고
				//null이 아닐때에만 출력하는 for문을 실행한다.
				
				//null이란 참조형 데이터타입의 초기화가
				//아직 안 이루어져 있는 상태를
				//널이라고 한다.
				
				if(nameArray[ban-1] == null) {
					System.out.println("아직 해당 반은 입력되지 않은 상태입니다.");
				}else {
					for(int i = 0; i < nameArray[ban-1].length; i++) {
						System.out.println(nameArray[ban - 1][i]);
					}
				}
				
				//기본형 데이터타입과 참조형 데이터타입의 차이점
				//기본형 : 스택 영역에 값이 곧장 들어가 있는 데이터 타입.
				//		btye short int long float double char boolean 8가지 종류가 있고
				//		기본적으로 0으로 초기화된다.
				
				//참조형 : 스택 영역에는 힙 영역으로 가는 주소값이 적혀져 있고
				//		실제 변수의 값 또는 메소드는 힙 영역을 확인해야 어떤 값, 어떤 메소드가 있는지 확인 가능한 데이터타입
				//		참조형에는 클래스(=객체형), 배열형, 인터페이스형 3가지가 있고
				//		new를 통해서 초기화 하지 않으면 null 로 초기화가 된다.
				//		null이란, 스택 영역에 주소값은 부여가 되어 있지만
				//		힙 영역에는 아무런 정보가 없는 상태를 null이라고 한다.
				//		null인 상태에서는 아무런 메소드, 필드 접근이 불가능하다.
				//		접근을 할려고 하면 NullPointerException이 발생하게 된다!!!
				
			}else if(choice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
				
			}
			
		}
		
	}
	
	private static char[] size(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	static int banchoice(BufferedReader a) throws NumberFormatException, IOException {
		System.out.print("반을 선택 : ");
		int ban = Integer.parseInt(a.readLine());
		
		
		while(ban < 1 || ban > SIZE) {
			System.out.println("잘못 입력하였습니다.");
			System.out.print("반을 선택 :(1부터 " + SIZE + "까지");
			System.out.print("> ");
			ban = Integer.parseInt(a.readLine());
		}
		return ban;
		
	}
	
	static String nameInput(BufferedReader a) throws IOException {
		System.out.print("이름 입력: ");
		String name = a.readLine();
		
		return name;
	}

	
	//학생의 수를 입력받는 메소드
	static int insertStudentSize(BufferedReader a) throws NumberFormatException, IOException {
		System.out.print("학생의 숫자 입력: ");
		int studentSize = Integer.parseInt(a.readLine());
		while(studentSize < 0) {
			System.out.println("잘못입력하셨습니다. 0보다 큰 수를 입력해주세요");
			System.out.println("학생의 숫자를 입력해주세요: ");
			studentSize = Integer.parseInt(a.readLine());
		}
		return studentSize;
	}
}
