import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819_차이를최대로 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int[]arr,dp;
	static int n,res;
	static boolean[]visit;
	
	public static void main(String[] args) throws IOException {

		n=stoi(br.readLine());
		arr=new int[n];
		dp=new int[n];
		visit=new boolean[n];
		res=Integer.MIN_VALUE;
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int idx=0;
		while(st.hasMoreTokens())
			arr[idx++]=stoi(st.nextToken());
		
		solve(0);
		System.out.println(res);
	}
	
	public static void solve(int cnt) {
		if(cnt==n) {
			int tmp=0;
			for (int i = 0; i < cnt-1; i++) {
				tmp+=Math.abs(dp[i]-dp[i+1]);
			}
			res=Math.max(res, tmp);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if(!visit[i]) {
				visit[i]=true;
				dp[cnt++]=arr[i];
				solve(cnt);
				cnt--;
				visit[i]=false;
			}
		}
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
