package com.basic.com;

/*
 * Nov 6, 2017 
 */
/*
 * Write a program to convert string to number without using Integer.parseInt() method.
 * => Convert each character to ascii number and form the number. 
 */

public class Convert_StringToNumber {

	public static int convert(String s){
		int sum = 0;
		char chArray[] = s.toCharArray();
		int zeroAscii = (int)'0';
		for(char c : chArray){
			int tempAscii = (int)c;
			sum = (sum*10) + (tempAscii - zeroAscii);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println("\"3256\" converts to : " + convert("3256"));
	}
}
