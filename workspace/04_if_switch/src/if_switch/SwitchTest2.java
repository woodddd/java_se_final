package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

/*
2���� ������ ���ڿ� ������(+,-,*,/)�� �Է��Ͽ� ����Ͻÿ�

[������]
a �Է� : 25
b �Է� : 36
������(+,-,*,/) �Է� : +
25 + 36 = xx

a �Է� : 25
b �Է� : 36
������(+,-,*,/) �Է� : /
25 / 36 = 0.xxx

a �Է� : 25
b �Է� : 36
������(+,-,*,/) �Է� : $
������ error
 */

public class SwitchTest2 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat("#,###");
		//DecimalFormat�� ��ȿ�����̸� ���ڰ� �״�� ������ ��ȿ���ڰ� �ƴϸ� ǥ�ø� ���� �ʴ´�.
		//ex) 13.000 �� .000 �� ��ȿ���ڰ� �ƴ϶� ���ŵǰ� 13�� ����
		//ex) 0.647 �� ������ ��ȿ���� �̹Ƿ� �״�� ����
		
		System.out.print("a �Է� : ");
		int a = Integer.parseInt(br.readLine());
		
		System.out.print("b �Է� : ");
		int b = Integer.parseInt(br.readLine());
		
		System.out.print("������(+, -, *, /) �Է� : ");
		String op = br.readLine();
		
		switch(op) {
		case "+" : System.out.println(a + " + " + b + " = " + (a + b));
		break;
		case "-" : System.out.println(a + " - " + b + " = " + (a - b));
		break;
		case "*" : System.out.println(a + " * " + b + " = " + (a * b));
		break;
		case "/" : System.out.println(a + " / " + b + " = " + String.format("%.3f",((double)a / b)));
		break;
		default : System.out.println("������ error");
		
			//���� �� �κп��� ���α׷��� �ٷ� ������ �� ��� 	System.exit(0); --- ���α׷� ���� ����		�� ����� �� ����.
		}
		
		//System.out.println("������ �Ϸ� ���ÿ�.");       �� 			�� �����ϸ� ���� ������ ������� �ʰ� �ٷ� �����ϰԵ�.
		
		
		
	}

}
