package collection;

import java.util.Deque;
import java.util.Stack;
import static java.lang.System.out;

public class StackTest {

	public static void main(String[] args) {

		String[] groupA = {"우주베키스탄","쿠웨이트","사우디","대한민국"};
		//LIFO(Last In First Out) 마지막에 들어간 것이 제일 먼저 추출이됨. stack의 특성.
		Stack<String> stack = new Stack<String>();
		
		for(int i = 0; i < groupA.length; i++)
			stack.push(groupA[i]);
		while( ! stack.isEmpty() )
			out.println( stack.pop() );
		
		
	}

}
