import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11576_BaseConversion {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int a,b;
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		a=Integer.parseInt(st.nextToken());
		b=Integer.parseInt(st.nextToken());
		
		int cnt=Integer.parseInt(br.readLine())-1;
		
		st=new StringTokenizer(br.readLine());
		
		int res=0;
		
		while(st.hasMoreTokens()) {
			res+=Math.pow(a,cnt--)*Integer.parseInt(st.nextToken());
		}
		
		if(res==0)
			System.out.println(0);
		else
			solve(res);
	}
	
	public static void solve(int res) {
		if(res==0)
			return;
		
		solve(res/b);
		System.out.print(res%b+" ");
	}
}
