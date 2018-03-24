package practice;

public class largestContinousSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sum();
	}
	public static void sum() {
		int[] arr = new int[] {0,4,-2,5,-9,3,9};
		int max=Integer.MIN_VALUE;
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			if(max<sum)
				max=sum;
			if(sum<0)
				sum=0;
		}
		System.out.println(sum);
	}

}
