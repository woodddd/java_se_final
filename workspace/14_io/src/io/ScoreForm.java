package io;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ScoreForm extends JFrame implements ActionListener{
	private JLabel hakL, nameL, korL, engL, mathL;
	private JTextField hakT, nameT, korT, engT, mathT;
	private JButton inputB, printB, searchB, rankB, saveB, loadB;
	private DefaultTableModel model;
	private JTable table;
	private Vector<String> vector;
	private Score score;
	
	public ScoreForm() {
		
		//�� ����
		hakL = new JLabel("�й�");
		nameL = new JLabel("�̸�");
		korL = new JLabel("����");
		engL = new JLabel("����");
		mathL = new JLabel("����");
		
		//�ؽ�Ʈ�ʵ� ����
		hakT = new JTextField(20);
		nameT = new JTextField(20);
		korT = new JTextField(20);
		engT = new JTextField(20);
		mathT = new JTextField(20);
		
		//��ư ����
		inputB = new JButton("�Է�");
		printB = new JButton("���");
		searchB = new JButton("�й��˻�");
		rankB = new JButton("����");
		saveB = new JButton("��������");
		loadB = new JButton("�����б�");
		
		vector = new Vector<String>();
		vector.add("�й�");
		vector.add("�̸�");
		vector.add("����");
		vector.add("����");
		vector.add("����");
		vector.add("����");
		vector.add("���");
		
		//���̺� �Ӽ��� ����
		model = new DefaultTableModel(vector, 0);
		
		//���̺� ����
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		score = new ScoreImpl();
		
		//�г� ���� - �г��� �⺻������ ����� �߽����� add �� ��ҵ��� �߰��ȴ�.
		
		JPanel p1 = new JPanel();
		p1.add(hakL);
		p1.add(hakT);
		
		JPanel p2 = new JPanel();
		p2.add(nameL);
		p2.add(nameT);
		
		JPanel p3 = new JPanel();
		p3.add(korL);
		p3.add(korT);
		
		JPanel p4 = new JPanel();
		p4.add(engL);
		p4.add(engT);
		
		JPanel p5 = new JPanel();
		p5.add(mathL);
		p5.add(mathT);
		
		//���� �г� ����
		JPanel inputP = new JPanel(new GridLayout(5,1)); // ��/��/����/����
		inputP.add(p1);
		inputP.add(p2);
		inputP.add(p3);
		inputP.add(p4);
		inputP.add(p5);
		
		//��ư�г� ����
		JPanel buttonP = new JPanel(new GridLayout(1,6));
		buttonP.add(inputB);
		buttonP.add(printB);
		buttonP.add(searchB);
		buttonP.add(rankB);
		buttonP.add(saveB);
		buttonP.add(loadB);
		
		
		
		
		JPanel p = new JPanel(new GridLayout(1,2));
		p.add(inputP);
		p.add(scroll);
		
		Container c = this.getContentPane();
		c.add("Center",p);
		c.add("South", buttonP);
		
		
		setBounds(700,200,600,400);
		setVisible(true);
		//setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	
	
	//�̺�Ʈ
	public void event() {
		inputB.addActionListener(this);
		printB.addActionListener(this);
		searchB.addActionListener(this);
		rankB.addActionListener(this);
		saveB.addActionListener(this);
		loadB.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == inputB) {
			//����, ��� ��� �� ScoreDTO�� ����
			ScoreDTO dto = new ScoreDTO();
			
			dto.setHak(hakT.getText());
			dto.setName(nameT.getText());
			dto.setKor(Integer.parseInt(korT.getText().trim()));
			dto.setEng(Integer.parseInt(engT.getText().trim()));
			dto.setMath(Integer.parseInt(mathT.getText().trim()));
			
			dto.calc(); // calc ���� ���,�� ������ ����.
			
			//������ 
			score.input(dto);
			
			JOptionPane.showMessageDialog(this, "��ϿϷ�");
			//�ʱ�ȭ
			hakT.setText("");
			nameT.setText("");
			korT.setText("");
			engT.setText("");
			mathT.setText("");
			
		}else if(e.getSource() == printB) {
			score.print(model); //list�� �׸��� ��� ������ JTable�� �Ѹ���
			//�𵨿� ���� �־���� ���̺� ���� ������ �Ǳ� ������ ���� ���� �Ѱ��־����.
		}else if(e.getSource() == searchB) {
			score.search(model);
		}else if(e.getSource() == rankB) {
			score.tot_desc();
			score.print(model);
		}else if(e.getSource() == saveB) {
			score.save();
		}else if (e.getSource() == loadB) {
			score.load();
			score.print(model);
		}
		
	}

}
