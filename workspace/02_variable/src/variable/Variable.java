package variable;

public class Variable {

	public static void main(String[] args) {

	boolean a;
	a = true;
	System.out.println("a = " + a);
	
	char b;
	b = 'A';
	System.out.println("b = " + b);
	
	char c;
	c = 65;
	// c = 65536; -error
	//char �� 2byte ���� ǥ�� �����ϹǷ� 65536 �� ǥ���� �� ����
	//65536 �� �ڹٰ� int ������ �޾Ƶ�� Ÿ�� mismatch���� �� �����Ե�.
	System.out.println("c = " + c);
	
	//int d;
	//d = 65;
	int d = 65;
	System.out.println("d = " + d);
	
	int e ='A';
	System.out.println("e = " + e); 
	// char ���� 2����Ʈ. int ���� 4����Ʈ �̹Ƿ� int ���� char ���� ���� �� ����.
	
	
	//�Ǽ��� �⺻���� double�� �ϴµ� double �� 43.8 �� float ���� ���� ������ �ϱ� ������ �� �ִ� ���̴�.
	//ū �������� ������������ ���� �� ����. ������ �߻���.
	float f;
	f = 43.8f; // 43.8 �� ������ float ������ ����
	//f = (float)43.8; //43.8�� double�� ������, float������ �ӽ� ����
	System.out.println("f = " + f);
	}
}
