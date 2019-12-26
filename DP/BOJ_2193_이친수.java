import java.util.Scanner;

public class BOJ_2193_이친수 {

	/*
	 * 1: 1 (1)
	 * 2: 1 (10)
	 * 3: 2 (100,101)
	 * 4: 3 (1000, 1001,1010)
	 * 5: 5 (10000, 10001, 10010, 10100, 10101)
	 */
	static Scanner sc=new Scanner(System.in);
	static long[]dp=new long[91];
	public static void main(String[] args) {
	
		dp[1]=dp[2]=1;
		
		for (int i = 3; i <=90; i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		
		System.out.println(dp[sc.nextInt()]);
	}
}
