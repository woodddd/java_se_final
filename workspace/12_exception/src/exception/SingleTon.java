package exception;

public class SingleTon {
	private int num = 3;
	private static SingleTon instance;
	
	
	//한개의 instance 객체를 생성한 후 getInstance() 를 실행하게 되면 동일한 instance 객체를 참좋게 함으로서
	//한개의 객체만을 사용하여 이를 SingleTon 이라 말함.
	public static SingleTon getInstance() {
		if(instance == null) {
			synchronized(SingleTon.class) { // SingleTon클래으에 synchronized 를 걸어 동기화 시키므로 해당 객체는 가 클래스를 사용한다면 다른객체는 사용할 수 없다.
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
		
		System.out.println("***싱글톤***");
		SingleTon cc = SingleTon.getInstance(); //생성
		cc.num++;
		System.out.println("cc = " + cc);
		System.out.println("num = " + cc.num);
		System.out.println();
		
		SingleTon dd = SingleTon.getInstance(); //생성 //새로운 getInstance 를 생성한 것이 아닌 기존에 생성되어있던 getInstance 의 주소 값을 받아와 dd 에 저장하므로 결국 dd 는 cc가 가지고 있는 객체 주소와 동일 주소를 공유하게 된다.
		dd.num++;
		System.out.println("dd = " + dd);
		System.out.println("num = " + dd.num);
		System.out.println();
		
	}
	
}
