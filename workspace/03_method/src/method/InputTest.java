package method;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputTest {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader - 버퍼에서 값을 읽어옴 
		//InputStreamReader(System.in) - (System.in)키보드 에서 값을 읽어옴
		System.out.print("정수 a : ");
		int a = Integer.parseInt(br.readLine());// readLine --- 엔터를 친 곳 까지 (한줄) String 문자열로 받음
		System.out.print("실수 b : ");
		double b = Double.parseDouble(br.readLine());
		
		System.out.println(a + " + " + b + " = " + (a + b));
		
	}
}
 