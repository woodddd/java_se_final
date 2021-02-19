package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

//������ �Ѱ��� �����ؾ� �Ѵ�. Ŭ���̾�Ʈ�� ���� �̴��� ������ �Ѱ��� �߾�ó�� �������� ó���� �ؾ��Ѵ�. ���� ������ ����� ��û���� ������ ���� ������ �� �� ����.
//���� �������� �����尡 ������ �����ȴٸ� �������� ���� ������ ������ Ŭ���̾�Ʈ ������ �����ϰ� �� ���̴�.
// �׷��� ���Ǹ� �ȵǱ� ������ �̷� �� ����ϴ°� �ڵ鷯 �̴�.

public class ChatHandler extends Thread {
	private Socket socket;
	private List<ChatHandler> list;
	
	private BufferedReader br;
	private PrintWriter pw;
	
	public ChatHandler(Socket socket,List<ChatHandler> list) throws IOException {
		this.socket = socket;
		this.list = list;
		
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		
	}

	@Override
	public void run() {
		//�г��� �޴� ��
		String line;
		
		try {
			String nickName = br.readLine();
			//��� Ŭ���̾�Ʈ���� ������
			broadcast(nickName + "�� �����Ͽ����ϴ�.");
			
			while(true) {
				line = br.readLine();
				
				if(line == null || line.toLowerCase().equals("quit")) {//���ǿ� null �� �ִ� ������ �����尡 ���ٰ� ���� ����ó���� �ϱ� ������ readLine�� �������� �о���� ��쵵 ������. �׷��� null�� �߰��� �ذ���.
					break;//while ���� ���Ͷ�.
				}//if
				
				//�޼����� ��� Ŭ���̾�Ʈ���� ������
				broadcast("[" + nickName + "]" + line); //���� Ŭ���̾�Ʈ�� ���ڸ� �����ٸ� ��켮 : �ȳ��ϼ��� �� ���� quit �ܸ̿� ����Ѵ�.
			}//while
			
			// quit�� ��û�� Ŭ���̾�Ʈ���Դ� quit�� ������
			// Ŭ���̾�Ʈ�� quit �� ��û�ϸ� while ���� ������
			// ���� ������ ������ Ŭ���̾�Ʈ�� �޼����� br�� �а� pw �� �ٽ� �ǵ��� �ָ鼭
			// Client Ŭ������ quit �� �ٽ� ���������μ�
			// Clinet Ŭ�������� ���α׷��� ������ �� �ִ� ���̴�.
			pw.println("quit");
			pw.flush();
			//���� Ŭ���̾�Ʈ���Դ� ����޼����� �������Ѵ�.
			list.remove(this);//quit ����� ���� ��ü�� list ���� �����
			broadcast(nickName + "���� �����Ͽ����ϴ�."); //broadcast �޼ҵ带 ���Ͽ� ����Ʈ�� �ִ� quit �� ������ ���� Ŭ���̾�Ʈ �鿡�� ���� �޼����� ������.
			
			br.close();
			pw.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}//run()
	
	public void broadcast(String msg) {
		for(ChatHandler handler : list) {
			handler.pw.println(msg);
			handler.pw.flush();
		}
	}
}
