import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978_소수찾기 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int res=0;
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		br.readLine();
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			solve(Integer.parseInt(st.nextToken()));
		}
		
		System.out.println(res);
	}
	
	public static void solve(int n) {
		if(n<=1)
			return;
		
		for (int i = 2; i <=n; i++) {
			if(n%i==0 && i!=n)
				return;
		}
		res++;
	}
}
