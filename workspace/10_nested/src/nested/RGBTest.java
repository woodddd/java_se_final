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

//Frame - BorderLayout(��������)
public class RGBTest extends Frame {
	
	private Button redBtn, greenBtn, blueBtn;
	private DrCanvas can;
	
	@Override
	public void paint(Graphics g) {
		g.drawString("�ٺ�", 100, 100);
	
	}//�̰� �����ӿ� "�ٺ�"�� �Է������� Canvas�� ��������� ������ �ʴ°���.
	
	public RGBTest() {
		redBtn = new Button("����");
		greenBtn = new Button("�ʷ�");
		blueBtn = new Button("�Ķ�");
		can = new DrCanvas();
		
		setBounds(900,100,500,500);
		setVisible(true);
		
		Panel p = new Panel();//FlowLayout(������ġ)
		
		p.setLayout(new GridLayout(1,3,5,0));//GridLayout(�࿭��ġ, �յ�迭)//â�� Ŀ���� ����Ŀ���� �۾����� ���� �۾���.
		//                        1��,3ĭ
		// �Ǵٸ� ��� new GridLayout(��, ��, ���ο���, ���ο���)
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
		
		//�̺�Ʈ
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
	
	//Canvas - ��ȭ�� �̴�. null(Layout�� ����.)
	class DrCanvas extends Canvas{
		public DrCanvas() {
			this.setBackground(new Color(255,255,0));
		}
		
		@Override
		public void paint(Graphics g) {
			g.drawString("�ٺ�", 100, 100);
		
		}
		
	}//class Canvas

	public static void main(String[] args) {
		new RGBTest();

	}

}
