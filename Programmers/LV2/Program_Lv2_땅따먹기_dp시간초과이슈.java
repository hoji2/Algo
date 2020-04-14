
public class Program_Lv2_땅따먹기_dp시간초과이슈 {

	//https://camelsource.tistory.com/42
	static int[][]dp;
	public static void main(String[] args) {
	
		int[][]map= {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		
		dp=new int[map.length][4];
		dp[0]=map[0];
		
		for (int i = 1; i < map.length; i++) {
			dp[i][0]=map[i][0]+Math.max(dp[i-1][1], Math.max(dp[i-1][2],dp[i-1][3]));
			dp[i][1]=map[i][1]+Math.max(dp[i-1][0], Math.max(dp[i-1][2],dp[i-1][3]));
			dp[i][2]=map[i][2]+Math.max(dp[i-1][0], Math.max(dp[i-1][1],dp[i-1][3]));
			dp[i][3]=map[i][3]+Math.max(dp[i-1][0], Math.max(dp[i-1][1],dp[i-1][2]));
		}
		
		int res=-1;
		for (int i = 0; i < 4; i++) {
			res=Math.max(res, dp[map.length-1][i]);
		}
		System.out.println(res);
	}
	
// 아래와 같이 col을 0~3까지 4번 dfs를 호출하여 결과낼 경우 시간초과 남	
	
//	public static void dfs(int cur_row, int bef_col, int[][]map) {
//		// idx 0 부터임 마지막(map.length-1)에 도착하면 return
//		// map.length 인덱스부터 다음으로 이동할 공간이 없으므로
//		if(cur_row==map.length-1)
//			return;
//		
//		// i,j는 col의 idx
//		for (int j = 0; j < 4; j++) {
//			if(bef_col !=j) {
//				int nr=cur_row+1;
//				
//				// 방문한 적이 없거나 기존값보다 큰 값이 들어오는 경우에 재귀 호출
//				int nv=dp[cur_row][bef_col]+map[nr][j];
//				if(dp[nr][j]<nv) {
//					dp[nr][j]=nv;
//					dfs(nr,j,map);
//				}
//			}
//		}
//	}
}
