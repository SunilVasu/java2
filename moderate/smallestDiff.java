package moderate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class smallestDiff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		smallestDifference();
		factorialZeros();
		//fibin
		int n=5;
		System.out.println("Fibonacci Series:");
		for(int i=1;i<=n;i++) {
			System.out.println(fibin(i));
		}
		System.out.println("Fibonacci Series:");
		for(int i=1;i<=n;i++) {
			System.out.println(fibinIter(i));
		}
	}
	//Given two arrays of integers, compute the pair of values (one value in each
	//array) with the smallest (non-negative) difference. Return the difference.
	public static void smallestDifference() {
		int[] a = new int[] {3,6,1,9};
		int[] b = new int[] {19, 15, 12, 17};
		Arrays.sort(a);
		Arrays.sort(b);
		int p1=0, p2=0, diff=Integer.MAX_VALUE;
		while(p1<a.length && p2<b.length) {
			if(diff>Math.abs(a[p1]-b[p2]))
				diff=Math.abs(a[p1]-b[p2]);
			else if(a[p1]<b[p2])
				p1++;
			else
				p2++;			
		}
		System.out.println("smallestDifference:"+diff);
	}
	//trailing zeros in factorial
	public static void factorialZeros() {
		int num=5;
		int count=0;
		for(int i=2;i<=num;i++)
			count+=factorsOf5(i);
		//calcu factorial
		int fact=1;
		for(int i=2;i<=num;i++)
			fact*=i;
		System.out.println("Factorial:"+fact);
		System.out.println("Trailing zeros:"+count);
	}
	public static int factorsOf5(int i) {
		int count=0;
		while(i%5==0) {
			count++;
			i/=5;
		}
		return count;
	}
	//Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential.
	//Extra Space: O(n) if we consider the function call stack size, otherwise O(1).
	public static int fibin(int n) {
		if(n==0||n==1) return n;
		return fibin(n-1)+fibin(n-2);
	}
	public static int fibinIter(int n) {
		if(n==0||n==1) return n;
		int a=0, b=1, z=0;
		for(int i=2;i<=n;i++) {
			z=a+b;
			a=b;
			b=z;
		}
		return z;
	}

	
}
