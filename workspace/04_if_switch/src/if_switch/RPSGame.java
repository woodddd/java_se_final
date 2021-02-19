package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * ����(1), ����(2), ��(3) ����

[������]
����(1),����(2),��(3) �� ��ȣ �Է� : 3 (user)
��ǻ�� : ����   �� : ���ڱ�
You Win!!

����(1),����(2),��(3) �� ��ȣ �Է� : 3 (user)
��ǻ�� : ����   �� : ���ڱ�
You Lose!!

����(1),����(2),��(3) �� ��ȣ �Է� : 2 (user)
��ǻ�� : ����   �� : ����
You Draw!!
 */

public class RPSGame {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("����(1),����(2),��(3) �� ��ȣ �Է� : ");
		int user = Integer.parseInt(br.readLine());
		
		//���� - ��ǻ�Ͱ� �������� �߻��ϴ� ��, 0<= ���� < 1
				// a~b������ ���� �߻� => (int)(Math.random()*(b-a+1)+a);1~3 --- a = 1 b = 3

		int computer = (int)(Math.random()*3 + 1); //��ǻ�Ͱ� 1~3 �� ���� ��ȯ
		
		
		if(computer == 1) 
		{
			if(user == 1)
			{
				System.out.println("��ǻ�� : ���� \t�� : ����" );
				System.out.println("You Draw!!");
			}else if(user == 2)
			{
				System.out.println("��ǻ�� : ���� \t�� : ����");
				System.out.println("You Win!!");
			}else
			{
				System.out.println("��ǻ�� : ���� \t�� : ��");
				System.out.println("You Lose!!");
			}
		}else if(computer ==2)
		{
			if(user == 1)
			{
				System.out.println("��ǻ�� : ���� \t�� : ����");
				System.out.println("You Lose!!");
			}else if(user == 2)
			{
				System.out.println("��ǻ�� : ���� \t�� : ����");
				System.out.println("You Draw!!");
			}else
			{
				System.out.println("��ǻ�� : ���� \t�� : ��");
				System.out.println("You Win!!");
			}
		}else
		{
			if(user == 1)
			{
				System.out.println("��ǻ�� : �� \t�� : ����");
				System.out.println("You Win!!");
			}else if(user == 2)
			{
				System.out.println("��ǻ�� : �� \t�� : ����");
				System.out.println("You Lose!!");
			}else
			{
				System.out.println("��ǻ�� : �� \t�� : ��");
				System.out.println("You Draw!!");
			}
		}
		
	}

}
