import java.util.Arrays;
import java.util.Scanner;

public class BOJ_9095_123더하기 {

	static Scanner sc=new Scanner(System.in);
	static int[]dp;
	
	public static void main(String[] args) {
	
		int tc=sc.nextInt();
		dp=new int[12];
		Arrays.fill(dp, -1);
		dp[0]=dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		
		for (int i = 0; i < tc; i++) {
			System.out.println(solve(sc.nextInt()));
		}
	}
	
	public static int solve(int num) {
	
		if(dp[num]!=-1) return dp[num];
		
		return dp[num]=solve(num-1)+solve(num-2)+solve(num-3);

	}
	
}
