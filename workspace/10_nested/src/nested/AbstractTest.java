package nested;

public abstract class AbstractTest { 
	//�߻�Ŭ������ new �� �� ����.
	String name;
	
	//���� �ڽ��� �߻�Ŭ������ ����Ѵٸ�, �ڽ�Ŭ�������� �߻�޼ҵ带 ������ �� �־�� �ϰ�,
	// �ڽ�Ŭ�������� ������ ���� ��������, �ڽ�Ŭ���� ���� �߻�Ŭ������ ����� �ڽĿ��� �߻�޼ҵ� �������̵��� ���ѱ��.
	
	//�߻�Ŭ������ �ִ� �߻�޼ҵ�� �������� �������̵��� ���ָ��.�� �ڽ��� �ƴϴ��󵵵�.
	public abstract void setName(String name);//�߻�޼ҵ�
	
	public String getName() {
		return name;
	}
	
}
