package day0912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//������ �迭
//������ �迭�̶� ������ �迭�� ������ ��
//���� ���� ũ�⸸ �������ְ�
//�ű⿡ ���ϴ� �迭�� ũ��� ����� �� �����ִ� ����̴�.

//���� : 1�г� 1���� 30��, 2���� 29��, 3���� 32���϶�
//�� ������ ��� �ؾ��ұ�?
//int[][] scoreArray = int[3][];
//scoreArray[0] = new int[30];
//scoreArray[1] = new int[29];
//scoreArray[2] = new int[32];

public class Ex02MultiArray {
	
	static final int SIZE = 3;

	public static void main(String[] args) throws NumberFormatException, IOException {
		//1�г� ������ �л����� �Է� �ް�
		//�� �л����� �̸��� �ݸ��� �־��ִ� ���α׷�
		String[][] nameArray = new String[SIZE][];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("��Ʈ����б� �̸� ���� ���α׷�");
			System.out.println("1. �Է� 2. ��� 3. ����");
			System.out.print("> ");
			int choice = Integer.parseInt(br.readLine());
			if(choice == 1) {
				//���� �����ϴ� �޼ҵ� ����
				int ban = banchoice(br); // �� ����
				
				//�̸��� �Է��ϴ� �޼ҵ� ����
				//�� �迭�� ũ�⸦ �����ؾ��ϹǷ�
				//�л� ���ڸ� �Է� �޵��� �Ѵ�.
				int studentSize = insertStudentSize(br); // �л��� ���� �Է�
				
				//�Է¹��� �ݰ� �л����ڷ� �ش� �迭�� �ʱ�ȭ���ش�.
				nameArray[ban-1] = new String[studentSize];// ���� 1���� �����ϰ� �л��� 30 �� �̶�� �ϸ�, nameArray[0] = new String[30] �̹Ƿ� nameArray �迭 0���� ���� String Ÿ�� 1�����迭�� 30���� �����ȴ�.
				//�л��� �̸��� �Է¹޴´�.
				for( int i = 0; i < nameArray[ban - 1].length; i++) {
					System.out.print((i + 1) + "�� �л��� �̸� : ");
					nameArray[ban -1][i] = br.readLine(); // ���� ������ ���÷� ���� ���ڸ� nameArray �� 0 ���� �ּҿ� 30���� String 1���� �迭�� �����Ͽ����Ƿ� �� ���� ���� �־��ִ� �۾�. nameArray[0][0],nameArray[0][1],nameArray[0][2]...nameArray[0][29] = "��켮"
				}
			}else if(choice == 2) {
				//�� �����ϴ� �޼ҵ� ����
				int ban = banchoice(br);
				//�̸��� ����ϴ� �޼ҵ� ����
				//�� ���⼭ �����ؾ��� ����
				//�ش� �迭�� �ʱ�ȭ�� �Ǿ� �ִ��� üũ�� �ؾ� �Ѵ�.
				//���� �ش� �迭�� �ʱ�ȭ �Ǿ����� �ʴٸ�
				//�� ������ ���� null�� �����̹Ƿ�
				//�츮�� ������ �� ����.
				//���� �� �迭�� null�������� üũ�ϰ�
				//null�� �ƴҶ����� ����ϴ� for���� �����Ѵ�.
				
				//null�̶� ������ ������Ÿ���� �ʱ�ȭ��
				//���� �� �̷���� �ִ� ���¸�
				//���̶�� �Ѵ�.
				
				if(nameArray[ban-1] == null) {
					System.out.println("���� �ش� ���� �Էµ��� ���� �����Դϴ�.");
				}else {
					for(int i = 0; i < nameArray[ban-1].length; i++) {
						System.out.println(nameArray[ban - 1][i]);
					}
				}
				
				//�⺻�� ������Ÿ�԰� ������ ������Ÿ���� ������
				//�⺻�� : ���� ������ ���� ���� �� �ִ� ������ Ÿ��.
				//		btye short int long float double char boolean 8���� ������ �ְ�
				//		�⺻������ 0���� �ʱ�ȭ�ȴ�.
				
				//������ : ���� �������� �� �������� ���� �ּҰ��� ������ �ְ�
				//		���� ������ �� �Ǵ� �޼ҵ�� �� ������ Ȯ���ؾ� � ��, � �޼ҵ尡 �ִ��� Ȯ�� ������ ������Ÿ��
				//		���������� Ŭ����(=��ü��), �迭��, �������̽��� 3������ �ְ�
				//		new�� ���ؼ� �ʱ�ȭ ���� ������ null �� �ʱ�ȭ�� �ȴ�.
				//		null�̶�, ���� ������ �ּҰ��� �ο��� �Ǿ� ������
				//		�� �������� �ƹ��� ������ ���� ���¸� null�̶�� �Ѵ�.
				//		null�� ���¿����� �ƹ��� �޼ҵ�, �ʵ� ������ �Ұ����ϴ�.
				//		������ �ҷ��� �ϸ� NullPointerException�� �߻��ϰ� �ȴ�!!!
				
			}else if(choice == 3) {
				System.out.println("������ּż� �����մϴ�.");
				break;
				
			}
			
		}
		
	}
	
	private static char[] size(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	static int banchoice(BufferedReader a) throws NumberFormatException, IOException {
		System.out.print("���� ���� : ");
		int ban = Integer.parseInt(a.readLine());
		
		
		while(ban < 1 || ban > SIZE) {
			System.out.println("�߸� �Է��Ͽ����ϴ�.");
			System.out.print("���� ���� :(1���� " + SIZE + "����");
			System.out.print("> ");
			ban = Integer.parseInt(a.readLine());
		}
		return ban;
		
	}
	
	static String nameInput(BufferedReader a) throws IOException {
		System.out.print("�̸� �Է�: ");
		String name = a.readLine();
		
		return name;
	}

	
	//�л��� ���� �Է¹޴� �޼ҵ�
	static int insertStudentSize(BufferedReader a) throws NumberFormatException, IOException {
		System.out.print("�л��� ���� �Է�: ");
		int studentSize = Integer.parseInt(a.readLine());
		while(studentSize < 0) {
			System.out.println("�߸��Է��ϼ̽��ϴ�. 0���� ū ���� �Է����ּ���");
			System.out.println("�л��� ���ڸ� �Է����ּ���: ");
			studentSize = Integer.parseInt(a.readLine());
		}
		return studentSize;
	}
}
