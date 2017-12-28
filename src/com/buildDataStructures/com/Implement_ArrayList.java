package com.buildDataStructures.com;

import java.util.Arrays;

/*
 * Nov 5, 2017
 * 
 * Question: Write a program to implement your own ArrayList class. It should
			 contain add(), get(), remove(), size() methods. Use dynamic array logic.
			 It should increase its size when it reaches threshold.
 * 
 */

/*
 * Arrays.copyOf :
 * 		It copies the specified array, truncating or padding with false (if necessary) 
 * 		so the copy has the specified length. 
 * 		Code: http://www.geeksforgeeks.org/java-util-arrays-copyof-java-examples/
 */

public class Implement_ArrayList {
    
	public static void main(String[] args) {
		Implement_ArrayList myArrayList = new Implement_ArrayList();
		System.out.println("Size - before any additions: " + myArrayList.size());
		
		myArrayList.add(10);
		myArrayList.add(20);
		myArrayList.add(30);
		
		System.out.println("Size - after additions: " + myArrayList.size());
		
		System.out.println("After Remove: " + myArrayList.remove(1));
	}
	
	private Object[] myStore;
	private int actualSize = 0;
	
	public Implement_ArrayList(){
		myStore = new Object[10];
	}
	
	/*
	 * Get: 
	 * Check if the 'index' is less than the actual size (NOT THE ASSIGNED ARRAY LENGTH) of the arrayList,
	 * if not, return array[index]
	 * else, throw : ArrayIndexOutOfBoundsException() 
	 */
	
	public Object get(int index){
		if(index < actualSize){
			return myStore[index];
		}else{
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	/*
	 * Add: 
	 * Check if the difference between actual size and assigned length of the array is less than or equal to 5.
	 * if Yes, increase the size of the arrayList by twice.
	 * Else, assign the given object to the next index of the array 
	 */
		
	public void add(Object obj){
		if(myStore.length - actualSize <= 5){
			increaseArrayListSize();
		}
		myStore[actualSize++] = obj;
	}
	
	/*
	 * IncreaseArrayListSize:
	 * Using Arrays.copyOf increase the arrayList size by twice. 
	 * Array.copyOf(arrayList_name, new length)
	 */
	
	private void increaseArrayListSize(){
		myStore = Arrays.copyOf(myStore, myStore.length * 2);
		System.out.println("New ArrayList length: " + myStore.length);
	}
	
	/*
	 * Remove:
	 * If the index to be removed object at is less than actual array size,then,
	 * store the obj at the index to be removed and then reassign all the further objects to index less than 1.
	 */
	
	public Object remove(int index){
		
		if(index < actualSize){
			Object objToRemove = myStore[index]; 
			myStore[index] = null;
			int temp = index;
			
			while(temp < actualSize){
				myStore[temp] = myStore[temp+1];
				myStore[temp+1] = null;
				temp++;
			}
			actualSize--; //Reduce the actualSize by 1 every time you move the objects backwards by one index. 
			
			return objToRemove;
		}else{
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	public int size(){
		return actualSize;
	}
	
	
}
