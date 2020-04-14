import java.util.Scanner;

public class BOJ_15988_123더하기3 {

	static Scanner sc=new Scanner(System.in);
	static long[]dp=new long[1000001];
	
	public static void main(String[] args) {
		
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		
		for (int i = 4; i <=1000000; i++) {
			long tmp=(dp[i-1]+dp[i-2]+dp[i-3])%1000000009;
			dp[i]=tmp;
		}
		
		int tc=sc.nextInt();
		for (int i = 0; i < tc; i++) {
			System.out.println(dp[sc.nextInt()]);
		}
	}
}
