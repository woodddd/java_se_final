package collection;

import java.util.LinkedList;
import static java.lang.System.out;

public class QueueTest {

	
	//Queue 특징 : FIFO
	public static void main(String[] args) {
		String[] item = {"소나타","렉스톤","제규어"};
		LinkedList<String> q = new LinkedList<String>();
		
		for(String n : item)
			q.offer(n); //offer 은 요소를 추가하는 역할 
		
		out.println("q의 크기: " + q.size() + "\n");
		String data = "";
		while( (data = q.poll()) != null) { //poll 은 데이터를 꺼내오는 역할을 함
			out.println(data + "삭제!");
			out.println("q의 크기 : " + q.size() + "\n");
		}//while
	}
	
}
