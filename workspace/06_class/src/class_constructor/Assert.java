package class_constructor;

import java.util.Scanner;

public class Assert {
	
	private int x,y,result = 1;
	
	public static void main(String[] args) {
		Assert as = new Assert();
		
		as.input();
		as.output();

	}
	
	public void input() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("x �Է� : ");
		x = scanner.nextInt();
		
		System.out.print("y �Է�: ");
		y = scanner.nextInt();
		
	}
	
	public void output() {
		//y�� �ݵ�� ����� �Է¹ްڴ�.
		//assert y >= 0; //�ش� ������ �����ϸ� �Ʒ��� ���� ���� �� ���̰�, ������ �����������ϸ� ���⼭ �����.
		//��, assert�� �Ϲ� run �� �����ϸ� ���õǰ�,
		//Run as - Run Configrations - Arguments - VM Arguments �� ���� -ea �� �ְ� �Ǹ� assert�� ó���ϰԵ�. (-da �� �ְ� �Ǹ� ó������ �ʰ� ��)
		// -ea (enable) -da(disable)
		assert y >= 0 : "y�� 0���� ũ�ų� ���ƾ� �Ѵ�.";// assert ���� : "�����޽���"; ������ �������� ���� �� �����޽��� ����. �� �Ʒ������� �������� ����
		System.out.print(x + "�� " + y + "���� ");
		for(int i = 0 ; i < y ; i++) {
			result *= x;
		}
		System.out.println(result);
	}

}
