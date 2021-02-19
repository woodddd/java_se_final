package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionTest2 {
	private int dan;
	//							�ֻ��� �θ�.
	public void input() throws IOException { //NumberFormatException, IOException �� ��Ӱ��� �� �ϳ��� ������ ����� ����
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("���ϴ� ���� �Է�: ");
		dan = Integer.parseInt(br.readLine());//throws �� ����϶�°� ������ �߻��ϴ°� �ƴ϶� ������ �߻��� ��Ȳ�� ����϶�� ��.
	}
	
	//IO Stream
	// �Է� : Reader	�߻�Ŭ����
	// ��� : Writer 	�߻�Ŭ����
	// Reader , Writer �� �߻�Ŭ���� �̱� ������ ���������� new �� �� ����, �ڽ�Ŭ������ �̿��ؾ���.

	//					      BufferedReader 		      InputStreamReader
	// ExceptionTest2.java <-------------------- buffer <-------------------- Ű����(System.in)
	
	// ExceptionTest2.java --------------------> buffer -------------------->  
	
	
	public void output() {
		if(dan >= 2 && dan <= 9) {
			for(int i = 1; i < 10 ; i++) {
				System.out.println(dan + " * " + i + " = " + (dan*i));	
			}//for
		}else {
			//System.out.println("���� �ʰ�");
			try {
				throw new MakeException("���� �ʰ�");//������ Exception �߻� //���� ���ڿ��� ������ ������ �ϰ� �ʹٸ� new MakeException() ��ȣ �ȿ� �޼����� �Է����ָ� �ȴ�.
			//  throw �� ������ �߻���ų �� ����Ѵ�. �ݸ� �ڿ� s �� ���̸� throws �� ������ ���� �� ����Ѵ�.
			}catch(Exception e) {
				e.printStackTrace(); //Stack�� �ִ� �����޼����� ����.
			}
			 
		}//if
	}
	public static void main(String[] args) throws NumberFormatException, IOException { //�����ο��� ���� ��Ȳ�� �߻��ҿ����� ������ ȣ��ο����� �� ����ó���� �� �־�� �Ѵ�.
		ExceptionTest2 ex = new ExceptionTest2();
			ex.input();
			ex.output();	
		
	}

}


//throw --���̷��� - ������ �߻���ų���̴�.
//throws --���    - ������ �������̴�.
//�������̵� �� �޼ҵ�� ������������� throws�� �� �� �� ����.



//���ϴ� ���� �Է�: 5	input()
//-----------------------
//5*1=5			output
//5*2=10
//..����.
//5*9=45