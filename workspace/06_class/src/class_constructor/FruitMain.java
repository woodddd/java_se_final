package class_constructor;

/* ��ü �迭�� ����Ͽ� ����Ǯ��.
 * static�� Ȱ���ϱ�
���� �Ǹŷ� ���ϱ�
���� �����հ赵 ���Ͻÿ�
[������]
--------------------------------------
PUM		JAN		FEB		MAR		TOT
--------------------------------------
���		100		80		75		255
����		30		25		10		xxx
����		25		30		90		xxx
--------------------------------------
		xxx		xxx		xxx
 */

class Fruit{
	//������
	//calcTot() - ����հ� ���ϴ� �޼ҵ�
	//display() - ���ϸ�, 1��, 2��, 3��, �հ�
	//output() - 1���� �հ�, 2���� �հ�, 3���� �հ� ����ϴ� �޼ҵ�
	
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
		
		frarr[0] = new Fruit("���",100,80,75);
		frarr[1] = new Fruit("����",30,25,10);
		frarr[2] = new Fruit("����",25,30,90);
		//Ŭ���� ����
		//�޼ҵ� ȣ��
		
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
