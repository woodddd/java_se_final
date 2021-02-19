package _interface;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//Frame은 BorderLayout(동서남북)	
public class WindowTest2 extends Frame implements ActionListener, MouseListener, WindowListener{
	private Button redBtn, greenBtn, blueBtn, exitBtn;
	private int x, y;
	
	public static void main(String[] args) {
		new WindowTest2().init();
		

	}
	

	public void init() {
		redBtn = new Button("빨강");
		greenBtn = new Button("초록");
		blueBtn = new Button("파랑");
		exitBtn = new Button("종료");
		
		Panel p = new Panel(); // 패널은 쟁반에 종이컵을 올려놓았다고 생각하면 됨.
		//Panel은 FlowLayout(순서배치) 이고, 가로측 중심으로 순서대로 배치함.
		
		p.setBackground(new Color(255,195,255));//color(R,G,B)0~255
		p.add(redBtn);
		p.add(greenBtn);
		p.add(blueBtn);
		p.add(exitBtn);
		
		
		this.add("North",p);//나(Frame)에 추가해라. 북쪽에 redBtn을
//		this.add("South",greenBtn);
//		this.add("Center",blueBtn);

		setBounds(900,100,300,400);//Window창 좌표(x,y,길이,높이)
		setVisible(true);//실행 시 paint 메소드로 넘어가게됨.
		
		//아래 재정의된 추상메소드를 사용하기 위하여
		//누가?(현재 윈도우창이(Frame이)).어디서?(addWindowListener의 메소드에서).위치어디? (메소드 위치(구현부 위치))
		this.addWindowListener(this);
		
		redBtn.addActionListener(this);
		greenBtn.addActionListener(this);
		blueBtn.addActionListener(this);
		exitBtn.addActionListener(this);
	
		this.addMouseListener(this);
	}
	
	

	//ActionListener추상메소드 오버라이딩
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//if(e.getActionCommand() == "빨강") {//값으로 객체를 찾아옴. 아래와 동일한 결과
		if(e.getSource()==redBtn) {
			this.setBackground(new Color(255,0,0));
		}else if(e.getSource()==greenBtn) {
			this.setBackground(new Color(0,255,0));
		}else if(e.getSource()==blueBtn) {
			this.setBackground(new Color(0,0,255));
		}else if(e.getSource()==exitBtn) {
			System.out.println("프로그램 종료");
			System.exit(0);
		}
		
	}
	
	public void paint(Graphics g) {//setVisible(true)가 실행될 때, 딱 한번만 실행됨.
		
		g.drawString("X : " + x + "\t Y " + y,x,y);//MouseListener 의추상메소드인 mouseClicked 에서 필드에 값을 저장하고 클래스의 필드값 을 받아옴.
		//			("문자열",x좌표,y좌표) Window화면의 해당 위치해 문자열을 출력한다.
	}
	
	@Override //MouseListener 추상메소드 오버라이딩
	public void mouseClicked(MouseEvent e) {
		System.out.println("마우스 클릭");
		
		this.x = e.getX();
		y = e.getY();
		System.out.println("X : " + e.getX() + "\t Y " + e.getY());
		
		repaint(); // paiunt 메소드가 자바가상머신(JVM)에 의해서 다시 호출됨
		//repaint 는 이전에 찍혀있던 화면의 값을 지워야 하므로 이전 화면을 버리고 새롭게 화면을 호출하게됨. 그래서 너무 많이 사용하면 시스템의 과부하가 일어나게됨.
	}
	
	//WindowListener 추상메소드 오버라이딩
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);//프로그램 강제종료
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}


	//MouseListener 추상메소드 오버라이딩
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	
	

}
