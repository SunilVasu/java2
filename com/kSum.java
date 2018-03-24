package com;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class kSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {1, 0, -1, 0, -2, 2};
		System.out.print("4Sum\n");
		find4Sum(arr, 0);
		//findSum(arr,0);
		System.out.print("\n3Sum\n");
		find3Sum(arr,0);
	}
	
	public static void find4Sum(int[] arr, int a) {
		
		if(arr==null || arr.length<4) return;
		Arrays.sort(arr);
		List<List<Integer>> res = new LinkedList<>();
		for(int i=0;i<arr.length;i++) { // 3ptr-->start[2loop+1ptr]; 1ptr-->end
			if(i>0 && arr[i]==arr[i-1]) continue; //to improve speed; this or while
 			for(int j=i+1;j<arr.length;j++) {
 				if(j>0 && arr[j]==arr[j-1]) continue;
				int p1=j+1;
				int p2=arr.length-1;
				while(p1<p2){
					int sum = arr[i]+arr[j]+arr[p1]+arr[p2];
					if(sum==a) {
						res.add(Arrays.asList(arr[i], arr[j], arr[p1], arr[p2]));	
						//while(p1<p2 && arr[p1]==arr[p1+1]) p1++;
						//while(p1<p2 && arr[p2]==arr[p2-1]) p2--;
						p1++; p2--;
					}else if(sum<a) {
						p1++;
					}else
						p2--;
				}
			}
		}

		for(List<Integer> l:res) {
			for(int k:l)
				System.out.print(k+" ");
			System.out.println();
		}
	}
	public static void findSum(int[] arr, int a) {
		if(arr==null || arr.length<4) System.out.println("No 4Sum");;
		Arrays.sort(arr);
		int[] res = null;
		for(int i=0;i<arr.length;i++) { 
			for(int j=i+1;j<arr.length;j++) {
				int p1=j+1;
				int p2=arr.length-1;
				while(p1<p2) {
					int sum = arr[i]-arr[j]+arr[p1]+arr[p2];
					if(sum==a) {
						res = new int[] {arr[i], arr[j], arr[p1], arr[p2]};
						break;
					}else if(sum<a)
						p1++;
					else
						p2--;
				}
			}
		}
		for(int k:res)
			System.out.print(k+" ");
	}
	public static void find3Sum(int[] arr, int a) { //3pointers = 1loop(start)+2ptr(start+end)
		arr = new int[] {-1, 0, 1, 2, -1, -4};
		if(arr==null || arr.length<3) return;
		Arrays.sort(arr);
		List<List<Integer>> res = new LinkedList<>();
		for(int i=0;i<arr.length;i++) {
			if(i>0 && arr[i]==arr[i-1]) continue;
			int p1=i+1;
			int p2=arr.length-1;
			while(p1<p2) {
				int sum=arr[i]+arr[p1]+arr[p2];
				if(sum==a) {
					res.add(Arrays.asList(arr[i], arr[p1], arr[p2]));
					//while(p1<p2 && arr[p1]==arr[p1+1]) p1++;
					//while(p1<p2 && arr[p2]==arr[p2-1]) p2--;
					p1++; p2--;
				}else if(sum<a) {
					p1++;
				}else
					p2--;
			}
		}
		
		for(List<Integer> l:res) {
			for(int k:l)
				System.out.print(k+" ");
			System.out.println();
		}
	}
}																																																																																																																																																																							
