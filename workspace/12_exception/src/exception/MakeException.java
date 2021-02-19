package exception;

public class MakeException extends Exception {	//개발자가 만든 Exception
	private String errorMsg;
	
	public MakeException(){}
	
	public MakeException(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	@Override
	public String toString() {
		return getClass() + ":" + errorMsg;//getClass()메소드는 Object 타입이다. 클래스 경로를 끌고옴.
		//return errorMsg;
	}
	
	public static void main(String[] args) {
	}
}
