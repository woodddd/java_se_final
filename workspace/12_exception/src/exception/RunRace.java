package exception;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Runas - Run Configurations - arguments 
//arguments
// �� ������  + " " + ���̸�1 + ���̸�2 + ���̸�3 .....

//Frame - BorderLayout(��������)
public class RunRace extends Frame implements ActionListener{
	private Button btn;
	private int count;
	private Racer[] r;
	
	public RunRace(String[] args) {
		
		btn = new Button("���");
		count = Integer.parseInt(args[0]);		
		r = new Racer[count];
		
		for(int i = 0; i < count ; i++) {
			r[i] = new Racer(args[i+1]);//Run as �� args[0]�� ���� ���� �Է��ϰ� 1���ε������� �̸��� �Է���.
		}
		
		Panel p = new Panel(new FlowLayout(FlowLayout.RIGHT));// FlowLayout��Ÿ�Ϸ� �ۼ��� �� ���̴�.������ ���̾ƿ�. RIGHT - �������ķ� �� ���̴�
		p.add(btn); //�гο� ��ư�� �ø���
		add("South", p); // ������ ���� �г��� �ø� �� �������� �г��� ���� ���̴�. Frame �� �⺻���� Border Layout ��/��/��/�� ��Ÿ�Ϸ� ���� ���ʿ� �г��� ���� �� �г��� ���� ������ �������� �ۼ��Ͽ���.
 
		Panel p2 = new Panel(new GridLayout(count,1));//�� ��������ŭ �г��� ����
		for(int i = 0; i < count; i ++) {
			p2.add(r[i]);//�гο� Racer��ü�� �� ��������ŭ �ø�.
			//�ᱹ Frame ���� �� ��������ŭ�� Canvas�� �ö� ����.
		}
		add("Center",p2);//GridLayout �� �̿��Ͽ� count ĭ 1���� �������� Frame�� Center������ ������

		setResizable(false);
		setBounds(700,200,600,400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//��ư�� �̺�Ʈ
		btn.addActionListener(this);//��ư�� ���� �̺�Ʈ�� ������ actionPerFormed �޼ҵ带 �����Ͽ� ��ư�� ��Ȱ��ȭ ��Ŵ
		
	}//RunRace

	
	//ActionListener �߻�޼ҵ� �������̵�
	@Override
	public void actionPerformed(ActionEvent e) {
		//��� ��ư�� ������ ��� ��ư�� ��Ȱ��ȭ
		btn.setEnabled(false);//��ư�� ��Ȱ��ȭ �ϰڴ�.
		Thread[] t = new Thread[count];
		for(int i = 0 ; i < count ; i++) {
			t[i] = new Thread(r[i]);// ������ ���� ( ) �ȿ���  Thread����� ��
			t[i].setPriority((int)(Math.random() * 10 + 1));// �켱������ 1~10 ���̷� �������� �־���
			//���� run() �� for ������ i�� �����ϰ� �����Ѵٸ� �켱������ ���� �����尡 Ȯ�������� ���� ������ �Ǿ� ���� �� Ŀ���� ���� ������ �� ����.
			//������� ���� ó���� �ϱ� ������ ���� �����尡 ����Ǹ� �켱������ ���� �����带 Ȯ�������� �� ���� �����ϰ� �Ǿ�����. ������ �켱������ ���ٰ� ������ ���� ����Ǵ� ���� �ƴ�.
			t[i].start();//������ ���� - ������ ����(�ü���� run() �� ã�ư�)
		}//for
	}//actionPerformed

	public static void main(String[] args) {
		if(args.length < 2 ) {
			System.out.println("Usage : java RunRace count name1, ...");
			System.exit(0);
		}
		if(Integer.parseInt(args[0]) != args.length -1) {
			System.out.println("�� �������� �̸��� ������ ���� �ʽ��ϴ�.");
			System.exit(0);
		}
		new RunRace(args);
	}


	
}
