package abstractMethod;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class WindowTest extends Frame {
	
	public WindowTest() {
		
		
		
		
		setTitle("�̹���");
		setBounds(900,100,500,500);
		setVisible(true);//(paint�޼ҵ带 �����ϰ� ���ִ� �̺�Ʈ)
	}
	
	public void paint(Graphics g) { //���� �޼ҵ带 �ƹ��������� ȣ������ ����. callback �޼ҵ�
		//Toolkit t = new Toolkit();//Toolkit�� �߻�Ŭ������ ������ �Ұ�
		//Toolkit t = Toolkit.getDefaultToolkit(); // �ش� �޼ҵ尡 �����ڴ�ü
		//Image img = t.getImage("java.jpg");//1. �̹��� �ҷ����� // �̹�����δ� ���� ������Ʈ ���� �־����.
		//g.drawImage(img, 30, 100, this);//2. �̹��� �׸��� // ���� �޸𸮿� ������ ���� �ּҰ��� new WindowTest() �� ������ �����Ƿ� �̷� �� new WindowTest() �� ����Ű�� ���� this �� �Ѵ�. 
		
		//Toolkit t = Toolkit.getDefaultToolkit();
		//Image img = t.getImage("java.jpg");
		Image img = Toolkit.getDefaultToolkit().getImage("java.jpg"); //���� �ΰ��� ��ģ��
		//               ToolkitŬ��������                   .     �̹����� ���Ͷ�
		
		//�̹��� �۰�
		g.drawImage(img,
				100,80,400,450,
				0,0,500,754,
				this);
		// �̹��� ���� ��ü
		// ? ? ? ?   ȭ��ũ��
		// ? ? ? ?   �̹��� ũ��
		// observer  �׸��� �׷��� ��� (WindowTest() ��ü�� �׸��� �׷��� ����� ��. �׷��� This)
		
		//�Ųٷ�
		g.drawImage(img,
				100,80,400,450,
				500,754,0,0,
				this);
	}

	public static void main(String[] args) {
		new WindowTest(); //WindowTest() ��� ��ü�̸��� ���� ��ü�� �����ϰԵ�
		
	}
 
}
