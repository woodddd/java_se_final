package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATMTest implements Runnable{ //중요한 것! -> ATMTest는 절대 스레드가 아니다. 스레드 이고 싶은것 이다. implements Runnable
	private long depositeMoney = 100000; //잔액
	private long balance;//찾고자 하는 금액
	
	public static void main(String[] args) {
		ATMTest atm = new ATMTest();//ATMTest를 생성하면 implements관계를 생성할 수 있음
		
		// main 은 static 영역이기 때문에 this 를 사용할 수 없음
		Thread mom = new Thread(atm, "엄마");//스레드 생성//매개변수는 Runnable 타입 이어야함. ATMTest는 Runnable 을 implements 하고 있으므로  ATMTest의 객체인 atm 은 Rubbable 타입이라고도 할 수 있다.
		Thread son = new Thread(atm, "아들");//스레드 생성
		
		//위의 방법처럼 스레드를 생성할 때 스레드 이름을 넣어주거나 , (atm) 만 있을 땐 setName을 통해서 직접 값을 넣어줌.
		
//		mom.setName("엄마"); 
//		son.setName("아들");
		
		
		//스레드 시작 - 스레드는 동시 병행처리를 하기 떄문에 프로세스는 main메소드와 Thread 들을 병행처리 하게 된다.
		mom.start(); //스레드 시작 - 스레드 실행( run() )
		son.start();
	}

	@Override
	public synchronized void run() { //오버라이드 된 메소드는 throws를 사용할 수 없음.. 부모에도 다 걸려야 하기 때문..
		//0.00000000000000000001초라도 먼저 들어온 객체가 run()을 점유하여 사용하게 됨.
		//한개의 객체의 사용이 끝나면 그 후 이용이 가능함.
		//Synchronized (동기화) 를 걸어준 메소드, 또는 클래스 들은 여러 객체가 동시에 사용 할 수 없다.
		//먼저 사용한 객체가 존재하면 lock 을 걸어 메소드 또는 클래스를 보호한다. 해당 객체가 사용이 끝난 후 메소드를 사용이 가능하다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(Thread.currentThread().getName());//현재 run 을 실행중인 스레드를 알려줌.
		//currentThread 는 현재 실행되고 있는 Thread가 무엇인지 get해준다.
		//Thread의 이름이 존재한다면 Thread의 이름을 추출하지만, 이름이 존재하지 않는다면 Thread-n 인덱스 넘버와 같이 자동으로 번호가 할당되어 나온다.
		System.out.println("찾고자 하는 금액 입력: ");
		
		try {
		//long 8바이트          int    4바이트
			balance = Long.parseLong(br.readLine());
		} catch (IOException e) {// IOException 이 최상이 클래스 이기 때문에 이것만 있으면 모든 에러를 처리할 수 있음
			e.printStackTrace();
		}
		
		
		//잔액계산
		if(balance % 10000 != 0) {
			System.out.println("만원 단위로 입력하세요");
		}else{
			
			if(balance > depositeMoney) {
				System.out.println("잔액부족");
			}else {
				depositeMoney -= balance;//depositeMoney 필드가 static 변수가 아닌 이유 : Thread 가 atm 이라는 동일객체를 참조 하고 있기 때문에 run 메소드 실행 시 같은 객체의 depositeMoney값이 바뀌므로 static 을 지정하지 않은 것이다.
				System.out.println("잔액은 " + depositeMoney + " 원 입니다.");
			}
		}
	}
}


//찾고자 하는 금액 입력 : 38000			찾고자 하는 금액 입력 : 20000
//만원단위로 입력하세요.					잔액은 xxxx원 입니다.
