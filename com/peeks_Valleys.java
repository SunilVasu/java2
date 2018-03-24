package com;

import java.util.Arrays;

/**
 * Created by sunil on 11/8/17.
 */
public class peeks_Valleys {
    public static void main(String[] args){
        peeks_Valleys pv = new peeks_Valleys();
        int[] arr = new int[]{0,1,4,7,8,9};

        System.out.print("Input:: ");
        for(int i=0; i<arr.length;i++)
            System.out.print(arr[i]+" ");

        System.out.print("\nSort Result::  ");
        pv.sort(arr);

        System.out.print("\nSort2 Result:: ");
        pv.sort2(arr);
    }
    // Sort method 1::
    //peek_valley generation after sorting the array
    public void sort(int[] arr){
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i+=2)
        {
            int temp = arr[i];
            arr[i] = arr[i-1];
            arr[i-1] = temp;
        }
        for(int i=0; i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }
    // Sort method 2::
    // peek & valley generation without sort function
    public static void sort2(int[] arr) {
    	for(int i=1;i<arr.length;i++) {
    		int biggestIndex = biggestIndex(arr, i-1, i, i+1);
    		if(i!=biggestIndex) {
    			int temp = arr[i];
    			arr[i] = arr[biggestIndex];
    			arr[biggestIndex] = temp;
    		}
    	}

    	for(int n:arr)
    		System.out.print(n+" ");
    }
    //return the Index which has the biggest value
    public static int biggestIndex(int[] arr, int a, int b, int c) {
    	int aVal = a>=0 && a<arr.length ? arr[a] : Integer.MIN_VALUE;
    	int bVal = b>=0 && b<arr.length ? arr[b] : Integer.MIN_VALUE;
    	int cVal = c>=0 && c<arr.length ? arr[c] : Integer.MIN_VALUE;
    	int max = Math.max(Math.max(aVal, bVal), cVal);
    	if(max==aVal) return a;
    	else if(max==bVal) return b;
    	else return c;
    }
}
