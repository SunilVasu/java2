package com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class k_multiple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k=4;
		List<Integer> list = allPossibilities(k);
		Collections.sort(list);
		for(int i:list) {
			System.out.println(i+" ");
		}
		System.out.println("\nResult::"+list.get(k));
		
		
		System.out.println("\nOptimized Result::"+getKthNumber(k));
	}
	public static List<Integer> allPossibilities(int k){
		List<Integer> values = new ArrayList<>();
		for(int a=0;a<=k;a++) {
			int powA = (int)Math.pow(3, a);
			for(int b=0;b<=k;b++) {
				int powB = (int)Math.pow(5, b);
				for(int c=0;c<=k;c++) {
					int powC = (int)Math.pow(7, c);
					int val = powA*powB*powC;
					
					if(val==0 || powA==Integer.MAX_VALUE || powB==Integer.MAX_VALUE
							|| powC==Integer.MAX_VALUE)
						val=Integer.MAX_VALUE;
					values.add(val);
				}
			}
		}
		return values;
	}
	public static int getKthNumber(int k) {
		int val=0;
		Queue<Integer> q3 = new LinkedList<>();
		Queue<Integer> q5 = new LinkedList<>();
		Queue<Integer> q7 = new LinkedList<>();
		q3.add(1);
		
		for(int i=0;i<=k;i++) {
			int v3 = q3.size()>0? q3.peek(): Integer.MAX_VALUE;
			int v5 = q5.size()>0? q5.peek(): Integer.MAX_VALUE;
			int v7 = q7.size()>0? q7.peek(): Integer.MAX_VALUE;
			val = Math.min(v3, Math.min(v5, v7));
			if(v3==val) {
				q3.remove();
				q3.add(3*val);
				q5.add(5*val);
				q7.add(7*val);
			}else if(v5==val) {
				q5.remove();
				q5.add(5*val);
				q7.add(7*val);
			}else if(v7==val) {
				q7.remove();
				q7.add(7*val);
			}
		}
		return val;
	}

}
