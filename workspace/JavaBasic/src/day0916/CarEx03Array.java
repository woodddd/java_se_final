package day0916;


// Ŭ���� �迭
public class CarEx03Array {
	final static int SIZE = 3;
	public static void main(String[] args) {
		
		Car[] carArray = new Car[SIZE];
		for(int i = 0; i < carArray.length; i++) {
			//Ŭ������ �迭�� �迭 ������ �ʱ�ȭ ���Ŀ�
			//�� ��ġ���� �츮�� �����ڸ� ȣ���ؼ�
			//�ش� �ε����� �ʱ�ȭ�� �� �־�� �Ѵ�.
			//���� ������NullPointerException������ �߻��Ѵ�.
			carArray[i] = new Car();
			carArray[i].setNumber("00�� 000" + i);
			carArray[i].setType("�ҳ�Ÿ");
			carArray[i].setYear(2020);;
			carArray[i].setPrice(7000000);
			carArray[i].setColor("�����");
		}
		
		for(int i = 0; i< carArray.length; i++) {
			System.out.println(carArray[i]);
		}
	}

}
