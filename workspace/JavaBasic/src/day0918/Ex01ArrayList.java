package day0918;

import java.util.ArrayList;

import day0916.Car;

// ArrayUtil(동적할당)의 단점:
// 우리가 필요할 때 마다 매번 비슷한 메소드들을 또 만들어 주어야 한다.
// 지금은 Student 배열과 Car 배열만 동적할당이 가능하다.
// 만약 우리가 게시판 만들면? 또 해당하는 메소드들을 만들어주어야 하고
// 회원? 회원도 만들어주어야 한다!!!
// 편한 방법 없을까?..
//

public class Ex01ArrayList {

	public static void main(String[] args) {
		// 자바에는 ArrayList라는 클래스가 존재한다.
		// 이 ArrayList는 우리가 동적할당으로 구현해놨던 모든 기능들을 알아서 가지고 있다.
		// 또한 템플릿이라는것을 사용해서
		// 모든 클래스를 동적할당 메소드를 따로 구현 안해도 사용가능하다.
		
		// ArrayList를 쓸 때 주의할 점 2가지
		// 1. 템플릿에는 클래스만 들어올 수 있다!
		//    Q) "강사님.. 기본형 데이터타입은 어레이리스트로 못써요?"
		//    A)네. 기본형 데이터 타입은 사용하지 못합니다.
		//    그래서 자바가 기본형 데이터타입을 클래스처럼 만들어 놓은 포장클래스(wrapper 클래스)가 존재합니다.
		//    int -> Integer, double -> Double 등등
		// 2. ArrayList는 내부적으로 해당 클래스의 equals() 메소드를 적극적으로 사용하기 떄문에
		//    우리가 만든 클래스에 equals() 메소드를 정확하게 구현하는 것이 중요하다.
		
		// ArrayList는 java.util 패키지에 있으므로 우리가 import 해야한다.
		
		// ArrayList 선언하기
		// ArrayList<클래스이름> list = new ArrayList<>();
		ArrayList<Car> carList = new ArrayList<>();
		
		Car c1 = new Car("a", "typeA", 2000, 1000000, "a");
		Car c2 = new Car("b", "typeB", 2001, 2000000, "b");
		Car c3 = new Car("c", "typeC", 2002, 3000000, "c");
		Car c4 = new Car("d", "typeD", 2003, 4000000, "d");
		Car c5 = new Car("e", "typeE", 2004, 5000000, "e");

		// 1. ArrayList의 현재크기를 알아볼때는 size()를 이용하면 된다.
		System.out.println("carList.size(): " + carList.size());
		
		// 2. ArrayList에 새로운 객체를 추가할 때에는 add() 메소드를 이용하면 된다.
		carList.add(c1);
		System.out.println("carList.size(): " + carList.size());
		carList.add(c2);
		System.out.println("carList.size(): " + carList.size());
		carList.add(c3);
		System.out.println("carList.size(): " + carList.size());
		carList.add(c4);
		System.out.println("carList.size(): " + carList.size());
		
		// 3. ArrayList에서 해당 위치에 있는 객체를
		System.out.println("carList.get(1)" + carList.get(1));
		// get으로 호출한 객체는 배열의 몇번째 칸에 있는 객체다 처럼 우리가 그 객체의 메소드를 실행해 줄 수 있다.
		System.out.println("carList.get(0).getType(): " + carList.get(0).getType());
	
		// 4. 어레이 리스트에서 객체를 제거할 때에는 2가지 방법이 가능하다.
		//	A) 인덱스로 삭제하기
		//		인덱스로 삭제할 때에는 remove(index)를 하면 된다.
		System.out.println("carList.get(0) : " + carList.get(0));
		carList.remove(0);
		System.out.println("carList.get(0) : " + carList.get(0));
		System.out.println("carList.size()" + carList.size());
	
		//	B) 객체로 삭제하기
		//		객체로 삭제할 때에는 해당 객체와 equals()가 true가 나오는 객체를 넣어주면 된다.
		Car c44 = new Car("d", "typeD", 2003, 4000000, "d");
		Car c55 = new Car("e", "typeE", 2004, 5000000, "e");
		
		System.out.println("c4.equals(c44): " + c4.equals(c44));
		System.out.println("carList.size(): " + carList.size());
		carList.remove(c44);
		System.out.println("carList.size(): " + carList.size());
		carList.remove(c55);
		System.out.println("carList.size(): " + carList.size());
		// remove에 객체를 집어넣으면
		// ArrayList는 해당 어레이리스트에 처음부터 끝까지
		// 파라미터로 넘어온 객체와 각 칸에 equals()를 실행해서
		// true가 나오는 칸을 삭제한다.
		// 만약 remove에 넘겨주는 객체랑 equals()가 true가 나오는 객체가 어레이 리스트에 없으면
		// 아무것도 삭제하지 않는다.
		
		// carList에 있던 애들: c1 c2 c3 c4
		// remove(0) 이후 : c2 c3 c4
		// remove(c44) 이후 : c2, c3
		
		// 5. carList에서 해당 객체의 index가 궁금하면 indexOf() 메소드를 실행하면 된다.
		System.out.println("carList.indexof(c2): " + carList.indexOf(c2));
		//	만약 해당 리스트에 그 객체가 존재하지 않으면 -1이 리턴된다.
		System.out.println("carList.indexOf(c4) " + carList.indexOf(c4));
		
		// 6. carList에서 해당 객체가 존재하는지 존재하지 않는지를 체크할 떄에는 contains() 메소드를 실행하면 된다.
		System.out.println("carList.contains(c2): " + carList.contains(c2));
		System.out.println("carList.contains(c4): " + carList.contains(c4));
		
		// 따라서, ArrayList를 제대로 사용하고 싶다면,
		// 우리가 < > 에 넣어줄 클래스에
		// equals()를 정확하게 만들어 주는 것이 중요하다!
		
		
	}

}
