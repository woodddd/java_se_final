package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServerObject {
	private ServerSocket ss;
	private List<ChatHandlerObject> list;
	
	public ChatServerObject() {
		try {
			ss = new ServerSocket(9500);
			System.out.println("���� �غ� �Ϸ�");
			
			list = new ArrayList<ChatHandlerObject>();
			
			
			while(true) {
				Socket socket = ss.accept(); //Ŭ���̾�Ʈ���� ������ ������ ����æ��. �� �� ������ ������ ������ ��, �ڵ鷯���� �����ش�.
				ChatHandlerObject handler = new ChatHandlerObject(socket, list); //������ ���� (ChatHandler�� �����带 ����ϰ� �ֱ� ����) ���� list �� �ּҰ��� �Ѱ��� ���̱� ������ list �� add �� ���� �Ǵ� ����� ����. �׻� �������¸� ������
				handler.start();
				// ���� ������ ������� Ŭ���̾�Ʈ�� ������� �ľ��� �ؾ� �� ������ŭ �����带 �����Ƿ� �ڵ鷯�� Ŭ���̾�Ʈ�� ����� �����־�� �Ѵ�.
				list.add(handler);
			}//while
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void main(String[] args) {
		new ChatServerObject();
	}
}
