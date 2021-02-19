package viewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import controller.BoardController;
import model.BoardDTO;
import model.UserDTO;
import util.InputUtil;

public class BoardViewer {
	private UserDTO logInUser;
	private BufferedReader bufferedReader;
	private BoardController boardController;
	private int boardId;
	
	public BoardViewer() {
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		boardController = new BoardController();
		boardId = 1;
	}
	public void setLogInUser(UserDTO logInUser) {
		this.logInUser = logInUser;
	}
	
	public void writeBoard() throws IOException {
		BoardDTO b = new BoardDTO();
		b.setId(boardId);
		boardId++;
		b.setWriterId(logInUser.getId());
		b.setWriterName(logInUser.getNickname());
		Calendar cal = Calendar.getInstance();
		b.setWrittenDate(cal);
		b.setUpdatedDate(cal);
		
		System.out.print("����: ");
		b.setTitle(bufferedReader.readLine());
		System.out.print("����: ");
		b.setContent(bufferedReader.readLine());

		boardController.add(b);
	}
	public void selectAll() throws IOException{
		ArrayList<BoardDTO> list = boardController.selectAll();
		for(int i = 0; i < list.size(); i++) {
			System.out.printf("%d. %s | %s\n", i+1,list.get(i).getTitle(), list.get(i).getWriterName());
		}
		System.out.println("�󼼺����� ��ȣ�� �Է����ּ���(0�� �ڷ�)");
		int userChoice = InputUtil.validateInt(0, list.size()) - 1;
		if(userChoice == -1) {
			System.out.println("�޴��� ���ư��ϴ�.");
		}else {
			selectOne(userChoice);
		}
	}
	
	public void selectOne(int index) throws IOException{
		BoardDTO b = boardController.selectOne(index);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� M�� d�� H�� m�� s��");
		System.out.println("����: " + b.getTitle());
		System.out.println("�ۼ���: " + b.getWriterName());
		System.out.println("�ۼ���: " + sdf.format(b.getWrittenDate().getTime()));
		System.out.println("������: " + sdf.format(b.getUpdatedDate().getTime()));
		System.out.println("-----------------------------------------");
		System.out.println("����");
		System.out.println("-----------------------------------------");
		System.out.println(b.getContent());
		if(logInUser.getId() == b.getWriterId()) {
			System.out.println("1. ���� 2. ���� 3. �������");
			int userChoice = InputUtil.validateInt(1, 3);
			if(userChoice == 1 ) {
				update(index);
			}else if(userChoice == 2) {
				delete(index);
			}else if(userChoice == 3) {
				selectAll();
			}
		}else {
			System.out.println("1. �������");
			int userChoice = InputUtil.validateInt(1, 1);
			if(userChoice == 1) {
				selectAll();
			}
		}
	}
	
	public void update(int index) throws IOException {
		BoardDTO b = boardController.selectOne(index); 
		Calendar cal = Calendar.getInstance();
		System.out.print("����: ");
		b.setTitle(bufferedReader.readLine());
		System.out.print("����: ");
		b.setContent(bufferedReader.readLine());
		b.setUpdatedDate(cal);
		boardController.update(index, b);
		selectOne(index);
	}
	
	public void delete(int index) throws IOException{
		System.out.println("�ش� ���� ������ �����Ͻðڽ��ϱ�? y/n");
		System.out.print("> ");
		String yn = bufferedReader.readLine().toUpperCase();
		if(yn.equals("Y")) {
			boardController.delete(index);
			selectAll();
		}else {
			selectOne(index);
		}
	}
}
