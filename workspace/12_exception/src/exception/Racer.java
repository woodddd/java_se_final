package exception;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

//말 1마리 
//RunRace클래스에서 사용함.
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
		g.drawLine(0, this.getSize().height/2, getSize().width, this.getSize().height/2);//canvas사이즈의 절반에 라인을 그려라.
		//g.drawLine(arg0, arg1, arg2, arg3);
		g.drawImage(img, pos, 0, 25,this.getSize().height,  this);
		//                        Canvas 객체의 사이즈를 가져와서 높이를 가져와라.
		//이미지,말의 이동량,x축 좌표 0,x축 좌표 25, 높이는 컨버스 사이즈, 표현할 공간은 Frame
	}

	
	//Rubbable 추상메소드
	@Override
	public void run() {				// i에 1~10까지의 무작위 수를 더해주어 말이 일정한 속도로 가지 않게 만들어준것.
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
		System.out.println(rank + " 등 : " + name);
	}//run
	
	
}
