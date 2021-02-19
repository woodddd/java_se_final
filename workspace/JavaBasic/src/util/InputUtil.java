package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputUtil {
	//입력과 관련된 메소드

	public static int validateInt(int minimum, int maximum) throws IOException {
		int parsedValue = stringToInt();
		while(parsedValue < minimum || parsedValue > maximum) {
			System.out.println("잘못입력하셨습니다.");
			parsedValue = stringToInt();
		}
		return parsedValue;
	}
	
	public static int stringToInt() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.print("> ");
		String userInput = bufferedReader.readLine();
		while( !userInput.matches("\\d*")) {
			System.out.println("숫자만 입력해주세요.");
			System.out.print("> ");
			userInput = bufferedReader.readLine();
		}
		return Integer.parseInt(userInput);
	}
}
