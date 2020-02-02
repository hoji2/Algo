import java.util.Scanner;

public class BOJ_1182_부분수열의합 {

	static Scanner sc=new Scanner(System.in);
	static int n, v, res;
	static int[]arr, dp;
	
	public static void main(String[] args) {
	
		n=sc.nextInt();
		v=sc.nextInt();
		
		arr=new int[n+1];
		dp=new int[n+1];

		for (int i = 1; i <= n; i++) {
			arr[i]=sc.nextInt();
		}
		
		for (int i = 1; i <= n; i++) {
			solve(1,0,i);
		}
		System.out.println(res);
	}
	
	public static void solve(int st, int cnt, int many) {
		
		if(cnt==many) {
			check(cnt);
			return;
		}
		
		for (int i = st; i <= n; i++) {
			dp[++cnt]=arr[i];
			solve(i+1,cnt,many);
			// 여기 중요 !! N과M이랑 비교
			dp[cnt--]=0;
		}
		
	}
	
	public static void check(int cnt) {
		int tmp=0;
		
		for (int i = 1; i <=cnt; i++) {
			tmp+=dp[i];
		}
		
		if(tmp==v)
			res++;
		
		return;
	}
}
