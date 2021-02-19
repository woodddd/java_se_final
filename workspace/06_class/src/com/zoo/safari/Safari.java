package com.zoo.safari;

import com.zoo.Zoo;
public class Safari extends Zoo {

	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		zoo.tiger(); 
//		zoo.giraffe(); // 부모클래스로 생성자를 실행하였고, 부모클래스는 자기 자신밖에 모름.
		// 그러기 때문에 protected인 giraffe 또한 참조할 수가 없는것임.
		//반드시 자식 클래스로 생성하여야 한다.
//		zoo.elephant();
//		zoo.lion();
		System.out.println();
		
		Safari safari = new Safari();
		safari.tiger();
		safari.giraffe();
//		safari.elephant();
//		safari.lion();
		
	}

}
