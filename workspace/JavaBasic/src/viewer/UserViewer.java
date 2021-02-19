package viewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.UserController;
import model.UserDTO;
import util.InputUtil;

public class UserViewer {
	private UserController userController;
	private BufferedReader bufferedReader;
	private BoardViewer boardViewer;
	private int id;
	private UserDTO logInUser;
	public UserViewer() {
		userController = new UserController();
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		boardViewer = new BoardViewer();
		id = 4;
	}
	
	public void index() throws IOException{
		while(true) {
			System.out.println("��Ʈ�Խ���");
			System.out.println("1. �α��� 2. ȸ������ 3. ����");
			int choice = InputUtil.validateInt(1,3);
			if(choice ==1) {
				logInUser = logIn();
				while(logInUser == null) {
					System.out.println("�߸��� ID Ȥ�� PW �Դϴ�.");
					logInUser = logIn();
				}
				System.out.println("�α��� ����");
				System.out.println(logInUser.getNickname() + "��, ȯ���մϴ�!");
				boardViewer.setLogInUser(logInUser);
				showMenu();
			}else if(choice == 2) {
				register();
			}else if(choice == 3) {
				System.out.println("������ּż� �����մϴ�.");
				break;
			}
		}
	}
	
	private void showMenu() throws IOException{
		while(true) {
		System.out.println("1. �۾��� 2. ��Ϻ��� 3. �α׾ƿ�");
			int userChoice = InputUtil.validateInt(1,3);
			if(userChoice == 1) {
				//�� ���� �޼ҵ� ȣ��
				boardViewer.writeBoard();
			}else if(userChoice == 2) {
				//�� ��Ϻ��� �޼ҵ� ȣ��
				boardViewer.selectAll();
			}else if(userChoice == 3) {
				System.out.println("������ּż� �����մϴ�.");
				logInUser = null;
				break;
			}
		}
	}
	
	private void register() throws IOException{
		UserDTO u = new UserDTO();
		u.setId(id);
		id ++;
		System.out.print("ȸ�� id: ");
		u.setUserId(bufferedReader.readLine());
		while(userController.isDuplivatedUserId(u.getUserId())) {
			System.out.println("�ߺ��� id�Դϴ�.");
			System.out.print("ȸ�� id: ");
			u.setUserId(bufferedReader.readLine());
		}
		System.out.print("ȸ�� pw: ");
		u.setPassword(bufferedReader.readLine());
		System.out.print("ȸ�� �г���: ");
		u.setNickname(bufferedReader.readLine());
		userController.insert(u);
		
	}

	private UserDTO logIn() throws IOException {
		UserDTO attempt = new UserDTO();
		System.out.print("id: ");
		attempt.setUserId(bufferedReader.readLine());
		System.out.print("PW: ");
		attempt.setPassword(bufferedReader.readLine());
		return userController.logIn(attempt);
		
	}
	
}
