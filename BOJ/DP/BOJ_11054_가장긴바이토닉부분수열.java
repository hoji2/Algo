import java.util.Arrays;
import java.util.Scanner;

public class BOJ_11054_가장긴바이토닉부분수열 {

	static Scanner sc=new Scanner(System.in);
	static int n;
	static int[]map, dp;
	
	public static void main(String[] args) {

		n=sc.nextInt();
		map=new int[n+1];
		dp=new int[n+1];
		for (int i = 1; i <=n; i++) {
			map[i]=sc.nextInt();
			//증가, 감소 두번의 루프를 도는 동안 겹치는 경우가 있으므로 -1로 초기값 세팅
			dp[i]=-1;
		}
		
		solve();
	}
	
	public static void solve() {
		int []tmp1=new int[n+1];
		int []tmp2=new int[n+1];
		
		for (int i = 1; i <=n; i++) {
			tmp1[i]=1;
			for (int j = 1; j <=i; j++) {
				if(map[i]>map[j])
					tmp1[i]=Math.max(tmp1[i], tmp1[j]+1);
			}
		}
		
		for (int i = n; i >=1; i--) {
			tmp2[i]=1;
			for (int j = n; j >=i; j--) {
				if(map[i]>map[j])
					tmp2[i]=Math.max(tmp2[i], tmp2[j]+1);
			}
		}

		for (int i = 1; i <=n; i++) {
			dp[i]+=tmp1[i]+tmp2[i];
		}
		Arrays.sort(dp);
		System.out.println(dp[n]);
		
	}
	
	
}
