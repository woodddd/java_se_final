package nested;

import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowTest extends Frame {
	
	public static void main(String[] args) {
		new WindowTest();
		
	}
	
	public WindowTest() {
		setBounds(900,100,300,400);
		setVisible(true);
		
		//이벤트
		this.addWindowListener(new WindowAdapter() { //WindowAdapter는 추상클래스임. WindowListener 의 모든 추상메소드를 껍데기만 가지고 있음.
			//WindowAdapter 추상클래스 내부를 살펴보면,
			//public abstract class WindowAdapter
			//extends Object
			//implements WindowListener, WindowStateListener, WindowFocusListener
			
			//인터페이스 WindowListener 를 implements 하고 있음.
			//그러므로 추상클래스인 WindowAdapter는 WindowListener 의 모든 메소드를 오버라이딩 해 주어야함. 
			//하지만 WindowAdapter는 추상클래스이지만 오버라이딩 한 메소드를 추상으로 만들지 않았으므로 필요한 메소드만 불러와서 재정의 해주면 됨.
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
		}
		});
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("마우스 IN");
			}
			
			
			@Override
	         public void mouseExited(MouseEvent e) {
	            System.out.println("마우스 OUT");
	         }
		});
	}

	

}
