package exception;

public class MakeException extends Exception {	//�����ڰ� ���� Exception
	private String errorMsg;
	
	public MakeException(){}
	
	public MakeException(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	@Override
	public String toString() {
		return getClass() + ":" + errorMsg;//getClass()�޼ҵ�� Object Ÿ���̴�. Ŭ���� ��θ� �����.
		//return errorMsg;
	}
	
	public static void main(String[] args) {
	}
}
