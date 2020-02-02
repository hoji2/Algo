import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1931_회의실배정 {

	//https://red-pulse.tistory.com/94
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int n,res;
	static int[][]dp;
	
	public static void main(String[] args) throws IOException {
	
		n=stoi(br.readLine());
		dp=new int[n][2];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			dp[i][0]=stoi(st.nextToken());
			dp[i][1]=stoi(st.nextToken());
		}
		
		Arrays.sort(dp, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1])
					return o1[0]-o2[0];
				
				return o1[1]-o2[1];
			}
		});
		
		solve();
		System.out.println(res);
		
	}
	
	public static void solve() {
		
		// 조건 중요
		int cur=0;
		
		for (int i = 0; i < n; i++) {
			if(cur<=dp[i][0]) {
				cur=dp[i][1];
				res++;
			}
		}
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
