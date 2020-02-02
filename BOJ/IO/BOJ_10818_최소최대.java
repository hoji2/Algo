import java.util.Arrays;
import java.util.Scanner;

public class BOJ_10818_최소최대 {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
	
		int n=sc.nextInt();
		int []dp=new int[n];
		
		for (int i = 0; i < n; i++) {
			dp[i]=sc.nextInt();
		}
	
		Arrays.sort(dp);
		
		System.out.println(dp[0]+" "+dp[n-1]);
	}
}
