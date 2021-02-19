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
			System.out.println("비트게시판");
			System.out.println("1. 로그인 2. 회원가입 3. 종료");
			int choice = InputUtil.validateInt(1,3);
			if(choice ==1) {
				logInUser = logIn();
				while(logInUser == null) {
					System.out.println("잘못된 ID 혹은 PW 입니다.");
					logInUser = logIn();
				}
				System.out.println("로그인 성공");
				System.out.println(logInUser.getNickname() + "님, 환영합니다!");
				boardViewer.setLogInUser(logInUser);
				showMenu();
			}else if(choice == 2) {
				register();
			}else if(choice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				break;
			}
		}
	}
	
	private void showMenu() throws IOException{
		while(true) {
		System.out.println("1. 글쓰기 2. 목록보기 3. 로그아웃");
			int userChoice = InputUtil.validateInt(1,3);
			if(userChoice == 1) {
				//글 쓰기 메소드 호출
				boardViewer.writeBoard();
			}else if(userChoice == 2) {
				//글 목록보기 메소드 호출
				boardViewer.selectAll();
			}else if(userChoice == 3) {
				System.out.println("사용해주셔서 감사합니다.");
				logInUser = null;
				break;
			}
		}
	}
	
	private void register() throws IOException{
		UserDTO u = new UserDTO();
		u.setId(id);
		id ++;
		System.out.print("회원 id: ");
		u.setUserId(bufferedReader.readLine());
		while(userController.isDuplivatedUserId(u.getUserId())) {
			System.out.println("중복된 id입니다.");
			System.out.print("회원 id: ");
			u.setUserId(bufferedReader.readLine());
		}
		System.out.print("회원 pw: ");
		u.setPassword(bufferedReader.readLine());
		System.out.print("회원 닉네임: ");
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
