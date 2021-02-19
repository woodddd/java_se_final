package day0916;


// 클래스 배열
public class CarEx03Array {
	final static int SIZE = 3;
	public static void main(String[] args) {
		
		Car[] carArray = new Car[SIZE];
		for(int i = 0; i < carArray.length; i++) {
			//클래스의 배열은 배열 생성과 초기화 이후에
			//각 위치마다 우리가 생성자를 호출해서
			//해당 인덱스에 초기화를 해 주어야 한다.
			//하지 않으면NullPointerException에러가 발생한다.
			carArray[i] = new Car();
			carArray[i].setNumber("00가 000" + i);
			carArray[i].setType("소나타");
			carArray[i].setYear(2020);;
			carArray[i].setPrice(7000000);
			carArray[i].setColor("노란색");
		}
		
		for(int i = 0; i< carArray.length; i++) {
			System.out.println(carArray[i]);
		}
	}

}
