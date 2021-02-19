package class_constructor;

import java.util.StringTokenizer;

public class Token {
	
	public static void main(String[] args) {
		String str = "�п�,��,,���ӹ�";
		
		StringTokenizer st = new StringTokenizer(str,",");//ū����ǥ ���� ���ڷ� str�� �и��ض�.
		System.out.println("��ū ���� = " + st.countTokens());
		
		//��ū�� ���� ,, �� �����Ѵ�.
		
		//hasMoreTokens() - ������ġ ��ū True/False
		//nextToken() - ���� ��ġ���� ��ū�� �����ְ� ���� ��ū���� �̵�
		
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}//while
		System.out.println("--------------------------");
		
		String[] ar = str.split(",");//ū����ǥ ���� ���� , �� �����Ͽ� ���ڿ� �迭�� ���� ������
		for(String data : ar) {//���� for�� . //for(������ �ڷ���  �����̸� : �迭�� ����)  //�迭��ó������ ������ �ݺ�����.
			System.out.println(data); // split �� ������ �������� �ʴ´�.
		}
	}

}
