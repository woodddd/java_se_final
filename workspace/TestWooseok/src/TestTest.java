class AAA extends Thread{
	public void run() {
		System.out.println("class AAA");
	
	}
}

class BBB extends Thread{
public void run() {
		System.out.println("class BBB");
	}
}



public class TestTest extends Thread{
public void run() {
		System.out.println("TestTest");
	}

public static void main(String[] args) {
	TestTest ts = new TestTest();
	BBB bbb = new BBB();
	AAA aaa = new AAA();
	Thread t = new Thread(ts);
	Thread t1 = new Thread(bbb);
	Thread t2 = new Thread(aaa);
	t.start();
	t1.start();
	t2.start();

}
}
