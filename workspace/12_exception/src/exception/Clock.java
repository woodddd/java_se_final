package exception;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock extends Frame implements Runnable{// Frame 위에는 Dialog 가 띄워질 수 있음. 하지만 Frame 위에는 새로운 Frame 을 띄울 수 없음. 병렬로 형성됨.
	
	public Clock() {
		this.setFont(new Font("고딕체", Font.ITALIC,24)); //PLAIN 기본 글씨체 BOLD 는 실제로 들어가보면 1 의 값이 있다. 이것은 상수 이기 때문에 바꿀 수 없다.
		setBounds(700,200,300,100);
		setVisible(true);
		setForeground(Color.red);
		
		
		this.addWindowListener(new WindowAdapter(){ //추상클래서 new 안됨 - 중첩 Inner클래스를 이용
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		Thread t = new Thread(this); //스레드 생성. 나를 스레드로 만들어달라.
		//스레드 시작 - 스레드 실행(run())
		t.start();//start() 로 인하여 run() 실행
		
	}
	
	//인터페이스Runnable 오버라이딩 
	@Override
	public void run() {
		while(true) {
			repaint();
			try {
				Thread.sleep(1000);	// 기본이 1/1000 밀리세컨드 초
			} catch(InterruptedException e){
				e.printStackTrace(); //에러가 발생할 경우 콘솔에 에러를 보여줘라. 
				//trace - 추적
			}
			
		}//while
	}
	
	public void paint(Graphics g) {//paint 메소드는 Frame 을 상속해야 사용할 수 있음.
//		SimpleDateFormat sd = new SimpleDateFormat("HH시 mm분 ss초");
//		Calendar cal = Calendar.getInstance();
//		g.drawString(sd.format(cal.getTime()), 100, 50);
		
		SimpleDateFormat sd = new SimpleDateFormat("HH시 mm분 ss초");
			Date d = new Date();
			g.drawString(sd.format(d), 70, 65);
		
	}

	public static void main(String[] args) {

		new Clock();
		
	}
	

}
