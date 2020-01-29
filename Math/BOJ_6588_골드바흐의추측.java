import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ_6588_골드바흐의추측 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int size=1000000;
	static boolean[]dp=new boolean[size+1];
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		Arrays.fill(dp, true);
		for (int i = 2; i <=size; i++) {
			if(dp[i])
				for (int j = i+i; j <=size; j+=i) {
					dp[j]=false;
				}
		}
		
		while(true) {
			int a=Integer.parseInt(br.readLine());
			if(a==0)
				break;
			
			solve(a);
		}
		bw.flush();
		bw.close();
	}
	
	public static void solve(int a) throws IOException {
		for (int i = 2; i <=size; i++) {
			if(dp[i])
				if(dp[a-i]) {
					bw.write(a+" = "+i+" + "+(a-i)+"\n");
					return;
				}
		}
	}
}
