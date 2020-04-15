import java.util.Scanner;

public class Solution_D4_9282 {

	static Scanner sc=new Scanner(System.in);
	static int[][]map;
	static int[][][][]dp;
	
	public static void main(String[] args) {
	
		int t=sc.nextInt();
		
		for (int tc = 1; tc <=t; tc++) {
			int row=sc.nextInt();
			int col=sc.nextInt();
			
			map=new int[row][col];
			dp=new int[row+1][col+1][row+1][col+1];
			
			for (int i = 0; i <= row; i++) {
				for (int j = 0; j <=col; j++) {
					for (int k = 0; k <=row; k++) {
						for (int p = 0; p <=col; p++) {
							dp[i][j][k][p]=Integer.MAX_VALUE;
						}
					}
				}
			}
			
			for (int i = 0; i <row; i++) {
				for (int j = 0; j <col; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			System.out.println("#"+tc+" "+dfs(0,0,row,col));
		}
	}
	
	public static int dfs(int x, int y, int row, int col) {
		
		if(row == 1 && col == 1) {
			return 0;
		}
		
		int sum=0;
		
		for (int i = x; i < x+row; i++) {
			for (int j = y; j < y+col; j++) {
				sum+=map[i][j];
			}
		}
		
		//가로로 자르기
		for (int i = 1; i < row; i++) {
			// 위쪽
			if(dp[x][y][i][col]==Integer.MAX_VALUE)
				dp[x][y][i][col]=dfs(x,y,i,col);
			// 아래
			if(dp[x+i][y][row-i][col]==Integer.MAX_VALUE)
				dp[x+i][y][row-i][col]=dfs(x+i,y,row-i,col);
			
			int tmp=sum+dp[x][y][i][col]+dp[x+i][y][row-i][col];
			dp[x][y][row][col]=Math.min(dp[x][y][row][col], tmp);
		}
		
		// 세로로 자르기
		for (int i = 1; i < col; i++) {
			// 왼쪽
			if(dp[x][y][row][i]==Integer.MAX_VALUE)
				dp[x][y][row][i]=dfs(x,y,row,i);
			// 오른
			if(dp[x][y+i][row][col-i]==Integer.MAX_VALUE)
				dp[x][y+i][row][col-i]=dfs(x,y+i,row,col-i);
			
			int tmp=sum+dp[x][y][row][i]+dp[x][y+i][row][col-i];
			dp[x][y][row][col]=Math.min(dp[x][y][row][col], tmp);
		}
		
		return dp[x][y][row][col];
	}
}
