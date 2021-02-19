package day0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//������ �迭
//�Ȱ��� ������Ÿ���� ���ִ� ���� �츮�� �迭�̶�� �Ѵ�.
//�׷� �迭�� ���ִ°�?

//��ǥ���� ������ �迭�� ���ð�
//�б��� �л����� �������� �迭
//[1�г�][���][����� ����]
//[2�г�][���][����� ����]
//[3�г�][���][����� ����]

public class Ex06MultiDimensionArray {
	final static int YEAR = 3;
	final static int TESTNUM = 4;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		//int 2���� �迭�� ������
		int[][] array = new int[2][3];
		//�� 2���� �迭��
		//int�� 3�� �� �� �ִ� �迭 2���� ���ִ� ��� ���� �ȴ�.
		
		for(int i = 0; i < array.length; i++) {//array.length = 2 //int�� 3�� �� �� �ִ� �迭 2���� ���ִ� ��� ���� �ȴ�.
			for(int j = 0; j < array[i].length; j++) {//array[i].length = //�迭�� ����  = 3 ���� int ��
				System.out.println("i: " + i + ", j: " + j);
			}
		}

		//�츮�� �� �迭�� ���� ���� ������
		//1����������
		//�迭�̸�[�ε���] = ��;
		//�̷��� �־�����
		
		//2�����迭������
		//�迭�̸�[���°�迭][�ε���] = ��
		//�̷��� �־�� �Ѵ�.
		
		//�׷�array�� 0��° �迭 2�� �ε����� 10�� �־����
		array[0][2] = 10;
		
		//�л��� ������ �����ϴ� �迭�� ���� ��
		//1,2,3�г�
		//������ 1�б� �߰� 1�б� �⸻, 2�б� �߰� 2�б� �⸻ �� �����ϴ�
		//�迭�� �����غ�����!
		
		
		
			int[][] koreanArray = new int[YEAR][TESTNUM];
			int[][] englishArray = new int[YEAR][TESTNUM];
			int[][] mathArray = new int[YEAR][TESTNUM];
			
			int year = 0;
			int number = 0;
			int korean = 0;
			int english = 0;
			int math = 0;
			int menu = 0;
			//����ڷκ��� ���г� ���° ������������ �Է¹޾Ƽ�
			//�ش� ��ġ�� ������ �ִ� �ڵ带 �����Ͻÿ�
			//����1. �߸��� �г��� �Էµ����ʰ� �Ͻÿ�
			//����2. ����� ���������� �Է¹��� �� �߸��� ������ �Էµ��� �ʰ� �Ͻÿ�.
			//����3. ������ �ùٸ� ������ �Էµǰ� �Ͻÿ�.
			
			//����
			//���г� �����Դϱ�? (�Է�4)
			//�ùٸ��� ���� �г��Դϴ�.
			//���г� �����Դϱ�? (�Է� 2)
			//����� �����Դϱ�? (�Է� -2)
			//�ùٸ��� ���� �����Դϴ�.
			//����� �����Դϱ�? (�Է� 1)
			//�����Դϱ�? (�Է� 80)
			//2�г� 1�б� �߰���� ��� 80���� �ԷµǾ����ϴ�.
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Ex06MultiDimensionArray mt = new Ex06MultiDimensionArray();
			
			
			
		while(true) {
			
			System.out.println("1.�Է�");
			System.out.println("2.���");
			menu = Integer.parseInt(br.readLine());
			
			while(menu < 1 || menu > 2) {
				System.out.println("�޴����� �߸� �Է� �Ͽ����ϴ�.");
				System.out.println("���� �ٽ� �Է����ּ���.");
				menu = Integer.parseInt(br.readLine());
				}
			
			if(menu == 1) {
				
			System.out.print("���г� �����Դϱ�?");
			year = mt.schoolyear(br);
			
			
			System.out.print("�� ��° �����Դϱ�?");
			number = mt.whattest(br);
			
			
			System.out.print("�������� : " );
			korean = mt.Testscore(br);
			
			System.out.print("�������� : " );
			english = mt.Testscore(br);
			
			System.out.print("�������� : " );
			math = mt.Testscore(br);
			
			}else if( menu == 2) {
			
			koreanArray[year-1][number-1] = korean;
			englishArray[year-1][number-1] = korean;
			mathArray[year-1][number-1] = korean;
			System.out.print(year + "�г� ");
			switch(number) {
			case 1:
				System.out.print("1�б� �߰�");
				break;
			case 2:
				System.out.print("1�б� �⸻");
				break;
			case 3:
				System.out.print("2�б� �߰�");
				break;
			case 4:
				System.out.print("2�б� �⸻");
				break;
			}
			
			System.out.println();
			System.out.println(" ���" + korean + "���� �ԷµǾ����ϴ�.");
			System.out.println(" ���" + english + "���� �ԷµǾ����ϴ�.");
			System.out.println(" ���п�" + math + "���� �ԷµǾ����ϴ�.");
			//�ָ� ����
		      //�� ������ 
		      //1��: ����, ����, ���� ������ ���� �� �� �ְ� �����ϰ�
		      //2��: ���ѷ����� �̿��Ͽ� �޴��� ���ؼ� �Է°� ����� �� �� �ְ� �ٲٰ�
		      //3��: �޼ҵ带 �и��غ�����.
		      
		      //��� ����: 2�г� 1�б� �߰���� ��� 80���� �ԷµǾ����ϴ�.
			
	//		[���� ���]
	//				1�г� 1�б� �߰� 
	//				���� 40 ���� 50 ���� 45
			}
		}
		
	}
		public int schoolyear(BufferedReader a) throws NumberFormatException, IOException{
			int year = Integer.parseInt(a.readLine());
			while( year < 1 || year > 3) {
				System.out.println("�߸��� �г��Դϴ�.");
				System.out.print("���г� �����Դϱ�?");
				year = Integer.parseInt(a.readLine());
			}
			return year;
		}
		
		public int whattest(BufferedReader a) throws NumberFormatException, IOException {
			int number = Integer.parseInt(a.readLine());
			while(number < 1 || number > 4) {// 1. 1�б� �߰�	2. 1�б� �⸻	3. 2�б� �߰�	4. 2�б� �⸻
				System.out.println("�߸��� �Է��Դϴ�");
				System.out.print("�� ��° �����Դϱ�?");
				number = Integer.parseInt(a.readLine());
			}
			return number;
		}
		
		public int Testscore(BufferedReader a) throws NumberFormatException, IOException {
			int score = Integer.parseInt(a.readLine());
			while(score < 0 || score > 100) {
				System.out.println("�߸��� �����Դϴ�.");
				System.out.print("������ �ٽ� �Է����ּ���. : " );
				score = Integer.parseInt(a.readLine());
			}
			return score;
		}
	

}
