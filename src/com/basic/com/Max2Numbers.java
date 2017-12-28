package com.basic.com;

/*
 * Nov 3, 3017 
 */

public class Max2Numbers {

	public static void main(String[] args) {
		int[] p = {5,34,78,2,45,1,99,23};
		max2Numbers(p);
	}
	
	public static void max2Numbers(int a[]){
		int maxOne = 0;
		int maxTwo = 0;
		
		for(int n: a){
			if(maxOne < n){
				maxTwo = maxOne;
				maxOne = n;
			}else if(maxTwo < n){
				maxTwo = n;
			}
		}
		System.out.println("Max One: " + maxOne);
		System.out.println("Max Two: " + maxTwo);
	}
}
