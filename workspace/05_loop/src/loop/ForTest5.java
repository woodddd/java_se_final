package loop;

import java.io.IOException;

/*
 * �ŵ������� ���Ͻÿ�
 * x�� y���� ����Ͻÿ�
 * 
 * [������]
 * x�� �Է� : 2
 * y�� �Է� : 5
 * 2�� 5�� xx
 * 
 * x�� �Է� : 3
 * y�� �Է� : 4
 * 3�� 4�� xx
 * 
 */

public class ForTest5 {

	public static void main(String[] args) throws IOException {
		
		for(int j = 1; j <=3; j++) {
			int result = 1;
			
			System.out.print("x�� �Է� : ");
			int x = System.in.read() - 48; //read() �� �Ѱ��� ���ڸ� �Է¹��� �⺻��ȯ�� int��(�Է¹����� �ƽ�Ű�ڵ尪)
			
			System.in.read();// ���ۿ��� ���Ͱ�(\r,\n) ����ֱ� flush
			System.in.read();
			
			System.out.print("y�� �Է� : ");
			int y = System.in.read() -48; 
			
			System.in.read();
			System.in.read();
			for(int i = 1 ; i<= y; i++) {
				result *=x;
			}
			System.out.println(x + "�� " + y + "�� " + result);
		}
	}

}
