import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_14425_문자열집합 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
	
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		HashSet<String> hs=new HashSet<String>();
		for (int i = 0; i < n; i++) {
			hs.add(br.readLine());
		}
		
		int res=0;
		
		for (int i = 0; i < m; i++) {
			if(hs.contains(br.readLine()))
				res++;
		}
		
		System.out.println(res);
		
	}
}
