package abstractMethod;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberTest {

	
	public static void main(String[] args) {
		NumberFormat nf = new DecimalFormat(); // �߻�Ŭ������ ������ Ŭ������ new�� �� �� ��� �ڽ�Ŭ������ �̿�!!
		//3�ڸ�����, ����ְ� �Ҽ����� 3°�ڸ� ���� ��������.
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();
		
		NumberFormat nf2 = new DecimalFormat("#,###.##��");
		//# - �Ҽ��� ������ ���ڰ� ��ȿ���ڰ� �ƴѰ��� ǥ������ �ʴ´�.
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();
		
		NumberFormat nf3 = new DecimalFormat("#,###.00��");
		//0 - ������ ǥ��
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();
		
		//NumberFormat nf4 = NumberFormat.getInstance(); // NumberFormat nf = new DecimalFormat(); ����Ŭ������ �̿��� �Ͱ� ������ ����� ����
		NumberFormat nf4 = NumberFormat.getCurrencyInstance();//�ܷ� ǥ��(���� ������ �ü�������� ���� �� ��ȭ)
		nf4.setMaximumFractionDigits(2);//�Ҽ� ���� 2° �ڸ����� ó��  // NumberFormat nf2 = new DecimalFormat("#,###.##��"); �� ���� ��� ����
		//.## �� �������
		nf4.setMinimumFractionDigits(2);//�Ҽ� ���� 2° �ڸ����� ������ 0�� ǥ��
		//.00 �� �������
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();
		
		//NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.US);//���� ǥ�� (US��ȭ)
		NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.JAPAN);//��ǥ��
		nf5.setMaximumFractionDigits(2);
		nf5.setMinimumFractionDigits(2);
		
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();
	}
}
