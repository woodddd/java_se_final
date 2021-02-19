package nested;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginResult extends Frame {
	
	private String id,pwd;
	private Frame frame;
	
	public LoginResult(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
		
		
		
		this.setBounds(900,100,200,200);
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);//윈도우 창을 실행하는 명령어는 setVisible(true) 이지만 setVisible(false)를 실행하면 현재 윈도우 창이 닫히게됨.
			}
		});
		
		
	}//LoginResult()
	
	public void paint(Graphics g) {
		if(id.equals("angel") && pwd.equals("1004")) {
					g.drawString("로그인 성공", 100, 100);
		}else {
					g.drawString("로그인 실패", 100, 100);
					
		}
	}//paint()
	

}
