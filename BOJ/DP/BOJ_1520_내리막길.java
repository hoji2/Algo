import java.util.Scanner;

public class BOJ_1520_내리막길 {

	static Scanner sc=new Scanner(System.in);
	static int[][]map,dp;
	static int row,col,cnt=0;
	static int[][]dir= {{-1,0},{0,-1},{1,0},{0,1}};
	
	public static void main(String[] args) {
	
		row=sc.nextInt();
		col=sc.nextInt();
		map=new int[row][col];
		dp=new int[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j]=sc.nextInt();
				dp[i][j]=-1;
			}
		}
		
		System.out.println(dfs(0,0));
	}
	
	private static int dfs(int x, int y) {
		
		if(x==row-1 && y==col-1)
			return 1;
		
		if(dp[x][y]!=-1)
			return dp[x][y];
		
		dp[x][y]=0;
		
		for (int i = 0; i < dir.length; i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			
			if(nx<0 || ny<0 || nx>=row || ny>=col) continue;
			
			if(map[nx][ny]<map[x][y])
				dp[x][y]+=dfs(nx,ny);
		}
		
		return dp[x][y];
	}
}

