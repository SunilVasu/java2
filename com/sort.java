package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arr = {"a","aa", "ab", "c"};
		sort obj = new sort();
		obj.string_sort(arr);
		System.out.print("\n");
		int[] nums = new int[] {1, 3, 111, 11};
		obj.nums_sort(nums);
		
	}
	public void nums_sort(int[] nums) {
		Arrays.sort(nums);
		for(int num:nums)
			System.out.print(num+" : ");
		
        List<Integer> list = new ArrayList<>();
        int curr=1;
        
        for(int i=0;i<nums.length;i++){
        	curr=nums[i];
            list.add(curr);
            if(curr*10<=nums[i])
                curr *= 10;
            else if(curr%10 != 9 && curr+1<=nums[i])
                curr++;
            else{
                while((curr/10)%10 == 9)
                    curr /= 10;
                curr = curr/10 + 1;
            }
        }
		for(int num:list)
			System.out.print(num+" : ");

    }
	
	
	public void string_sort(String[] arr) {
		//lexicographically
		boolean didSwap=true;
		while(didSwap) {
			didSwap= false;
			for(int i=0;i<arr.length-1;i++) {
				if(arr[i].compareTo(arr[i+1])> 0) {
					didSwap = true;
					String temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1]=temp;
				}
			}
		}
		
		for(String str:arr)
			System.out.print(str+" : ");
		
		String[] arr2 = {"a","aa", "ab", "c"};
		Arrays.sort(arr2);
		//for(String str:arr2)
		//	System.out.println(str);
	}
}
