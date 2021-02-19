package exception;

public class SingleTon {
	private int num = 3;
	private static SingleTon instance;
	
	
	//�Ѱ��� instance ��ü�� ������ �� getInstance() �� �����ϰ� �Ǹ� ������ instance ��ü�� ������ �����μ�
	//�Ѱ��� ��ü���� ����Ͽ� �̸� SingleTon �̶� ����.
	public static SingleTon getInstance() {
		if(instance == null) {
			synchronized(SingleTon.class) { // SingleTonŬ������ synchronized �� �ɾ� ����ȭ ��Ű�Ƿ� �ش� ��ü�� �� Ŭ������ ����Ѵٸ� �ٸ���ü�� ����� �� ����.
				instance = new SingleTon();
			}
		}
		
		return instance;
	}
	
	public static void main(String[] args) {
		
		SingleTon aa = new SingleTon();
		aa.num++;
		System.out.println("aa = " + aa);
		System.out.println("num = " + aa.num);
		System.out.println();
		
		SingleTon bb = new SingleTon();
		bb.num++;
		System.out.println("bb = " + bb);
		System.out.println("num = " + bb.num);
		System.out.println();
		
		System.out.println("***�̱���***");
		SingleTon cc = SingleTon.getInstance(); //����
		cc.num++;
		System.out.println("cc = " + cc);
		System.out.println("num = " + cc.num);
		System.out.println();
		
		SingleTon dd = SingleTon.getInstance(); //���� //���ο� getInstance �� ������ ���� �ƴ� ������ �����Ǿ��ִ� getInstance �� �ּ� ���� �޾ƿ� dd �� �����ϹǷ� �ᱹ dd �� cc�� ������ �ִ� ��ü �ּҿ� ���� �ּҸ� �����ϰ� �ȴ�.
		dd.num++;
		System.out.println("dd = " + dd);
		System.out.println("num = " + dd.num);
		System.out.println();
		
	}
	
}
