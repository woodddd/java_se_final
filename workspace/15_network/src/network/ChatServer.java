package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private ServerSocket ss;
	private List<ChatHandler> list; // ArrayList<> list 도 상관없고 부모인 list 도 상관없다.
	
	public ChatServer() {
		try {
			ss = new ServerSocket(9500); //서버측 소켓 생성 (포트번호 9500)
			System.out.println("서버 준비 완료");
			
			list = new ArrayList<ChatHandler>();
			
			
			while(true) { //accept를 계속 할 수 있도록 무한루프를 돌린다.
				Socket socket = ss.accept(); //클라이언트에서 보내는 소켓을 낚아챈다. 그 후 서버측 소켓을 생성한 후, 핸들러에게 보내준다.
				ChatHandler handler = new ChatHandler(socket, list); //스레드 생성 (ChatHandler가 스레드를 상속하고 있기 때문) 또한 list 의 주소값만 넘겨준 것이기 때문에 list 의 add 가 언제 되던 상관이 없음. 항상 공유상태를 유지함
				handler.start();
				// 현재 서버를 사용중인 클라이언트가 몇명인지 파악을 해야 그 개수만큼 스레드를 돌리므로 핸들러에 클라이언트의 명수를 보내주어야 한다.
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
