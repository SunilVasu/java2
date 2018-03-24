package com;

import java.util.Arrays;

public class Sorts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = init();
		//MergeSort
		display(arr, "Input Array::>");
		mergeSort(arr, new int[arr.length], 0, arr.length-1);
		display(arr, "MergeSort::");
		
		//QuickSort
		arr=init();
		quickSort(arr, 0, arr.length-1);
		display(arr, "QuickSort");
		//BubbleSort
		arr=init();
		bubbleSort(arr);
		//SelectionSort
		arr=init();
		selectionSort(arr);
		//InsertionSort
		insertionSort(arr);
		//BucketSort
		bucketSort(arr);
		//Binary Search
		System.out.println("\nBinary Search: "+binarySearch(5));
		arr = new int[] {1,5,8,3,5,7};
		System.out.println("Binary Search Recursion: "+binarySearchRecursion(arr, 0, arr.length, 3));
	}
	public static void mergeSort(int[] arr, int[] helper, int start, int end) {
		if(start>=end) return;
		int mid = (start+end)/2;
		mergeSort(arr, helper, start, mid);
		mergeSort(arr, helper, mid+1, end);
		merge(arr, helper, start, mid, end);
	}
	public static void merge(int[] arr, int[] helper, int start, int mid, int end) {
		for(int i=start;i<=end;i++)
			helper[i]=arr[i];
		int h_left=start, h_right=mid+1, curr=start;
		while(h_left<=mid && h_right<=end) {
			if(helper[h_left]<helper[h_right])
				arr[curr++] = helper[h_left++];
			else
				arr[curr++] = helper[h_right++];
		}
		while(h_left<=mid)
			arr[curr++] = helper[h_left++];
	}
	//QuickSort
	public static void quickSort(int[] arr, int left, int right) {
		if(left>=right) return;
		int index = partition(arr, left, right);
		quickSort(arr, left, index-1);
		quickSort(arr, index, right);
	}
	public static int partition(int[] arr, int left, int right) {
		int pivot = arr[(left+right)/2];
		while(left<=right) {
			while(arr[left]<pivot)
				left++;
			while(arr[right]>pivot)
				right--;
			if(left<=right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				right--;
				left++;
			}
		}
		return left;
	}
	
	

	//Bubble Sort : pair wise comparison and at the end the arr is sorted
	public static void bubbleSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j]<arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	//SelectionSort : select the smallest elem and swap with ith elem
	public static void selectionSort(int[] arr) {
		arr=init();
		for(int i=0;i<arr.length;i++) {
			int index = i;
			for(int j=i+1;j<arr.length;j++) {
				if(arr[index]>arr[j])
					index=j;
			}
			if(index!=i) {
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
			}
		}
		display(arr, "SelectionSort");
	}
	
	//Insertion Sort, select elem and insert into rearrange arr. Shuffling cards
	public static void insertionSort(int[] arr) {
		arr = init();
		for(int i=1;i<arr.length;i++) {
			int key = arr[i];
			int j=i-1;
			while(j>=0 && key<arr[j]) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=key;
		}
		display(arr, "InsertionSort");
	}
	
	//bucketSort	
	public static void bucketSort(int[] arr) {
	   int maxVal=9;
	   arr=init();
	   int[] bucket = new int[maxVal+1];
	   for(int i=0;i<bucket.length;i++)
		   bucket[i]=0;
	   for(int i=0;i<arr.length;i++)
		   bucket[arr[i]]++;
	   
	   int pos=0;
	   for(int i=0;i<bucket.length;i++)
		   for(int j=0;j<bucket[i];j++)
			   arr[pos++]=i;
	   display(arr,"BucketSort");
	}
   //display
	public static void display(int[] arr, String name) {
		System.out.print("\n"+name+"\t");
		for(int n:arr)
			System.out.print(n+" ");
	}
	public static int[] init() {
		return new int[] {9,1,2,7,8,3,4,5};
	}
	
	public static int binarySearch(int x) {
		int[] arr = new int[] {9,1,2,7,8,3,4,5};
		Arrays.sort(arr);
		display(arr, "BinarySearch i/p");
		int start=0, end = arr.length-1;
		int mid;
		while(start<=end) {
			mid = (start+end)/2;
			if(arr[mid]==x)
				return arr[mid];
			else if(arr[mid]>x)
				end=mid-1;
			else 
				start=mid+1;
		}
		return -1;
	}
	
	public static int binarySearchRecursion(int[] arr, int start, int end, int n) {
		
		if(start>end)
			return -1;
		int mid = (start+end)/2;
		if(arr[mid]==n)
			return arr[mid];
		else if(arr[mid]>n)
			return binarySearchRecursion(arr, start, mid-1, n);
		else
			return binarySearchRecursion(arr, mid+1, end, n);
	}
	
}
