package exception;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

//�� 1���� 
//RunRaceŬ�������� �����.
public class Racer extends Canvas implements Runnable{
	private Image img;
	private String name;
	private int pos;
	private static int rank;

	public Racer(String name) {
		
		this.name = name;
		img = Toolkit.getDefaultToolkit().getImage("horse.gif");
		//setBackground(new Color((int)(Math.random()*255 + 1),(int)(Math.random()*255 + 1),(int)(Math.random()*255 + 1)));
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawLine(0, this.getSize().height/2, getSize().width, this.getSize().height/2);//canvas�������� ���ݿ� ������ �׷���.
		//g.drawLine(arg0, arg1, arg2, arg3);
		g.drawImage(img, pos, 0, 25,this.getSize().height,  this);
		//                        Canvas ��ü�� ����� �����ͼ� ���̸� �����Ͷ�.
		//�̹���,���� �̵���,x�� ��ǥ 0,x�� ��ǥ 25, ���̴� ������ ������, ǥ���� ������ Frame
	}

	
	//Rubbable �߻�޼ҵ�
	@Override
	public void run() {				// i�� 1~10������ ������ ���� �����־� ���� ������ �ӵ��� ���� �ʰ� ������ذ�.
		for(int i = 0; i < 600 ; i += ((int)(Math.random() * 10 + 1))) {
			
			pos = i;
			repaint();
			
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}//for
		rank++;
		System.out.println(rank + " �� : " + name);
	}//run
	
	
}
