package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ChatHandlerObject extends Thread {
	private Socket socket;
	private List<ChatHandlerObject> list;
	
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	private String nickName;

	
	public ChatHandlerObject(Socket socket,List<ChatHandlerObject> list) throws IOException {
		this.socket = socket;
		this.list = list;
		
		ois = new ObjectInputStream(socket.getInputStream());
		oos = new ObjectOutputStream(socket.getOutputStream());
		
	}

	@Override
	public void run() {
		//�г��� �޴� ��
		
		InfoDTO dto= new InfoDTO();
			
			while(true) {
				//��� Ŭ���̾�Ʈ���� ������
				
				try {
					dto = (InfoDTO)ois.readObject();
					
					if(dto.getCommand() == Info.JOIN) {
						nickName = dto.getNickName();
						
						dto.setMessage(nickName + "�� �����Ͽ����ϴ�.");
						dto.setCommand(Info.SEND);
						
						broadcast(dto);
					}//JOIN
					
					
					if(dto.getCommand() == Info.SEND) {
					
						if(dto.getMessage() == null || dto.getMessage().toLowerCase().equals("quit") || dto.getCommand() == Info.EXIT) {
							break; // while �� ������.
						}
						
						dto.setMessage("[" + nickName + "] " + dto.getMessage());
						dto.setCommand(Info.SEND);
		                broadcast(dto);
						
					}//SEND
					
					
					
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//try catch
				
			}//while
				
			try {
				if(dto.getCommand() == Info.EXIT || dto.getMessage().equals("quit")) {
					
					dto.setMessage("quit");
					dto.setCommand(Info.EXIT);	
					oos.writeObject(dto);
					oos.flush();
					
					list.remove(this);
					dto.setMessage(nickName + "���� �����Ͽ����ϴ�.");
					dto.setCommand(Info.SEND);
					broadcast(dto); 
					
					ois.close();
					oos.close();
					socket.close();
					
				}//EXIT
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}//run()
	
	public void broadcast(InfoDTO dto) {
		for(ChatHandlerObject handler : list) {
			try {
				handler.oos.writeObject(dto);
				oos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
