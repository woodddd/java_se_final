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

public class SwingTest extends JFrame implements ActionListener{ //JFrame �� Frame �� ����ϰ� �־� Frame �� ��� ����� ������ �ִ�.
	private JButton newBtn, exitBtn;
	private JTextArea area;	
	
	//Area�� ������ �ڵ����� ��ũ���� �������� ����.
	public SwingTest() {
		//newBtn = new JButton("���θ����");
		newBtn = new JButton("������",new ImageIcon("image/���Ƹ�.gif"));
		exitBtn = new JButton("����");
		area = new JTextArea();
		JScrollPane scroll = new JScrollPane(area);//JTextArea�� scroll �� �÷� �ؽ�Ʈ�� ���̰� ������� ��ũ���� �߻��ǵ��� �� ��.
				
		JPanel p = new JPanel();
		p.add(newBtn);
		p.add(exitBtn);
		
		Container c = this.getContentPane();//this - JFrame ���� ���� Content�������� Container�� ��ü��  �÷��ִ°�.
		//c�� ������� �ʾƵ� ������ ����� �ٸ��� ������, ���� �� �������� ������ ��.
		c.add("North", p);//�г��� JFrame ���� ���ʿ� �ø���.
		c.add("Center", scroll);
		
		setBounds(700,100,300,400);
		setVisible(true);
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);//EXIT_ON_CLOSE �� �̿��ϸ� ������â�� x �� ������ �� ������â�� ���� �ʰ� �ٷ� �����.
		//WIndowListener�� windowClosing �޼ҵ带 �̿����� �����Ƿ� showConfirmDialog �� NO �� ������ â�� �����Ե�. 
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//�ƹ��͵� ���� ���� ��ϵ� WindowListener ��ü�� windowClosing �޼��忡�� �۾��� ó���ϵ��� ���α׷��� ��û
		newBtn.addActionListener(this);
		exitBtn.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				int result = JOptionPane.showConfirmDialog(SwingTest.this, "������ �����Ͻðڽ��ϱ�?", "������â ����" , JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
			int result = JOptionPane.showConfirmDialog(this, "������ �����Ͻðڽ��ϱ�", "����", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			//showConfirmDialog �� Yes/No �� ���� int�� ������ ���� ��ȯ��.
			
			//if(result == JOptionPane.YES_OPTION) { YES_OPTION �� ���α׷� ������ ���� int 0�� ����Ǿ� �־� ��ȯ���� 0��
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
