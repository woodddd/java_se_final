package Test;

public class ArrayTest {
	
	public static void main(String[] args) {
		int[] scores =  { 95,71,84,93,87};
		
		int sum = 0;
		for(int score : scores) {
			sum = sum + score;
		}
		
		//���� for ��
		
		//1 .scores �� ó�� ���� �ִ��� Ȯ���Ѵ�. ������ �׸��� ���ٸ� for���� ������.
		//2. ���� ������ �׸��� �ִٸ�, ���� ������ int score�� ���� �ִ´�.
		//3. ó�� ���� �� ���� �����ϰ�
		//4. ���� ������ �ݺ��Ͽ� scores �� ���� �ҷ��� ���� ���� �� ���� ���� ������ �ݺ��Ѵ�.
		System.out.println("���� ����  = " + sum);
		
		double avg = (double) sum / scores.length;
		System.out.println("���� ��� = " + avg);
		
		
	}
}
