package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ATMTest implements Runnable{ //�߿��� ��! -> ATMTest�� ���� �����尡 �ƴϴ�. ������ �̰� ������ �̴�. implements Runnable
	private long depositeMoney = 100000; //�ܾ�
	private long balance;//ã���� �ϴ� �ݾ�
	
	public static void main(String[] args) {
		ATMTest atm = new ATMTest();//ATMTest�� �����ϸ� implements���踦 ������ �� ����
		
		// main �� static �����̱� ������ this �� ����� �� ����
		Thread mom = new Thread(atm, "����");//������ ����//�Ű������� Runnable Ÿ�� �̾����. ATMTest�� Runnable �� implements �ϰ� �����Ƿ�  ATMTest�� ��ü�� atm �� Rubbable Ÿ���̶�� �� �� �ִ�.
		Thread son = new Thread(atm, "�Ƶ�");//������ ����
		
		//���� ���ó�� �����带 ������ �� ������ �̸��� �־��ְų� , (atm) �� ���� �� setName�� ���ؼ� ���� ���� �־���.
		
//		mom.setName("����"); 
//		son.setName("�Ƶ�");
		
		
		//������ ���� - ������� ���� ����ó���� �ϱ� ������ ���μ����� main�޼ҵ�� Thread ���� ����ó�� �ϰ� �ȴ�.
		mom.start(); //������ ���� - ������ ����( run() )
		son.start();
	}

	@Override
	public synchronized void run() { //�������̵� �� �޼ҵ�� throws�� ����� �� ����.. �θ𿡵� �� �ɷ��� �ϱ� ����..
		//0.00000000000000000001�ʶ� ���� ���� ��ü�� run()�� �����Ͽ� ����ϰ� ��.
		//�Ѱ��� ��ü�� ����� ������ �� �� �̿��� ������.
		//Synchronized (����ȭ) �� �ɾ��� �޼ҵ�, �Ǵ� Ŭ���� ���� ���� ��ü�� ���ÿ� ��� �� �� ����.
		//���� ����� ��ü�� �����ϸ� lock �� �ɾ� �޼ҵ� �Ǵ� Ŭ������ ��ȣ�Ѵ�. �ش� ��ü�� ����� ���� �� �޼ҵ带 ����� �����ϴ�.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(Thread.currentThread().getName());//���� run �� �������� �����带 �˷���.
		//currentThread �� ���� ����ǰ� �ִ� Thread�� �������� get���ش�.
		//Thread�� �̸��� �����Ѵٸ� Thread�� �̸��� ����������, �̸��� �������� �ʴ´ٸ� Thread-n �ε��� �ѹ��� ���� �ڵ����� ��ȣ�� �Ҵ�Ǿ� ���´�.
		System.out.println("ã���� �ϴ� �ݾ� �Է�: ");
		
		try {
		//long 8����Ʈ          int    4����Ʈ
			balance = Long.parseLong(br.readLine());
		} catch (IOException e) {// IOException �� �ֻ��� Ŭ���� �̱� ������ �̰͸� ������ ��� ������ ó���� �� ����
			e.printStackTrace();
		}
		
		
		//�ܾװ��
		if(balance % 10000 != 0) {
			System.out.println("���� ������ �Է��ϼ���");
		}else{
			
			if(balance > depositeMoney) {
				System.out.println("�ܾ׺���");
			}else {
				depositeMoney -= balance;//depositeMoney �ʵ尡 static ������ �ƴ� ���� : Thread �� atm �̶�� ���ϰ�ü�� ���� �ϰ� �ֱ� ������ run �޼ҵ� ���� �� ���� ��ü�� depositeMoney���� �ٲ�Ƿ� static �� �������� ���� ���̴�.
				System.out.println("�ܾ��� " + depositeMoney + " �� �Դϴ�.");
			}
		}
	}
}


//ã���� �ϴ� �ݾ� �Է� : 38000			ã���� �ϴ� �ݾ� �Է� : 20000
//���������� �Է��ϼ���.					�ܾ��� xxxx�� �Դϴ�.
