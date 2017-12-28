package com.sorting.com;

/*
 * Nov 4, 2017
 */

public class InsertionSort {
	public static void main(String[] args) {
		int[] a = {12,9,4,99,120,1,3,10};
		insertionSort(a);
		for(int i =0; i < a.length; i++){
			System.out.print(a[i] + " ");
		}
 	}
	
	public static void insertionSort(int[] a){
		for(int i =1 ; i < a.length; i++){
			int b = a[i];
			int j = i;
			
			while((j > 0) && (a[j-1] > b)){
				a[j] = a[j-1];
				j--;
			}
			
			a[j] = b;
		}
	}
}
