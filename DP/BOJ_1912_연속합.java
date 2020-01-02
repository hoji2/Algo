import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1912_연속합 {

	static Scanner sc=new Scanner(System.in);
	static long []map;
	static long []dp;
	
	// https://m.blog.naver.com/PostView.nhn?blogId=1ilsang&logNo=221384920352&proxyReferer=https%3A%2F%2Fwww.google.com%2F
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		map=new long[n];
		dp=new long[n];
				
		for (int i = 0; i <n; i++) {
			map[i]=sc.nextInt();
		}
		
		System.out.println(solve(n));
			
	}
	
	public static long solve(int n) {
		if(n==1)
			return map[0];
		
		dp[0]=map[0];
		
		// dp값이 커지다가 작아지는 경우 -> 어차피 이전 최대기록이 dp에 적용되어 있음 + 새로운 시작을 통해 연속조건 초기화
		for (int i = 1; i <n; i++) {
			dp[i]=Math.max(dp[i-1]+map[i], map[i]);
		}
		
		Arrays.sort(dp);
		return dp[n-1];
	}
}
