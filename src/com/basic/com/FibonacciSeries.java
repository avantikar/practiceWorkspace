package com.basic.com;

/*
 * Nov 08, 2017 
 */

public class FibonacciSeries {

	public static void fibonacciSeries(int n){
		int febCount = n;
		int[] feb = new int[febCount];
		feb[0] = 0;
		feb[1] = 1;
		
		for(int i = 2; i < febCount; i++){
			feb[i] = feb[i-1] + feb[i-2];
 		}
		
		for(int i = 0; i< feb.length; i++){
			System.out.print(feb[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		fibonacciSeries(15);
	}
}
