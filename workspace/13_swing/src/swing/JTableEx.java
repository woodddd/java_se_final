package swing;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

class JTableModel extends AbstractTableModel {//AbstractTableModel - 추상메소드들을 가지고 있는 추상클래스.
	Object[][] data =  {{"Nari","마루치",new Integer(1234),"옆집친구"},
						{"One","오윤아",new Integer(1111),"예쁜이"},
						{"two","오윤서",new Integer(2222),"귀염둥이"},
						{"three","아라치",new Integer(3333),"동아리 친구"}};
	
	String[] name = {"아이디","이름","비밀번호","구분"};//필드명

	@Override
	public int getColumnCount() {
		return name.length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public Object getValueAt(int r, int c) {
		return data[r][c];
	}
	
	
	public String getColumnName(int c) {
		return name[c];//테이블의 열의 이름을 name에서 가져온다.
	}
	
	
	public boolean isCellEditable(int r, int c) {
		return (c!= 0) ? true : false; //첫번째 열(테이블의 속성명이 적힌 부분) 은 수정할 수 없고, 다른 열은 수정이 가능하다.. true - 셀의 값을 수정할 수 있음. false - 셀의 값을 수정할 수 없음
	}
	
	@Override
		public void setValueAt(Object ob, int r, int c) {
		data[r][c] = ob; //셀을 선택하여 값을 입력하면 값을 data의 [r][c]에 저장한다.
	}
	
}
//---------------
public class JTableEx extends JFrame{
	JTable table;
	JTableModel model;
	
	public JTableEx() {
		model = new JTableModel();
		table = new JTable(model);
		
		add(new JScrollPane(table));
		
		setBounds(200,200,300,300);
		setVisible(true);
		//						JFrame은 생략 가능!
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JTableEx();
		
	}

}
