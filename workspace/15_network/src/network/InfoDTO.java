package network;

import java.io.Serializable;

enum Info{
	JOIN, EXIT, SEND
//	닉네임, 종료  , 메세지
}

//BufferedReader, PrintWriter 사용x
//객체(InfoDTO)로 데이터를 넘기고 받고
//ObjectInputStream, ObjectOutputStream을 써야한다.
public class InfoDTO implements Serializable {
	private String nickName;
	private String message;
	private Info command;
	
	
	public String getNickName() {
		return nickName;
	}
	public String getMessage() {
		return message;
	}
	public Info getCommand() {
		return command;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setCommand(Info command) {
		this.command = command;
	}

	
	
}
