import java.util.Scanner;

public class Solution_D3_2806 {

	static Scanner sc=new Scanner(System.in);
	static boolean[][]map;
	static int[][]dir= {{-1,-1},{-1,0},{-1,1},{0,-1},{0,1}};
	static int n;
	static int res;
	
	public static void main(String[] args) {
	
		int tc=sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			n=sc.nextInt();
			map=new boolean[n][n];
			res=0;
			for (int i = 0; i < n; i++) {
				dfs(0,i);
			}
			System.out.println("#"+t+" "+res);
		}
	}
	
	private static void dfs(int row, int col) {
		
		if(row==n-1) {
			res++;
			return;
		}
		
		map[row][col]=true;
		
		for (int i = 0; i < n; i++) {
			if(valid(row+1,i)) {
				dfs(row+1,i);
			}
		}
		
		map[row][col]=false;
		
	}
	
	private static boolean valid(int row, int col) {
		
		for (int i = 0; i < dir.length; i++) {
			int nx=row+dir[i][0];
			int ny=col+dir[i][1];
			while(true) {
				if(nx<0 || ny<0 || nx>=n || ny>=n) {
					break;
				}
				
				if(map[nx][ny])
					return false;
				
				nx+=dir[i][0];
				ny+=dir[i][1];
			}
		}
		return true;
	}
}
