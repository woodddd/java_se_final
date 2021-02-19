 package _interface;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class WindowTest extends Frame implements ActionListener,MouseListener,MouseMotionListener{
	//�ڹ� Ŭ������ ���� ��Ӹ� �ȴ�.
	//�ٸ� Ŭ�����κ��� ���� �ް������� interface �� ����ؾ��Ѵ�.
	
	private Button exitBtn;
	
	public void init() {
		
		exitBtn = new Button("����"); //��ư ����
		this.add("North", exitBtn); //��ġ (��ġ, ..) ��ġ�� ���� ���� ���� ��ư�� ��ġ�� �޶��� 
		//���� - East , ���� - West , ���� - South , North - ����
		
		setBounds(900,100,300,400);
		setVisible(true);//â�� ����ּ���.
		
		//�̺�Ʈ
		//�̺�Ʈ �߻� -> �Ʒ��� �������� ��� � �޼ҵ尡 �߻��Ͽ� �޼ҵ尡 ��� ��ġ�� �ִ��� ã��
		//�� ��  �޼ҵ带 �����ϰ� ��.
		this.addMouseListener(this); // CallBack �޼ҵ带 �ڹ� ����ӽ�(JVM)���� ������. �̺�Ʈ ��ü�� ������ �ֱ� ������ this.addMouseListener(this);(��ȣ �ȿ��� �ش� �޼ҵ尡 �ִ� ��ġ�� �ڹٰ���ӽſ��� �˷������)
		this.addMouseMotionListener(this);//(this) �� �ǹ�.  MouseMotionListener �� �ش��ϴ� �߻�Ŭ������ �����θ� ��(main�޼ҵ忡�� new ������ ���簴ü)�� ������ �ִ�.
		//����(���) �̺�Ʈ �߻� ��ġ. � Ŭ������ �޼ҵ忡�� �߻��ϰ��� ������ �߰�. (EvendHandler�� ��ġ) ��� �߻��� ���̳�.(add�޼ҵ� ���� ��ġ)
		//          this        .       add....                  . (��ġ) 
		this.addWindowListener(new WindowExit()); // WindowListener �� ������ �ִ� �� WindowExit Ŭ������ ��ü �̹Ƿ� WindowListener�� �������̵��� �޼ҵ尡 �����ϴ� ��ġ�� ������ ����.
		exitBtn.addActionListener(this); // �����ư���� �̺�Ʈ�� �߻��ϸ�. actionPerformed �� ����ǰ�. �޼ҵ��� ���� ��ġ�� ���� ��ü ���� �ִ�.
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {//������â�� ���� ��ư�� click�� �� �����
		System.exit(0); //���α׷� ����. console�� ������ �׸� �ڽ��� �����ϸ��.(���μ�������)
		
	}
	
	//Interface �� MouseListener �� �߻�޼ҵ带 ��� �������̵�.
	//�������̵� �� �޼ҵ带 ���� �����ؼ� ����ؾ���.
	// interface �� �߻� �޼ҵ� �̱� ������ interface�� Ʋ�� ������ �ϱ� ����.
	
	// ���⿡�� ���� �߻�޼ҵ� ���� ���� Call Back �޼ҵ���. ȣ���� ���� �ʰ� ��� �̺�Ʈ�� �߻��� �޼ҵ带 �ڵ� �����ϰԵ�.
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("���콺 Ŭ��");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {//����(������â ������)
		System.out.println("���콺 IN");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {//������(������â ������)
		System.out.println("���콺 OUT");
		
	}

	//Interface �� MouseMotionListener �� �߻�޼ҵ带 ��� �������̵�.
	
	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("���콺 �巡��");
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {

		new WindowTest().init();//��ȸ�� ��ü ����.�޼ҵ� ���
		
	}



}