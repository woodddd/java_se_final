package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

//서버는 한개만 존재해야 한다. 클라이언트가 여럿 이더라도 서버는 한개의 중앙처리 서버에서 처리를 해야한다. 실제 서버의 비용은 엄청나기 때문에 많은 서버를 둘 수 없다.
//만약 서버에서 스레드가 여러개 생성된다면 여러개의 서버 소켓이 각각의 클라이언트 소켓을 제어하게 될 것이다.
// 그렇게 사용되면 안되기 때문에 이럴 떄 사용하는게 핸들러 이다.

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
		//닉네임 받는 쪽
		String line;
		
		try {
			String nickName = br.readLine();
			//모든 클라이언트에게 보내기
			broadcast(nickName + "님 입장하였습니다.");
			
			while(true) {
				line = br.readLine();
				
				if(line == null || line.toLowerCase().equals("quit")) {//조건에 null 이 있는 이유는 스레드가 돌다가 보면 동시처리를 하기 때문에 readLine이 끝났더라도 읽어오는 경우도 존재함. 그래서 null을 추가해 준것임.
					break;//while 문을 나와라.
				}//if
				
				//메세지를 모든 클라이언트에게 보내기
				broadcast("[" + nickName + "]" + line); //만약 클라이언트가 문자를 보낸다면 김우석 : 안녕하세요 와 같이 quit 이외를 출력한다.
			}//while
			
			// quit를 요청한 클라이언트에게는 quit을 보내고
			// 클라이언트가 quit 을 요청하면 while 문을 나오고
			// 현재 서버에 접속한 클라이언트의 메세지를 br로 읽고 pw 로 다시 되돌려 주면서
			// Client 클래스로 quit 을 다시 보내줌으로서
			// Clinet 클래스에서 프로그램을 종료할 수 있는 것이다.
			pw.println("quit");
			pw.flush();
			//남은 클라이언트에게는 퇴장메세지를 보내야한다.
			list.remove(this);//quit 명령이 들어온 객체를 list 에서 지우고
			broadcast(nickName + "님이 퇴장하였습니다."); //broadcast 메소드를 통하여 리스트에 있는 quit 을 보내지 않은 클라이언트 들에게 퇴장 메세지를 날린다.
			
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
