package exception;



class JoinTest implements Runnable{ //이건 JoinTest가 스레드가 된 것이 아님. 상속받은 것이 아니라 스레드 인 것 처럼 implements 를 한 것 뿐임

	@Override
	public void run() {
		for(int i = 1; i <= 5; i ++) {
			System.out.println(i);
			
			try {
				Thread.sleep(500);
			}catch( InterruptedException e) {
				e.printStackTrace();
			}
		}//for
	}
	
}

//-----------------
public class JoinMain {

	public static void main(String[] args) {
		//스레드 생성
		JoinTest jt = new JoinTest(); //JoinTest jt = new Thread(); 를 할 수 없는 이유는 JoinTest는 스레드가 아니라 스레드가 되고싶은 것 뿐이기 때문
		Thread t = new Thread(jt);//스레드 생성
		System.out.println("스레드 시작");
		//스레드 실행
		t.start();//스레드 실행
		try {		//join을 사용하게 되면 run이 완벽하게 끝나기 전까지 다음 문으로 들어갈 수 없음.
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("스레드 종료"); // 위의 join문으로 인하여 해당 스레드가 종료될 떄 까지 main 메소드가 실행되지 않는 것을 볼 수 있음.
		//main이 끝나도 백그라운드에서 스레드는 돌아가기 때문에 스레드는 종료되지 않는다.

	}

}
