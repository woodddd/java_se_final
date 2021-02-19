package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;


//������ Ŭ���̾�Ʈ�� ����Ϸ��� �׻� �������� ���� �����־����.
//�� �� ���� ������ ����Ǿ������.
//����������
//1. Ŭ���̾�Ʈ�� ������ ���ö����� ��ٸ���.
//2. ����ä�� Ŭ���̾�Ʈ�� ������ ������ ������ش�. accept() - ����ä��
public class ProtocolServer {
	private ServerSocket ss;
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	
	public ProtocolServer() {
		try {
			ss = new ServerSocket(9500); // Ŭ���̾�Ʈ�� ���� �� ���� ��� ��ٸ�
			System.out.println("���� �غ� �Ϸ�");
			
			socket = ss.accept();// ����æ��. Ŭ���̾�Ʈ�� ���ϰ� ��ȣ�ۿ��� �������� ������ ����� �� ��.
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			System.out.println("Ŭ���̾�Ʈ�� ������ �ȵǾ����ϴ�");
			e.printStackTrace();
			System.exit(0);
		}
		
		//-----------------------
		String line;
		
		while(true) {
			//Ŭ���̾�Ʈ�� ���� ���� �޼��� �б�
			try {
				line = br.readLine(); // "100:angel","200:angel","300:angel:�ȳ�"
				
				//Ŭ���̾�Ʈ�� ������
				String[] ar = line.split(":");
				if(ar[0].equals(Protocol.ENTER)) {//line�� : ���� ���� 100�̳�
					bw.write(ar[1] + "�� ����\n");//"angel�� ����" �ݵ�� \n�� �� �־�� Ŭ���̾�Ʈ���� �ٽ� ���� ���� ����.
					bw.flush();//���� ����. ���۸� ������ ���� �����Ͱ� �� �� �ִ�.
				}else if(ar[0].equals(Protocol.EXIT)) {
					bw.write(ar[1] + "�� ����\n");
					bw.flush();
					
					br.close();
					bw.close();
					socket.close();
					System.exit(0);
				}else if(ar[0].equals(Protocol.SEND_MESSAGE)) {
					bw.write("[" + ar[1] + "] " + ar[2] + "\n"); // ������ ���� ���� �׻� \n�� �����ؾ��Ѵ�. ����
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
