package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ProtocolClient {
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	private BufferedReader keyboard;//키보드로부터 데이터를 들어오게 할 것임.
	
	
	//*	getInputStream() - 소켓을 통해서 InputStream 을 리턴해줌.
	//* getOutputStream() - 소켓을 통해서 OutputStream 을 리턴해줌.
	//ex) Socket.getOutputStream()
	//리턴타입 OutputStream
	
	
	//클라이언트에서 값을 서버에 전송하면 서버는 클라이언트에게 값을 다시 전송한다.
	//통신규약
	//					클라이언트의 역할									    |			    서버의 역할							
	//ProtocalClient.java -------------> buffer -------------> Socket -------------> Socket -------------> buffer -------------> ProtocolServer.java
	public ProtocolClient() {
		try {
			socket = new Socket("192.168.0.22", 9500);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			
			
		} catch (UnknownHostException e) { // ip번호를 찾을 수 없다.
			System.out.println("서버를 찾을 수 없습니다.");
			e.printStackTrace();
			System.exit(0);

		} catch (IOException e) {
			System.out.println("서버와 연결이 안되었습니다.");
			e.printStackTrace();
			System.exit(0);
		}
		
		//-------------------------
		String msg, line;
		
		while(true) {
			//서버로 보내는 쪽
			try {
				msg = keyboard.readLine();// 키보드로 부터 메세지를 읽는다 // !!readLine 은 엔터를 읽지 않음!!
				bw.write(msg + "\n");// 서버로 보내기; // 서버쪽에서도 readLine으로 msg를 받아서 읽는데 msg에서 엔터를 입력하지 않은 경우 msg를 찾기위해 계속 뱅뱅 돈다. 그래서 프로그램이 정지해있는 상태가 된다.
				bw.flush();// 버퍼 비우기. 비퍼를 비워줘야 다음 데이터가 들어갈 수 있다.
				
				//서버로부터 받는 쪽
				line = br.readLine(); // 서버로 오는 메세지 읽기
				System.out.println(line);//콘솔화면에 출력

				String[] ar = msg.split(":");//ex) 서버로 보낸 값 "100:angel"  서버에서 받은 값 "100님 입장"
				//split으로 분리하여 " " 안에 들어온 값을 기준으로 배열로 나눠버린다.
				//그래서 : 를 기준으로 "100:angel"을 나누면 ar[0]에 100 ar[1]에 angel 을 저장한다.
				
				//100:angel - angel님 입장
				//200:angel - angel님 퇴장
				//300:angel:안녕 - [angle] 안녕
				if(ar[0].equals(Protocol.EXIT)) {
					//문자를 보내고 나면 메모리를 다 사용했으므로 close 시켜 준다.
					
					br.close();
					bw.close();
					socket.close();
					
					keyboard.close();
					
					System.exit(0);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
			
		}//while
	}//ProtocolClient
	
	public static void main(String[] args) {
		new ProtocolClient();
	}

}
