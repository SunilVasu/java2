package com;

public class coinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int ans = coinChange(new int[] {1,2,3}, 10);
			System.out.println(ans);
	}
	public static int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount+1];
		for(int sum=1;sum<=amount;sum++) {
			int min = -1;
			for(int coin:coins) {
				if(sum>=coin && dp[sum-coin]!=-1) {
					int temp = dp[sum-coin]+1;
					min=min<0?temp:temp<min?temp:min;
				}
			}
			dp[sum]=min;
		}
		return dp[amount];
	}

}
