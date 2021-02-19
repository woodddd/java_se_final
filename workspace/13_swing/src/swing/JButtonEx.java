package swing;

import java.awt.Container;
import java.awt.GridLayout;


//Swing 패키지의 특징
//플랫폼과 상관없이 같은 모양의 창을 보여줄 수 있다.
//AWT보다는 많은 도구를 제공한다.
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class JButtonEx extends JFrame{ //JFrame 은 Freame 을 상속하고 있기 때문에 Frame 의 기능을 모두 사용할 수 있다. 
										
	//부모 = 자식
	//public class ImageIcon implements Icon
	//
	private Icon icon1 = new ImageIcon("image/피카츄.jpg");
	private Icon icon2 = new ImageIcon("image/라이츄.jpg");
	private Icon icon3 = new ImageIcon("image/병아리.gif");
	private Icon icon4 = new ImageIcon("image/어니부기.jpg");
	
	private JRadioButton[] jb = new JRadioButton[4];
	private ButtonGroup bg = new ButtonGroup();
	
	public JButtonEx() {
		super("Test");
		
		//컨테이너 : 다른 객체(구성요소)들을 포함할 수 있는 객체 자기 자신도 다른 컨테이너에 포함될 수 있다.
		Container con = this.getContentPane();
		con.setLayout(new GridLayout(2,2));
		for(int i = 0; i < 4 ; i++) {
			jb[i] = new JRadioButton(i + 1 + "번 버튼", icon1);
			con.add(jb[i]);
			jb[i].setToolTipText(i + 1 + "번째 버튼이다. 눌러...");
			jb[i].setMnemonic(i+ 49);//Alt + 숫자 1,2,3,4 (문자)
			jb[i].setRolloverIcon(icon2);//icon에 마우스를 올려놓을 때
			jb[i].setPressedIcon(icon3);//icon을 누를 때
			jb[i].setSelectedIcon(icon4);//icon 을 클릭 할 떄, radio버튼으로설정했으므로 한가지만 선택이 됨.
			bg.add(jb[i]);
		}
		pack();
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		
		new JButtonEx();
		
		
	}

}
