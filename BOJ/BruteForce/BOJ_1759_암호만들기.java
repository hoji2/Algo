import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1759_암호만들기{

	static Scanner sc=new Scanner(System.in);
	static int r,n;
	static char[]arr, dp;
	
	public static void main(String[] args) {
	
		r=sc.nextInt();
		n=sc.nextInt();
		
		arr=new char[n+1];
		dp=new char[n+1];
		
		StringBuilder sb=new StringBuilder();
		sb.append('1');
		for (int i = 0; i < n; i++) {
			sb.append(sc.next());
		}
		arr=sb.toString().toCharArray();
		
	
		Arrays.sort(arr);
		// idx 0 버림
		solve(1,0);
	}
	
	public static void solve(int st, int cnt) {
		if(cnt==r) {
			valid(cnt);
			return;
		}
		
		for (int i = st; i <=n; i++) {
			dp[++cnt]=arr[i];
			solve(i+1, cnt);
			dp[cnt--]='1';
		}
	}
	
	public static void valid(int cnt) {
		int a=0;
		int b=0;
		
		for (int i = 1; i <=cnt; i++) {
			// 증가여부 파악
			if(i<cnt)
				if(dp[i+1]<dp[i])
					return;
			
			if(dp[i]=='a' || dp[i]=='i' || dp[i]=='e' || dp[i]=='o' || dp[i]=='u')
				a++;
			else
				b++;
		}
		
		if(a>=1 && b>=2) {
			for (int i = 1; i <=cnt; i++) {
				System.out.print(dp[i]);
			}System.out.println();
		}
		return;
	}
}
