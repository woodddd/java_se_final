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
	private ObjectOutputStream oos; // println �� ����ϱ� ����.
	

	public ChatClientObject() {
		
		InfoDTO dto = new InfoDTO();
		
		output = new JTextArea();
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS); // VERTICAL ���� , ��ũ�� ����
		output.setEditable(false); //JTextArea �� ���� �Ұ����ϰ� ���´�.
		
		input = new JTextField();
		
		send = new JButton("������");
		
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
		String serverIP = JOptionPane.showInputDialog(this,"����IP�� �Է��ϼ���");//(this,"����IP�� �Է��ϼ���","192.168.");
		InfoDTO dto = new InfoDTO();
		
		if(serverIP == null || serverIP.length() == 0) {
			System.out.println("���� IP�� �Էµ��� �ʾҽ��ϴ�");
			System.exit(0);
		}//if
		
		String nickName = JOptionPane.showInputDialog(this,
													"�г����� �Է��ϼ���",
													"�г���",
													JOptionPane.INFORMATION_MESSAGE);
		if(nickName == null || nickName.length() == 0) {
			nickName = "guest";
			}
		
			try {
				socket = new Socket(serverIP,9500);
				oos = new ObjectOutputStream(socket.getOutputStream());
				ois = new ObjectInputStream(socket.getInputStream());
				
			} catch (UnknownHostException e) {
				System.out.println("������ ã�� �� �����ϴ�.");
				e.printStackTrace();
				System.exit(0);
			} catch (IOException e) {
				System.out.println("������ ã�� �� �����ϴ�.");
				e.printStackTrace();
				System.exit(0);
			} 
			
			//������ �г��� ������
			try {
				dto.setNickName(nickName);
				dto.setCommand(Info.JOIN);
				oos.writeObject(dto);
				oos.flush();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//������ ����
			Thread t = new Thread(this);//Ŭ���̾�Ʈ�� �����尡 �ȴ�.
			//������ ����
			t.start();
			
			//�̺�Ʈ
			send.addActionListener(this);
			input.addActionListener(this);
			
	}//service()
	
	@Override
	 public void run() {
	      //�����κ��� �ޱ�
	      InfoDTO dto = new InfoDTO();
	      while(true) {
	         try {
	            //��ü �ޱ�
	            dto = (InfoDTO)ois.readObject();
	            
	            if(dto.getCommand() == Info.SEND || dto.getCommand() == Info.EXIT) {
	           //�޼����� �����ų�, ���� ,quit�� ���� ��,
	           
	            //������ ��
	            if(dto.getMessage() == null || dto.getCommand() == Info.EXIT) {
	               ois.close();
	               oos.close();
	               socket.close();
	               System.out.println("���α׷�����");
	               System.exit(0);
	            }
	            
	            //���� �޽��� ���
	            output.append(dto.getMessage() + "\n");
	            }//if
	            //ä��â �Ѿ�� �˾Ƽ� ��ũ�ѹٰ� ���󰡰�
	            int pos = output.getText().length();
	            output.setCaretPosition(pos);
	            
	         } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	         }
	      }
	   }

	
	@Override
	public void actionPerformed(ActionEvent e) {
		//�����κ��� �޽����� ������ ��
		InfoDTO dto = new InfoDTO();
		String msg = input.getText();
		dto.setMessage(msg);
		dto.setCommand(Info.SEND);
		
		try {
			oos.writeObject(dto);
			oos.flush();
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}//���� �����͸� ���������� ����
		input.setText("");
		
	}
	
	public static void main(String[] args) {
		new ChatClientObject().service();// ������ ���� �� service �� �����ض�.
	}

}
