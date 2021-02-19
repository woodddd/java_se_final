package class_constructor;

public class SalaryDTO {
	
	private String name;
	private String position;
	private int basePay;
	private int benefit;
	private double taxRate;
	private double tax;
	private double salary;
	
	
	public SalaryDTO(String name, String position, int basePay, int benefit) {
		this.name = name;
		this.position = position;
		this.basePay = basePay;
		this.benefit = benefit;
	}
	
	public void calc() {// this. 은 결과를 가시적으로 표기하기 위하여 사용하였음
		
		//세율
		if(basePay <= 2000000) {
			this.taxRate = 0.01;
		}else if(basePay <= 4000000) {
			this.taxRate = 0.02;
		}else {
			this.taxRate = 0.03;
		}
		
		//세금
		this.tax = (basePay + benefit) * taxRate;
		//월급
		this.salary = basePay + benefit - tax;
	}
	
	//게터 메소드
	
	public String getName() {
		return name;
	}
	
	public String getPosition() {
		return position;
	}
	
	public int getBasePay() {
		return basePay;
	}
	
	public int getBenefit() {
		return benefit;
	}
	
	public double getTaxRate() {
		return taxRate;
	}
	
	public double getTax() {
		return tax;
	}
	
	public double getSalary() {
		return salary;
	}
	
}
