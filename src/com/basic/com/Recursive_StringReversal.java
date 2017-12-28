package com.basic.com;
/*
 * Nov 01, 2017
 */
public class Recursive_StringReversal {

	String reverse = "";
	
	public String reverseString(String str){
		if(str.length() == 1){
			return str;
		}
		else{
			reverse += str.charAt(str.length()-1)
					+ reverseString(str.substring(0, str.length()-1));
			return reverse;
		}
	}
	
	public static void main(String[] args) {
		Recursive_StringReversal reverseStr = new Recursive_StringReversal();
		System.out.println("Result: " + reverseStr.reverseString("AvantikaSathaye"));
	}
	
}
