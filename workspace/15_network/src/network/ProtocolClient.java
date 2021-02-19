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
	private BufferedReader keyboard;//Ű����κ��� �����͸� ������ �� ����.
	
	
	//*	getInputStream() - ������ ���ؼ� InputStream �� ��������.
	//* getOutputStream() - ������ ���ؼ� OutputStream �� ��������.
	//ex) Socket.getOutputStream()
	//����Ÿ�� OutputStream
	
	
	//Ŭ���̾�Ʈ���� ���� ������ �����ϸ� ������ Ŭ���̾�Ʈ���� ���� �ٽ� �����Ѵ�.
	//��űԾ�
	//					Ŭ���̾�Ʈ�� ����									    |			    ������ ����							
	//ProtocalClient.java -------------> buffer -------------> Socket -------------> Socket -------------> buffer -------------> ProtocolServer.java
	public ProtocolClient() {
		try {
			socket = new Socket("192.168.0.22", 9500);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			
			
		} catch (UnknownHostException e) { // ip��ȣ�� ã�� �� ����.
			System.out.println("������ ã�� �� �����ϴ�.");
			e.printStackTrace();
			System.exit(0);

		} catch (IOException e) {
			System.out.println("������ ������ �ȵǾ����ϴ�.");
			e.printStackTrace();
			System.exit(0);
		}
		
		//-------------------------
		String msg, line;
		
		while(true) {
			//������ ������ ��
			try {
				msg = keyboard.readLine();// Ű����� ���� �޼����� �д´� // !!readLine �� ���͸� ���� ����!!
				bw.write(msg + "\n");// ������ ������; // �����ʿ����� readLine���� msg�� �޾Ƽ� �дµ� msg���� ���͸� �Է����� ���� ��� msg�� ã������ ��� ��� ����. �׷��� ���α׷��� �������ִ� ���°� �ȴ�.
				bw.flush();// ���� ����. ���۸� ������ ���� �����Ͱ� �� �� �ִ�.
				
				//�����κ��� �޴� ��
				line = br.readLine(); // ������ ���� �޼��� �б�
				System.out.println(line);//�ܼ�ȭ�鿡 ���

				String[] ar = msg.split(":");//ex) ������ ���� �� "100:angel"  �������� ���� �� "100�� ����"
				//split���� �и��Ͽ� " " �ȿ� ���� ���� �������� �迭�� ����������.
				//�׷��� : �� �������� "100:angel"�� ������ ar[0]�� 100 ar[1]�� angel �� �����Ѵ�.
				
				//100:angel - angel�� ����
				//200:angel - angel�� ����
				//300:angel:�ȳ� - [angle] �ȳ�
				if(ar[0].equals(Protocol.EXIT)) {
					//���ڸ� ������ ���� �޸𸮸� �� ��������Ƿ� close ���� �ش�.
					
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
