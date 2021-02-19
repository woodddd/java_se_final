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
		idL = new Label("아이디");
		pwdL = new Label("비밀번호");
		
		idT = new TextField();
		pwdT = new TextField();
		
		loginBtn = new Button("로그인");
		cancelBtn = new Button("취소");
		
//		idL.setLocation(50,80); // 0,0에서 시작해서 50 옆으로 80 아래로 
//		idL.setSize(50, 30); //가로길이 50 세로길이 30 (픽셀)
		//위의 두 기능을 한번에 처리해주는 메소드
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
		
		
		setLayout(null);//기존 BorderLayout(동서남북) 을 없애고 빈 도화지 같이 만들어줌. 모든걸 좌표로 사용해야함.
		setBounds(800,100,300,400);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		//이벤트
		loginBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
	}//Login()
	

	
	//ActionListener는 메소드가 한개이기 때문에 WindowEvent와 같은 추상클래스가 따로 없음.
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == loginBtn) {
			new LoginResult(idT.getText(),pwdT.getText()); //getText()는 TextField 의 값을 가져옴.
			
		}else if(e.getSource() == cancelBtn) {
			idT.setText(" ");//취소버튼을 누르면 해당 텍스트필드 초기화
			idT.setText("");//원래 이게 취소버튼이지만 현재 awt에서는 이게 제대로 안될수가 있어서 위에줄에서 스페이스를 한번 넣어준 후 공백을 넣어줌. 그러면 문제가 없음
			pwdT.setText(" ");
			pwdT.setText("");
		}
		
	}
	
	public static void main(String[] args) {
		new Login();
	}

}
