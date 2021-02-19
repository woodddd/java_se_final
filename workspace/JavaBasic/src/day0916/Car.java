package day0916;

public class Car {
	
	//	숙제: Car 클래스를 만들어서 그 클래스 객체를 활용하는 프로그램을 작성해보세요.
	//	Car  클래스의 필드: 차량번호, 차량 종류, 연식, 가격, 색깔
	
	//	메소드: 현재 차량의 정보를 예쁘게 출력하는 메소드, 차량에 대한 파라미터가 있는 생성자와 파라미터가 없는 생성자, 캡슐화
	
	//차량 번호
	private String number; 
	// 차량 종류
	private String type; 
	// 연식
	private int year; 
	// 가격
	private int price; 
	//색상
	private String color; 
	
	
	//메소드
	//차량 정보 출력메소드
	public void printInfo() {
		System.out.printf("차량번호 : %s 차량 종류 : %s\n", number, type);
		System.out.printf("연식 : %d년 가격 : %d원\n ", year, price);
		System.out.printf("색상: %s\n", color);
	}
	
	//파라미터가 없는 생성자
	public Car() {
		number = new String();
		type = new String();
		year = 0;
		price = 0;
		color = new String();
	}
	
	//파라미터가 있는 생성자
	public Car(String number, String type, int year, int price, String color) {
		this.number = number;
		this.type = type;
		this.year = year;
		this.price = price;
		this.color = color;
	}
	
	// 필드에 대한 캡슐화
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	//                     클래스     객체
	public boolean equals(Object obj) {
		//파라미터로 넘어온 객체가 이 equals 메소드를 실행하는 객체와 같은지 비교할려면
		//1. obj가 이 Car 클래스의 객체인지 확인해야한다.
		//2. obj가 Car 클래스의 객체가 맞다면
		//	 필드 중 몇몇 정보를 비교해서 같을때에만
		//   return true 해준다.
		
		//1. obj 가 해당 클래스 객체인지 확인할 떄에는
		//	 instanceof 클래스이름 이란 코드로 확인 가능하다.
		if(obj instanceof Car) {//obj가 Car클래스의 객체인지 확인.
			// 만약 obj 가 Car클래스의 객체라면 True 아니라면 false
			//obj가 Car 클래스의 객체이므로
			//obj를 Car로 형변환 시켜줄 수 있다.
			Car c = (Car)obj;
			if(number.equals(c.number)) {// == 은 객체가 가지고 있는 주소 값을 비교하게 되고, equals 는 객체가 가지고 있는 값을 비교함
			//   number -> c2 객체의 number      c.number -> c3 을 말하게 되는 것임.
				//	equals 메소드를 CarEx01 클래스에서 사용했으므로
			
				return true;
			}
		}
		
		return false;
	}
	
	public String toString() {
		return "차량 번호 : " + number + 
				", 차량 종류 : " + type + 
				", 차량 가격 : " + price + "원, " +
				", 차량 연식 : " + year + "년, " + 
				", 차량 색상 : " + color;
	}
}
