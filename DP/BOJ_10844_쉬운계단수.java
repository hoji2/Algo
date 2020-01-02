import java.util.Scanner;

public class BOJ_10844_쉬운계단수 {

	static Scanner sc=new Scanner(System.in);
	static long[][]dp;
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		// row : 숫자의자리수(1~n) col : 끝자리 오는 숫자(0~9)
		dp=new long[n+1][10];
		
		for (int i = 1; i <=9; i++) {
			dp[1][i]=1;
		}
		
		for (int i = 2; i <=n; i++) {
			for (int j = 0; j < 10; j++) {
				if(j==0)
					dp[i][j]=dp[i-1][j+1]%1000000000;
				else if(j==9)
					dp[i][j]=dp[i-1][j-1]%1000000000;
				else
					dp[i][j]=(dp[i-1][j-1]+dp[i-1][j+1])%1000000000;
			}
		}
		
		long res=0;
		for (int i = 0; i <=9; i++) {
			res+=dp[n][i];
		}
		
		System.out.println(res%1000000000);
		
	}
}
