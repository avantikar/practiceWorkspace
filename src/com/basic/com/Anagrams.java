package com.basic.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 * Two strings are called anagrams if they contain same set of characters but in different order. 
 * For example, “Dormitory – Dirty Room”, “keep – peek”,  “School Master – The Classroom” are some anagrams.
 */
public class Anagrams {
	
	public static void main(String[] args) {
		//checkAnagrams("keep", "peek");
		String[] questionArray = {"cat","dog","ogd","act","tca","ofg", "cat", "bde", "bed"};
		//String[] questionArray = {};
		anagramPairs(questionArray);
	}
	
	public static void checkAnagrams(String str1, String str2){
		// Clean the strings and convert into lower case:
		String newStr1 = str1.replaceAll("\\s", "");
		String newStr2 = str2.replaceAll("\\s", "");
		
		newStr1 = newStr1.toLowerCase();
		newStr2 = newStr2.toLowerCase();
		
		// Convert the strings into character arrays and sort and compare using Arrays.sort and Arrays.equals.
		char[] str1ch = newStr1.toCharArray();
		char[] str2ch = newStr2.toCharArray();
		
		Arrays.sort(str1ch);
		Arrays.sort(str2ch);
		
		if(Arrays.equals(str1ch, str2ch)){
			System.out.println("The two strings are anagrams of each other");
		}
		else{
			System.out.println("No anagrams found");
		}
		
	}
	
	public static void anagramPairs(String[] strr){
		
		if(strr == null || strr.length == 0){
			System.out.println("No array provided!!");
			return;
		}
		
		
		
		Set<String> questionSet = new HashSet<String>();
		Collections.addAll(questionSet, strr);
		
		List<String> outputList = new ArrayList<String>();
		Map<String, List<String>> sortedEntries = new HashMap<String, List<String>>();
		
		
		for(String word: strr){
			char[] chars = word.toCharArray();
			Arrays.sort(chars);
			String sortedWord = new String(chars); // this becomes your key.
			
			List<String> valueList = sortedEntries.get(sortedWord);
			if (valueList==null) {
				valueList = new ArrayList<String>();
			}
			valueList.add(word);
			sortedEntries.put(sortedWord, valueList);
		}
		
		System.out.println("Size of sortedEntries map: " + sortedEntries.size());
		for (Map.Entry<String,List<String>> entry : sortedEntries.entrySet()) 
            System.out.println("Key = " + entry.getKey() +
                             ", Value = " + entry.getValue());
	}
}
