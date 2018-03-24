package com;

import java.util.Arrays;

public class peek_valley {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		peek_valley pv = new peek_valley();
		int[] arr = new int[] {0,1,4,7,8,9};
		System.out.print("Input:: ");
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+", ");
		System.out.print("\nSort1:: ");	
		pv.sort1(arr);
		System.out.print("\nSort2:: ");	
		pv.sort2(arr);
	}
	//SORT 1
	public void sort1(int[] arr) {
		Arrays.sort(arr);
		for(int i=1;i<arr.length;i+=2) {
			int temp = arr[i];
			arr[i]=arr[i-1];
			arr[i-1]=temp;
		}
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+", ");	
	}
	// SORT 2
	public void sort2(int[] arr) {
		for(int i=1; i<arr.length;i+=1) {
			int biggestIndex = maxIndex(arr, i-1, i, i+1);
			if(i!=biggestIndex) {
				int temp = arr[i];
				arr[i]=arr[biggestIndex];
				arr[biggestIndex] = temp;
			}
		}
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+", ");	
	}
	public int maxIndex(int[] arr, int a, int b, int c) {
		int aVal = a>=0 && a<arr.length? arr[a] : Integer.MIN_VALUE;
		int bVal = b>=0 && b<arr.length? arr[b] : Integer.MIN_VALUE;
		int cVal = c>=0 && c<arr.length? arr[c] : Integer.MIN_VALUE;
		
		int max = Math.max(aVal, Math.max(bVal, cVal));
		if(max == aVal) return a;
		else if (max == bVal) return b;
		else return c;
	}

}
