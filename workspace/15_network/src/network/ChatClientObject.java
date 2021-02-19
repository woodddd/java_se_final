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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

public class ChatClientObject extends JFrame implements ActionListener, Runnable {
	/**
	 * 
	 */
	//private static final long serialVersionUID = 7297905080224262949L;
	private JTextField input;
	private JButton send;
	private JTextArea output;
	
	
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos; // println 을 사용하기 위함.
	

	public ChatClientObject() {
		
		InfoDTO dto = new InfoDTO();
		
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
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { 
				try {
					dto.setMessage("quit");
					dto.setCommand(Info.SEND);
					oos.writeObject(dto);
					oos.flush();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
 		});
		
	}//ChatClient()
	
	public void service() {
		String serverIP = JOptionPane.showInputDialog(this,"서버IP를 입력하세요");//(this,"서버IP를 입력하세요","192.168.");
		InfoDTO dto = new InfoDTO();
		
		if(serverIP == null || serverIP.length() == 0) {
			System.out.println("서버 IP가 입력되지 않았습니다");
			System.exit(0);
		}//if
		
		String nickName = JOptionPane.showInputDialog(this,
													"닉네임을 입력하세요",
													"닉네임",
													JOptionPane.INFORMATION_MESSAGE);
		if(nickName == null || nickName.length() == 0) {
			nickName = "guest";
			}
		
			try {
				socket = new Socket(serverIP,9500);
				oos = new ObjectOutputStream(socket.getOutputStream());
				ois = new ObjectInputStream(socket.getInputStream());
				
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
			try {
				dto.setNickName(nickName);
				dto.setCommand(Info.JOIN);
				oos.writeObject(dto);
				oos.flush();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//스레드 생성
			Thread t = new Thread(this);//클라이언트가 스레드가 된다.
			//스레드 시작
			t.start();
			
			//이벤트
			send.addActionListener(this);
			input.addActionListener(this);
			
	}//service()
	
	@Override
	 public void run() {
	      //서버로부터 받기
	      InfoDTO dto = new InfoDTO();
	      while(true) {
	         try {
	            //객체 받기
	            dto = (InfoDTO)ois.readObject();
	            
	            if(dto.getCommand() == Info.SEND || dto.getCommand() == Info.EXIT) {
	           //메세지를 보내거나, 종료 ,quit이 들어올 때,
	           
	            //종료할 때
	            if(dto.getMessage() == null || dto.getCommand() == Info.EXIT) {
	               ois.close();
	               oos.close();
	               socket.close();
	               System.out.println("프로그램종료");
	               System.exit(0);
	            }
	            
	            //받은 메시지 출력
	            output.append(dto.getMessage() + "\n");
	            }//if
	            //채팅창 넘어가면 알아서 스크롤바가 따라가게
	            int pos = output.getText().length();
	            output.setCaretPosition(pos);
	            
	         } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	         }
	      }
	   }

	
	@Override
	public void actionPerformed(ActionEvent e) {
		//서버로부터 메시지를 보내는 쪽
		InfoDTO dto = new InfoDTO();
		String msg = input.getText();
		dto.setMessage(msg);
		dto.setCommand(Info.SEND);
		
		try {
			oos.writeObject(dto);
			oos.flush();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}//얻어온 데이터를 서버쪽으로 전송
		input.setText("");
		
	}
	
	public static void main(String[] args) {
		new ChatClientObject().service();// 생성자 실행 후 service 를 실행해라.
	}

}
