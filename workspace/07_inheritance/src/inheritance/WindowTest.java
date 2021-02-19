package inheritance;

import java.awt.Color;
import java.awt.Frame; //Frame Ŭ���� import
import java.awt.Graphics;
//java.lang �� JVM �� �˾Ƽ� ã�ư����� �� �ܴ̿� ��! import�� �� �־�� �Ѵ�.
public class WindowTest extends Frame {
	
	public WindowTest() {//����
		//new Frame("���� �Է��߽��ϴ�!").setVisible(true);
		//main �޼ҵ���new WindowTest() ������ �θ�� �ڽ� �����ڸ� �����ϰ� �Ǵµ�,
		// ���� ������ �����ϰ� �Ǹ� �θ�Ŭ������ �����ڸ� �ѹ� �� �����ϰԵ�
		//�׷��� �Ǹ� ��������� main �޼ҵ� �� ���� �θ�Ŭ���� 1 �� �ڽ�Ŭ���� 1�� ������ ����.
		// �� �� WindowTest()��������  new Frame("���� �Է��߽��ϴ�!")�� ���� �θ� Ŭ������ �����ڸ� 1�� ����
		//����� �θ�Ŭ����2������ �ڽ�Ŭ���� 1���� ����ǰ� �Ǿ� Frame Ŭ������ �����ڰ� 2������Ǿ����Ƿ�
		//â�� �ΰ��� �����Ǵ� ����.
		
		// *super�� ������ ù��° �ٿ� ����ؾ���!!
		super("���� ���� ������");//super�� ����ϰ� �Ǹ� �θ�����ڸ� �����ϰ� �� ��, super()�� ���� �Ķ���Ϳ� �Է°��� ���Ե�.
		//�ñ��Ѱ�.
		//�θ�Ŭ������ �����ڸ� ���� ������ �� super �� ���� �ڽ�Ŭ������ �����ڸ� ������ �� super�� ���� �Ķ���� ���� �־��ְ� �Ǹ� �̹� �θ�����ڰ� ����ǰ� �� �� ���� ������ �ȵǾ�� �ϴ� �� �ƴѰ���? �װ� �ƴ϶�� super�� ���� �θ�����ڸ� �ѹ� �� ������ �ִ°ǰ���?
		//�ذ� : �켱 main �޼ҵ忡�� WindowTest() �� ���� �����Ƿ� �ڽ� �޼ҵ��� WindowTest�ε��� ��
		//�θ� �����ڸ� �����ϰ� �Ǵµ� super�� ���� �� �Ķ���Ͱ� �ִ� �����ڷ� ����, ���� �����ڷ� �� �� �����ϰ� ��,
		// �׷��� WindowTest() -> super -> Frame ������ ���� -> WindowTest ������ ����
		//��! super�� ���� �� ��� �θ� �������� �����ڸ� �̿��϶�� �� �̹Ƿ� �ٷ� �θ� �����ڸ� �����ϸ� �ȴ�.
		//���� super ����� ������ super() ����� �Ⱦ����� �� ���̹Ƿ� �θ� ������ -> �ڽĻ����� ������ �����Ѵ�.
		
		System.out.println("����");// System.in -> Ű����� �Է��� ���� System.out -> console �� ���
		//�׷��� ���� ������� ������ â�� ���� �̶� ���ڸ� ������ �� ���� ����.
		
		//Color c = new Color(126,222,86); // �̰� ��ü�� �ּҰ��� �����ϹǷ� �޸𸮿� ���� ��������
		this.setBackground(new Color(126,222,86));//������// �Ʒ��� ���� ����ϸ� ���� ���������ʰ� ��ȸ������ ����ϰ� �Ǵ°�.
		
		setForeground(Color.yellow);
		
		//setSize(300,400);(int weight, int height)
		//setBounds(x�� ��ġ, y�� ��ġ , �ʺ�, ����)
		this.setBounds(650,150,300,400);
		this.setVisible(true); //Visible ���̴�, ���ü� (������ȭ���� ���̰� �ض�)
	}
	
	public void paint(Graphics g) {//����
		//������â �ȿ� ���𰡸� �׸��� �޼ҵ�
		g.drawString("����", 100, 80); // (������ �� , x��ǥ, y��ǥ)
		
		//g.drawLine(x1, y1, x2, y2);
		g.drawLine(70, 120, 200, 300); 
		g.drawLine(200, 120, 70, 300);
		//g.drawRect(x, y, width, height);
		g.drawRect(220, 310, 70, 70);
		//g.drawOval(x, y, width, height);
		g.drawOval(220, 310, 70, 70);
		
	} //patint �޼ҵ�� ȣ��ΰ� ����. 
	// �̷��� ��ó��
	// ������ ������ �Ǹ� JVM�� ���ؼ� ȣ��Ǵ� �޼ҵ� - Call Back �޼ҵ�
	// �츮�� �˰� �ִ� �޼ҵ� �� main �޼ҵ� ���� Call Back �޼ҵ��̴�.
	// �������(Ctrl + f11)�� �Ǹ� main �޼ҵ带 �����Ѵ�.
	// paint �޼ҵ�� setVisible(true) ��� �޼ҵ尡 ����� ��,
	// �� �������� JVM �� ���� �ڵ� ȣ��Ǿ� �����̵�.
	
	public static void main(String[] args) {
		//WindowTest aa = new WindowTest(); ��ü aa �� ����� ���� �ּҸ� ����
		new WindowTest(); // ���� �������� �ʰ� ��ȸ����
	}

}
