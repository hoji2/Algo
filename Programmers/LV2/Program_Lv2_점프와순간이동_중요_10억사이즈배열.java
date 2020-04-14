import java.util.Arrays;

public class Program_Lv2_점프와순간이동_중요_10억사이즈배열 {

	public static void main(String[] args) {
		
		int n=5000;
		
		int ans=0;
		
		//도착 -> 출발점으로 간다
		//출발점 0에 도착하면 끝
		while(n!=0) {
			// 순간이동해서 올수 있으면 순간이동 백
			if(n%2==0)
				n/=2;
			
			// 아니면 출발->도착 방향으로 점프(+1)를 한 경우이므로 반대로 -1하고 점프 개수 +1
			else {
				n-=1;
				ans++;
			}
		}
		
		System.out.println(ans);
	}
	
	/*
	 * 
	 * dp배열 사용했을 시 효율성테스트 통과x
	 * 
	static int[]dp;
	public static void main(String[] args) {
		
		int n=5000;
		dp=new int[n+1];
		Arrays.fill(dp,Integer.MAX_VALUE);
		// 중요 : 무한루프 조심 -> 0*2=0 -> 무한루프  돔
		// 순간이동을 하려면 일단 점프 한번은 필수이므로 한칸점프해서 cur=1, cost=1 에서 시작
		dfs(1,1,n);
		System.out.println(dp[n]);
	
	}
	
	public static void dfs(int cur, int cost, int end) {
		
		if(cur>end)
			return;
			
		if(dp[cur]>cost) {
			dp[cur]=cost;
			dfs(cur*2,cost,end);
			dfs(cur+1,cost+1,end);
		}
	}
	*/
}
