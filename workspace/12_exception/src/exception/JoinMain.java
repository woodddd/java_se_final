package exception;



class JoinTest implements Runnable{ //�̰� JoinTest�� �����尡 �� ���� �ƴ�. ��ӹ��� ���� �ƴ϶� ������ �� �� ó�� implements �� �� �� ����

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
		//������ ����
		JoinTest jt = new JoinTest(); //JoinTest jt = new Thread(); �� �� �� ���� ������ JoinTest�� �����尡 �ƴ϶� �����尡 �ǰ���� �� ���̱� ����
		Thread t = new Thread(jt);//������ ����
		System.out.println("������ ����");
		//������ ����
		t.start();//������ ����
		try {		//join�� ����ϰ� �Ǹ� run�� �Ϻ��ϰ� ������ ������ ���� ������ �� �� ����.
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("������ ����"); // ���� join������ ���Ͽ� �ش� �����尡 ����� �� ���� main �޼ҵ尡 ������� �ʴ� ���� �� �� ����.
		//main�� ������ ��׶��忡�� ������� ���ư��� ������ ������� ������� �ʴ´�.

	}

}
