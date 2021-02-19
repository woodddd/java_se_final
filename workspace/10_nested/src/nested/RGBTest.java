package nested;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Frame - BorderLayout(동서남북)
public class RGBTest extends Frame {
	
	private Button redBtn, greenBtn, blueBtn;
	private DrCanvas can;
	
	@Override
	public void paint(Graphics g) {
		g.drawString("바보", 100, 100);
	
	}//이건 프레임에 "바보"를 입력했으나 Canvas가 덮어버려서 보이지 않는것임.
	
	public RGBTest() {
		redBtn = new Button("빨강");
		greenBtn = new Button("초록");
		blueBtn = new Button("파랑");
		can = new DrCanvas();
		
		setBounds(900,100,500,500);
		setVisible(true);
		
		Panel p = new Panel();//FlowLayout(순서배치)
		
		p.setLayout(new GridLayout(1,3,5,0));//GridLayout(행열배치, 균등배열)//창이 커지면 같이커지고 작아지면 같이 작아짐.
		//                        1줄,3칸
		// 또다른 기능 new GridLayout(행, 열, 가로여백, 세로여백)
		p.setBackground(new Color(222,179,0));
		p.add(redBtn);
		p.add(greenBtn);
		p.add(blueBtn);
		
		
		this.add("North",p);
		add("Center",can);
		
		
		
		this.addWindowListener(new WindowAdapter(){
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			};
		});
		
		//이벤트
		redBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.RED);
			}
		});
		greenBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.GREEN);
			}
		});
		blueBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.BLUE);
			}
		});
		
	}
	
	//Canvas - 도화지 이다. null(Layout이 없다.)
	class DrCanvas extends Canvas{
		public DrCanvas() {
			this.setBackground(new Color(255,255,0));
		}
		
		@Override
		public void paint(Graphics g) {
			g.drawString("바보", 100, 100);
		
		}
		
	}//class Canvas

	public static void main(String[] args) {
		new RGBTest();

	}

}
