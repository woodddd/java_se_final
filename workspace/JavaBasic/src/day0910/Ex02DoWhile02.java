package day0910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//����ڷκ��� ����, ���� , ���� ������ �Է¹޾Ƽ�
//������ ������ִ� ���α׷�
//�� ����ڰ� �Է��� ������ �߸��� ����(0���� �۰ų� 100���� ū ���)
//�� ������
//�ùٸ� ������ ���� �� ����
//�ٽ� �Է��� �޴´�.
//�Է��� �� ������ do while�� ����ϵ��� �Ѵ�.

public class Ex02DoWhile02 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int kor = 0;
		int eng = 0;
		int math = 0;
		
		do {
			if(kor < 0 || kor > 100) {
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
			}
		
		System.out.print("���� ������ �Է� : ");
		kor = Integer.parseInt(br.readLine());
		
		}while(kor < 0 || kor > 100);
		
		do {
			if(eng < 0 || eng > 100) {
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
			}
			
		System.out.print("���� ������ �Է� : ");
		eng = Integer.parseInt(br.readLine());
			
			}while(eng < 0 || eng > 100);
		
		do {
			if(math < 0 || math > 100) {
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
			}
			
		System.out.print("���� ������ �Է� : ");
		math = Integer.parseInt(br.readLine());
		
		}while(math < 0 || math > 100);
		
		System.out.println("����, ���� , ���� �� ������ : " + (kor + eng + math));
		
		
		
		
	}

}
