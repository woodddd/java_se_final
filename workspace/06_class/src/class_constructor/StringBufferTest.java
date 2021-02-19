package class_constructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringBufferTest {

	private int dan;
	
	public StringBufferTest() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("원하는 단 입력: ");
		dan = Integer.parseInt(br.readLine());
	}
	
	public void disp() {
		StringBuffer buffer = new StringBuffer();
		
		for(int i = 1; i < 10 ; i++) {
			//System.out.println(dan + " * " + i + " = " + (dan * i));
			buffer.append(dan); // append 추(가하다.)
			buffer.append("*");
			buffer.append(i);
			buffer.append("=");
			buffer.append(dan*i);
			
			System.out.println(buffer);
			System.out.println(buffer.length()); //buffer.length() 의 삭제 범위 또한 delete(s,e-1)
			buffer.delete(0, buffer.length()); // 이것을 제거하지 않으면 이전 값에 그대로 값이 이어져서 나오게됨.
			//해당 출력이 for 문 안에 있으므로 delete하지 않고 사용 시  다음 포문이 넘어가게 되었을 때, 이전 값뒤에 추가로 값이 나오게됨.
			
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {

		StringBufferTest bt = new StringBufferTest();
		bt.disp();
		
	}

}
