package abstractMethod;

//�߻�Ŭ������ ���� ! - �ڽ�Ŭ������ �����ϱ� ����
public abstract class AbstractTest { //POJO(Plain Old Java Object) - �츮�� �˰� �ִ� Ŭ����. Object���� ��ӹ��� Ŭ����,��������Ŭ����
//�߻�޼ҵ尡 �ִ� Ŭ������ �ݵ�� �߻�Ŭ�����̾�� �Ѵ�. abstract�� �־��ָ��.
//�ݴ�� �߻�Ŭ�����̸� �߻�޼ҵ尡 �־���Ѵ� y|n
//������ n �߻�Ŭ�������� �߻�޼ҵ尡 �� �־���ϴ°� �ƴ�. �־ �ǰ� �����.
	protected String name;
	
	public abstract void setName(String name); //�߻�޼ҵ� -- �޼ҵ忡 {}(body) �� ���� �� �ڸ��� ; �� ������ �� ���� �߻�޼ҵ�� �Ѵ�.
	//�߻�޼ҵ�� ȣ�� �� �� ����.
	
	public String getName() {//����
		return name;
	}
}
