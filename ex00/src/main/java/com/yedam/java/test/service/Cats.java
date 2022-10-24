package com.yedam.java.test.service;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;

@Data
public class Cats {
	private String name;
	private int age;
	private String color;
	
	public void printInfo() {
		System.out.println(this.getName() + ", "
						 + this.getAge() + ", "
						 + this.getColor());
	}
	
	@Autowired
	Cats myCat;
	
	public void printData() {
		System.out.println(myCat.getName() + ", "
						 + myCat.getAge() + ", "
						 + myCat.getColor());
	}
}
