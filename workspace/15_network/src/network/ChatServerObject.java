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
			System.out.println("서버 준비 완료");
			
			list = new ArrayList<ChatHandlerObject>();
			
			
			while(true) {
				Socket socket = ss.accept(); //클라이언트에서 보내는 소켓을 낚아챈다. 그 후 서버측 소켓을 생성한 후, 핸들러에게 보내준다.
				ChatHandlerObject handler = new ChatHandlerObject(socket, list); //스레드 생성 (ChatHandler가 스레드를 상속하고 있기 때문) 또한 list 의 주소값만 넘겨준 것이기 때문에 list 의 add 가 언제 되던 상관이 없음. 항상 공유상태를 유지함
				handler.start();
				// 현재 서버를 사용중인 클라이언트가 몇명인지 파악을 해야 그 개수만큼 스레드를 돌리므로 핸들러에 클라이언트의 명수를 보내주어야 한다.
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
