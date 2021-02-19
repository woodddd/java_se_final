package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class SungJukService {
//		private ArrayList<SungJukDTO> list = new ArrayList<SungJukDTO>();
		
		private ArrayList<SungJukDTO> list;
		
		public SungJukService() {
			list = new ArrayList<SungJukDTO>();
		}
		
		public void menu() {
			Scanner scan = new Scanner(System.in);
			int num;
			
			while(true) {
			System.out.println("menu()");
			System.out.println("***********************");
			System.out.println("1. �Է�");
			System.out.println("2. ���");
			System.out.println("3. �˻�");
			System.out.println("4. ����");
			System.out.println("5. ����");
			System.out.println("6. ��");
			System.out.println("***********************");
			
			System.out.println("1~6�߿� �����ϼ��� ");
			System.out.print("�޴� ��ȣ�� �Է����ּ���: ");
			num = scan.nextInt();
			System.out.println();
			
			if(num== 6) break;
			if(num==1) {
				insertArticle();
			}
			else if(num==2) {
				printArticle();
			}
			else if(num==3) {
				searchArticle();
			}
			
			else if(num==4) {
				deleteArticle();
			}
			else if(num==5) {
				sortArticle();
			}
			else {
				System.out.println("1~6 �߿� �����ϼ���!!!");
			}	
		}//while
	}
		
		public void insertArticle() {
			
			Scanner scan = new Scanner(System.in);
			
			System.out.print("��ȣ �Է�: ");
			int number = scan.nextInt();
			
			System.out.print("�̸� �Է�: ");
			String name = scan.next();
			
			System.out.print("���� �Է�: ");
			int kor = scan.nextInt();
			
			System.out.print("���� �Է�: ");
			int eng = scan.nextInt();
			
			System.out.print("���� �Է�: ");
			int math = scan.nextInt();
			
			SungJukDTO dto = new SungJukDTO();
			dto.setNumber(number);
			dto.setName(name);
			dto.setKor(kor);
			dto.setEng(eng);
			dto.setMath(math);
			
			dto.calc();
			
			
			list.add(dto);
			
			menu();
		}
		
		public void printArticle() {
			System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
			
			
			for(int i = 0; i < list.size() ; i++) {
			System.out.println(list.get(i).getNumber()+"\t"+list.get(i).getName()+"\t"+list.get(i).getKor()+"\t"
							+list.get(i).getEng()+"\t"+list.get(i).getMath()+list.get(i).getTot()+"\t"+list.get(i).getAvg());
		}	
	}
		public void searchArticle() {
			Scanner scan = new Scanner(System.in);
			
			System.out.print("�˻� �� �̸� �Է� : " );
			
			String inputname = scan.next();
			int count = 0 ;
			
			System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
			
			for(int i = 0; i < list.size() ; i++) {
				
				if(list.get(i).getName().equals(inputname)) {
					System.out.println(list.get(i).getNumber()+"\t"+list.get(i).getName()+"\t"+list.get(i).getKor()+"\t"
							+list.get(i).getEng()+"\t"+list.get(i).getMath()+list.get(i).getTot()+"\t"+list.get(i).getAvg());
						count ++;
				}
			}
			
			if(count == 0) {
				System.out.println("ã�����ϴ� �̸��� �����ϴ�.");
			}

		}
		
		public void deleteArticle() {
			
			Scanner scan = new Scanner(System.in);
			
			
			//��� 1
//			System.out.print("���� �� �̸� �Է� : ");
			String deletename = scan.next();
//			
//			for(int i = 0; i < list.size(); i ++) {
//				if(list.get(i).getName().equals(deletename)) {
//					list.remove(i);
//					i = -1;
//					System.out.println("�����͸� �����Ͽ����ϴ�.");
//				}//if
//			}//for
			
			
			//���2
			int sw = 0;
//			for(SungJukDTO dto : list) {
//				if(dto.getName().equals(deletename)) {
//					list.remove(dto);
//					sw = 1;
//			System.out.println("�����͸� �����Ͽ����ϴ�.");
//				}
//			}
			//---- ������ �߻��ϰ� ��, �ε����� �����Ǹ鼭 ������ �Ǳ� ������.
			// �׷��� �̷� �� �ο��ϴ°� Iterator �� �����.
			// ���ͷ����ʹ� �ε����� ������ �ִ� ���� �ƴ϶�, �ڽ��� �ִ� ��ġ�� ���ϴ� �� �̹Ƿ� �ε����� ������ �Ǿ
			// ���� ��ġ�� ����Ű�� �ִ�.
			// Iterator ���� 
			// 1. Ÿ�� ���������� �̵� -> �� �� ���� ������ ����( ���������ʹ� ���������� �̵��ϱ������� ���ۿ� ������ )
			
			
			//���3
			Iterator<SungJukDTO> it = list.iterator();
			while(it.hasNext()) {
				SungJukDTO dto = it.next(); //���� �׸����� �̵�.
				if(dto.getName().equals(deletename)) {
					it.remove();
					sw = 1;	
				}
				
				
			}//while
		
		
		}//deleteArticle()
		
		public void sortArticle() {
			Scanner scan = new Scanner(System.in);
			int num=0;
			
			while(true) {
				System.out.println();
				System.out.println("1. �̸����� ��������");
				System.out.println("2. �������� ��������");
				System.out.println("3. �����޴�");
				System.out.print("	��ȣ �Է� : ");
				
				num = scan.nextInt();
				
				if(num == 3) break;
				if(num == 1) {
					//Collections.sort(list); //SungJukDTO �� ���� ���ذ��� ������� �ʾƼ� ������ �߻���.
					
					Comparator<SungJukDTO> com = new Comparator<SungJukDTO>() {
						public int compare(SungJukDTO s1, SungJukDTO s2) {
							return s1.getName().compareTo(s2.getName());
						}
						
					};
					
					Collections.sort(list , com);
					printArticle();
					
				}else if(num == 2) {
					Comparator<SungJukDTO> com = new Comparator<SungJukDTO>() {
						@Override
						public int compare(SungJukDTO s1, SungJukDTO s2) {
							//���ǿ�����? ��: ����;
							
							//return s1.getTot() < s2.getTot() ? -1 : 1 ; //��������
							return s1.getTot() < s2.getTot() ? 1 : -1; //��������
						}//compare()
					};//Comparator()�޼ҵ�
				}
			}//while
		}

}
