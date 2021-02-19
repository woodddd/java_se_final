package inheritance;

/*
Class Object{
	public boolean equals(Object ob){}//������ ��
	public String toString(){}//��Ű����.Ŭ������@16����
	public int hashCode(){}//10����
}

final class String extends Object{
public boolean equals(Object ob){}//���ڿ� ��
	public String toString(){}
	public int hashCode(){} // ���ڿ��� 10���� ��ȯ
							//���ڿ� ��ѽĿ� ���ؼ� ������� ��
							//�ٸ� ���ڿ��̾ ���� �ؽð��� �߻��� �� �ִ�.
							//int 21�ﰳ�̰� ���ڿ��� ���Ѵ�� ǥ�ð� �Ұ�.
}
*/


class Test2{
	@Override
	public String toString() {
		return super.toString();
	}
	
}

public class ObjectMain {

	public static void main(String[] args) {

		Test2 t = new Test2();
		System.out.println("��ü t = " + t);
		System.out.println("��ü t = " + t.toString());
		System.out.println("��ü t = " + t.hashCode()); //��Ű����.Ŭ������@16���� ---> 16������ 10������ ǥ������
		System.out.println();
		
		String str = "apple";
		System.out.println("��ü str = " + str);
		System.out.println("��ü str = " + str.toString());
		System.out.println("��ü str = " + str.hashCode());//������ �ȵȴ�. ���� ������ ���� �ֱ� ����.
		System.out.println();
		
		String aa = new String("apple");
		String bb = new String("apple");
		System.out.println("aa=bb : " + (aa==bb));//�ּ� �� ��
		System.out.println("aa.equals(bb) : " + aa.equals(bb));//���ڿ�
		System.out.println();
		
		Object cc = new Object();
		Object dd = new Object();
		System.out.println("cc=dd : " + (cc==dd));//�ּ� �� ��
		System.out.println("cc.equals(dd) : " + cc.equals(dd));//ObjectŬ������ equals �޼ҵ� �̹Ƿ� �ּҰ��� ����. false
		System.out.println();
		
		Object ee = new String("apple");
		Object ff = new String("apple");
		System.out.println("ee=ff : " + (ee==ff));//�ּ� �� ��
		System.out.println("cc.equals(ff) : " + ee.equals(ff));//���ڿ� String Ŭ������ �������̵� �� toSTring �޼ҵ带 �����ϰԵ�. 
	}

}

