package method;

public class Boxing {

	public static void main(String[] args) {

		int a = 25;
		double b = (double) a / 3; // ��������ȯ/�ڵ�����ȯ (Casting, Cast ����)
		
		int c = 5;
		Integer d = c; // JDK 5.0 �̻�, AutoBoxing(�ڵ����� �ڽ��Ѵ�.) -> �⺻���� �ڵ����� Wrapper Class�� �ٲ��ش�.
		//��ü			int(�⺻��)
		//Integer d = new Integer(c);
		
		Integer e = 5;
		int f = e; //JDK 5.0 �̻�, unAutoBoxing -> Wrapper Class�� �⺻������ �ڵ� ��ȯ�ϰڴ�.
		//�⺻�� = ��ü��
		//int f = e.intValue();
		
		
		
	}

}
