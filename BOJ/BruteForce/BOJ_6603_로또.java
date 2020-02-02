import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_6603_로또 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int n;
	static int[]arr,dp;
	static boolean[]visit;
	
	public static void main(String[] args) throws IOException {
	
		while(true) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			n=stoi(st.nextToken());
			if(n==0)
				break;
			
			arr=new int[n];
			dp=new int[n];
			visit=new boolean[n];
			
			for (int i = 0; i < n; i++) {
				arr[i]=stoi(st.nextToken());
			}
			
			solve(0,0);
			bw.write("\n");
			bw.flush();
		}
		bw.close();
	}
	
	public static void solve(int st, int cnt) throws IOException {
		if(cnt==6){
			print(cnt);
			return;
		}
		
		for (int i = st; i < arr.length; i++) {
			if(!visit[i]) {
				visit[i]=true;
				dp[cnt++]=arr[i];
				solve(i,cnt);
				dp[--cnt]=0;
				visit[i]=false;
			}
		}
	}
	
	public static void print(int cnt) throws IOException {
		for (int i = 0; i <cnt; i++) {
			bw.write(dp[i]+" ");
		}
		bw.write("\n");
	}
	
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}
}
