package network;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChatClient extends JFrame implements ActionListener, Runnable{
	private JTextField input;
	private JButton send;
	private JTextArea output;
	
	
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw; // println 을 사용하기 위함.
	
	//pintln 은 문자를 보낸 후 자동 엔터 기능이 있어 메시지를 주고 받을 때, readLine 을 통해 \n 을 추가하지 않고 이용 할 수 있다.
	public ChatClient() {
		
		output = new JTextArea();
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // VERTICAL 수직 , 스크롤 생성
		output.setEditable(false); //JTextArea 를 수정 불가능하게 막는다.
		
		input = new JTextField();
		
		send = new JButton("보내기");
		
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		p.add("Center", input);
		p.add("East", send);
		
		Container con = this.getContentPane();
		con.add("Center",scroll);
		con.add("South",p);
		
		setBounds(700,200,300,300);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);//x 버튼을 눌렀을 때 종료하지 않고 windowClosing에서 quit을 서버로 보냈을 때, 서버에서 quit 을 받아와서 run()메소드에서 처리한다.
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { //서버로 quit 를 보냈다가 서버로부터 quit를 다시 돌려받으면 run()실행
				pw.println("quit");
				pw.flush();
			}
 		});
		
	}//ChatClient()
	
	public void service() {
		//서버IP
//		String serverIP = JOptionPane.showInputDialog(this,
//													"서버IP를 입력하세요",
//													"서버IP",
//													JOptionPane.INFORMATION_MESSAGE);
		String serverIP = JOptionPane.showInputDialog(this,"서버IP를 입력하세요","192.168.0.");
		
		if(serverIP == null || serverIP.length() == 0) {//취소버튼을 누르거나, 글자수가 없을 때,
			System.out.println("서버 IP가 입력되지 않았습니다");
			System.exit(0);
		}//if
		
		//닉네임. 누가 들어왔는지 알아야함
		String nickName = JOptionPane.showInputDialog(this,
													"닉네임을 입력하세요",
													"닉네임",
													JOptionPane.INFORMATION_MESSAGE); //다이어로그 띄울 위치, 다이어로그 메시지, 다이어로그 타이틀, 입력받을 문자 칸
		if(nickName == null || nickName.length() == 0) {
			nickName = "guest";
			}
			
		//소켓 생성
		//소켓은 클라이언트마다 생성을 하여 서버에서 클라이언트에게 소켓을 뿌려줘야 내가 메세지를 보냈을 떄, 나를 포함한 서버를 사용하고 있는 카톡방(예시) 사람들에게 문자를 보낼 수 있다.
		
			try {
				socket = new Socket(serverIP,9500);//"(server ip주소,포트넘버)" 포트넘버가 같아야 같은 방 안에서 만날 수 있다.
				
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
				//Reader와 Writer를 사용한 경우 문자기반 스트림을 사용한 것이다.
				
			} catch (UnknownHostException e) {
				System.out.println("서버를 찾을 수 없습니다.");
				e.printStackTrace();
				System.exit(0);
			} catch (IOException e) {
				System.out.println("서버를 찾을 수 없습니다.");
				e.printStackTrace();
				System.exit(0);
			} 
			
			//서버로 닉네임 보내기
			pw.println(nickName); //서버측 소켓에게 닉네임 데이터를 보낸다. //데이터를 보내고 자동으로 줄바꿈이 일어남 그래서 + \n을 할 필요가 없음
			pw.flush(); //버퍼를 비운다.
			
			//스레드 생성
			Thread t = new Thread(this);//클라이언트가 스레드가 된다.
			//스레드 시작
			t.start();
			
			//이벤트
			send.addActionListener(this); //센드 버튼을 눌렀을 때,임.
			input.addActionListener(this); //JTextField에서 엔터를 누를 때, 이 떄에도 메세지를 보내야 하기 때문에 ActionListener가 필요함
			//보내기 또는 엔터를 누르면 TextField에 입력한 내용을 서버로 전송해야함.
			//서버에 전송된 메세지는 모든 클라이언트들에게 내용을 보내야 하므로 스레드를 사용해서 동시에 사용들에게 보내줘야한다.
			
	}//service()
	
	@Override
	public void run() {
		//서버로부터 메세지를 받는 쪽
		String line;
		while(true) {
			try {
				line = br.readLine(); //서버에서부터 받은 소켓의 문자를 읽어옴
				
				//WindowListener를 이용하여 quit 가 들어온 경우에도 서버로부터 quit 를 받아 종료를 진행함.
				
				if(line == null || line.toLowerCase().equals("quit")) {//조건에 null 이 있는 이유는 스레드가 돌다가 보면 동시처리를 하기 때문에 readLine이 끝났더라도 읽어오는 경우도 존재함. 그래서 null을 추가해 준것임.
										//대소문자 구분없이 quit을 읽어오기 위함.
					br.close();
					pw.close();
					socket.close();
					
					System.exit(0);
				}
				
				//readLine() 은 엔터를 치기 이전까지 데이터 값을 받아오므로 
				//append 해서 추가할 때에는 값을 나눠주기 위해서 \n을 해서 줄바꿈을 해준다.
				output.append(line + "\n"); //서버로부터 받아온 line 을 TextArea에 display한다.
				
				int pos = output.getText().length();//aread의 글자수를 꺼내오고
				output.setCaretPosition(pos); //꺼내온 글자수를 매개변수에 넣어주면 스크롤바가 자동으로 위치값에 따라 위치를 맞춘다.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {//send를 누르나 TextField에서 엔터를 누르나 메세지를 서버에 보내줘야 하므로 e.getSource로 어떤 입력이 들어왔는지 비교할 필요가 없음/
		//서버로부터 메시지를 보내는 쪽
		String msg = input.getText();//텍스트필드로부터 데이터를 얻어옴
		pw.println(msg);//얻어온 데이터를 서버쪽으로 전송
		pw.flush();// 버퍼메모리 비우기. 버퍼의 잔내용까지 싹다 보냄
		input.setText("");//데이터를 보냈으니 텍스트필드를 비워야함. 텍스트필드 지우기
		
	}
	
	public static void main(String[] args) {
		new ChatClient().service();// 생성자 실행 후 service 를 실행해라.
	}

	

}
//Center - 텍스트애리어
//하단 좌측 텍스트 필드
// 보내기
