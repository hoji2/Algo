import java.util.Arrays;
import java.util.Scanner;

public class BOJ_1463_1로만들기 {

	static Scanner sc=new Scanner(System.in);
	// 입력 n까지 정보를 저장할 dp배열 
	static int[] dp;
	
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		dp=new int[n+1];
		bottom_up(n);
		
		Arrays.fill(dp, -1);
		dp[0]=dp[1]=0;
		System.out.println(top_down(n));
	}


	// Bottom-up 방식
	public static void bottom_up(int n) {
	
		//dp[0], dp[1]은 0으로 초기값 설정 후 n=2부터 계산
		for (int i = 2; i <=n; i++) {
			
			// CASE 1 : n-1을 만드는 최소횟수 + 1 (제약조건 : 없음)
			dp[i]=dp[i-1]+1;
			
			// CASE 2 : n%2==0을 만드는 최소횟수 + 1 ( 제약조건 : 나누어 떨어지는 경우) 
			// CASE 3 도 마찬가지
			
			if(i%2==0) dp[i]=Math.min(dp[i], dp[i/2]+1);
			if(i%3==0) dp[i]=Math.min(dp[i], dp[i/3]+1);
			
		}
		System.out.println(dp[n]);
	}
	
	public static int top_down(int n) {
		
		// 재귀를 활용
		// 1. 이미 계산된적이 있는 정점이면 저장되어있는 값 리턴
		if(dp[n]!=-1) return dp[n];
		
		int min=Integer.MAX_VALUE;
		
		if(n%2==0) min=Math.min(min, top_down(n/2));
		if(n%3==0) min=Math.min(min, top_down(n/3));
		
		min=Math.min(min, top_down(n-1));
		
		return dp[n]=min+1;
	}
}
