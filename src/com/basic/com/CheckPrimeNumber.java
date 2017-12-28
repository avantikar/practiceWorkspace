package com.basic.com;

/*
 * Nov 11
 */

public class CheckPrimeNumber {

	public static void main(String[] args) {
		System.out.println(checkForPrime(4357));
	}
	
	public static boolean checkForPrime(int number){
		for(int i = 2; i < number/2; i++){
			if(number % i == 0){
				return false;
			}
		}
		return true;
	}
}
