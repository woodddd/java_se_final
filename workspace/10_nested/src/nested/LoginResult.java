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
				setVisible(false);//������ â�� �����ϴ� ��ɾ�� setVisible(true) ������ setVisible(false)�� �����ϸ� ���� ������ â�� �����Ե�.
			}
		});
		
		
	}//LoginResult()
	
	public void paint(Graphics g) {
		if(id.equals("angel") && pwd.equals("1004")) {
					g.drawString("�α��� ����", 100, 100);
		}else {
					g.drawString("�α��� ����", 100, 100);
					
		}
	}//paint()
	

}
