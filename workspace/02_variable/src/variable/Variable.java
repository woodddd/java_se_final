package variable;

public class Variable {

	public static void main(String[] args) {

	boolean a;
	a = true;
	System.out.println("a = " + a);
	
	char b;
	b = 'A';
	System.out.println("b = " + b);
	
	char c;
	c = 65;
	// c = 65536; -error
	//char 는 2byte 까지 표현 가능하므로 65536 은 표현할 수 없고
	//65536 은 자바가 int 값으로 받아드려 타입 mismatch에러 가 나오게됨.
	System.out.println("c = " + c);
	
	//int d;
	//d = 65;
	int d = 65;
	System.out.println("d = " + d);
	
	int e ='A';
	System.out.println("e = " + e); 
	// char 형은 2바이트. int 형은 4바이트 이므로 int 형은 char 형을 가질 수 있음.
	
	
	//실수는 기본값을 double로 하는데 double 의 43.8 을 float 형에 집어 넣으려 하기 떄문에 못 넣는 것이다.
	//큰 변수형은 작은변수형에 넣을 수 없음. 에러가 발생됨.
	float f;
	f = 43.8f; // 43.8 을 강제로 float 형으로 변경
	//f = (float)43.8; //43.8은 double형 이지만, float형으로 임시 변형
	System.out.println("f = " + f);
	}
}
