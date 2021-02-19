package class_constructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringBufferTest {

	private int dan;
	
	public StringBufferTest() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���ϴ� �� �Է�: ");
		dan = Integer.parseInt(br.readLine());
	}
	
	public void disp() {
		StringBuffer buffer = new StringBuffer();
		
		for(int i = 1; i < 10 ; i++) {
			//System.out.println(dan + " * " + i + " = " + (dan * i));
			buffer.append(dan); // append ��(���ϴ�.)
			buffer.append("*");
			buffer.append(i);
			buffer.append("=");
			buffer.append(dan*i);
			
			System.out.println(buffer);
			System.out.println(buffer.length()); //buffer.length() �� ���� ���� ���� delete(s,e-1)
			buffer.delete(0, buffer.length()); // �̰��� �������� ������ ���� ���� �״�� ���� �̾����� �����Ե�.
			//�ش� ����� for �� �ȿ� �����Ƿ� delete���� �ʰ� ��� ��  ���� ������ �Ѿ�� �Ǿ��� ��, ���� ���ڿ� �߰��� ���� �����Ե�.
			
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {

		StringBufferTest bt = new StringBufferTest();
		bt.disp();
		
	}

}
