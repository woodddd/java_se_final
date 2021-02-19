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
������ ��ư�� ��� ������ ���ڰ� ��� �ö󰡰�
��ư���� ���� ���� ���ڰ� �����ȴ�.
�ٽ� ��ư�� ������ ���ڰ� �̾ ��� �ö󰣴�.
 */

public class ThreadOnOff extends Frame implements Runnable{// �����带 ����ϱ� ���ؼ� extends Thread�� ������ָ������ �̹� ����ϰ� �ִ� Ŭ������ �ִٸ� implements runnable �� ������ָ��.
	private Button pushBtn;
	private Label label;
	private Thread t;
	private boolean aa = true;
	private int ii;

	public ThreadOnOff() {
		label = new Label("0",Label.CENTER);
		label.setFont(new Font("���ü", Font.BOLD , 50));
		label.setForeground(Color.RED);
		pushBtn = new Button("������");
		
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
		
		pushBtn.addMouseListener(new MouseAdapter() { //�͸��� Runnable�� �Ȱ����� �ֱ� ������ Thread�� ���� �� ����.
			Thread t;
			@Override
			public void mousePressed(MouseEvent e) {
				t = new Thread(ThreadOnOff.this); //�׳� this �� ����ϸ� �͸�ü�� ���ϴ� ���̱� ������ ��øŬ������ ��ü�� ������ Ŭ������.��ü �� ������Ѵ�.
				//������� ���� ���������� , ������ ��ü�� �����ϱ� ������ �ʵ� ii�� static �� �ƴϴ���, ���� ������ �� �ִ°���.
				System.out.println("������ t = " + t);
				t.start();
				
				aa = true;
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				t = null;
				System.out.println("�ն��� t = " + t);
				aa = false;
			}
		});
		
		
	}//������

	@Override
	public void run() {
			//int i =ii;
			while(true) {
				//i++;
				ii++;
				label.setText(ii+""); //ii �� int �������� +""(���ڿ�) �� ���ָ� ���ڿ� + int ������ �ǹǷ� String Ÿ���� �ȴ�.
				
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
