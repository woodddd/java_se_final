package abstractMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

/*
�⵵ �Է� : 2002
�� �Է� : 10   

��	��	ȭ	��	��	��	��
	1   2   3   4   5	6
7   8   9   10  11  12	13
14  15  16  17  18  19	20
21  22  23  24  25  26	27
28  29  30  31

�⺻������ - �⵵, �� �Է�
calculator() - �Ŵ� 1���� ���� ���Ϸ� ����?, �Ŵ� ������ ��?
display() - ���
 */

public class CalendarMain {
	
	private int year;
	private int month;
	private int week;
	private int lastDay;
	public CalendarMain() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("�⵵ �Է�: ");
		year = Integer.parseInt(br.readLine());
		System.out.print("�� �Է�: ");
		month = Integer.parseInt(br.readLine());
	}
	
	public void calculator() {
		Calendar cal = Calendar.getInstance(); //Ŭ���� ���� calendar Ŭ������ �߻�Ŭ�����̹Ƿ� ���������� new �� �� ����.
		
		//�ð��� ������ �ʿ�.
//		cal.set(Calendar.YEAR,year);
//		cal.set(cal.MONTH, month - 1);
//		cal.set(cal.DAY_OF_MONTH,1); //DAY_OF_MONTH (�Ѵ��߿� ��) 
		//(cal.DAY_OF_MONTH,1) �Ѵ��߿� �������� 1�Ϸ� �ٲٰڴ�.
		
		cal.set(year, month -1 , 1);// 1��
		week = cal.get(cal.DAY_OF_WEEK); // 1���� ���� ���Ϸ� ���� �ϴ��� ����
		lastDay = cal.getActualMaximum(cal.DAY_OF_MONTH); // �Ŵ� ������ �� .(getActualMaximum - ���߿��� ���� ū���� ȣ��)
		
		System.out.println("week = " + week);
	}
	
	public void display() {
	System.out.println("��\t��\tȭ\t��\t��\t��\t��");
	
		for(int i = 1; i < week; i++) {
			System.out.print("\t");
		}
		
		for(int i = 1; i <=lastDay; i++) {
			System.out.print(i + "\t");
			
			if(week%7==0) {
				System.out.println();
			}
			week++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		CalendarMain cm = new CalendarMain();
		cm.calculator();
		cm.display();
		
		
		
		
	}

}
