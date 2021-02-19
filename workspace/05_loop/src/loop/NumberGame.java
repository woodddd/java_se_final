package loop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 ���ڸ��߱� ����
1~100������ ������ �߻��Ͽ� ���ߴ� ����

[������]
���� �Է� : 50
50���� Ů�ϴ�

���� �Է� : 90
90���� �۽��ϴ�

...

���� �Է� : 87
������ xx������ ���߼̽��ϴ�

continue(Y/N) : n
���α׷��� �����մϴ�
 */

public class NumberGame {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String retry ;
		int count = 0;
		int user = 0;
		int computer = 0;
		
		for(;;) {
			computer = (int)(Math.random()*100+1);
			System.out.println(computer);
			
			while(true) {
				
				System.out.print("���� �Է� : ");
				user = Integer.parseInt(br.readLine());
				
				if(computer > user) {
					System.out.println(user + "���� Ů�ϴ�");
					count ++;
					
				}else if(computer < user) {
					System.out.println(user + "���� �۽��ϴ�");
					count ++;
					
				}else{
					count ++;
					System.out.println("������" + count + "������ ���߼̽��ϴ�.");
					break;
				}
				
				
			}//while
			System.out.println("--------------------");
			
			while(true) {
				System.out.println("continue(Y/N) : ");
				retry = br.readLine();
				
				if(retry.equals("y")||retry.equals("Y")||retry.equals("n")||retry.equals("N")){
						break;
				}
				
			}
			//if(retry.equals("y")||retry.equals("Y")){ continue};  ����continue�� ����ϰ� �ȴٸ� continue�� ������ �ݺ����� �Ӹ��κ����� ����.
			if(retry.equals("n")||retry.equals("N")) {
				break;
			}
		}//for
		System.out.println("���α׷��� �����մϴ�.");
	}

}
