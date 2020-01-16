import java.util.Scanner;
//https://fbtmdwhd33.tistory.com/80
public class BOJ_2225_합분해 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		int k=sc.nextInt();
		
		long[][]dp=new long[n+1][k+1];
		
		for (int i = 0; i <=n; i++) {
			dp[i][1]=1;
		}
		
		for (int i = 1; i <=k; i++) {
			dp[0][i]=1;
		}
		
		for (int i = 1; i <=n; i++) {
			for (int j = 2; j <=k; j++) {
				for (int x = 0; x <=i; x++) {
					dp[i][j]+=dp[i-x][j-1]%1000000000;
				}
				dp[i][j]%=1000000000;
			}
		}
		System.out.println(dp[n][k]);
	}
}
