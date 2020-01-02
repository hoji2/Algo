import java.util.Arrays;
import java.util.Scanner;

public class BOJ_2156_포도주시식 {

	// cf) 계단오르기와 비교 
	// https://m.blog.naver.com/PostView.nhn?blogId=occidere&logNo=220791788953&proxyReferer=https%3A%2F%2Fwww.google.com%2F
	
	static Scanner sc=new Scanner(System.in);
	static long []map;
	static long []dp;
	static int n;
	
	public static void main(String[] args) {
		
		n=sc.nextInt();
		map=new long[n+1];
		dp=new long[n+1];
		
		for (int i = 1; i <= n; i++) {
			map[i]=sc.nextInt();
		}
		//초기화 조건 중요(문제)
		if(n==1)
			dp[n]=map[1];
		else if(n==2)
			dp[n]=map[1]+map[2];
		else {
			dp[1]=map[1];
			dp[2]=map[1]+map[2];
			for (int i = 3; i <= n; i++) {
				// 총 3가지 조건
				dp[i]=Math.max(dp[i-2]+map[i], dp[i-3]+map[i-1]+map[i]);
				// dp[i-1]조건 중요(무조건 최종점에 도착안해도 되는 조건)
				dp[i]=Math.max(dp[i], dp[i-1]);
			}
		}

		Arrays.sort(dp);
		System.out.println(dp[n]);
	}
}
