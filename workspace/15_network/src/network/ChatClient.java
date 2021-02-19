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
	private PrintWriter pw; // println �� ����ϱ� ����.
	
	//pintln �� ���ڸ� ���� �� �ڵ� ���� ����� �־� �޽����� �ְ� ���� ��, readLine �� ���� \n �� �߰����� �ʰ� �̿� �� �� �ִ�.
	public ChatClient() {
		
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
		//setDefaultCloseOperation(EXIT_ON_CLOSE);//x ��ư�� ������ �� �������� �ʰ� windowClosing���� quit�� ������ ������ ��, �������� quit �� �޾ƿͼ� run()�޼ҵ忡�� ó���Ѵ�.
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { //������ quit �� ���´ٰ� �����κ��� quit�� �ٽ� ���������� run()����
				pw.println("quit");
				pw.flush();
			}
 		});
		
	}//ChatClient()
	
	public void service() {
		//����IP
//		String serverIP = JOptionPane.showInputDialog(this,
//													"����IP�� �Է��ϼ���",
//													"����IP",
//													JOptionPane.INFORMATION_MESSAGE);
		String serverIP = JOptionPane.showInputDialog(this,"����IP�� �Է��ϼ���","192.168.0.");
		
		if(serverIP == null || serverIP.length() == 0) {//��ҹ�ư�� �����ų�, ���ڼ��� ���� ��,
			System.out.println("���� IP�� �Էµ��� �ʾҽ��ϴ�");
			System.exit(0);
		}//if
		
		//�г���. ���� ���Դ��� �˾ƾ���
		String nickName = JOptionPane.showInputDialog(this,
													"�г����� �Է��ϼ���",
													"�г���",
													JOptionPane.INFORMATION_MESSAGE); //���̾�α� ��� ��ġ, ���̾�α� �޽���, ���̾�α� Ÿ��Ʋ, �Է¹��� ���� ĭ
		if(nickName == null || nickName.length() == 0) {
			nickName = "guest";
			}
			
		//���� ����
		//������ Ŭ���̾�Ʈ���� ������ �Ͽ� �������� Ŭ���̾�Ʈ���� ������ �ѷ���� ���� �޼����� ������ ��, ���� ������ ������ ����ϰ� �ִ� ī���(����) ����鿡�� ���ڸ� ���� �� �ִ�.
		
			try {
				socket = new Socket(serverIP,9500);//"(server ip�ּ�,��Ʈ�ѹ�)" ��Ʈ�ѹ��� ���ƾ� ���� �� �ȿ��� ���� �� �ִ�.
				
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
				//Reader�� Writer�� ����� ��� ���ڱ�� ��Ʈ���� ����� ���̴�.
				
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
			pw.println(nickName); //������ ���Ͽ��� �г��� �����͸� ������. //�����͸� ������ �ڵ����� �ٹٲ��� �Ͼ �׷��� + \n�� �� �ʿ䰡 ����
			pw.flush(); //���۸� ����.
			
			//������ ����
			Thread t = new Thread(this);//Ŭ���̾�Ʈ�� �����尡 �ȴ�.
			//������ ����
			t.start();
			
			//�̺�Ʈ
			send.addActionListener(this); //���� ��ư�� ������ ��,��.
			input.addActionListener(this); //JTextField���� ���͸� ���� ��, �� ������ �޼����� ������ �ϱ� ������ ActionListener�� �ʿ���
			//������ �Ǵ� ���͸� ������ TextField�� �Է��� ������ ������ �����ؾ���.
			//������ ���۵� �޼����� ��� Ŭ���̾�Ʈ�鿡�� ������ ������ �ϹǷ� �����带 ����ؼ� ���ÿ� ���鿡�� ��������Ѵ�.
			
	}//service()
	
	@Override
	public void run() {
		//�����κ��� �޼����� �޴� ��
		String line;
		while(true) {
			try {
				line = br.readLine(); //������������ ���� ������ ���ڸ� �о��
				
				//WindowListener�� �̿��Ͽ� quit �� ���� ��쿡�� �����κ��� quit �� �޾� ���Ḧ ������.
				
				if(line == null || line.toLowerCase().equals("quit")) {//���ǿ� null �� �ִ� ������ �����尡 ���ٰ� ���� ����ó���� �ϱ� ������ readLine�� �������� �о���� ��쵵 ������. �׷��� null�� �߰��� �ذ���.
										//��ҹ��� ���о��� quit�� �о���� ����.
					br.close();
					pw.close();
					socket.close();
					
					System.exit(0);
				}
				
				//readLine() �� ���͸� ġ�� �������� ������ ���� �޾ƿ��Ƿ� 
				//append �ؼ� �߰��� ������ ���� �����ֱ� ���ؼ� \n�� �ؼ� �ٹٲ��� ���ش�.
				output.append(line + "\n"); //�����κ��� �޾ƿ� line �� TextArea�� display�Ѵ�.
				
				int pos = output.getText().length();//aread�� ���ڼ��� ��������
				output.setCaretPosition(pos); //������ ���ڼ��� �Ű������� �־��ָ� ��ũ�ѹٰ� �ڵ����� ��ġ���� ���� ��ġ�� �����.
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {//send�� ������ TextField���� ���͸� ������ �޼����� ������ ������� �ϹǷ� e.getSource�� � �Է��� ���Դ��� ���� �ʿ䰡 ����/
		//�����κ��� �޽����� ������ ��
		String msg = input.getText();//�ؽ�Ʈ�ʵ�κ��� �����͸� ����
		pw.println(msg);//���� �����͸� ���������� ����
		pw.flush();// ���۸޸� ����. ������ �ܳ������ �ϴ� ����
		input.setText("");//�����͸� �������� �ؽ�Ʈ�ʵ带 �������. �ؽ�Ʈ�ʵ� �����
		
	}
	
	public static void main(String[] args) {
		new ChatClient().service();// ������ ���� �� service �� �����ض�.
	}

	

}
//Center - �ؽ�Ʈ�ָ���
//�ϴ� ���� �ؽ�Ʈ �ʵ�
// ������
