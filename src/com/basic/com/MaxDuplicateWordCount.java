package com.basic.com;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;

/*
 *  Nov 10
 */

/*
 * 	Write a program to read words from a file. Count the 
	repeated or duplicated words. Sort it by maximum repeated or
	duplicated word count.
	
	Covers: Write a program to sort a map by value
 */

public class MaxDuplicateWordCount {
	
	public static void main(String[] args) throws IOException {
		MaxDuplicateWordCount maxWordCount = new MaxDuplicateWordCount();
		maxWordCount.getDuplicateWordsMap("/Users/avantikasathaye/Documents/workspace"
				+ "/practiceWorkspace/PracticeExamples/testData/maxWordCount.txt");
		
		
		
		// Method two :
		Map<String, Integer> wordMap = maxWordCount.getDuplicateWordsMap("/Users/avantikasathaye/Documents/workspace"
				+ "/practiceWorkspace/PracticeExamples/testData/maxWordCount.txt");
		List<Entry<String, Integer>> newList = maxWordCount.sortByValue(wordMap);
		for(Map.Entry<String, Integer> entry: newList){
			System.out.println(entry.getKey() + " ---> " + entry.getValue());
		}
	}

	public Map<String,Integer> getDuplicateWordsMap(String fileName) throws IOException{
		
		Map<String, Integer> wordCount = new HashMap<String, Integer>();
		
		FileInputStream fs = null;
		DataInputStream ds = null;
		BufferedReader br = null;
		
		fs = new FileInputStream(fileName);
		ds = new DataInputStream(fs);
		br = new BufferedReader(new InputStreamReader(ds));
		String line = null;
		
		while((line = br.readLine()) != null){
			StringTokenizer strTokens = new StringTokenizer(line, " ");
			while(strTokens.hasMoreTokens()){
				String token = strTokens.nextToken().toLowerCase();
				if(wordCount.containsKey(token)){
					wordCount.put(token, wordCount.get(token)+1);
				}else{
					wordCount.put(token, 1);
				}
			}
		}
		
		//Count each word occurence :-
		// METHOD ONE: (VERY BASIC) 
		int maxCount = 0;
		String wordOccurredMaxTimes = null;
		for (String word : wordCount.keySet()) {
			if(wordCount.get(word) > 1 && wordCount.get(word) > maxCount){
				System.out.println("Word: " + word + " occurred " + wordCount.get(word) + " times.");
				maxCount = wordCount.get(word);
				wordOccurredMaxTimes = word;
			}
		}
		System.out.println("=============================================");
		System.out.println("Word: '" + wordOccurredMaxTimes + "' occurred " + maxCount + " times.");
		
		return wordCount;
	}
	
		// METHOD TWO: Using Comparator : 
	
		public List<Entry<String, Integer>> sortByValue(Map<String, Integer> countMap){
			
			Set<Entry<String, Integer>> set = countMap.entrySet();
			//Convert the set to list because the Collections.sort() method takes list as arguments and not set!
			List<Entry<String, Integer>> list = new ArrayList<Entry<String,Integer>>(set); 
			Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
			{
				public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
					return o2.getValue().compareTo(o1.getValue());
				}
			}
					);
			return list;
		}
}
