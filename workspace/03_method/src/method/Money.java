package method;

/*
 *  �ݾ�(money)�� 5679���� �� ������ ���� ����Ͻÿ� (/, % ������ �����ڷ� Ǯ���ÿ�.)
 *  [������]
 *  �ݾ� : 5679��
 *  õ�� : 5��
 *  ��� : 6��
 *  �ʿ� : 7��
 *  �Ͽ� : 9��
 */

public class Money {

	public static void main(String[] args) {

		int money = 5679;
		int thousand = money / 1000 ;
		int hundred = money % 1000 / 100;
		int Ten = money % 1000 % 100 / 10;
		int one = money % 1000 % 100 % 10;
		
		System.out.println("[������]");
		System.out.println("�ݾ� : " + money);
		System.out.println("õ�� : " + thousand + "��");
		System.out.println("��� : " + hundred + "��");
		System.out.println("�ʿ� : " + Ten + "��");
		System.out.println("�Ͽ� : " + one + "��");
		
		
	}

}
