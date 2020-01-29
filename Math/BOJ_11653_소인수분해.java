import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_11653_소인수분해 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static int size=10000000;
	static boolean[]dp=new boolean[size+1];
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		// false : 소수인것들
		for (int i = 2; i <=size; i++) {
			if(!dp[i])
				for (int j = i+i; j <=size; j+=i) {
					dp[j]=true;
				}
		}
		
		int n=Integer.parseInt(br.readLine());
		
		// 1 일때 아무것도 출력 X
		if(n!=1) {
			solve(n);
			bw.flush();
			bw.close();
		}
	}
	
	public static void solve(int n) throws IOException {
		if(n==0)
			return;
		
		for (int i = 2; i <=n; i++) {
			if(!dp[i] && n%i==0) {
				bw.write(i+"\n");
				solve(n/i);
				return;
			}
		}
	}
}
