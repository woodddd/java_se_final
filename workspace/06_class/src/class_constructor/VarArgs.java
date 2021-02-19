package class_constructor;

public class VarArgs {

//	public int sum(int a, int b) {
//		return a + b;
//	}
//	
//	public int sum(int a, int b, int c) {
//		return a + b + c;
//	}
//	
//	public int sum(int a, int b, int c, int d) {
//		return a + b + c + d;
//	}
	//
	public int sum(int...ar) { // 파라미터의 개수에 따라 배열의 방을 잡음. // 파라미터의 자료형을 Object로 하게 되면, Object 는 모든 최상위개체, 모든타입을 수용할 수 있음
		int hap = 0;
		for(int i = 0; i < ar.length ; i++) {
			hap += ar[i];
		}//for
		return hap;
	}
	
	public static void main(String[] args) {
		VarArgs va = new VarArgs();
		System.out.println("합 = " + va.sum(10,20));
		System.out.println("합 = " + va.sum(10,20,30));
		System.out.println("합 = " + va.sum(10,20,30,40));
		
		
	}
}
