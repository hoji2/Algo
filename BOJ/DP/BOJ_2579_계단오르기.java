import java.util.Scanner;

public class BOJ_2579_계단오르기 {

	static Scanner sc=new Scanner(System.in);
	static int[]dp;
	static int[]stair;
	public static void main(String[] args) {
	
		int n=sc.nextInt();
		dp=new int[n+1];
		stair=new int[n+1];
		
		for (int i = 1; i <=n; i++) {
			stair[i]=sc.nextInt();
		}
		
		dp[1]=stair[1];
		dp[2]=dp[1]+stair[2];
		dp[3]=Math.max(stair[1], stair[2])+stair[3];
		
		System.out.println(solve(n));
	}
	
	public static int solve(int num) {
		
		if(dp[num]!=0) return dp[num];
		
		// 마지막 단계를 기준으로 2칸 전에서 올라오는 상황 vs 1칸 전에서 올라오는 상황(중요 제약조건)
		// 제약 조건 : 1칸 전에서 올라오는 경우는 그 전 상황에서 2칸으로 올라오는  상황이어야함(3번연속 1칸씩 이동 불가능하기 때문)

		return dp[num]=Math.max(solve(num-2)+stair[num],solve(num-3)+stair[num-1]+stair[num]);
	}
	
	
}
