package com.zoo.safari;

import com.zoo.Zoo;
public class Safari extends Zoo {

	public static void main(String[] args) {
		Zoo zoo = new Zoo();
		zoo.tiger(); 
//		zoo.giraffe(); // �θ�Ŭ������ �����ڸ� �����Ͽ���, �θ�Ŭ������ �ڱ� �ڽŹۿ� ��.
		// �׷��� ������ protected�� giraffe ���� ������ ���� ���°���.
		//�ݵ�� �ڽ� Ŭ������ �����Ͽ��� �Ѵ�.
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
