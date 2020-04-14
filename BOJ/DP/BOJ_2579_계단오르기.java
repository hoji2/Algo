import java.util.Scanner;

public class BOJ_2579_계단오르기 {

	static Scanner sc=new Scanner(System.in);
	static int n;
	static int[]dp,map;
	
	public static void main(String[] args) {

		n=sc.nextInt();
		dp=new int[n+1];
		map=new int[n+1];
		
		for (int i = 1; i <=n; i++) {
			map[i]=sc.nextInt();
		}
		
		//n=1
		if(n==1)
			System.out.println(map[1]);
		//n=2
		else if(n==2)
			System.out.println(map[1]+map[2]);
		//n=3 이상일 때
		else {
			dp[1]=map[1];
			dp[2]=map[1]+map[2];
			// 마지막 단계를 기준으로 2칸 전에서 올라오는 상황 vs 1칸 전에서 올라오는 상황(중요 제약조건)
			// 제약 조건 : 1칸 전에서 올라오는 경우는 그 전 상황에서 2칸으로 올라오는  상황이어야함(3번연속 1칸씩 이동 불가능하기 때문)
			for (int i = 3; i <=n; i++) {
				// 2칸전(dp[i-2])에서 올라오는 경우는 제약조건이 없다
				int tmp1=dp[i-2];
				// 1칸전(map[i-1])에서 올라오는 경우는 제약조건이 잇다
				// 3연속 1칸이동이 되면 안되므로 map[i-1]기준 2칸 전인 dp[i-3]값을 밟고 올라감 
				int tmp2=dp[i-3]+map[i-1];
				dp[i]=Math.max(tmp1, tmp2)+map[i];
			}
			System.out.println(dp[n]);
		}
	}
	
	
}
