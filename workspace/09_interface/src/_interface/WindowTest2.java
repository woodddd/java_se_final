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

//Frame�� BorderLayout(��������)	
public class WindowTest2 extends Frame implements ActionListener, MouseListener, WindowListener{
	private Button redBtn, greenBtn, blueBtn, exitBtn;
	private int x, y;
	
	public static void main(String[] args) {
		new WindowTest2().init();
		

	}
	

	public void init() {
		redBtn = new Button("����");
		greenBtn = new Button("�ʷ�");
		blueBtn = new Button("�Ķ�");
		exitBtn = new Button("����");
		
		Panel p = new Panel(); // �г��� ��ݿ� �������� �÷����Ҵٰ� �����ϸ� ��.
		//Panel�� FlowLayout(������ġ) �̰�, ������ �߽����� ������� ��ġ��.
		
		p.setBackground(new Color(255,195,255));//color(R,G,B)0~255
		p.add(redBtn);
		p.add(greenBtn);
		p.add(blueBtn);
		p.add(exitBtn);
		
		
		this.add("North",p);//��(Frame)�� �߰��ض�. ���ʿ� redBtn��
//		this.add("South",greenBtn);
//		this.add("Center",blueBtn);

		setBounds(900,100,300,400);//Windowâ ��ǥ(x,y,����,����)
		setVisible(true);//���� �� paint �޼ҵ�� �Ѿ�Ե�.
		
		//�Ʒ� �����ǵ� �߻�޼ҵ带 ����ϱ� ���Ͽ�
		//����?(���� ������â��(Frame��)).���?(addWindowListener�� �޼ҵ忡��).��ġ���? (�޼ҵ� ��ġ(������ ��ġ))
		this.addWindowListener(this);
		
		redBtn.addActionListener(this);
		greenBtn.addActionListener(this);
		blueBtn.addActionListener(this);
		exitBtn.addActionListener(this);
	
		this.addMouseListener(this);
	}
	
	

	//ActionListener�߻�޼ҵ� �������̵�
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//if(e.getActionCommand() == "����") {//������ ��ü�� ã�ƿ�. �Ʒ��� ������ ���
		if(e.getSource()==redBtn) {
			this.setBackground(new Color(255,0,0));
		}else if(e.getSource()==greenBtn) {
			this.setBackground(new Color(0,255,0));
		}else if(e.getSource()==blueBtn) {
			this.setBackground(new Color(0,0,255));
		}else if(e.getSource()==exitBtn) {
			System.out.println("���α׷� ����");
			System.exit(0);
		}
		
	}
	
	public void paint(Graphics g) {//setVisible(true)�� ����� ��, �� �ѹ��� �����.
		
		g.drawString("X : " + x + "\t Y " + y,x,y);//MouseListener ���߻�޼ҵ��� mouseClicked ���� �ʵ忡 ���� �����ϰ� Ŭ������ �ʵ尪 �� �޾ƿ�.
		//			("���ڿ�",x��ǥ,y��ǥ) Windowȭ���� �ش� ��ġ�� ���ڿ��� ����Ѵ�.
	}
	
	@Override //MouseListener �߻�޼ҵ� �������̵�
	public void mouseClicked(MouseEvent e) {
		System.out.println("���콺 Ŭ��");
		
		this.x = e.getX();
		y = e.getY();
		System.out.println("X : " + e.getX() + "\t Y " + e.getY());
		
		repaint(); // paiunt �޼ҵ尡 �ڹٰ���ӽ�(JVM)�� ���ؼ� �ٽ� ȣ���
		//repaint �� ������ �����ִ� ȭ���� ���� ������ �ϹǷ� ���� ȭ���� ������ ���Ӱ� ȭ���� ȣ���ϰԵ�. �׷��� �ʹ� ���� ����ϸ� �ý����� �����ϰ� �Ͼ�Ե�.
	}
	
	//WindowListener �߻�޼ҵ� �������̵�
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);//���α׷� ��������
		
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


	//MouseListener �߻�޼ҵ� �������̵�
	

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
