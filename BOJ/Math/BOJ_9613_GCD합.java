package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9613_GCD합 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int[]dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int tc=Integer.parseInt(br.readLine());
		
		for (int i = 0; i < tc; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int n=Integer.parseInt(st.nextToken());
			dp=new int[n];
			
			for (int j = 0; j < n; j++) {
				dp[j]=Integer.parseInt(st.nextToken());
			}
			
			long res=0;
			
			for (int j = 0; j < n; j++) {
				for (int k = j+1; k <n; k++) {
					res+=gcd(j,k);
				}
			}
			
			System.out.println(res);
		}
	}
	
	public static int gcd(int st, int end) {
		
		int a=dp[st];
		int b=dp[end];
		int gcd=0;
		
		while(b>0) {
			gcd=b;
			b=a%b;
			a=gcd;
		}
		
		return gcd;
	}
}
