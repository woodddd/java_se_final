package class_constructor;
/*
x와 y의 값을 받아서 합,차,곱,몫을 구하시오

클래스명 : Compute
필드      : x, y, sum, sub, mul, div
메소드   : 생성자를 통해서 데이터를 주입
        calc() - 합, 차, 곱, 몫을 계산
        getX()
        getY()
        getSum()
        getSub()
        getMul()
        getDiv()
        
[실행결과]
X      Y      SUM      SUB      MUL      DIV
320      258
256		 125
452      365	
*/
public class ComputeMain {

	public static void main(String[] args) {

		//객체 배열
//		Compute[] ar = new Compute[3]; //객체배열
		//여기서 중요한 것! 여기서 new 는 Compute 클래스를 생선한 것이 아니다. 단지 자료형 Compute 클래스 타입의 방이 3개인 배열을 생성한 것이다.
//		ar[0] = new Compute(320, 258);
//		ar[1] = new Compute(256, 125);
//		ar[2] = new Compute(452, 365);
		
		//Compute[] ar = {new Compute(320, 258),new Compute(256, 125),new Compute(452, 365)};
		//위에처럼도 사용 가능함
		
		Compute[] ar = new Compute[]{new Compute(320,258),
                new Compute(256, 125),
                new Compute(452, 365)};		
		
		ar[0].calc();
		System.out.println("X\tY\tSUM\tSUB\tMUL\tDIV");
		System.out.println();
		for(int i = 0 ; i < ar.length ; i++) {
			ar[i].calc();
			
			System.out.println(ar[i].getX() + "\t"
					+ ar[i].getY() + "\t"
					+ ar[i].getSum() + "\t"
					+ ar[i].getSub() + "\t"
					+ ar[i].getMul() + "\t"
					+ ar[i].getDiv());
			System.out.println();
		}
		
	}

}
