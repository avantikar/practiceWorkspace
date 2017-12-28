package com.basic.com;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

/*
 * Nov 12
 */

public class ReverseWordsInString {

	public static void main(String[] args) {
		//reverseWordsInString("The Sky Is Blue");
		
		reverseEquationString("1+2*3-20");
	}
	
	public static void reverseWordsInString(String str){
		String[] words = str.split(" ");
		String newString = "";
		
		StringBuffer strbuff = new StringBuffer();
		
		for(int i = words.length - 1; i >= 0; i--){
			strbuff.append(words[i] + " ");
		}
		
		newString = strbuff.toString().trim();
		
		System.out.println("New String: " + newString + " .Length of new string: " + newString.length());
	}
	
	/*
	 * Reverse : "1+2*3-20" . Retain '20' as in. The output should be "20-3*2+1"
	 */
	public static String reverseEquationString(String strEquation){
		
		String reversed = "";
		
		// Check the delimiter in the string :-
		boolean spaceDelimiter = false;
		char[] c = strEquation.toCharArray();
		int i = 0 ;
		
		for(char ch : c){
			if(ch == ' '){
				System.out.println("String contains space(s)");
				spaceDelimiter = true;
				break;
			}
		}
		
		if(spaceDelimiter){
			reverseWordsInString(strEquation);
		}else{
			
			StringBuffer buff = new StringBuffer();
			StringBuffer temp = new StringBuffer();
			for(int j = strEquation.length()-1; j >= 0; j--){
				//buff.append(strEquation.charAt(j));
				
				if(Character.isDigit(strEquation.charAt(j))){
					temp.append(strEquation.charAt(j)); 
				}else{
					
					if(temp.length() != 0){
						buff.append(temp.toString().trim());
						buff.append(strEquation.charAt(j));
						temp = new StringBuffer();
					}else{
						buff.append(strEquation.charAt(j));
					}
				}
				// to append last character
				if(j == 0 && temp.length()!=0){
					buff.append(strEquation.charAt(0));
				}
			}
			
			reversed = buff.toString();
		}
		System.out.println("Reversed: " + reversed);
		return reversed;
	}
}
