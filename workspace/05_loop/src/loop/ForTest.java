package loop;

public class ForTest {

	public static void main(String[] args) {
		
		int i;
		
		for(i = 1 ; i <= 10 ; i ++) {
			System.out.println("Hello kitty  " + i);
		}//지역변수 - 구역{ } 에서만 생존기간. 구역 밖에선 생존하지 못함(소멸) 
		//현재 문장에서는 for(int i= 1) 와 같이 for문에서 i를 선언해 줬으므로 for{ } for 문이 종료되면 변수는 소멸됨.
		System.out.println("탈출 i = " + i);
		System.out.println();
		
		// 10 9 8 7 6 5 4 3 2 1 
		for(i = 10; i > 0; i--) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		// A B C D E F G ... X Y Z
		for(i = 65; i <91; i++) { //for(i = 'A'; i <= 'Z' ; i++) 가 더 정확하고 보기 좋음
			System.out.print((char)i + " ");
		}
	}

}
