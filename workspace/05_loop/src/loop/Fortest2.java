package loop;

import java.io.IOException;

/*
 *  ���ϴ� ���� �Է� : 2  �� System.in.read()
2*1=2
2*2=4
2*3=6
2*4=8
2*5=10
2*6=12
2*7=14
2*8=16
2*9=18
 */

public class Fortest2 {

	public static void main(String[] args)throws IOException {
		
		System.out.print("���ϴ� ���� �Է� : ");
		int k = (int)System.in.read() - 48;
		
		
		
		for(int i = 1 ; i <= 9 ; i++) {
			System.out.println(k + "*" + i + "=" + k*i);
			
		}
		
	}

}
