package nested;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Login extends Frame implements ActionListener{
	private Label idL, pwdL;
	private TextField idT, pwdT;
	private Button loginBtn, cancelBtn;
	
	public Login() {
		idL = new Label("���̵�");
		pwdL = new Label("��й�ȣ");
		
		idT = new TextField();
		pwdT = new TextField();
		
		loginBtn = new Button("�α���");
		cancelBtn = new Button("���");
		
//		idL.setLocation(50,80); // 0,0���� �����ؼ� 50 ������ 80 �Ʒ��� 
//		idL.setSize(50, 30); //���α��� 50 ���α��� 30 (�ȼ�)
		//���� �� ����� �ѹ��� ó�����ִ� �޼ҵ�
		idL.setBounds(50, 80, 50, 30);
		idT.setBounds(120, 80, 100, 30);
		
		
		pwdL.setBounds(50,120, 60, 30);
		pwdT.setBounds(120,120, 150, 30);
		
		loginBtn.setBounds(70, 300, 60, 40);
		cancelBtn.setBounds(170,300, 60, 40);
		

		this.add(idL);
		this.add(idT);
		
		this.add(pwdL);
		this.add(pwdT);
		
		this.add(loginBtn);
		this.add(cancelBtn);
		
		
		setLayout(null);//���� BorderLayout(��������) �� ���ְ� �� ��ȭ�� ���� �������. ���� ��ǥ�� ����ؾ���.
		setBounds(800,100,300,400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//�̺�Ʈ
		loginBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}//Login()
	

	
	//ActionListener�� �޼ҵ尡 �Ѱ��̱� ������ WindowEvent�� ���� �߻�Ŭ������ ���� ����.
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginBtn) {
			new LoginResult(idT.getText(),pwdT.getText()); //getText()�� TextField �� ���� ������.
			
		}else if(e.getSource() == cancelBtn) {
			idT.setText(" ");//��ҹ�ư�� ������ �ش� �ؽ�Ʈ�ʵ� �ʱ�ȭ
			idT.setText("");//���� �̰� ��ҹ�ư������ ���� awt������ �̰� ����� �ȵɼ��� �־ �����ٿ��� �����̽��� �ѹ� �־��� �� ������ �־���. �׷��� ������ ����
			pwdT.setText(" ");
			pwdT.setText("");
		}
		
	}
	
	public static void main(String[] args) {
		new Login();
	}

}
