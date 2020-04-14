import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_11046_팰린드롬2 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int[]dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		int n=Integer.parseInt(br.readLine());
		int[] arr=new int[2*n-1];
		dp=new int[2*n-1];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i+=2) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		solve(arr);
		
		int loop=Integer.parseInt(br.readLine());
		for (int i = 0; i < loop; i++) {
			st=new StringTokenizer(br.readLine());
			check(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1);
		}
		bw.flush();
		bw.close();
	}
	
	private static void check(int a, int b) throws IOException {
		a*=2;
		b*=2;
		
		int mid=(a+b)/2;
		int r=(b-a)/2;
		
		bw.write(dp[mid]>=r ? "1\n":"0\n");
	}
	
	private static void solve(int []arr) {
		
		int r=0,p=0;
		
		for (int i = 0; i < arr.length; i++) {
			
			if(i<=r)
				dp[i]=Math.min(dp[2*p-i],r-i);
			else
				dp[i]=0;
			
			while(i-(dp[i]+1)>=0 && i+dp[i]+1<arr.length && arr[i-(dp[i]+1)]==arr[i+dp[i]+1])
				dp[i]++;
			
			if(r<i+dp[i]) {
				r=i+dp[i];
				p=i;
			}
		}
	}
}
