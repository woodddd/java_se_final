package io;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ScoreImpl implements Score {
	private List<ScoreDTO> list;
	
	public ScoreImpl() {
		list = new ArrayList<ScoreDTO>();
	}

	@Override
	public void input(ScoreDTO dto) {
		list.add(dto);
		
	}

	@Override
	public void print(DefaultTableModel model) {
		//테이블을 가져 왔으면 테이블을 초기화 시켜주어야함.
		model.setRowCount(0); //테이블 초기화
		//기존에 값이 있었다면 만약 print 를 했을때 기존 저장되어 있던 값에 또 값이 추가 되기 때문에
		//테이블을 초기화 시켜준 후 초기화를 해야 중복데이터가 재생성 되지 않는다.
		
		//테이블에는 어레이 리스트를 출력할 수 없기 때문에 벡터 이용
		for(ScoreDTO dto : list) {
			Vector<String> v = new Vector<String>();
			v.add(dto.getHak());
			v.add(dto.getName());
			v.add(dto.getKor() + ""); //add는 문자열만 들어갈 수 있기 때문에
			v.add(dto.getEng() + "");
			v.add(dto.getMath() + "");
			v.add(dto.getTot() + "");
			v.add(dto.getAvg() + "");
			
			model.addRow(v);
		}//for
		
	}
	
	@Override
	public void save() {
		//파일 저장버튼을 누르면 현재 테이블 정보를 파일로 저장해야한다.
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(null);//저장을 할 수 있는 다이어로그창이 나옴//null을 넣으면 독립적으로 다이어로그가 생성됨
		File file = null;//초기화
		
		if(result == JFileChooser.APPROVE_OPTION) {//저장 버튼을 누름
			file = chooser.getSelectedFile();// 선택된 파일(파일이름)을 가져온다.
		}
		
		if(file == null) return; //세이브 다이어로그에서 취소를 누른 경우.
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));//아까 받아 놓았던 file (파일명을 저장하고있음) 을 내보내어 파일을 경로를 생성함.
			for(ScoreDTO dto : list) {
				oos.writeObject(dto); //파일 경로가 지정되어 있는 oos 를 통하여 Object 타입으로 객체에 저장된 값을 내보냄.
			}
			oos.close();// OutputStream 객체를 다 사용하였다면 close를 통하여 메모리 할당을 해제한다.
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void search(DefaultTableModel model) {
//		//showInputDialog를 이용해서 학번을 입력받는다.
//		model.setRowCount(0); //기존 입력된 것이 있으면 초기화 시켜줘야함
//		
//		String hak = JOptionPane.showInputDialog(null,"원하는 학번을 입력하세요", "학번으로 검색", JOptionPane.YES_NO_CANCEL_OPTION);
//		
//		
//		//만약 취소를 누르거나 학번을 입력하지 않으면 그냥 메소드를 나간다.
//		if(hak == "" || hak == null) {//null 은 취소를 눌렀을 때 이다.
//			return; 
//		}else {
//			for(ScoreDTO dto : list) {
//				if(hak.equals(dto.getHak())) {
//					Vector<String> v = new Vector<String>();
//					v.add(dto.getHak());
//					v.add(dto.getName());
//					v.add(dto.getKor() + ""); 
//					v.add(dto.getEng() + "");
//					v.add(dto.getMath() + "");
//					v.add(dto.getTot() + "");
//					v.add(dto.getAvg() + "");
//					
//					model.addRow(v);
//				}//if
//			}//for
//		}//if
		
		//원하는 학번이 있으면 JTable에 출력해주면 된다.
		
		//원하는 학번이 없으면 showMessageDialog를 이용해서 "찾고자 하는 학번이 없습니다." 라고 출력한다.
		
		
		
		//강사님꺼
		String hak = JOptionPane.showInputDialog(null, "학번을 입력하세요");
		if(hak == null || hak.equals("")) return; // 취소를 누르거나 아무것도 입력하지 않은경우
		
		int sw = 0;
		//model.setRowCount(0); // 같은 코드를 못찾아도 해당 메소드를 들어오면 지워짐
		for(ScoreDTO dto : list) {
			if(hak.equals(dto.getHak())) {
				
				model.setRowCount(0);//매번 포문이 돌아가기 떄문에 같은 학번이 존재한다면 학번은 한개만 나오게됨. 하지만 학번이 실제로 중복될 일은 없기 때문에 신경 쓰지x
				
				Vector<String> v = new Vector<String>();
				v.add(dto.getHak());
				v.add(dto.getName());
				v.add(dto.getKor() + ""); 
				v.add(dto.getEng() + "");
				v.add(dto.getMath() + "");
				v.add(dto.getTot() + "");
				v.add(dto.getAvg() + "");
				
				model.addRow(v);
				
				sw = 1;
			}//if
		}//for
		
		if(sw == 0) {
			JOptionPane.showMessageDialog(null,"찾고자 하는 학번이 없습니다.");
		}//if
		
	}//search()


	@Override
	public void tot_desc() {
		
		
		//Comparator 사용 한 것! 단, 얘를 사용하려면 매개변수 DefaultTableModel model 를 받아야함.
		
//		Comparator<ScoreDTO> com = new Comparator<ScoreDTO>() {
//
//			@Override
//			public int compare(ScoreDTO a, ScoreDTO b) {
//				
//				return a.getTot() < b.getTot() ? 1 : -1;//return 값을 a < b 기준 -1 : 1 -> 오름차순 , 1 : -1 -> 내림차순
//			}
//			
//		};//익명클래스
//			Collections.sort(list, com);
//			
//			model.setRowCount(0);
//			
//			for(ScoreDTO dto : list) {
//				
//				
//				
//			Vector<String> v = new Vector<String>();
//			v.add(dto.getHak());
//			v.add(dto.getName());
//			v.add(dto.getKor() + ""); 
//			v.add(dto.getEng() + "");
//			v.add(dto.getMath() + "");
//			v.add(dto.getTot() + "");
//			v.add(dto.getAvg() + "");
//			
//			model.addRow(v);
//			}
		
		//Comparable 사용!!
		//Collections.sort(list); // ScoreDTO 에서 implements 한 Comparable<ScoreDTO> 의 compareTo 메소드를 오버라이딩 하여 
		// Collections.sort를 이용할 수 있도록 변경 한 것이다.
		//sort 메솓드가 실행되면 오버라이딩 된 CompareTo 메소드를 찾아감.
			
		//강사님의 Comparator<ScoreDTO>
		
		Comparator<ScoreDTO> com = new Comparator<ScoreDTO>() {//인터페이스인 Comparator 는 추상의 개념이므로 직접 new 할 수 없다.그래서 익명 이너 클래스를 이용
			public int compare(ScoreDTO s, ScoreDTO s2) {
				return s.getTot() < s2.getTot() ? 1: -1; // 만약 좌측의 값이 작을 경우 -1 클경우 1 이 나오게 한다면 오름차순
				//그 반대의 경우 내림차순 정렬이 된다.
			}
		};
		Collections.sort(list, com);
		
			
	}//tot_desc

	@Override
	public void load() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(null);//파일을 열 수 있는 다이어로그 생성
		File file = null;
		
		if(result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile(); // 선택한 파일이 있다면 파일명 및 경로정보를 객체로 가져옴
		}
		
		if(file == null) return;
		
		list.clear(); // 리스트 자체를 지워버리는 것이 아니고 , list안에 담겨있는 값을 비워줘라. 라는 뜻
		
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file)); 
			while(true) {
				try {
					ScoreDTO dto = (ScoreDTO)ois.readObject(); // 자식 = (자식)부모  ---> readObject 가 Object타입으로 읽어오고, 그것을 자식클래스로 강제 형변환 시켜준 것임.
					list.add(dto); //list에 추가한 후 ScoreForm 에서 print 해줌.
				}catch(EOFException e) { // End Of File Exception (파일의 끝을 만나게 되면 에러) 위에서 찾는것들이 언제 끝나는지를 모르기 때문에 에러가 발생하게됨.
					break;
				}
				
			}//while
			
			//ois.close(); Unreachable --- 여기까지 도달할 수 없는 코드다.
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) { // ClassNotFoundException 는 IOException 을 상속하지 않는다. 그래서 readObject를 사용하려면 무조건 이 두개를 catch 해 주어야 한다.
			e.printStackTrace();
		}//ClassNotFoundException -- 클래스를 찾지 못했을 경우..
		
	}
	
	
	

}
