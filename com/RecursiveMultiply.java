package com;

public class RecursiveMultiply {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 4;
		int b = 10;
		int smaller = a>b?b:a;
		int bigger = a>b?a:b;
		System.out.print(helper(smaller,bigger));
	}
	public static int helper(int smaller, int bigger) {
		if(smaller==0) return 0;
		else if(smaller==1) return bigger;
		
		int s = smaller>>1;
		System.out.print("s:"+s+" smaller:"+smaller+" bigger:"+bigger+"\n");
		int halfprod = helper(s, bigger);
		System.out.print("halfprod:"+halfprod+" s:"+s+" smaller:"+smaller+" bigger:"+bigger+"\n");
		if(smaller%2==0)
			return halfprod+halfprod;
		else
			return halfprod+halfprod+bigger;
	}
}
