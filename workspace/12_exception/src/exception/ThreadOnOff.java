package exception;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
누르기 버튼을 계속 누르면 숫자가 계속 올라가고
버튼에서 손을 떼면 숫자가 정지된다.
다시 버튼을 누르면 숫자가 이어서 계속 올라간다.
 */

public class ThreadOnOff extends Frame implements Runnable{// 스레드를 사용하기 위해서 extends Thread를 사용해주면되지만 이미 상속하고 있는 클래스가 있다면 implements runnable 을 사용해주면됨.
	private Button pushBtn;
	private Label label;
	private Thread t;
	private boolean aa = true;
	private int ii;

	public ThreadOnOff() {
		label = new Label("0",Label.CENTER);
		label.setFont(new Font("고딕체", Font.BOLD , 50));
		label.setForeground(Color.RED);
		pushBtn = new Button("누르기");
		
		Panel p = new Panel(new FlowLayout(FlowLayout.RIGHT));
		p.add(pushBtn);
		
		add("Center", label);
		add("South",p);
		
		setBounds(700,200,300,300);
		setVisible(true);
		setResizable(false);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		pushBtn.addMouseListener(new MouseAdapter() { //익명은 Runnable을 안가지고 있기 때문에 Thread를 가질 수 없다.
			Thread t;
			@Override
			public void mousePressed(MouseEvent e) {
				t = new Thread(ThreadOnOff.this); //그냥 this 를 사용하면 익명객체를 말하는 것이기 때문에 중첩클래스의 객체를 쓰려면 클래스명.객체 로 해줘야한다.
				//스레드는 새로 생성되지만 , 동일한 객체를 참조하기 때문에 필드 ii가 static 이 아니더라도, 서로 공유될 수 있는것임.
				System.out.println("누르기 t = " + t);
				t.start();
				
				aa = true;
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				t = null;
				System.out.println("손떼기 t = " + t);
				aa = false;
			}
		});
		
		
	}//생성자

	@Override
	public void run() {
			//int i =ii;
			while(true) {
				//i++;
				ii++;
				label.setText(ii+""); //ii 는 int 형이지만 +""(문자열) 을 해주면 문자열 + int 형식이 되므로 String 타입이 된다.
				
				if(!aa) break;
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}//while
		
		
	}
	
	public static void main(String[] args) {
		new ThreadOnOff();
		
		
	}


}
