package class_constructor;

/* 객체 배열을 사용하여 문제풀기.
 * static을 활용하기
과일 판매량 구하기
월별 매출합계도 구하시오
[실행결과]
--------------------------------------
PUM		JAN		FEB		MAR		TOT
--------------------------------------
사과		100		80		75		255
포도		30		25		10		xxx
딸기		25		30		90		xxx
--------------------------------------
		xxx		xxx		xxx
 */

class Fruit{
	//생성자
	//calcTot() - 모든합계 구하는 메소드
	//display() - 과일명, 1월, 2월, 3월, 합계
	//output() - 1월의 합계, 2월의 합계, 3월의 합계 출력하는 메소드
	
	private String pum;
	private int jan;
	private int feb;
	private int mar;
	private int tot;
	private static int jantot;
	private static int febtot;
	private static int martot;
	
	public Fruit(String pum,int jan, int feb, int mar) {
		this.pum = pum;
		this.jan = jan;
		this.feb = feb;
		this.mar = mar;
		
	}
	
	
	public void calcTot() {
		tot = jan + feb + mar;
		
		jantot += jan;
		febtot += feb;
		martot += mar;
	}
	
	public void display() {
		
		System.out.println(pum + "\t" + jan + "\t" + feb + "\t" + mar + "\t" + tot);
		
	}
	
	public static void outPut() {
		System.out.println("\t" + jantot + "\t" + febtot + "\t" + martot);
	}
	
}


public class FruitMain {

	final static int SIZE = 3;
	
	public static void main(String[] args) {
		Fruit[] frarr = new Fruit[SIZE];
		
		frarr[0] = new Fruit("사과",100,80,75);
		frarr[1] = new Fruit("포도",30,25,10);
		frarr[2] = new Fruit("딸기",25,30,90);
		//클래스 생성
		//메소드 호출
		
		System.out.println("--------------------------------------");
		System.out.println("PUM\tJAN\tFEB\tMAR\tTOT");
		System.out.println("--------------------------------------");
		for(int i = 0; i < frarr.length ; i++) {
			frarr[i].calcTot();
			frarr[i].display();
		}
		System.out.println("--------------------------------------");
		Fruit.outPut(); 
		
		
	}

}
