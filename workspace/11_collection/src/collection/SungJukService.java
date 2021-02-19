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
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 검색");
			System.out.println("4. 삭제");
			System.out.println("5. 정렬");
			System.out.println("6. 끝");
			System.out.println("***********************");
			
			System.out.println("1~6중에 선택하세요 ");
			System.out.print("메뉴 번호를 입력해주세요: ");
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
				System.out.println("1~6 중에 선택하세요!!!");
			}	
		}//while
	}
		
		public void insertArticle() {
			
			Scanner scan = new Scanner(System.in);
			
			System.out.print("번호 입력: ");
			int number = scan.nextInt();
			
			System.out.print("이름 입력: ");
			String name = scan.next();
			
			System.out.print("국어 입력: ");
			int kor = scan.nextInt();
			
			System.out.print("영어 입력: ");
			int eng = scan.nextInt();
			
			System.out.print("수학 입력: ");
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
			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
			
			
			for(int i = 0; i < list.size() ; i++) {
			System.out.println(list.get(i).getNumber()+"\t"+list.get(i).getName()+"\t"+list.get(i).getKor()+"\t"
							+list.get(i).getEng()+"\t"+list.get(i).getMath()+list.get(i).getTot()+"\t"+list.get(i).getAvg());
		}	
	}
		public void searchArticle() {
			Scanner scan = new Scanner(System.in);
			
			System.out.print("검색 할 이름 입력 : " );
			
			String inputname = scan.next();
			int count = 0 ;
			
			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
			
			for(int i = 0; i < list.size() ; i++) {
				
				if(list.get(i).getName().equals(inputname)) {
					System.out.println(list.get(i).getNumber()+"\t"+list.get(i).getName()+"\t"+list.get(i).getKor()+"\t"
							+list.get(i).getEng()+"\t"+list.get(i).getMath()+list.get(i).getTot()+"\t"+list.get(i).getAvg());
						count ++;
				}
			}
			
			if(count == 0) {
				System.out.println("찾고자하는 이름이 없습니다.");
			}

		}
		
		public void deleteArticle() {
			
			Scanner scan = new Scanner(System.in);
			
			
			//방법 1
//			System.out.print("삭제 할 이름 입력 : ");
			String deletename = scan.next();
//			
//			for(int i = 0; i < list.size(); i ++) {
//				if(list.get(i).getName().equals(deletename)) {
//					list.remove(i);
//					i = -1;
//					System.out.println("데이터를 삭제하였습니다.");
//				}//if
//			}//for
			
			
			//방법2
			int sw = 0;
//			for(SungJukDTO dto : list) {
//				if(dto.getName().equals(deletename)) {
//					list.remove(dto);
//					sw = 1;
//			System.out.println("데이터를 삭제하였습니다.");
//				}
//			}
			//---- 에러가 발생하게 됨, 인덱스가 삭제되면서 재정의 되기 때문에.
			// 그래서 이럴 때 싸용하는게 Iterator 를 사용함.
			// 이터레이터는 인덱스를 가지고 있는 것이 아니라, 자신이 있는 위치를 말하는 것 이므로 인덱스가 재정의 되어도
			// 같은 위치를 가르키고 있다.
			// Iterator 동작 
			// 1. 타겟 다음순서로 이동 -> 그 후 이전 데이터 제거( 이전데이터는 다음순서로 이동하기전까진 버퍼에 저장함 )
			
			
			//방법3
			Iterator<SungJukDTO> it = list.iterator();
			while(it.hasNext()) {
				SungJukDTO dto = it.next(); //다음 항목으로 이동.
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
				System.out.println("1. 이름으로 오름차순");
				System.out.println("2. 중점으로 내림차순");
				System.out.println("3. 이전메뉴");
				System.out.print("	번호 입력 : ");
				
				num = scan.nextInt();
				
				if(num == 3) break;
				if(num == 1) {
					//Collections.sort(list); //SungJukDTO 에 비교의 기준값을 잡아주지 않아서 에러가 발생함.
					
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
							//조건연산자? 참: 거짓;
							
							//return s1.getTot() < s2.getTot() ? -1 : 1 ; //오름차순
							return s1.getTot() < s2.getTot() ? 1 : -1; //내림차순
						}//compare()
					};//Comparator()메소드
				}
			}//while
		}

}
