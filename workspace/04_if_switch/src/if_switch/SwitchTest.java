package if_switch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwitchTest {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int days = 0;
		System.out.println("원하는 월 입력 : ");
		int month = Integer.parseInt(br.readLine());
		
		switch(month) {
		case 1 : 
		case 3 :
		case 5 :
		case 7 :
		case 8 :
		case 10 :
		case 12 : days = 31;
		//문장이 위에서 아래로 내려오는걸 이용하는 문. 
		break; // switch를 벗어나라
		
		case 2 : days = 28;
		break;
		
		case 4 :
		case 6 :
		case 9 :
		case 11 : days = 30;
		break;
		
		default : days = 0; // 1,2,3,4 가 아닌 경우 기본값을 0으로 줘라.
		}
		
		System.out.println(month + "월은" + days + "일 까지 입니다.");
		
	}

}
