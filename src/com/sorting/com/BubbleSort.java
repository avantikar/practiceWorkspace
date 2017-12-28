package com.sorting.com;
/*
 * Nov 2, 2017
 */
public class BubbleSort {

	public static void main(String[] args) {
		int x[] = {12, 9, 4, 99, 120, 1, 3, 10};
		bubbleSort(x);
		for(int i  = 0; i < x.length; i++){
			System.out.print(x[i] + " ");
		}
	}
	
	public static void bubbleSort(int x[]){
		int i, j, n;
		n = x.length;
		for(i = 0; i < n; i++){
			for(j = 1; j < (n-i); j++){
				if(x[j-1] > x[j]){
					int t = x[j-1];
					x[j-1] = x[j];
					x[j] = t;
				}
			}
		}
	}
}
