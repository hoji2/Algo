import java.util.Scanner;

public class BOJ_1021_유기농배추 {

	// 입력 : col부터
	// char[][]의 경우 default로 아무 값도 안들어가있음 
	// cf) int[][]의 경우 default=0
	
	static Scanner sc=new Scanner(System.in);
	static int row, col, cnt;
	static int[][]map;
	
	public static void main(String[] args) {
		
		int tc=sc.nextInt();
		for (int i = 0; i < tc; i++) {
			col=sc.nextInt();
			row=sc.nextInt();
			cnt=sc.nextInt();
			map=new int[row][col];
			
			for (int j = 0; j < cnt; j++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				map[b][a]=1;
			}
			
			int res=0;
			
			for (int k = 0; k < row; k++) {
				for (int j = 0; j < col; j++) {
					if(map[k][j]==1) {
						res++;
						dfs(k,j);
					}
				}
			}
			System.out.println(res);
		}
	}
	
	public static void dfs(int x, int y) {
		
		// break조건
		if(x<0 || y<0 || x>=row || y>=col || map[x][y]==0)
			return;
		
		// 방문표시
		map[x][y]=0;
		
		dfs(x+1,y);
		dfs(x-1,y);
		dfs(x,y+1);
		dfs(x,y-1);
	}
	
}