package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int a, int b) {
		
		if ((a > 0) && (b > 0)) return a + b;
		else throw new IllegalArgumentException("Both parameters must be positive!");
	}
	
	public boolean isPalindrome(String str) {
		String strLowerCased = str.toLowerCase();
		String reverse = "";
		for (int i = strLowerCased.length()-1; i >= 0; i--)
			reverse += strLowerCased.charAt(i);
		
		if (reverse.equals(strLowerCased)) return true;
		else return false;
	}
	
	public int randomNumberSquared() {
		int randomNumber = getRandomInt();
		return (int) Math.pow(randomNumber, 2);
	}

	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}
	
}
