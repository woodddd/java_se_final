package method;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputTest {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader - ���ۿ��� ���� �о�� 
		//InputStreamReader(System.in) - (System.in)Ű���� ���� ���� �о��
		System.out.print("���� a : ");
		int a = Integer.parseInt(br.readLine());// readLine --- ���͸� ģ �� ���� (����) String ���ڿ��� ����
		System.out.print("�Ǽ� b : ");
		double b = Double.parseDouble(br.readLine());
		
		System.out.println(a + " + " + b + " = " + (a + b));
		
	}
}
 