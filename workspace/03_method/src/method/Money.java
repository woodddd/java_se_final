package method;

/*
 *  금액(money)이 5679원일 때 다음과 같이 출력하시오 (/, % 나머지 연산자로 풀으시오.)
 *  [실행결과]
 *  금액 : 5679원
 *  천원 : 5장
 *  백원 : 6개
 *  십원 : 7개
 *  일원 : 9개
 */

public class Money {

	public static void main(String[] args) {

		int money = 5679;
		int thousand = money / 1000 ;
		int hundred = money % 1000 / 100;
		int Ten = money % 1000 % 100 / 10;
		int one = money % 1000 % 100 % 10;
		
		System.out.println("[실행결과]");
		System.out.println("금액 : " + money);
		System.out.println("천원 : " + thousand + "장");
		System.out.println("백원 : " + hundred + "개");
		System.out.println("십원 : " + Ten + "개");
		System.out.println("일원 : " + one + "개");
		
		
	}

}
