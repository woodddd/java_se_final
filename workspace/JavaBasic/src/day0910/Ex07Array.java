package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//�迭
//�迭�̶� �Ȱ��� �ڷ����� ���ִ� ����
//�迭�̶�� �Ѵ�.

//���� : 
//int �迭�̶�� �ϸ�
//int�� ����ڰ� ������ ��ŭ ���ְ�
//�� ��ü�� �ϳ��� �迭�̶�� �Ѵ�.

public class Ex07Array {

	public static void main(String[] args) throws IOException {
		//�迭�� �����ϴ� ���
		//�迭�� �ڷ���[] �迭�̸� = new �ڷ���[ũ��]
		
		//���� �츮�� int�迭�� ����� �ȴٸ�
		int[] arr = new int[5];
		//�̷��� �����.
		
		//�迭�� �츮�� �׻� ũ�⸦ ������ �־�� �Ѵ�.
		//�� ũ�⸦ ��� �� ����.
		//���� arr�� �ش� �迭�� 5���� int ������ �ٷ� �� �ִٴ� ���� ���Ѵ�.
		
		//�迭�� �ִ� �� ������ ������ ������
		//�迭�̸�[�ش� ��ġ]�� ��� �����ϰ� �ȴ�.
		
		//�ش� ��ġ�� �츮�� index��� ǥ���Ѵ�.
		//�׸��� index��
		//0~ ũ�� -1 �����̴�.
		//�� ũ�Ⱑ 5�� �迭��
		//�ε����� 0������ 4������ �ִ�.
		
		//�츮�� ������
		//�������� ��쿡��
		int a;
		a = 20;
		System.out.println("a : " + a);
		//�� ���� ������ �̸����� ������ ������
		
		//�迭 ���� ��쿡��   	// �迭�� �ʱⰪ�� 0��.
		arr[0] = 15;
		System.out.println("arr[0]: " + arr[0]);
		//�迭�̸�[�ε���] 
		
		//�׷� �迭�� �� ��ҿ� ���� �ѹ� �Է��غ���
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//0������ 4������ ���ʴ�� �Է��� �غ���
		System.out.print("0�� �ε����� �Է��� ��: ");
		arr[0] = Integer.parseInt(br.readLine());
		
		System.out.print("1�� �ε����� �Է��� ��: ");
		arr[1] = Integer.parseInt(br.readLine());
		
		System.out.print("2�� �ε����� �Է��� ��: ");
		arr[2] = Integer.parseInt(br.readLine());
		
		System.out.print("3�� �ε����� �Է��� ��: ");
		arr[3] = Integer.parseInt(br.readLine());
		
		System.out.print("4�� �ε����� �Է��� ��: ");
		arr[4] = Integer.parseInt(br.readLine());
		
		for(int i = 0; i <= 4 ; i++) {
		System.out.println("arr[" + i + "]" + " = "+ arr[i]);
		
		//�迭�� �ٷ� �� �˾Ƶθ� ���� ��
		//1. ũ��� ������ �� �� �ִ�.
		int size = 10;
		arr = new int[size];
		//2. index�� ����� ���� ������ ����.
		//System.out.println(arr[-1]); --- ����
		System.out.println(arr[10]);
		//3. index�� ������ �־��� �� �ִ�.
		}
		
	}

}
