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
		SnackTest aa = new SnackTest("�����");//������ ����
		SnackTest bb = new SnackTest("��īĨ");//������ ����
		SnackTest cc = new SnackTest("��Ĩ");//������ ����
		
		//������ �̸� �ο�
		aa.setName("�����");
		bb.setName("��īĨ");
		cc.setName("��");
		
		
		
		//�켱���� 1~10 (default : 5)
		aa.setPriority(10);// ���� �ǹ�  aa.setPriority(Thread.MAX_PRIORITY);
		bb.setPriority(Thread.MIN_PRIORITY);//1
		cc.setPriority(Thread.NORM_PRIORITY);//5
		
		aa.start();//������ ���� -> ������ ���� (run() �� ã�ư�) -> �ä���� �˾Ƽ� ����.
//		try {
//		aa.join(); // �����尡 ���⶧���� ��ٸ��� �Ѵ�.
//		} catch(InterruptedException e) {
//			e.printStackTrace();
//		}
		bb.start();
		cc.start();
		
	}
	
}
