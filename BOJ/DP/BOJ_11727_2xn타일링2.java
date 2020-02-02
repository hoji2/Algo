import java.util.Scanner;

public class BOJ_11727_2xn타일링2 {

	static Scanner sc=new Scanner(System.in);
	static long[]dp;
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		if(n==1)
			System.out.println(1);
		else if(n==2)
			System.out.println(3);
		else {
			dp=new long[n+1];
			dp[1]=1;
			dp[2]=3;
			for (int i = 3; i <=n; i++) {
				dp[i]=(dp[i-2]*2+dp[i-1])%10007;
			}
			System.out.println(dp[n]%10007);
		}
	}
}
