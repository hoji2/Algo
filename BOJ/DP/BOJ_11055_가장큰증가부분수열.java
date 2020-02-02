import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11055_가장큰증가부분수열 {

	static int map[],dp[];
	
	public static void main(String[] args)   {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		map = new int[n+1];
		dp = new int[n+1];
        
		for(int i=1;i<=n;i++) {
			map[i] = sc.nextInt();
			dp[i]=map[i];
		}
		
		for(int i=2;i<=n;i++) { 
			for(int j=1;j<i;j++) { 
				if(map[i]>map[j]) {
					dp[i] = Math.max(dp[i],dp[j]+map[i]);
				}
			}
		}

		Arrays.sort(dp);
		System.out.println(dp[n]);
		
	}
}
