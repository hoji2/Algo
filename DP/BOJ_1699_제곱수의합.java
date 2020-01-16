import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * BOJ#1699 제곱수의 합
 * https://www.acmicpc.net/problem/1699
 */

public class BOJ_1699_제곱수의합 {

	public static void main(String[] args) throws IOException {

		// 그리디 X
		// 반례 : 12 = 2^2 + 2^2 + 2^2 (3) VS 3^2 + 1^1 + 1^1 + 1^1 (4)
		int N;
		int[] dp;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {

			// 1^2 + 1^2 들의 합으로 초기화
			dp[i] = i;
			// 1^2, 2^2 , 3^2 .... 현재수 i 전까지 반복문
			for (int j = 1; j * j <= i; j++) {

				// 점화식 +1은 제곱수의 합 
				// ex) dp[12]=dp[11]+dp[1] (j=1, dp[1]=1)
				//     dp[12]=dp[8]+dp[4] (j=2, dp[4]=1)
				//     dp[12]=dp[3]+dp[9] (j=3, dp[9]=1)
					
				int temp = dp[i - j * j] + 1;
				dp[i] = dp[i] > temp ? temp : dp[i];
			}
		}
		System.out.println(dp[N]);
	}

}

[풀이 2 약간 비효율적]

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1699_제곱수의합 {

	static int[]map, dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		map=new int[n+1];
		dp=new int[n+1];
		dp[1]=1;
		int q=solve(n);
		System.out.println(q);
	}
	
	public static int solve(int n) {
		
		if(dp[n]!=0)
			return dp[n];
		
		double root=Math.sqrt(n);
		
		if(root==(int)root)
			return 1;
		
		int tmp=Integer.MAX_VALUE;
		
		for (int i = 1; i <=(int)root ; i++) {
			double q=Math.pow(i, 2);
			tmp=Math.min(tmp, solve((int)q)+solve((int)(n-q)));
		}
		return dp[n]=tmp;
	}
}