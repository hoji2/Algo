import java.util.Arrays;
import java.util.Scanner;

//https://fbtmdwhd33.tistory.com/60
public class BOJ_12865_평범한배낭 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		int max_weight=sc.nextInt();
		
		int[][]info=new int[n+1][2];
		
		for (int i = 1; i <=n; i++) {
			info[i][0]=sc.nextInt();
			info[i][1]=sc.nextInt();
		}
		
		// max_weight까지 넣을 수 있는 모든 경우의수 구하기
		int[][]dp=new int[n+1][max_weight+1];
		
		for (int i = 1; i <=n; i++) {
			for (int j = 0; j <= max_weight; j++) {
				
				dp[i][j]=dp[i-1][j];
				
				if(j<info[i][0]) continue;
				
				int aft=dp[i-1][j-info[i][0]]+info[i][1];
				
				dp[i][j]=Math.max(dp[i][j], aft);
			}
		}
		
		Arrays.sort(dp[n]);
		System.out.println(dp[n][max_weight]);
		
	}
}
