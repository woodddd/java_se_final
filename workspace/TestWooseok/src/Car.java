
public class Car {
	
	private String color;
	private String size;
	private int wheelEA;
	private int cc;
	private boolean ox;
	
//	Car(int wheelEA,int cc){
//		this.wheelEA = wheelEA;
//		this.cc = cc;
//	}
	
	
	public boolean getOx() {
		return ox;
	}
	public String getColor() {
		return color;
	}
	
	public int getWheelEA() {
		return wheelEA;
	}

	public void setWheelEA(int wheelEA) {
		this.wheelEA = wheelEA;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}
	
	

	public int speed() {
		return wheelEA * cc;
	}
	
	public static void main(String[] args) {
		//Car bmw = new Car();
//		bmw.wheelEA=4;
//		bmw.cc=3000;
//		
//		
//		System.out.println(bmw.speed());
		
	}

}
