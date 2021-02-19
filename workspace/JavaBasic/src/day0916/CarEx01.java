package day0916;

import java.text.DecimalFormat;

public class CarEx01 {

	public static void main(String[] args) {

		//Car 객체를 여러개 만들어보자
		Car c1 = new Car();
		Car c2 = new Car();
		Car c3 = new Car();
		
		//c1, c2, c3에 셋터를 이용해서 정보를 입력해보자
		
		c1.setNumber("00가 0000");
		c1.setType("모닝");
		c1.setYear(2019);
		c1.setPrice(5000000);
		c1.setColor("빨간색");
		
		c2.setNumber("11가 1111");
		c2.setType("벤츠");
		c2.setYear(2020);
		c2.setPrice(10000000);
		c2.setColor("은색");
		
		c3.setNumber("22가 2222");
		c3.setType("BMW");
		c3.setYear(2020);
		c3.setPrice(10000000);
		c3.setColor("검은색");
		
		c1.printInfo();
		c2.printInfo();
		c3.printInfo();
		
		
		// 형식주기..ㅎㅎ
		DecimalFormat df = new DecimalFormat("#,###");
		System.out.println(df.format((long)c1.getPrice()));
		
		c3.setNumber("11가 1111");
		c3.setType("벤츠");
		c3.setYear(2020);
		c3.setPrice(10000000);
		c3.setColor("은색");
		
		c2.printInfo();
		c3.printInfo();
		
		//c2와 c3에는 똑같은 정보가 들어가있다.
		//그렇다면 c2.equals(c3)는 어떻게 될까?
		System.out.println("c2.equals(c3) : " + c2.equals(c3));
		System.out.println("c2.equals(abc) : " + c2.equals("abc"));
		System.out.println(c1);
	}

}
