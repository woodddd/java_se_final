package _2;

public class Main {

	public static void main(String[] args) {
		int[] intArr = new int[10];
		
			intArr[0] = 1;
			intArr[1] = 1;
		
			for(int i = 0; i < intArr.length ; i++) {
				if(i >= 2) {
				intArr[i] = intArr[i-1] + intArr[i-2];
				}
				System.out.print(intArr[i] + " ");
			}
		
		
		
		
		
	}

}
