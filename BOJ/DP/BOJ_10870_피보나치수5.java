import java.util.Scanner;

public class BOJ_10870_피보나치수5 {

	static Scanner sc=new Scanner(System.in);
	static final int size=91;
	
	public static void main(String[] args) {
		
		long[]dp=new long[size];
		
		dp[0]=0;
		dp[1]=1;
		dp[2]=1;
		
		for (int i = 3; i <=size-1; i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
		
		System.out.println(dp[sc.nextInt()]);
	}
}
