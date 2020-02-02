import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1932_정수삼각형 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int[][]map;
	static int[][]dp;
	static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		n=Integer.parseInt(br.readLine());
		map=new int[n][n];
		dp=new int[n][n];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int idx=0;
			while(st.hasMoreTokens()) 
				map[i][idx++]=Integer.parseInt(st.nextToken());
			
		}
	
		dp[0][0]=map[0][0];
		dp[1][0]=map[0][0]+map[1][0];
		dp[1][1]=map[0][0]+map[1][1];
		solve();

		Arrays.sort(dp[n-1]);
		System.out.println(dp[n-1][n-1]);
	}
	
	public static void solve() {
		for (int i = 2; i <n; i++) {
			for (int j = 0; j <=i; j++) {
				
				if(j==0)
					dp[i][j]=dp[i-1][j]+map[i][j];
				else if(i==j)
					dp[i][j]=dp[i-1][j-1]+map[i][j];
				else
					dp[i][j]=Math.max(dp[i-1][j-1], dp[i-1][j])+map[i][j];
			}
		}
	}
	
	
	
}
