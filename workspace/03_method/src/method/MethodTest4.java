package method;

import java.io.IOException;
import java.text.DecimalFormat;
// �ڹٴ� java.lang �� �⺻ ��Ű���� ���
import java.util.Random; // Random �� java.util �ȿ� �ִ� Random �޼ҵ� �Դϴ�. ����������


public class MethodTest4 {

	
	//�޼ҵ�� �޼ҵ� �ȿ��� �ۼ��ϸ� �ȵ�!!
	public static void main(String[] args) throws IOException{

		System.out.println(Math.abs(-25));
		
		//���� - ��ǻ�Ͱ� �������� �߻��ϴ� ��, ( 0 <=  ����  < 1 )
		System.out.println("���� = " + Math.random());
		Random r = new Random(); // ���� Ŭ���� ����!
		System.out.println("���� = " + r.nextDouble());
		
		//���ڸ� 3�ڸ� ���� "," ���
		int num = 1234567;
		
		DecimalFormat df = new DecimalFormat("#,###��");
		System.out.println(df.format(num));
		
		//�Է�
		//System.in.read(); Ű���� �Է� --> �����ʹ� int Ÿ������ �������
		// !! Ű���带 ���ؼ� �Էµ� ���� ��� 1���� '����' �� �ν���
		System.out.print("������ a : ");
		char a = (char)System.in.read(); //��������
		
		// A�� �Է��ϰ� �Ǹ� A - Enter �� �ֿܼ� �Է��ϰ� ��.
		//�޸� ------ buffer ------ ȭ��(�ܼ�)
		//  A <------   A   <------   A 
		//flush - ���� ����
		
		// Enter�� ���
				// �����ٷ� �̵�                   \n
				// (��������)ó������ �̵�   \r
		System.in.read(); //- \r
		System.in.read(); //- \n
		
		System.out.print("������ b : ");// ������ \n \r �� �Է��ϰ� �Ǿ����Ƿ� ������b �� ���������� �Է� ���� �� �ְԵ�
		char b = (char)System.in.read(); //��������
		
		
		
		//����ó�� 
		//throws
		// - System.in(�Է�) �� ���ܰ� �߻��� �� JVM ���� ���ܸ� ������.
		// �Լ� �ڿ� �ۼ��Ѵ�.
		
		System.out.println("��� = " + a + "\t" + b);
		
		//����� ���� �Լ� - a�� b �߿��� ū ���� ����ϴ� �޼ҵ� �ۼ�
		MethodTest4 call = new MethodTest4();
		char max = call.big(a,b);
		System.out.println("ū �� : " + max);
		
		
	}
	
	public char big(char a,char b) { // char a, char b --- parameter(�Ű�����), argument(�μ�)
		return a >= b ? a : b;
	}
	
}
