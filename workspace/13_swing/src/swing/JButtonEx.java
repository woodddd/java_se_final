package swing;

import java.awt.Container;
import java.awt.GridLayout;


//Swing ��Ű���� Ư¡
//�÷����� ������� ���� ����� â�� ������ �� �ִ�.
//AWT���ٴ� ���� ������ �����Ѵ�.
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class JButtonEx extends JFrame{ //JFrame �� Freame �� ����ϰ� �ֱ� ������ Frame �� ����� ��� ����� �� �ִ�. 
										
	//�θ� = �ڽ�
	//public class ImageIcon implements Icon
	//
	private Icon icon1 = new ImageIcon("image/��ī��.jpg");
	private Icon icon2 = new ImageIcon("image/������.jpg");
	private Icon icon3 = new ImageIcon("image/���Ƹ�.gif");
	private Icon icon4 = new ImageIcon("image/��Ϻα�.jpg");
	
	private JRadioButton[] jb = new JRadioButton[4];
	private ButtonGroup bg = new ButtonGroup();
	
	public JButtonEx() {
		super("Test");
		
		//�����̳� : �ٸ� ��ü(�������)���� ������ �� �ִ� ��ü �ڱ� �ڽŵ� �ٸ� �����̳ʿ� ���Ե� �� �ִ�.
		Container con = this.getContentPane();
		con.setLayout(new GridLayout(2,2));
		for(int i = 0; i < 4 ; i++) {
			jb[i] = new JRadioButton(i + 1 + "�� ��ư", icon1);
			con.add(jb[i]);
			jb[i].setToolTipText(i + 1 + "��° ��ư�̴�. ����...");
			jb[i].setMnemonic(i+ 49);//Alt + ���� 1,2,3,4 (����)
			jb[i].setRolloverIcon(icon2);//icon�� ���콺�� �÷����� ��
			jb[i].setPressedIcon(icon3);//icon�� ���� ��
			jb[i].setSelectedIcon(icon4);//icon �� Ŭ�� �� ��, radio��ư���μ��������Ƿ� �Ѱ����� ������ ��.
			bg.add(jb[i]);
		}
		pack();
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		
		new JButtonEx();
		
		
	}

}
