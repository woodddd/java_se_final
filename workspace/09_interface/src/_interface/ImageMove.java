package _interface;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class ImageMove extends Frame implements ActionListener,KeyListener,MouseListener,WindowListener {
	//Ŭ������ ��� �޼ҵ忡�� ����ϱ� ���Ͽ� �ʵ�� ���� ���� 
	private Button initBtn, leftBtn, upBtn, downBtn, rightBtn;
	private int x = 100, y = 100;
	private Image img = Toolkit.getDefaultToolkit().getImage("������.jpg");
	
	public static void main(String[] args) {
		new ImageMove().init();
	}
	
	public void init() {
		
		
		//��ư����
		initBtn = new Button("�ʱ�ȭ");
		leftBtn = new Button("����");
		upBtn = new Button("����");
		downBtn = new Button("�Ʒ�");
		rightBtn = new Button("������");
		
		initBtn.setFocusable(false);
		leftBtn.setFocusable(false);
		upBtn.setFocusable(false);
		downBtn.setFocusable(false);
		rightBtn.setFocusable(false);

		setBounds(100,100,500,500);
		setResizable(false);
		setVisible(true);
		
		Panel p = new Panel();
		
		p.setBackground(new Color(33,160,30));
		
		p.add(initBtn);
		p.add(leftBtn);
		p.add(upBtn);
		p.add(downBtn);
		p.add(rightBtn);
		
		this.add("North", p);
		
		
		//��Ŀ���� ������� �ʰڴ�.
		//���� �Ʒ��� ������ ������� ���� �� �ʱⰪ���� ��ư�� ���� �׵θ��� �ѷ��׿� ��Ŀ���� �Ǿ� �ִ�.
		//��Ŀ���� �Ǿ����� ��� keyListener�� Ű���� �Է� ���� ��Ŀ���� ���� �������� ���� �Ǿ�
		//KeyListener�� ������ ���� �ʴ´�. �׷��� ��Ŀ���� ������ �� ����ؾ��Ѵ�.
		
		//�̺�Ʈ
		this.addWindowListener(this); 
		
		initBtn.addActionListener(this);
		leftBtn.addActionListener(this);
		upBtn.addActionListener(this);
		downBtn.addActionListener(this);
		rightBtn.addActionListener(this);
		
		this.addKeyListener(this);
		
	}
	
	
	
	//paint�� ImageMove�� �θ�Ŭ������ Frame -> �� �θ�Ŭ������ Window Ŭ������ ������. �������̵��� �� ����.
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, x, y, this); //�ʱⰪ �̹��� ��ġ (�������ϸ�, x��ǥ, y��ǥ, �̹���ǥ����ġ(���� Frame��ü�̹Ƿ� this))
	}
	
	//actionListener �߻�޼ҵ� �������̵�
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == initBtn) {
			x = 100;
			y = 100;
		}else if(e.getSource() == leftBtn) {
			x -= 10;
		}else if(e.getSource() == upBtn) {
			y -= 10;
		}else if(e.getSource() == downBtn) {
			y += 10;
		}else if(e.getSource() == rightBtn) {
			x += 10;
		}
		if(x < -100) {
			x  += 600;
		}else if(x > 500) {
			x -= 600;
		}
		
		if(y < -100) {
			y  += 600;
		}else if(y > 500) {
			y -= 600;
		}
		repaint();
		
	}
	
	
	//WindowListener �߻�޼ҵ� �������̵�
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
		
		
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
	public void mouseClicked(MouseEvent e) {
		
		}
		
	

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

	
	//KeyListener �߻�޼ҵ� �������̵�
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){//VK - Virtual Key
			System.exit(0);
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			x -= 10;
		}else if(e.getKeyCode() == KeyEvent.VK_UP) {
			y -= 10;
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			y += 10;
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			x += 10;
		}
		if(x < -100) {
			x  += 600;
		}else if(x > 500) {
			x -= 600;
		}
		
		if(y < -100) {
			y  += 600;
		}else if(y > 500) {
			y -= 600;
		}
		repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}