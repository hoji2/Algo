package groom;

import java.util.Scanner;

public class 징검다리건너기_dp {

	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		int[]map=new int[n+1];
		int[]dp=new int[n+1];
		
		for (int i = 1; i <= n; i++) {
			map[i]=sc.nextInt();
		}
		
		if(n<=2) {
			System.out.println(0);
		}else {
			dp[1]=map[1];
			dp[2]=map[2];
			dp[3]=map[3];
			
			for (int i = 4; i <=n; i++) {
				dp[i]=map[i]+Math.min(dp[i-1], Math.min(dp[i-2], dp[i-3]));
			}
			
			int res=0;
			
			//마지막 -1, -2, -3 중 최소값
			res=Math.min(dp[n], Math.min(dp[n-1], dp[n-2]));
			System.out.println(res);
		}
	}
}
