package loop;

public class ForTest {

	public static void main(String[] args) {
		
		int i;
		
		for(i = 1 ; i <= 10 ; i ++) {
			System.out.println("Hello kitty  " + i);
		}//�������� - ����{ } ������ �����Ⱓ. ���� �ۿ��� �������� ����(�Ҹ�) 
		//���� ���忡���� for(int i= 1) �� ���� for������ i�� ������ �����Ƿ� for{ } for ���� ����Ǹ� ������ �Ҹ��.
		System.out.println("Ż�� i = " + i);
		System.out.println();
		
		// 10 9 8 7 6 5 4 3 2 1 
		for(i = 10; i > 0; i--) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		// A B C D E F G ... X Y Z
		for(i = 65; i <91; i++) { //for(i = 'A'; i <= 'Z' ; i++) �� �� ��Ȯ�ϰ� ���� ����
			System.out.print((char)i + " ");
		}
	}

}
