import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11722_가장긴감소하는부분수열 {

	static Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		int []map=new int[n+1];
		int []dp=new int[n+1];
		
		for (int i = 1; i <=n; i++) {
			map[i]=sc.nextInt();
			dp[i]=1;
		}
		
		for (int i = n; i >=1; i--) {
			for (int j = n; j >=i; j--) {
				if(map[j]<map[i]) {
					dp[i]=Math.max(dp[i], dp[j]+1);
				}
			}
		}
		Arrays.sort(dp);
		System.out.println(dp[n]);
	}
}
