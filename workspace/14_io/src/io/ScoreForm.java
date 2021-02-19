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
		
		//라벨 생성
		hakL = new JLabel("학번");
		nameL = new JLabel("이름");
		korL = new JLabel("국어");
		engL = new JLabel("영어");
		mathL = new JLabel("수학");
		
		//텍스트필드 생성
		hakT = new JTextField(20);
		nameT = new JTextField(20);
		korT = new JTextField(20);
		engT = new JTextField(20);
		mathT = new JTextField(20);
		
		//버튼 생성
		inputB = new JButton("입력");
		printB = new JButton("출력");
		searchB = new JButton("학번검색");
		rankB = new JButton("순위");
		saveB = new JButton("파일저장");
		loadB = new JButton("파일읽기");
		
		vector = new Vector<String>();
		vector.add("학번");
		vector.add("이름");
		vector.add("국어");
		vector.add("영어");
		vector.add("수학");
		vector.add("총점");
		vector.add("평균");
		
		//테이블 속성값 생성
		model = new DefaultTableModel(vector, 0);
		
		//테이블 생성
		table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		
		score = new ScoreImpl();
		
		//패널 생성 - 패널은 기본적으로 가운데를 중심으로 add 된 요소들이 추가된다.
		
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
		
		//왼쪽 패널 생성
		JPanel inputP = new JPanel(new GridLayout(5,1)); // 행/열/여백/여백
		inputP.add(p1);
		inputP.add(p2);
		inputP.add(p3);
		inputP.add(p4);
		inputP.add(p5);
		
		//버튼패널 생성
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

	
	
	//이벤트
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
			//총점, 평균 계산 및 ScoreDTO에 저장
			ScoreDTO dto = new ScoreDTO();
			
			dto.setHak(hakT.getText());
			dto.setName(nameT.getText());
			dto.setKor(Integer.parseInt(korT.getText().trim()));
			dto.setEng(Integer.parseInt(engT.getText().trim()));
			dto.setMath(Integer.parseInt(mathT.getText().trim()));
			
			dto.calc(); // calc 에서 평균,합 데이터 저장.
			
			//데이터 
			score.input(dto);
			
			JOptionPane.showMessageDialog(this, "등록완료");
			//초기화
			hakT.setText("");
			nameT.setText("");
			korT.setText("");
			engT.setText("");
			mathT.setText("");
			
		}else if(e.getSource() == printB) {
			score.print(model); //list의 항목을 모두 꺼내서 JTable에 뿌리기
			//모델에 값을 넣어줘야 테이블에 값이 생성이 되기 때문에 모델의 값을 넘겨주어야함.
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
