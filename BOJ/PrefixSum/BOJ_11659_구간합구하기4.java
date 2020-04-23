import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11659_구간합구하기4 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int size;
	static int[]map,dp;
	
	public static void main(String[] args) throws IOException {
	
		StringTokenizer st=new StringTokenizer(br.readLine());
		size=Integer.parseInt(st.nextToken());
		int tc=Integer.parseInt(st.nextToken());
		map=new int[size+1];
		dp=new int[size+1];
		
		st=new StringTokenizer(br.readLine());
		for (int i = 1; i <= size; i++) {
			map[i]=Integer.parseInt(st.nextToken());
		}
		
		init();
		
		for (int i = 0; i < tc; i++) {
			st=new StringTokenizer(br.readLine());
			int a1=Integer.parseInt(st.nextToken());
			int a2=Integer.parseInt(st.nextToken());
			// 뺼셈 시 상쇄되는 a1의 값을 추가로 더해줌
			System.out.println(dp[a2]-dp[a1]+map[a1]);
		}
	}
	
	private static void init() {
		int tmp=0;
		for (int i = 1; i <=size; i++) {
			tmp+=map[i];
			dp[i]=tmp;
		}
	}
}
