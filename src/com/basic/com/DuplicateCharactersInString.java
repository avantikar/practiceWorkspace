package com.basic.com;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
 * Nov 07, 2017 
 */

/*
 * Write a program to find out duplicate or repeated characters in a
   string, and calculate the count of repeatation.
 */

public class DuplicateCharactersInString {

	public void findDuplicateCharacters(String str){
		
		Map<Character, Integer> dup = new HashMap<Character, Integer>();
		
		char[] chars = str.toCharArray();
		for(Character ch: chars){
			if(dup.containsKey(ch)){
				dup.put(ch, dup.get(ch)+1);
			}else{
				dup.put(ch, 1);
			}
		}
		
		Set<Character> dupKeysSet = dup.keySet();
		for(Character chS: dupKeysSet){
			if(dup.get(chS) > 1){
				System.out.println("Character: " + chS + "----> " + dup.get(chS));
			}
		}
	}
	
	public static void main(String[] args) {
		DuplicateCharactersInString duplicateCharacters = new DuplicateCharactersInString();
		duplicateCharacters.findDuplicateCharacters("AvantikaSathaye");
	}
}
