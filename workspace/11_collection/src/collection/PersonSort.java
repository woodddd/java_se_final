package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PersonSort {

	public static void main(String[] args) {
		String[] ar = {"orange","apple","banana","pear","peach","applemango"};
		
		System.out.println("���� �� = ");
		for(String data : ar) {
			System.out.print(data + " ");
		}
		System.out.println();
		
		//sort����� �츮�� �� �� ����. ���α׷� ���ο��� �˾Ƽ� ����ؼ� ���� �ֱ� ������..
		Arrays.sort(ar); //sort�� ������ �Ű����� ar�� String[] Ÿ�� �̹Ƿ� Arrays Ŭ�������ִ� sort �޼ҵ带 ����� �� ����.
		//ArraysŬ������ sort�޼ҵ忡 �Ķ���͸� �⺻�ڷ����� �迭�� �־��
		//�˾Ƽ� ������ �ؼ� ��������.
		
		//sort �޼ҵ�� compareTo �޼ҵ带 ȣ������.
		//��ǥ������ sort�ڿ� �迭�� ���ٸ� Arrays Ŭ������ sort�� �̿���.
		
		
		System.out.println("���� �� = ");
		for(String data : ar) {
			System.out.print(data + " ");
		}
		System.out.println("\n");
		
		PersonDTO aa = new PersonDTO("ȫ�浿", 25);
		PersonDTO bb = new PersonDTO("��ġ", 40);
		PersonDTO cc = new PersonDTO("�����", 30);
		
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		System.out.println("���� �� = " + list);
		
		System.out.println("\n���̷� ����");
		Collections.sort(list); //sort�޼ҵ��� �Ű����� list��  ArrayList<PersonDTo> Ÿ�� �̹Ƿ�, CollectionsŬ������ �ִ� sort �޼ҵ带 ����ؾ���.
		//�Ϲ������� ��� ����Ʈ�� CollectionsŬ������ sort �޼ҵ带 �̿���.
		
		
		System.out.println("���� �� = " + list);
		System.out.println();
		
		//���� ������ �̸����� ����
		Comparator<PersonDTO> com = new Comparator<PersonDTO>() {//Comparator �� �������̽��� new �� �� ���� ��ø�̳� Ŭ������ �̿��Ѱ�
			@Override
			public int compare(PersonDTO p1, PersonDTO p2) {
				
				return p1.getName().compareTo(p2.getName())*(-1); // 1 , 0 , -1 �� compareTo �޼ҵ尡 ��ü������ �������
				//(-1)�� ���̸� �������������̵�. 1�� -1�� -1�� 1�� 0�� 0����
			}
		};
		
		System.out.println("\n�̸����� ����");
		Collections.sort(list, com); //1.�� ����� �� 2.�δ���� �� �� �ڸ��ٲ�
		System.out.println("���� �� = " + list);
		System.out.println();
		
	}
	

}
