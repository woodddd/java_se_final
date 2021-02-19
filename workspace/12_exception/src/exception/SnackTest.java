package exception;

public class SnackTest extends Thread {

	private String str;
	
	public SnackTest(String str) {
		this.str = str;
	}
	
	public void run() {
		for(int i =1 ; i <= 5 ; i++) {
			System.out.println(str + "\t" + "i = " + i + Thread.currentThread());
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		SnackTest aa = new SnackTest("새우깡");//스레드 생성
		SnackTest bb = new SnackTest("포카칩");//스레드 생성
		SnackTest cc = new SnackTest("썬칩");//스레드 생성
		
		//스레드 이름 부여
		aa.setName("새우깡");
		bb.setName("포카칩");
		cc.setName("썬");
		
		
		
		//우선순위 1~10 (default : 5)
		aa.setPriority(10);// 같은 의미  aa.setPriority(Thread.MAX_PRIORITY);
		bb.setPriority(Thread.MIN_PRIORITY);//1
		cc.setPriority(Thread.NORM_PRIORITY);//5
		
		aa.start();//스레드 시작 -> 스레드 실행 (run() 를 찾아감) -> 운영채제가 알아서 수행.
//		try {
//		aa.join(); // 스레드가 멈출때까지 기다리게 한다.
//		} catch(InterruptedException e) {
//			e.printStackTrace();
//		}
		bb.start();
		cc.start();
		
	}
	
}
