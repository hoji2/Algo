import java.util.Scanner;

public class BOJ_1010_다리놓기 {

	/*
	 * 파스칼의 삼각형 dp배열로 저장
	 */
	static Scanner sc=new Scanner(System.in);
	static int[][]dp=new int[30][30];
	
	public static void main(String[] args) {
	
		for (int i = 0; i < 30; i++) {
			dp[i][0]=1;
			dp[i][i]=1;
		}
		
		for (int i = 2; i < 30; i++) {
			for (int j = 1; j <= i-1; j++) {
				dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
			}
		}
		
		
		int tc=sc.nextInt();
		
		for (int i = 0; i < tc; i++) {
			
			int r=sc.nextInt();
			int n=sc.nextInt();
			
			System.out.println(dp[n][r]);
			
		}
	}
}
