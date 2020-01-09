import java.util.Scanner;

public class BOJ_2167_2차원배열합 {

	//AUB = A+B-A교B 개념
	static Scanner sc=new Scanner(System.in);
	static int [][]map;
	static int [][]dp;
	public static void main(String[] args) {
		
		int n=sc.nextInt();
		int r=sc.nextInt();
		map=new int[n+1][r+1];
		dp=new int[n+1][r+1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= r; j++) {
				map[i][j]=sc.nextInt();
			}
		}
		
		// n=0 r=0 인 배열에는 defalut 0
		// dp[1][1] 부터 배열 생성 시 영향 無
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= r; j++) {
				dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+map[i][j];
			}
		}
		
		int tc=sc.nextInt();
		for (int p = 0; p < tc; p++) {
			int res=0;
			int i,j,x,y;
			i=sc.nextInt();
			j=sc.nextInt();
			x=sc.nextInt();
			y=sc.nextInt();
			
			res=dp[x][y]-dp[i-1][y]-dp[x][j-1]+dp[i-1][j-1];
			System.out.println(res);
		}
		
	}	
}
