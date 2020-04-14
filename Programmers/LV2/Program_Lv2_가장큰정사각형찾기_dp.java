
public class Program_Lv2_가장큰정사각형찾기_dp {

	//dp 적용
	//https://codedrive.tistory.com/53
	
	static int res=Integer.MIN_VALUE;
	static int[][]dp;
	public static void main(String[] args) {
		
		int[][]map= {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		dp=new int[map.length][map[0].length];
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				dp[i][j]=map[i][j];
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				if(dp[i][j]!=0) {
					if(i-1>=0 && j-1>=0) {
						dp[i][j]=Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+map[i][j];
					}
				}
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				res=Math.max(res, dp[i][j]);
			}
		}
		
		if(res==1)
			System.out.println(1);
		else
			System.out.println(res*res);
		
	}
}
