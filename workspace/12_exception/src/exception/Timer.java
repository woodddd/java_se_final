package exception;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Timer extends Frame implements ActionListener,Runnable{
	private Label label;
	private Button startBtn, stopBtn;
	private boolean aa = true;
	
	public Timer() {
		setLayout(null); // Frame�� �⺻ ������ Border Layout�� ������� �ʱ� ���ؼ� Layout ������ null�� �������� ��. -
		//- �� ��� Frame ȭ�鿡 ������������ ������ �ִ� ������ ������Ƿ� ��� ������ ��ǥ���� ���� �̿��ؾ���
		
		label = new Label("0");
		label.setFont(new Font("���ü", Font.BOLD , 120));
		label.setForeground(Color.RED);
		label.setBackground(Color.BLUE);
		startBtn = new Button("����");
		stopBtn = new Button("����");
		
		
		
		label.setBounds(50,30,100,100);
		startBtn.setBounds(200,40,60,30);
		stopBtn.setBounds(200,80,60,30);
		
		startBtn.setEnabled(true);//���۹�ư Ȱ��ȭ
		stopBtn.setEnabled(false);//������ư ��Ȱ��ȭ
		
		
		add(label);
		add(startBtn);
		add(stopBtn);
				
		
		setTitle("Ÿ�̸�");//Frame ȭ���� Title �̸��� Ÿ�̸ӷ� ����
		setBounds(700,200,300,200);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		startBtn.addActionListener(this);
		stopBtn.addActionListener(this);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t;
		if(e.getSource() == startBtn) {
			//������ ����
			t = new Thread(this);//���� ��ư�� ���� �� ���� �����带 ���� �����������μ� 
			//������ ����
			t.start();
			
			aa= true;
			
			//���۹�ư ��Ȱ��
			startBtn.setEnabled(false);
			//������ư Ȱ��
			stopBtn.setEnabled(true);
			
		}else if(e.getSource() == stopBtn) {
			//������ ����
			t = null;
			
			aa = false;
			//���۹�ư Ȱ��
			startBtn.setEnabled(true);
			//��������ư ��Ȱ��
			stopBtn.setEnabled(false);
		}
		
	}

	@Override
	public void run() {
		for(int i = 1; i <= 100 ; i++) {
			label.setText(i + "");
		
			if(!aa) break; // ������ư�� ���� �� aa �� false �� ������ ! �� ���Ͽ� if ���� ������ true �� �ǹǷ� break ���� ���Ͽ� for���� �������´�.
			
			try {
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}//for
		//���� �ð��ʰ� �� �帥 �� ���� for���� ����Ǹ�
		//���۹�ư�� �ٽ� Ȱ��ȭ��Ű��, ������ư�� ��Ȱ��ȭ ���� �ٽ� ������ �� �ֵ��� ������ش�.
		startBtn.setEnabled(true);
		stopBtn.setEnabled(false);
	}
	
	public static void main(String[] args) {
		new Timer();
	}
	
}
