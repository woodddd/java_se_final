package exception;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Clock extends Frame implements Runnable{// Frame ������ Dialog �� ����� �� ����. ������ Frame ������ ���ο� Frame �� ��� �� ����. ���ķ� ������.
	
	public Clock() {
		this.setFont(new Font("���ü", Font.ITALIC,24)); //PLAIN �⺻ �۾�ü BOLD �� ������ ������ 1 �� ���� �ִ�. �̰��� ��� �̱� ������ �ٲ� �� ����.
		setBounds(700,200,300,100);
		setVisible(true);
		setForeground(Color.red);
		
		
		this.addWindowListener(new WindowAdapter(){ //�߻�Ŭ���� new �ȵ� - ��ø InnerŬ������ �̿�
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		Thread t = new Thread(this); //������ ����. ���� ������� �����޶�.
		//������ ���� - ������ ����(run())
		t.start();//start() �� ���Ͽ� run() ����
		
	}
	
	//�������̽�Runnable �������̵� 
	@Override
	public void run() {
		while(true) {
			repaint();
			try {
				Thread.sleep(1000);	// �⺻�� 1/1000 �и������� ��
			} catch(InterruptedException e){
				e.printStackTrace(); //������ �߻��� ��� �ֿܼ� ������ �������. 
				//trace - ����
			}
			
		}//while
	}
	
	public void paint(Graphics g) {//paint �޼ҵ�� Frame �� ����ؾ� ����� �� ����.
//		SimpleDateFormat sd = new SimpleDateFormat("HH�� mm�� ss��");
//		Calendar cal = Calendar.getInstance();
//		g.drawString(sd.format(cal.getTime()), 100, 50);
		
		SimpleDateFormat sd = new SimpleDateFormat("HH�� mm�� ss��");
			Date d = new Date();
			g.drawString(sd.format(d), 70, 65);
		
	}

	public static void main(String[] args) {

		new Clock();
		
	}
	

}
