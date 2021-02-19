package exception;

public class Synchronized extends Thread{
	private static int count;
	
	public static void main(String[] args) {
		

		Synchronized aa = new Synchronized(); //������ ����
		Synchronized bb = new Synchronized(); //������ ����
		Synchronized cc = new Synchronized(); //������ ����
		
		aa.setName("aa");//������ �̸� ����
		bb.setName("bb");
		cc.setName("cc");
		
		aa.start();//������ ���� - ������ ���� (run())
		bb.start();
		cc.start();
		
	}
	
	//����ȭ�� �ϱ� ���ؼ��� �׻� �浹�� �Ͼ����. ���� ����� �� ����, �Ѱ��� ����ϰԲ� ������ �� �ִ°���.
	@Override
	//public synchronized void run() { //���� ��ü���� ������ run() �޼ҵ带 ������ �ֱ� ������ synchronized �� ����ȭ�� ���� ���Ѱ���.
	public void run() {
		synchronized(Synchronized.class) { // Ŭ���� ��ü�� synchronized�� �ɾ� ���ÿ� �޼ҵ忡 �����ϴ� ���� ���°���.  - ����ȭ O
		//synchronized(this) { //����ȭ�� �ȵ�. ������ ��ü�μ� ���� �޼ҵ忡 �����ϱ� ����. - public synchronized void run() �� ����
			for(int i = 1; i <= 5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName()+" : " + count);
			}
		}
	}
}
