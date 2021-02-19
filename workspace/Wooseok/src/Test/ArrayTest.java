package Test;

public class ArrayTest {
	
	public static void main(String[] args) {
		int[] scores =  { 95,71,84,93,87};
		
		int sum = 0;
		for(int score : scores) {
			sum = sum + score;
		}
		
		//향상된 for 문
		
		//1 .scores 의 처음 값이 있는지 확인한다. 가져올 항목이 없다면 for문을 나간다.
		//2. 만약 가져올 항목이 있다면, 값을 가져와 int score에 값을 넣는다.
		//3. 처음 값이 들어가 값을 실행하고
		//4. 위의 문장을 반복하여 scores 의 다음 불러올 값이 없을 떄 까지 위의 문장을 반복한다.
		System.out.println("점수 총합  = " + sum);
		
		double avg = (double) sum / scores.length;
		System.out.println("점수 평균 = " + avg);
		
		
	}
}
