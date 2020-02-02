import java.util.Arrays;
import java.util.Scanner;

public class BOJ_5014_스타트링크 {

	static Scanner sc=new Scanner(System.in);
	static int f,s,g,u,d,res;
	static int[]dp;
	
	
	public static void main(String[] args) {
	
		f=sc.nextInt();
		s=sc.nextInt();
		g=sc.nextInt();
		u=sc.nextInt();
		d=sc.nextInt();
		res=Integer.MAX_VALUE;
		dp=new int[f+1];
		
		Arrays.fill(dp, -1);
		
		solve(s,0);
		if(dp[g]==-1)
			System.out.println("use the stairs");
		else
			System.out.println(dp[g]);
	}
	
	public static void solve(int cur, int cnt) {
		
		// 방문한 기록이 있으면 현재 cnt와 비교해서 최소값으로 갱신하고 리턴
		if(dp[cur]!=-1) {
			dp[cur]=Math.min(dp[cur], cnt);
			return;
		}
		
		// 방문한 기록이 없으면 현재 cnt가 최초 방문값이된다
		dp[cur]=cnt;
		
		// 다음 방문
		if(cur+u<=f)
			solve(cur+u,cnt+1);
		if(cur-d>=1)
			solve(cur-d,cnt+1);
		
	}
}
