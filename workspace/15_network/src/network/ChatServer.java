package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private ServerSocket ss;
	private List<ChatHandler> list; // ArrayList<> list �� ������� �θ��� list �� �������.
	
	public ChatServer() {
		try {
			ss = new ServerSocket(9500); //������ ���� ���� (��Ʈ��ȣ 9500)
			System.out.println("���� �غ� �Ϸ�");
			
			list = new ArrayList<ChatHandler>();
			
			
			while(true) { //accept�� ��� �� �� �ֵ��� ���ѷ����� ������.
				Socket socket = ss.accept(); //Ŭ���̾�Ʈ���� ������ ������ ����æ��. �� �� ������ ������ ������ ��, �ڵ鷯���� �����ش�.
				ChatHandler handler = new ChatHandler(socket, list); //������ ���� (ChatHandler�� �����带 ����ϰ� �ֱ� ����) ���� list �� �ּҰ��� �Ѱ��� ���̱� ������ list �� add �� ���� �Ǵ� ����� ����. �׻� �������¸� ������
				handler.start();
				// ���� ������ ������� Ŭ���̾�Ʈ�� ������� �ľ��� �ؾ� �� ������ŭ �����带 �����Ƿ� �ڵ鷯�� Ŭ���̾�Ʈ�� ����� �����־�� �Ѵ�.
				list.add(handler);
			}//while
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}
	
}
