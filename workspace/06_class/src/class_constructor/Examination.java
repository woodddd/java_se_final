package class_constructor;

import java.util.Scanner;

public class Examination {
	
	
	private String name;
	private String dap;
	private char[] ox;
	private int score;
	private static final String JUNG = "11111"; // ����
	
	public Examination() {
		
		Scanner scan = new Scanner(System.in); // in <- InputStream Ÿ��. (Ű����κ��� �Է��� ���´�.)
		
		System.out.print("�̸� �Է� : ");
		name = scan.next();
		
		System.out.print("�� �Է� : ");
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
