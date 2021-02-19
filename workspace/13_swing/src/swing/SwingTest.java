package swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SwingTest extends JFrame implements ActionListener{ //JFrame 은 Frame 을 상속하고 있어 Frame 의 모든 기능을 가지고 있다.
	private JButton newBtn, exitBtn;
	private JTextArea area;	
	
	//Area를 잡으면 자동으로 스크롤이 생성되지 않음.
	public SwingTest() {
		//newBtn = new JButton("새로만들기");
		newBtn = new JButton("새파일",new ImageIcon("image/병아리.gif"));
		exitBtn = new JButton("종료");
		area = new JTextArea();
		JScrollPane scroll = new JScrollPane(area);//JTextArea를 scroll 에 올려 텍스트의 길이가 길어지면 스크롤이 발생되도록 한 것.
				
		JPanel p = new JPanel();
		p.add(newBtn);
		p.add(exitBtn);
		
		Container c = this.getContentPane();//this - JFrame 으로 부터 Content영역을얻어서 Container의 객체에  올려주는것.
		//c를 사용하지 않아도 이전과 결과는 다르지 않으나, 조금 더 안정적인 역할을 함.
		c.add("North", p);//패널은 JFrame 위의 북쪽에 올린다.
		c.add("Center", scroll);
		
		setBounds(700,100,300,400);
		setVisible(true);
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);//EXIT_ON_CLOSE 를 이용하면 윈도우창의 x 를 눌렀을 때 윈도우창이 숨지 않고 바로 종료됨.
		//WIndowListener의 windowClosing 메소드를 이용하지 않으므로 showConfirmDialog 의 NO 를 눌러도 창이 닫히게됨. 
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//아무것도 하지 말고 등록된 WindowListener 객체의 windowClosing 메서드에서 작업을 처리하도록 프로그램을 요청
		newBtn.addActionListener(this);
		exitBtn.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(SwingTest.this, "정말로 종료하시겠습니까?", "윈도우창 종료" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
				System.exit(0);
			}else {
				
			}
				
			}
		});
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exitBtn) {
//			System.exit(0);
			int result = JOptionPane.showConfirmDialog(this, "정말로 종료하시겠습니까", "종료", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			//showConfirmDialog 는 Yes/No 에 따라서 int형 정수의 값을 반환함.
			
			//if(result == JOptionPane.YES_OPTION) { YES_OPTION 은 프로그램 내부적 으로 int 0이 저장되어 있어 반환값이 0임
			//	System.exit(0);
				
				if(result == JOptionPane.YES_OPTION) {
					System.exit(0);
				}else {
					
				}
		}else if(e.getSource() == newBtn) {
			area.setText("");
		}
		
	}
	
	
	public static void main(String[] args) {
		new SwingTest();
		
	}



}
