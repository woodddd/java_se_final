package loop;

/*
 * 대문자(A~Z)를 무작위로 100개를 발생하여 1줄에 10개씩 출력하시오
이중에서 A가 몇개인지 출력하시오

[실행결과]
H  D  D  R  A  Y  A  K  T  H
C  X  F  Z  B  S  L  Y  Q  D
H  K  O  H  O  B  Z  N  J  T
U  P  A  P  K  Q  G  W  F  A
S  U  D  Z  I  V  J  U  O  G
L  M  Z  L  H  U  Y  D  Q  R
F  T  I  Z  A  W  E  O  F  Z
A  Y  C  I  U  Z  O  B  C  G
H  G  Y  Z  V  P  I  R  L  G
Y  H  R  R  M  H  Y  S  B  P

A의 개수 = 6
 */

public class ForTest3 {

	public static void main(String[] args) {
		
		int a = 0;
		
		for(int i = 1; i <= 100 ; i++) {
			
			
			int nansu = (int)(Math.random()*26 + 65);
			System.out.printf("%-2c ",(char)nansu);// printf -> 포맷 형식 출력을 이용하여 균일한 자릿수를 배정할 수 있음
			// 또한 형식으로는 %d 정수 %f 실수 %s 문자열 %c 문자 와 같이 이용할 수 있고 %-3c --- -3 의 - 는 왼쪽을 기준 정렬 하라는 것이고,3은  문자를 전체자리 3자리로 사용하는 말
			if(i % 10 == 0) {
				System.out.println();
			}
			if(nansu == 'A') {
				a++;
			}
		}
		System.out.println();
		System.out.print("A의 개수 = " + a);
	}

}
