package io;

import java.io.Serializable;

public class PersonDTO implements Serializable{//객체 직렬화. - 객체 정보를 주고 받을 떄 해당 객체를 직렬화를 해야 한다.
	private String name;
	private int age;
	private double height;
	public PersonDTO(String name, int age, double height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public double getHeight() {
		return height;
	}
	
	
}
