package day0918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import day0915.Student;
import util.ArrayUtil;

public class StudentEx01 {
	private static BufferedReader bufferedReader;
	private static Student[] studentArray;
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		studentArray = new Student[0];
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		
		//BufferedReader �� �ʱ�ȭ, �� �����ڸ� ȣ���ϰ� �������ʹ�
		//���� ���� �޼ҵ尡 �ٸ� �޼ҵ带 �� ���Ŀ� ȣ���ϰ� �ȴٸ�
		//�̹� �ʱ�ȭ�� �� �����̱� ������ NullPointerException�� �߻����� �ʰ�
		//���������� ����� �� �ִ�.
		
			showMenu();
	
	}
	private static void showMenu() throws NumberFormatException, IOException {
		while(true) {
			System.out.println("��Ʈ ���� ���� ���α׷�");
			System.out.println("1. �Է� 2. ��� 3. ����");
			System.out.print("> ");
			int userChoice = Integer.parseInt(bufferedReader.readLine());
			if(userChoice == 1) {
				//�Է� �޼ҵ� ����
				add();
			}else if(userChoice == 2) {
				//��� �޼ҵ� ����
				printArray();
			}else if(userChoice == 3) {
				System.out.println("������ּż� �����մϴ�.");
				break;
			}else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}
	}
	
	private static void printArray() {
		for(int i = 0; i < studentArray.length; i++) {
			System.out.println(studentArray[i]); // �̰��� System.out.println �� �Ķ���� ���� studentArray[i] ��� ��ü�� ����
			//������ �ּ� ���� ��� �Ǿ�� �ϴµ� Student Ŭ������ toString �޼ҵ带 �������̵� �Ͽ� ���� ������ ����� �������Ƿ� ���� ��µǰ� �ȴ�.
		}
	}
	
	private static void add() throws IOException {
		studentArray = ArrayUtil.add(studentArray, setStudentInfo());
	}
	
	private static Student setStudentInfo() throws IOException {
		
		Student s = new Student();// Student()��ü�� �����ϰ� ��ü�� �ڷ����� Student, �̸��� s�� �ȴ�.
		
		System.out.print("�л� �̸�: ");
		s.setName(bufferedReader.readLine());
		
		System.out.print("�л� ��ȣ: ");
		s.setId(Integer.parseInt(bufferedReader.readLine()));
		
		System.out.print("���� ����: ");
		s.setKorean(Integer.parseInt(bufferedReader.readLine()));
		
		System.out.print("���� ����: ");
		s.setEnglish(Integer.parseInt(bufferedReader.readLine()));
	
		System.out.print("���� ����: ");
		s.setMath(Integer.parseInt(bufferedReader.readLine()));
		
		return s;
	}
	
}
