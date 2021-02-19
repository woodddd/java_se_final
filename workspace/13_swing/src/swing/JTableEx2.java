package swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/*   숙     제
1.입력받는 아이디와 기존 아이디를 비교하여 사용중인 아이디는 받지 않도록.
JOptionPane.showMessageDialog(this,"사용중인 아이디 입니다..");

2.delete() 추가.

3.그림판 - 틀만 작성하세요 
Project : 13_swing

Class : MsPaint.java

private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
private JCheckBox fill;
private JRadioButton line, circle, rect, roundRect, pen;
private JComboBox<String> combo;
private JButton draw;
private DrCanvas can;

 */

public class JTableEx2 extends JFrame implements ActionListener {
	private ArrayList<PersonDTO> list;
	private Vector<String> vector;
	private DefaultTableModel model; //내부적 테이블의 작업을 해준다.
	private JTable table; // 화면에 띄워주는 역할
	private JButton insertBtn, deleteBtn;
	
	
	public JTableEx2(){
		//데이터
		list = new ArrayList<PersonDTO>(); //ArratList 는 테이블에 직접 삽입할 수 없음. 그래서 벡터에 담았다가 벡터에서 테이블로 데이터를 보내줘야함.
		list.add(new PersonDTO("hong","홍길동","111","010-123-1234"));
		list.add(new PersonDTO("conan","코난","333","010-777-7777"));

		//타이틀
		vector = new Vector<String>();
		vector.addElement("아이디");
		vector.addElement("이름");
		vector.add("비밀번호");
		vector.add("핸드폰");
		
		
		model = new DefaultTableModel(vector, 0) {//타이틀은  vector에 있는 것을 가져와라. 0 - 밑에 들어갈 테이블의 공간을 잡지말고 타이틀만 잡아라.
			@Override
			public boolean isCellEditable(int r, int c) {//DefaultTableModel은 추상클래스가 아니기 때문에 메소드를 꼭 오버라이딩 해 주어야 하는 것은 아님. 필요한 것을 오버라이딩..
				return (c!=0) ? true : false; //0열이 아니면이 아니면 true //아이디를 제외한 셀은 수정이 가능하다.
			}
		}; 
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		//테이블 - 데이터
		for(PersonDTO dto : list) {
			Vector<String> v = new Vector<String>(); //ArrayList는 바로 테이블에 담을 수 없으므로 vector 에 값을 저장한 후 테이블에 값을 넣어준다.
			v.add(dto.getId());
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getTel());
			
			model.addRow(v);//행단위로 붙이겠다.
		}//for
				
		//버튼생성
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		insertBtn = new JButton("추가");
		deleteBtn = new JButton("삭제");
		
		
		p.add(insertBtn);
		p.add(deleteBtn);
				
		Container c = this.getContentPane();
		c.add("Center", scroll);
		c.add("South", p);
		
		setBounds(200,200,500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//이벤트
		insertBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		
		
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == insertBtn) {
			insert();
		}else if(e.getSource() == deleteBtn) {
			delete();
		}
		
	}


	private void insert() {
		//리턴 값 : 사용자가 입력한 문자열, 취소 버튼이 선택되거나 창이 닫히면 null 리턴
		String id = JOptionPane.showInputDialog(this, "아이디를 입력하세요");// 다이어로그를 띄울거다.( 띄울위치 , 메세지)
		if(id == null) {//추가 - 취소 를 하게 되면 아무것도 메세지를 내보내지 않고 닫기.
			return; //메소드를 벗어나라
		}
		
		if(id.length()==0) {
				JOptionPane.showInternalMessageDialog(this, "아이디는 필수 항목입니다.");
		}
		for(int i = 0 ; i < model.getRowCount() ; i++) {
			if(id.equals(model.getValueAt(i, 0))) {
				JOptionPane.showMessageDialog(this, "사용중인 아이디 입니다..");
				return;
			}
		}
		
		//사용중인 아이디 입니다.
		
		String name = JOptionPane.showInputDialog(this, "이름을 입력하세요"); 
		String pwd =  JOptionPane.showInputDialog(this, "비밀번호를 입력하세요");
		String tel = JOptionPane.showInputDialog(this, "전화번호를 입력하세요");
		
		Vector<String> v = new Vector<String>();
		v.add(id);
		v.add(name);
		v.add(pwd);
		v.add(tel);
		
		model.addRow(v);
		JOptionPane.showMessageDialog(this, "추가 완료");
		System.out.println(model.getRowCount());
	}

	private void delete() {
		String name = JOptionPane.showInputDialog(this, "이름을 입력하세요"); 
		int sw = 0; // sw - switch
		
		if(name == null || name.equals("")) {
			return;
		}
		
		for(int i = 0 ; i < model.getRowCount() ; i++) {
			if(name.equals(model.getValueAt(i, 1))){
				model.removeRow(i);
				i --; // i = -1 도 상관없음.
				sw ++;
			}//if
			
		}//for
		
		if(sw == 0) {
			JOptionPane.showMessageDialog(this, "검색한 이름이 없습니다.");
		}
		
		
		//지워졌으면 삭제완료!
		//없는 이름이면 없는 이름입니다. (만약 같은 이름이 있다면 전부다제거)
	}
	
	public static void main(String[] args) {
		new JTableEx2();
	}
}
