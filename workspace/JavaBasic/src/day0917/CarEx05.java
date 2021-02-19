package day0917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0916.Car;

// ���� ������
// ���� �տ��� ���� �����ϰ�
// ��ĭ�� ���ܼ� �� �������� ������ ��������
// �迭�� �����ϴ� ���α׷�

public class CarEx05 {
	private static int SIZE = 3;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Car[] carArray = new Car[SIZE];
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			showMenu();
			int userchoice = Integer.parseInt(br.readLine());
			
			if(userchoice == 1) {
				//�Է� �޼ҵ� ����
				
				carArray = add(carArray);
			}else if(userchoice == 2) {
				//��� �޼ҵ� ����
				printArray(carArray);
			}else if(userchoice == 3) {
				//�޽��� ��� �� ����
				System.out.println("������ּż� �����մϴ�.");
				break;
				
			}else {
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
			}
		}
	}
	
	private static void printArray(Car[] carArray) {// CarŬ���� �迭�� carArray �� �Ķ���ͷ� �޾ƿ�.(Car[] �� �Ķ������ ������ Ÿ���� ����)
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i] != null) {
				System.out.println("carArray[i] : " + carArray[i]);
			}
		}
	}
	
	private static Car[] add(Car[] carArray) throws IOException {
		int index = findEmptyIndex(carArray);
		if(index != -1) {
			//��ĭ�� �����ϹǷ� index �� ĭ��
			//Car ��ü�� �־��ش�.
			carArray[index] = setCarInfo();
		}else {
			// �迭�� ��� �� �� á���Ƿ� �迭�� �� ĭ�� ���ܼ�
			// �� ������ ĭ�� ���ο� �Էµ� c�� �ְ� ���þ�����
			for(int i = 1; i < carArray.length; i++ ) {
				carArray[i-1] = carArray[i];
			}
			carArray[SIZE - 1] = setCarInfo();
		}
		return carArray;
	}
	
	private static Car setCarInfo() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Car c = new Car(); // ���⼭ ������ c �� �޼ҵ� ���ο��� ���� �����ϰ� �� �ּҰ��� ������ �ִٰ�
							//carArray[SIZE - 1] = setCarInfo(); �̰��� ���� return ���ְ� c�� �Ҹ�ȴ�.
							// �׷��Ƿ� setCarInfo() �� �ٽ� ����� ��, ���� ���� ������ �ּ� ���� �ƴ�
							// ���ο� c ��ü�� �����Ͽ� ���ο� �ּҰ��� �Ѱ��ְ� �Ǵ� ����.
		
		System.out.println("���� ���� : ");
		c.setNumber(br.readLine());
		System.out.println("���� ���� : ");
		c.setType(br.readLine());
		System.out.println("���� ���� : ");
		c.setYear(Integer.parseInt(br.readLine()));
		System.out.println("���� ���� : ");
		c.setPrice(Integer.parseInt(br.readLine()));
		System.out.println("���� ���� : ");
		c.setColor(br.readLine());
		
		return c; // ����Ÿ���� Car �̹Ƿ� CarŬ������ c ��ü�� ��ȯ�ϰڴٴ� �ǹ���
		
	}
	
	private static int findEmptyIndex(Car[] carArray) {
		for(int i = 0; i < carArray.length; i++) {
			if(carArray[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	private static void showMenu() {
		System.out.println("��Ʈ �������� ���α׷� ver 2.0");
		System.out.println("1. �Է� 2. ��� 3. ����");
		System.out.print("> ");
	}

}
