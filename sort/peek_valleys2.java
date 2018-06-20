package sort;

import java.util.Arrays;

public class peek_valleys2 {
	public static void main(String[] args) {
		int[] arr = new int[] {1,9,2,3,4,5};
		generate(arr);
		generate2(arr);
	}
	//Sort1
	public static void generate(int[] arr) {
		Arrays.sort(arr);
		for(int i=1;i<arr.length;i+=2) {
			int temp = arr[i];
			arr[i] = arr[i-1];
			arr[i-1] = temp;
		}
		display(arr, "generate");
	}
	//Sort2
	public static void generate2(int[] arr) {
		for(int i=1;i<arr.length;i++) {
			int biggestIndex = biggestIndex(arr, i-1, i, i+1);
			if(i!=biggestIndex) {
				int temp = arr[i];
				arr[i] = arr[biggestIndex];
				arr[biggestIndex] = temp;
			}
		}
		display(arr,"generate2");
	}
	public static int biggestIndex(int[] arr, int a, int b, int c) {
		int aVal = a>=0 && a<arr.length ? arr[a]:Integer.MIN_VALUE;
		int bVal = b>=0 && b<arr.length ? arr[b]:Integer.MIN_VALUE;
		int cVal = c>=0 && c<arr.length ? arr[c]:Integer.MIN_VALUE;
		int max = Math.max(Math.max(aVal, bVal), cVal);
		if(max==aVal) return a;
		else if(max==bVal) return b;
		else return c;
	}
	
	
	public static void display(int[] arr, String name) {
		System.out.print(name+" : ");
		for(int n:arr)
			System.out.print(n+"-");
		System.out.println();
	}
}
