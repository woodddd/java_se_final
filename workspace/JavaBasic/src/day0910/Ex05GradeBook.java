package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//�������� ���α׷�
//�츮�� ����ڷκ��� �Է��� �޵�
//���� �������� ����ڷκ��� ������� ������ �Է� �޾Ƽ�
//���� ����ڰ� ���Ḧ �����ϸ� ���α׷��� ���ᰡ�Ǵ� �������� ���þ��
public class Ex05GradeBook {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//��Ʈ���� �ʱ�ȭ ���ִ� ���
		//1�� ���
		String yn = new String();
		//2�� ���
		//yn = null;
		//3�� ���
		//yn = "";
		//4�� ���
		//yn = "��Ʈ��";
		do {
			System.out.print("�̸�: ");
			String name = br.readLine();
			
			System.out.print("���� : ");
			int kor = Integer.parseInt(br.readLine());
			
			System.out.print("���� : ");
			int eng = Integer.parseInt(br.readLine());
			
			System.out.print("���� : ");
			int math = Integer.parseInt(br.readLine());
			
			int sum = kor + eng + math;
			System.out.println("���� " + sum);
			
			System.out.print("����Ͻðڽ��ϱ�? (y/n)");
			yn = br.readLine().toUpperCase();
			//toUpperCase()�޼ҵ��
			//�ش� ������ ��� �빮�ڷ� �ٲ��ִ� �޼ҵ��̴�.
		}while(yn.equals("Y"));
	}

}
