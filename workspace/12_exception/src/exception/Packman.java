package exception;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Packman extends Frame implements KeyListener, Runnable{
	private Image img = Toolkit.getDefaultToolkit().getImage("pacman.png");
	private Image food = Toolkit.getDefaultToolkit().getImage("been.jpg");

	//private Image img1 = Toolkit.getDefaultToolkit().getImage("horse.gif");
	
	
	//�Ѹ��� �� ��� ��ǥ 25, 25;
	//�Ѹ��� ���̸� �������� ��ǥ�� ���� ���� �ƴ�, ���� ���� ��ǥ���� ���Ͽ� �԰� �������
	
	private int x1 = 225,y1 = 225;
	private int sel = 2;
	private int[] foodx, foody;
	
	public Packman() {
		setBounds(700,200,500,500);
		setVisible(true);
		//setResizable(false);
		
		//���� �߻�
		foodx = new int[5];
		foody = new int[5];
		
		for(int i = 0 ; i < foodx.length ; i++) {
			foodx[i] = (int) (Math.random() * 301) + 100 ; // ���̴� 100~400 ���� ��Ƴ��� ���� ȭ���� ��������.
			foody[i] = (int) (Math.random() * 301) + 100 ;
			System.out.println(foodx[i] + " " + foody[i]);
		}
		
		
		
		//�̺�Ʈ
		addKeyListener(this);
		//������ ����
		Thread t = new Thread(this);// ���� ������� ������ּ���.
		//������ ����
		t.start();
		
		
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(img, x1, y1, x1+50, y1 +50, sel*50, 0, sel*50 +50, 50, this);//observer �� ���� �׸��� �׸� ��ġ
		//dx1, dy1 destination ��ǥ ���� ��ġ(��ǥ).
		//dx2, dy2 destination ��ǥ ���� ��ġ(��ǥ).
		//sx1, sy1 source ������ �̹����� ���� ��ġ(��ǥ).
		//sx2, sx2 source ������ �̹����� ���� ��ġ(��ǥ).
		//this -> �̹����� �׸� ��ġ
//		for(int i = 0; i < 5 ; i++) {
//		System.out.println(foodx[i] + " " + foody[i]);
//		}
		for(int i = 0; i < 5 ; i++) { //���� �̹��� Frame �� ȣ��
			g.drawImage(food,foodx[i],foody[i],this);
		}
		
	}
	

	//�������̽� Runnable �߻�޼ҵ� �������̵�
	@Override
	public void run() {
		while(true) {
			if(sel % 2 == 0) {
				sel += 1;
			}else {
				sel -= 1;
			}
			
			if(sel == 0) {//��
				if(x1 > 0) {
					x1 -= 20;
				}else if( x1 <= 0){
					x1 = 500;
				}
				
			}else if(sel ==2) {//��
				if( x1 > 500) {
					x1 = 0;
				}else if( x1 <= 500) {
					x1 += 20;
				}
			}else if(sel == 4) {//��
				if( y1 > 0) {
					y1 -= 20;
				}else if( y1 <= 0) {
					y1 = 500;
				}
				
			}else if(sel == 6) {//�Ʒ�
				if( y1 > 500) {
					y1 = 0;
				}else if(y1 <= 500) {
					y1 += 20;
				}
				
			}
			
			for(int i = 0; i < 5 ; i++) {
				if(x1 +25 <= foodx[i] +25 && x1 +25 >= foodx[i]-5 &&
						y1 +25 <= foody[i] +25 && y1 +25 >= foody[i] -5) {
					foodx[i] = -100;
					foody[i] = -100;
				}//x1 +25 , y1 + 25 �� �� ������ �Ѹ��� ������ ���� ������ �ƴ� ������ 25,25 ��ǥ�� ����ϱ� ���ؼ�
			}
			
			repaint();
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace(); //������ �߻��� ��� �ֿܼ� ������ �������.
			}
		}//while
		
	}
	
	public static void main(String[] args) {
		new Packman();
	}

	
	//�������̽� KeyListener �߻�޼ҵ� �������̵�
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(0);
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			sel = 0;
			
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			sel = 2;
			
		}else if(e.getKeyCode() == KeyEvent.VK_UP) {
			sel = 4;
			
		}else if(e.getKeyCode() == KeyEvent.VK_DOWN) { 
			sel = 6;
			
			
		}else if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			System.exit(0); //�����ư ������ �����Ƽ�
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


}
