package inheritance;

class AA{
	
}

class BB extends AA{
	
}

public class InstanceOf {

	public static void main(String[] args) {
		AA aa = new AA();
		BB bb = new BB();
		AA aa2 = new BB();
		
		AA aa3 = aa;
		if(aa instanceof AA) System.out.println(("1. TRUE"));
		else System.out.println("1. FALSE");
		
		AA aa4 = bb; // �θ� = �ڽ� //���� bb��� ���� �ȿ��� aa �� �����ϱ� ������ ���� �� ����
		if(bb instanceof AA) System.out.println(("1. TRUE")); // bb�� AA�� �����ϰ� �ֱ� ������ ����ȯ�� ������.
		else System.out.println("1. FALSE");
		
		BB bb2 = (BB)aa2; // �ڽ�Ŭ������ �θ�Ŭ������ ���� ���� �� ���� �ڽ� = (�ڽ�) �θ�
		if(aa2 instanceof BB) System.out.println(("1. TRUE"));
		else System.out.println("1. FALSE");
		//BB bb3 = (BB)aa3;
		if(aa3 instanceof BB) System.out.println(("1. TRUE"));
		else System.out.println("1. FALSE");
	 }

}

// aa instanceof AA
//aa�� ����Ű�� ���� Ŭ���� AA �� �ִ³�?
//aa�� AA ����ȯ(casting)�� �����ϳ�?