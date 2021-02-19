package swing;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

class JTableModel extends AbstractTableModel {//AbstractTableModel - �߻�޼ҵ���� ������ �ִ� �߻�Ŭ����.
	Object[][] data =  {{"Nari","����ġ",new Integer(1234),"����ģ��"},
						{"One","������",new Integer(1111),"������"},
						{"two","������",new Integer(2222),"�Ϳ�����"},
						{"three","�ƶ�ġ",new Integer(3333),"���Ƹ� ģ��"}};
	
	String[] name = {"���̵�","�̸�","��й�ȣ","����"};//�ʵ��

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
		return name[c];//���̺��� ���� �̸��� name���� �����´�.
	}
	
	
	public boolean isCellEditable(int r, int c) {
		return (c!= 0) ? true : false; //ù��° ��(���̺��� �Ӽ����� ���� �κ�) �� ������ �� ����, �ٸ� ���� ������ �����ϴ�.. true - ���� ���� ������ �� ����. false - ���� ���� ������ �� ����
	}
	
	@Override
		public void setValueAt(Object ob, int r, int c) {
		data[r][c] = ob; //���� �����Ͽ� ���� �Է��ϸ� ���� data�� [r][c]�� �����Ѵ�.
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
		//						JFrame�� ���� ����!
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JTableEx();
		
	}

}
