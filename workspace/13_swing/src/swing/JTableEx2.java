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

/*   ��     ��
1.�Է¹޴� ���̵�� ���� ���̵� ���Ͽ� ������� ���̵�� ���� �ʵ���.
JOptionPane.showMessageDialog(this,"������� ���̵� �Դϴ�..");

2.delete() �߰�.

3.�׸��� - Ʋ�� �ۼ��ϼ��� 
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
	private DefaultTableModel model; //������ ���̺��� �۾��� ���ش�.
	private JTable table; // ȭ�鿡 ����ִ� ����
	private JButton insertBtn, deleteBtn;
	
	
	public JTableEx2(){
		//������
		list = new ArrayList<PersonDTO>(); //ArratList �� ���̺� ���� ������ �� ����. �׷��� ���Ϳ� ��Ҵٰ� ���Ϳ��� ���̺�� �����͸� ���������.
		list.add(new PersonDTO("hong","ȫ�浿","111","010-123-1234"));
		list.add(new PersonDTO("conan","�ڳ�","333","010-777-7777"));

		//Ÿ��Ʋ
		vector = new Vector<String>();
		vector.addElement("���̵�");
		vector.addElement("�̸�");
		vector.add("��й�ȣ");
		vector.add("�ڵ���");
		
		
		model = new DefaultTableModel(vector, 0) {//Ÿ��Ʋ��  vector�� �ִ� ���� �����Ͷ�. 0 - �ؿ� �� ���̺��� ������ �������� Ÿ��Ʋ�� ��ƶ�.
			@Override
			public boolean isCellEditable(int r, int c) {//DefaultTableModel�� �߻�Ŭ������ �ƴϱ� ������ �޼ҵ带 �� �������̵� �� �־�� �ϴ� ���� �ƴ�. �ʿ��� ���� �������̵�..
				return (c!=0) ? true : false; //0���� �ƴϸ��� �ƴϸ� true //���̵� ������ ���� ������ �����ϴ�.
			}
		}; 
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		//���̺� - ������
		for(PersonDTO dto : list) {
			Vector<String> v = new Vector<String>(); //ArrayList�� �ٷ� ���̺� ���� �� �����Ƿ� vector �� ���� ������ �� ���̺� ���� �־��ش�.
			v.add(dto.getId());
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getTel());
			
			model.addRow(v);//������� ���̰ڴ�.
		}//for
				
		//��ư����
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		insertBtn = new JButton("�߰�");
		deleteBtn = new JButton("����");
		
		
		p.add(insertBtn);
		p.add(deleteBtn);
				
		Container c = this.getContentPane();
		c.add("Center", scroll);
		c.add("South", p);
		
		setBounds(200,200,500,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//�̺�Ʈ
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
		//���� �� : ����ڰ� �Է��� ���ڿ�, ��� ��ư�� ���õǰų� â�� ������ null ����
		String id = JOptionPane.showInputDialog(this, "���̵� �Է��ϼ���");// ���̾�α׸� ���Ŵ�.( �����ġ , �޼���)
		if(id == null) {//�߰� - ��� �� �ϰ� �Ǹ� �ƹ��͵� �޼����� �������� �ʰ� �ݱ�.
			return; //�޼ҵ带 �����
		}
		
		if(id.length()==0) {
				JOptionPane.showInternalMessageDialog(this, "���̵�� �ʼ� �׸��Դϴ�.");
		}
		for(int i = 0 ; i < model.getRowCount() ; i++) {
			if(id.equals(model.getValueAt(i, 0))) {
				JOptionPane.showMessageDialog(this, "������� ���̵� �Դϴ�..");
				return;
			}
		}
		
		//������� ���̵� �Դϴ�.
		
		String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���"); 
		String pwd =  JOptionPane.showInputDialog(this, "��й�ȣ�� �Է��ϼ���");
		String tel = JOptionPane.showInputDialog(this, "��ȭ��ȣ�� �Է��ϼ���");
		
		Vector<String> v = new Vector<String>();
		v.add(id);
		v.add(name);
		v.add(pwd);
		v.add(tel);
		
		model.addRow(v);
		JOptionPane.showMessageDialog(this, "�߰� �Ϸ�");
		System.out.println(model.getRowCount());
	}

	private void delete() {
		String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���"); 
		int sw = 0; // sw - switch
		
		if(name == null || name.equals("")) {
			return;
		}
		
		for(int i = 0 ; i < model.getRowCount() ; i++) {
			if(name.equals(model.getValueAt(i, 1))){
				model.removeRow(i);
				i --; // i = -1 �� �������.
				sw ++;
			}//if
			
		}//for
		
		if(sw == 0) {
			JOptionPane.showMessageDialog(this, "�˻��� �̸��� �����ϴ�.");
		}
		
		
		//���������� �����Ϸ�!
		//���� �̸��̸� ���� �̸��Դϴ�. (���� ���� �̸��� �ִٸ� ���δ�����)
	}
	
	public static void main(String[] args) {
		new JTableEx2();
	}
}
