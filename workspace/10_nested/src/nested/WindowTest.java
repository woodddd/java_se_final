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
		
		//�̺�Ʈ
		this.addWindowListener(new WindowAdapter() { //WindowAdapter�� �߻�Ŭ������. WindowListener �� ��� �߻�޼ҵ带 �����⸸ ������ ����.
			//WindowAdapter �߻�Ŭ���� ���θ� ���캸��,
			//public abstract class WindowAdapter
			//extends Object
			//implements WindowListener, WindowStateListener, WindowFocusListener
			
			//�������̽� WindowListener �� implements �ϰ� ����.
			//�׷��Ƿ� �߻�Ŭ������ WindowAdapter�� WindowListener �� ��� �޼ҵ带 �������̵� �� �־����. 
			//������ WindowAdapter�� �߻�Ŭ���������� �������̵� �� �޼ҵ带 �߻����� ������ �ʾ����Ƿ� �ʿ��� �޼ҵ常 �ҷ��ͼ� ������ ���ָ� ��.
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
		}
		});
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("���콺 IN");
			}
			
			
			@Override
	         public void mouseExited(MouseEvent e) {
	            System.out.println("���콺 OUT");
	         }
		});
	}

	

}
