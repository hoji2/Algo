package swea;
import java.util.Scanner;

public class BOJ_16922_로마숫자만들기 {

	static Scanner sc=new Scanner(System.in);
	static int n,res;
	// 0번 idx 사용 x
	static int[]dp,arr= {0,1,5,10,50};
	static boolean[]visit=new boolean[1001];
	
	public static void main(String[] args) {

		n=sc.nextInt();
		dp=new int[n+1];
		solve(1,0);
		System.out.println(res);
	}
	
	public static void solve(int st, int cnt) {
		if(cnt==n) {
			check();
			return; 
		}
		
		for (int i = st; i <=4; i++) {
			dp[++cnt]=arr[i];
			solve(i,cnt);
			dp[cnt--]=0;
		}
	}
	
	public static void check() {
		
		int tmp=0;
		
		for (int i = 1; i <= n; i++) {
			tmp+=dp[i];
		}
		
		if(!visit[tmp]) {
			visit[tmp]=true;
			res++;
		}
	}
}
