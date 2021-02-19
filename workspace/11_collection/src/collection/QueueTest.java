package collection;

import java.util.LinkedList;
import static java.lang.System.out;

public class QueueTest {

	
	//Queue Ư¡ : FIFO
	public static void main(String[] args) {
		String[] item = {"�ҳ�Ÿ","������","���Ծ�"};
		LinkedList<String> q = new LinkedList<String>();
		
		for(String n : item)
			q.offer(n); //offer �� ��Ҹ� �߰��ϴ� ���� 
		
		out.println("q�� ũ��: " + q.size() + "\n");
		String data = "";
		while( (data = q.poll()) != null) { //poll �� �����͸� �������� ������ ��
			out.println(data + "����!");
			out.println("q�� ũ�� : " + q.size() + "\n");
		}//while
	}
	
}
