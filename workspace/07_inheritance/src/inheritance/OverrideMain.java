package inheritance;


//����������
//private < default < protected < public

//private
//���� Ŭ���� �� 
//default
//�ٸ� ��Ű���� ���� X ���� ��Ű�� ������ ���
//protected
//�ٸ� ��Ű�� ���� ����,�� �ڽ�Ŭ������ ��� ���ٰ���


class Test{
	int a = 3;
	
	public void disp() {
		a += 5;
		System.out.println("Test Ŭ������ disp() ���� ---");
		System.out.println("Test : a = " + a);
	}
}

class Sample extends Test{
	int a = 8;
	
	@Override
	public void disp() {
		a += 5;
		System.out.println("Sample Ŭ������ disp() ���� ---");
		System.out.println("Sample : a = " + a);
	}
	
}

public class OverrideMain {
	public static void main(String[] args) {
		Sample aa = new Sample(); //Test �⺻������ , Sample �� �⺻������
		aa.disp(); //Sample Ŭ������ disp() ȣ��
		System.out.println("aa.a : " + aa.a);
		System.out.println();
		
		Test bb = new Sample(); // �θ� = �ڽ� �� ������ �� �ִ�.
		bb.disp(); // �������̵� �� �޼ҵ尡 �ִٸ� �ڽ�Ŭ������ �޼ҵ尡 ����� (Sample Ŭ������ disp()����)
		//�ڽ�Ŭ������ �ִ� SampeŬ������ disp�� �����ϰ� �Ǿ� Sample Ŭ������ �������Ƿ�  a�� ���� Sample �޼ҵ��� a = 8 �� �ȴ�.
		System.out.println("bb.a : " + bb.a);//TestŬ������  ��ü bb �� �ʵ� a�� �ȴ�.
		System.out.println();
		
		Sample dd = (Sample) bb; // �ڽ� = (�ڽ�)�θ� // ��������ȯ(ĳ����) 
		//�����ڸ� ���� �ʱ�ȭ�� �ƴ� bb �����Ͱ� ����� ��ü bb �� ����ȯ�Ͽ� dd �� �����Ͽ���.
		dd.disp();
		System.out.println("dd.a : " + dd.a);
		
		Test cc = new Test();
		cc.disp(); // //Test Ŭ������ disp() ȣ��
		System.out.println("cc.a : " + cc.a);
		System.out.println();
		
		//Sample ee = (Sample)cc; // ������ ������ ������ ���� �� error �� �����ϰԵ�.
		//cc �� �����ڸ� ���Ͽ� Test �� �޸𸮿� ������ ���� �����̹Ƿ� Sample �� �޸𸮿� �������� �ʾ� ����ȯ�� �� �� ����.
		
		
		
	}
}
