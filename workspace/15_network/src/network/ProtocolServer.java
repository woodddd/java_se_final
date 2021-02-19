package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


//서버와 클라이언트를 사용하려면 항상 서버쪽이 먼저 켜져있어야함.
//그 후 서버 소켓이 실행되어줘야함.
//서버소켓은
//1. 클라이언트의 소켓이 들어올때까지 기다린다.
//2. 낚아채서 클라이언트와 연결할 소켓을 만들어준다. accept() - 낚아채다
public class ProtocolServer {
	private ServerSocket ss;
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	
	public ProtocolServer() {
		try {
			ss = new ServerSocket(9500); // 클라이언트가 들어올 떄 까지 계속 기다림
			System.out.println("서버 준비 완료");
			
			socket = ss.accept();// 낚아챈다. 클라이언트의 소켓과 상호작용할 서버측의 소켓을 만들어 준 것.
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			System.out.println("클라이언트와 연결이 안되었습니다");
			e.printStackTrace();
			System.exit(0);
		}
		
		//-----------------------
		String line;
		
		while(true) {
			//클라이언트로 부터 오는 메세지 읽기
			try {
				line = br.readLine(); // "100:angel","200:angel","300:angel:안녕"
				
				//클라이언트로 보내기
				String[] ar = line.split(":");
				if(ar[0].equals(Protocol.ENTER)) {//line의 : 앞의 값이 100이냐
					bw.write(ar[1] + "님 입장\n");//"angel님 입장" 반드시 \n을 해 주어야 클라이언트에서 다시 받을 수가 있음.
					bw.flush();//버퍼 비우기. 버퍼를 비워줘야 다음 데이터가 들어갈 수 있다.
				}else if(ar[0].equals(Protocol.EXIT)) {
					bw.write(ar[1] + "님 퇴장\n");
					bw.flush();
					
					br.close();
					bw.close();
					socket.close();
					System.exit(0);
				}else if(ar[0].equals(Protocol.SEND_MESSAGE)) {
					bw.write("[" + ar[1] + "] " + ar[2] + "\n"); // 내용을 보낼 때엔 항상 \n이 존재해야한다. 꼭꼭
					bw.flush();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}//while
		
	}
	
	
	public static void main(String[] args) {
		new ProtocolServer();
		
	}
	
}
