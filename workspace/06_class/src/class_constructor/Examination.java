package class_constructor;

import java.util.Scanner;

public class Examination {
	
	
	private String name;
	private String dap;
	private char[] ox;
	private int score;
	private static final String JUNG = "11111"; // 정답
	
	public Examination() {
		
		Scanner scan = new Scanner(System.in); // in <- InputStream 타입. (키보드로부터 입력이 들어온다.)
		
		System.out.print("이름 입력 : ");
		name = scan.next();
		
		System.out.print("답 입력 : ");
		dap = scan.next();
		ox = new char[dap.length()];
	}
	
	public void compare() {
		
		for(int i = 0; i < dap.length() ; i++) {
			if(dap.charAt(i) == JUNG.charAt(i)) {
				ox[i] = 'O';
				
				score += 20; 
			}else {
				ox[i] = 'X';
			}
		}
		
		
	}
	
	//getter
	
	public String getName() {
		return name;
	}
	
	public String getDap() {
		return dap;
	}
	
	public char[] getOx() {
		return ox;
	}
	
	public int getScore() {
		return score;
	}


}
