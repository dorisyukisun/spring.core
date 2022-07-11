package com.spring.core.session02;

import java.util.Random;

public class Lotto {
	private int number;
	
	public Lotto() {
		Random random = new Random();
		number = random.nextInt(100)+1;//1-100
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Lotto [number=" + number + "]";
	}
	
}
