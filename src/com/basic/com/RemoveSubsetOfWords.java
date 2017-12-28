package com.basic.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/*
 * You are given two string (like two statements). You have to remove all the words of second string from first string 
 * and print the remaining first string. Please maintain the order of the remaining words from the first string. 
 * You will be only removing the first word, not all occurrence of a word. 
 * Example: Str1 = "A Statement is a Statement", Str2 = "Statement a" 
 * Output: "A is Statement"
 */

public class RemoveSubsetOfWords {
	
	public static void main(String[] args) {
		removeSubset("A Statement is a Statement", "Statement a");
	}

	public static void removeSubset(String original, String subset){
		
		String[] subsetWords = subset.split(" ");
		String[] origWords = original.split(" ");
		
//		for(String word: subsetWords){
//			for(int i = 0; i < origWords.length;i++){
//				if(origWords[i].equals(word)){
//					// set the word in the array to null. to do this, convert your string array to list and then 
//					// 'remove' the word from this list and convert the list back to string array.
//					List<String> strArray = new ArrayList<String>(Arrays.asList(origWords));
//					strArray.remove(origWords[i]);
//					origWords = strArray.toArray(new String[0]);
// 					break;
//				}
//// 					else{
////					finalWords.add(origWords[i]);
////				}
//			}
//		}
		
		List originalList = new ArrayList<>(); 
		Collections.addAll(originalList, origWords);
		for(String word: subsetWords){
			if(originalList.contains(word)){
				originalList.remove(word);
			}
		}

		for(int i = 0; i < originalList.size(); i++){
			System.out.println(originalList.get(i) + " ");
		}
		
		List<Leaf> wordTree = new ArrayList<Leaf>(); // O(n)
		for(String word: origWords){
			Leaf l = new Leaf();
			l.value = word;
			l.visited = false;
			wordTree.add(l);
		}
		
		for(String word: subsetWords){
			if(wordTree.contains(word)){
				int num = wordTree.indexOf(word);
				Leaf l = wordTree.get(num);
				l.visited = true;
			}
		}
		
	}
	
	
}

class Leaf{
	String value;
	boolean visited;
}
