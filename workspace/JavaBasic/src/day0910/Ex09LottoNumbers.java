package day0910;

import java.util.Random;

public class Ex09LottoNumbers {
	//로또 번호는 1~45까지 6개의 숫자가 필요하기 때문에
	//상수를 미리 만들어 놓아야함.
			
	//하드코딩
	//하드코딩이란 경직된 코딩 이란 뜻으로써
	//코딩의 난이도는 낮지만 유지보수는 어려워지는 형태의 코딩을
	//하드코딩이라고 한다.

	final static int SIZE = 6;
	final static int MAX = 45;
	public static void main(String[] args) {
		//로또 번호를 저장할 인트배열을 만들어주자
		int[] lottoNumbers = new int[SIZE];
		Random random = new Random();
		
		//for문을 통해서 랜덤 숫자를 배열에 차례대로 넣어보자
		for(int i = 0; i < lottoNumbers.length ; i++) {
			//랜덤 변수의 nextInt() 메소드는
			//괄호안의 최대값을 지정해줄 수 있다.
			//하지만 최대값을 넣어주면
			//0부터 최대값 -1 까지의 숫자가 나오기 때문에
			//만약 1부터 최대값 까지를 뽑아내고 싶으면
			//무조건 결과값에 1을 더해주면 된다.
			
			lottoNumbers[i] = random.nextInt(MAX) + 1;
			//					int 0~44          + 1   --- 1~45 까지표현
		}
		System.out.println("난수 생성 직후");
		for(int i = 0 ; i < lottoNumbers.length ; i++) {
			System.out.println(lottoNumbers[i]);
		}
		
		//여기까지는 우리가 중복값도 제거가 안되어 있고
		//순서도 뒤죽박죽이다.
		//따라서 중복값을 제거해주고
		//새로운 값을 넣어주고
		//그리고 마지막으로 정렬까지 해주어야 한다.
		
		//중복이란?
		//확인하는 두 인덱스가 다르지만
		//해당인덱스에 저장되어있는 값이 같을 떄를 중복이라고 한다.
		
		//예시 : 5 13 5 13 4 8
		// 이 저장되어 있는 인덱스에서
		// 1번째와 3번쨰는 인덱스는 다르지만
		// 저장된 값이 같으므로 중복이다.
		
		// 우리는 이 중 for 문을 사용해서
		// i번쨰와 j 번쨰를 비교해서
		// 만약 i 와 j 가 다르지만
		// i 번쨰와 j 번째의 값이 같다면?
		// 그렇다면 중복이므로
		// i 번쨰에 새로운 값을 넣어준다.
		for(int i = 0; i < SIZE ; i++) {
			for(int j = 0; j < SIZE; j++) {
				//i가 0일 때
				//j 가 0~ 5까지 검사해서
				//같은 값이 있으면
				//i번쨰에 새로운 값을 넣어주고
				//i 를 -1로 초기화해준다.
				// 그 이유는! 
				// i 를 -1 로 초기화 해주고 나서
				//실행되는 명령어는 i++ 이기 떄문에
				//i 는 0이된다.
				//따라서 처음부터 다시 검사가 된다.
				
				//만약 i 와 j는 다르지만
				//lottoNumbers[i] 와 lottoNumbers[j]가 같으면
				//중복이라고 한다.
				
				// 만약 18 5 23 29 45 45
				//라면 i[4] 와 i[5] 의 index 값이 4, 5 로 서로 다르고 값이 같으므로 i 의 값을 임의로 바꿔줌.
				//그 후 j = -1 을 만들어 다음 for 동작의 j++ 를 통해 j 를 0으로 만들어 (그렇게 되면 j for문을 통해 lottoNumber[0] 부터 다시 검색하게됨.)
				//바뀐 lottoNumbers[i] 의 값과 lottoNumbers[j] 의 비교를 통해 바뀐 값이 
				// 이전의 값과 중복이 없는지 다시 비교후 중복되지 않으면 끝을 낸다!
				if(i != j && lottoNumbers[i] == lottoNumbers[j]) {
					lottoNumbers[i] = random.nextInt(MAX) + 1;
					j = -1;
				}
			}
		}
		System.out.println("중복제거 후");
		for(int i = 0; i <lottoNumbers.length;i ++) {
			System.out.println(lottoNumbers[i]);
		}
		
		//정렬을 해보자!
		//정렬의 경우
		//i 번쨰가 i + 1보다 값이 크면 2개의 위치를 바꿔준다.
		
		//18 23 29 5 23 45
		//i = 0 일때
		//lottoNumbers[i];
		//lottoNumbers[i+1];
		
		// int a = 5; 
		// int b = 6; 
		// int temp = a;
		// a = b;
		// b = temp;
		
		for(int i = 0; i< lottoNumbers.length -1; i++) { // lottoNumbers.length -1 을 한 이유는 2개씩 묶어서 값을 비교 하기 떄문에 배열의 길이 -1 만큼 비교해야함
			if(lottoNumbers[i] > lottoNumbers[i+1]) {
				int temp = lottoNumbers[i];
				lottoNumbers[i] = lottoNumbers[i+1];
				lottoNumbers[i+1] = temp;
				i = -1;
			}
		}
		System.out.println("정렬 후");
		for(int i = 0; i < lottoNumbers.length; i++) {
			System.out.println(lottoNumbers[i]);
		}
	}

}
