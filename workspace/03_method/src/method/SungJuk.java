package method;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
�̸�(name), ����(kor), ����(eng), ����(math)������ �Է¹޾Ƽ� ����(tot),���(avg)�� ���Ͻÿ�

���� = ���� + ���� + ����
��� = ���� / �����

[������]
�̸� �Է� : ȫ�浿
���� �Է� : 95
���� �Է� : 90
���� �Է� : 91

   *** ȫ�浿 ���� ***
����      ����      ����      ����      ���
95      90      91      xxx      xx.xxx
*/

public class SungJuk {

	public static void main(String[] args)throws IOException {// �Է��� ���� ��, �Է¿� ���� ���� ó���� JVM ���� ���������.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //
		
		System.out.print("�̸� �Է� : ");
		String name = br.readLine();
		System.out.print("���� �Է� : ");
		int kor = Integer.parseInt(br.readLine());
		System.out.print("���� �Է� : ");
		int eng = Integer.parseInt(br.readLine());
		System.out.print("���� �Է� : ");
		int math = Integer.parseInt(br.readLine());
		System.out.println();
		
		//int tot = kor + eng + math;
		//double avg = (double)tot / 3;
		
		//�޼ҵ�� ������ ���ϴ� ���
		SungJuk sungJuk = new SungJuk();
		int tot = sungJuk.calTot(kor, eng, math);
		double avg = sungJuk.calAvg(tot);
		
		System.out.println("\t\t*** " + name + " ***");
		System.out.println("����\t����\t����\t����\t���");
		System.out.println(kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + String.format("%.3f", avg));
		
		
	}
	
	public int calTot(int kor, int eng, int math) {
	return kor + eng+ math;
	}
	
	public double calAvg(int tot) {
		return tot / 3.0;
	}

}
