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
	
	
	//팩맨의 입 가운데 좌표 25, 25;
	//팩맨이 먹이를 먹으려면 좌표가 같은 것이 아닌, 실제 입의 좌표쯤을 비교하여 먹게 해줘야함
	
	private int x1 = 225,y1 = 225;
	private int sel = 2;
	private int[] foodx, foody;
	
	public Packman() {
		setBounds(700,200,500,500);
		setVisible(true);
		//setResizable(false);
		
		//난수 발생
		foodx = new int[5];
		foody = new int[5];
		
		for(int i = 0 ; i < foodx.length ; i++) {
			foodx[i] = (int) (Math.random() * 301) + 100 ; // 먹이는 100~400 까지 잡아놨음 위에 화면이 가려져서.
			foody[i] = (int) (Math.random() * 301) + 100 ;
			System.out.println(foodx[i] + " " + foody[i]);
		}
		
		
		
		//이벤트
		addKeyListener(this);
		//스레드 생성
		Thread t = new Thread(this);// 나를 스레드로 만들어주세요.
		//스레드 실행
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
		
		g.drawImage(img, x1, y1, x1+50, y1 +50, sel*50, 0, sel*50 +50, 50, this);//observer 는 현재 그림을 그릴 위치
		//dx1, dy1 destination 목표 시작 위치(좌표).
		//dx2, dy2 destination 목표 최종 위치(좌표).
		//sx1, sy1 source 가져올 이미지의 시작 위치(좌표).
		//sx2, sx2 source 가져올 이미지의 종료 위치(좌표).
		//this -> 이미지를 그릴 위치
//		for(int i = 0; i < 5 ; i++) {
//		System.out.println(foodx[i] + " " + foody[i]);
//		}
		for(int i = 0; i < 5 ; i++) { //먹이 이미지 Frame 에 호출
			g.drawImage(food,foodx[i],foody[i],this);
		}
		
	}
	

	//인터페이스 Runnable 추상메소드 오버라이딩
	@Override
	public void run() {
		while(true) {
			if(sel % 2 == 0) {
				sel += 1;
			}else {
				sel -= 1;
			}
			
			if(sel == 0) {//왼
				if(x1 > 0) {
					x1 -= 20;
				}else if( x1 <= 0){
					x1 = 500;
				}
				
			}else if(sel ==2) {//오
				if( x1 > 500) {
					x1 = 0;
				}else if( x1 <= 500) {
					x1 += 20;
				}
			}else if(sel == 4) {//위
				if( y1 > 0) {
					y1 -= 20;
				}else if( y1 <= 0) {
					y1 = 500;
				}
				
			}else if(sel == 6) {//아래
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
				}//x1 +25 , y1 + 25 를 한 이유는 팩맨의 초점을 좌측 위쪽이 아닌 입쪽인 25,25 좌표를 사용하기 위해서
			}
			
			repaint();
			try {
				Thread.sleep(100);
			}catch(InterruptedException e) {
				e.printStackTrace(); //에러가 발생할 경우 콘솔에 에러를 보여줘라.
			}
		}//while
		
	}
	
	public static void main(String[] args) {
		new Packman();
	}

	
	//인터페이스 KeyListener 추상메소드 오버라이딩
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
			System.exit(0); //종료버튼 누르기 귀찮아서
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
