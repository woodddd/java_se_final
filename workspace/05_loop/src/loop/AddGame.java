package loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
���ϱ� ���� ���α׷�
10~99 ������ ������ 2��(a, b) �߻��Ͽ� ���� ���ϴ� ���α׷�
�������� �� 5������ �����Ѵ� - for
1������ ���� 20���� ���

[������]
[1] 25 + 36 = 45
Ʋ�ȴ�

[2] 78 + 10 = 88
������
...

[5] 12 + 25 = 37
������

����� �� x������ ���߾ xx�� �Դϴ�
�� �ҷ�(Y/N)
 */

public class AddGame {
	

	public static void main(String[] args) throws  IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = 0;
		int b = 0;
		int user;
		int count = 0;
		String result;
		
		while(true) {
			count = 0;
			for(int i = 1 ; i <= 5; i++) {
				
				a = (int)(Math.random()*90+10);
				b = (int)(Math.random()*90+10);
				
				System.out.print("[" + i + "] " + a + " + " + b + " = " );
				user = Integer.parseInt(br.readLine());
				
				if(a + b == user) {
					System.out.println("������");
					count++;
				}else {
			 		System.out.println("Ʋ�ȴ�");
				}
				
			}//for
			
			System.out.println("����� �� " + count + " ������ ���߾ " + count*20 + "�� �Դϴ�");
			
			while(true) {
				System.out.println("�� �ҷ�(Y/N)");
				result = br.readLine();
				
				
				
				if(result.equals("y")||result.equals("Y")||result.equals("n")||result.equals("N")) {
					break;
				}else {
					System.out.println("�߸��� �����Դϴ�.");
				}
			
		}//while
			
		if(result.equals("N")||result.equals("n")) {
			break;
		}
	}//while
		System.out.println("���α׷��� �����մϴ�.");
}
}
