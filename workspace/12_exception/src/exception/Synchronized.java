package exception;

public class Synchronized extends Thread{
	private static int count;
	
	public static void main(String[] args) {
		

		Synchronized aa = new Synchronized(); //스레드 생성
		Synchronized bb = new Synchronized(); //스레드 생성
		Synchronized cc = new Synchronized(); //스레드 생성
		
		aa.setName("aa");//스레드 이름 지정
		bb.setName("bb");
		cc.setName("cc");
		
		aa.start();//스레드 시작 - 스레드 실행 (run())
		bb.start();
		cc.start();
		
	}
	
	//동기화를 하기 위해서는 항상 충돌이 일어나야함. 같이 사용을 할 때에, 한개만 사용하게끔 막아줄 수 있는것임.
	@Override
	//public synchronized void run() { //현재 객체들은 각각의 run() 메소드를 가지고 있기 때문에 synchronized 로 동기화를 막지 못한것임.
	public void run() {
		synchronized(Synchronized.class) { // 클래스 자체에 synchronized를 걸어 동시에 메소드에 접근하는 것을 막는것임.  - 동기화 O
		//synchronized(this) { //동기화가 안됨. 각각의 객체로서 현재 메소드에 접근하기 때문. - public synchronized void run() 과 동일
			for(int i = 1; i <= 5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName()+" : " + count);
			}
		}
	}
}
