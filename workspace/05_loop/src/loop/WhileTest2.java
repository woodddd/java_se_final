package loop;

public class WhileTest2 {

	public static void main(String[] args) {
		//A B C D E F G ... X Y Z ���ٿ� 7���� ������ ����ϱ�
		
		char ch = 'A';
		while(ch <= 'Z') {
			
			System.out.printf("%-2c",ch);
			if((int)(ch - 64) % 7 == 0) {
				System.out.println();
			}
			ch++;
		}

	}

}
