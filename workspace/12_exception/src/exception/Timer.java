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
		setLayout(null); // Frame의 기본 형식인 Border Layout을 사용하지 않기 위해서 Layout 형식을 null로 지정해준 것. -
		//- 그 결과 Frame 화면에 동서남북으로 나눠져 있던 영역이 사라지므로 모든 영역을 좌표값을 통해 이용해야함
		
		label = new Label("0");
		label.setFont(new Font("고딕체", Font.BOLD , 120));
		label.setForeground(Color.RED);
		label.setBackground(Color.BLUE);
		startBtn = new Button("시작");
		stopBtn = new Button("정지");
		
		
		
		label.setBounds(50,30,100,100);
		startBtn.setBounds(200,40,60,30);
		stopBtn.setBounds(200,80,60,30);
		
		startBtn.setEnabled(true);//시작버튼 활성화
		stopBtn.setEnabled(false);//정지버튼 비활성화
		
		
		add(label);
		add(startBtn);
		add(stopBtn);
				
		
		setTitle("타이머");//Frame 화면의 Title 이름을 타이머로 지정
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
			//스레드 생성
			t = new Thread(this);//시작 버튼을 누를 떄 마다 스레드를 새로 생성해줌으로서 
			//스레드 시작
			t.start();
			
			aa= true;
			
			//시작버튼 비활성
			startBtn.setEnabled(false);
			//정지버튼 활성
			stopBtn.setEnabled(true);
			
		}else if(e.getSource() == stopBtn) {
			//스레드 종료
			t = null;
			
			aa = false;
			//시작버튼 활성
			startBtn.setEnabled(true);
			//정지성버튼 비활성
			stopBtn.setEnabled(false);
		}
		
	}

	@Override
	public void run() {
		for(int i = 1; i <= 100 ; i++) {
			label.setText(i + "");
		
			if(!aa) break; // 정지버튼을 누를 시 aa 가 false 가 되지만 ! 를 통하여 if 문의 조건이 true 가 되므로 break 문을 통하여 for문을 빠져나온다.
			
			try {
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}//for
		//만약 시간초가 다 흐른 후 위의 for문이 종료되면
		//시작버튼을 다시 활성화시키고, 정지버튼을 비활성화 시켜 다시 실행할 수 있도록 만들어준다.
		startBtn.setEnabled(true);
		stopBtn.setEnabled(false);
	}
	
	public static void main(String[] args) {
		new Timer();
	}
	
}
