package class_constructor;

import java.util.Scanner;

public class Assert {
	
	private int x,y,result = 1;
	
	public static void main(String[] args) {
		Assert as = new Assert();
		
		as.input();
		as.output();

	}
	
	public void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("x 입력 : ");
		x = scanner.nextInt();
		
		System.out.print("y 입력: ");
		y = scanner.nextInt();
		
	}
	
	public void output() {
		//y는 반드시 양수만 입력받겠다.
		//assert y >= 0; //해당 조건이 만족하면 아래의 식을 수행 할 것이고, 조건을 만족하지못하면 여기서 멈춘다.
		//단, assert는 일반 run 을 실행하면 무시되고,
		//Run as - Run Configrations - Arguments - VM Arguments 의 값에 -ea 를 주게 되면 assert를 처리하게됨. (-da 를 주게 되면 처리하지 않게 됨)
		// -ea (enable) -da(disable)
		assert y >= 0 : "y는 0보다 크거나 같아야 한다.";// assert 조건 : "에러메시지"; 조건을 만족하지 않을 시 에러메시지 수행. 후 아래문장을 실행하지 않음
		System.out.print(x + "의 " + y + "승은 ");
		for(int i = 0 ; i < y ; i++) {
			result *= x;
		}
		System.out.println(result);
	}

}
