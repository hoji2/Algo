import java.util.Scanner;

public class Solution_D3_2814 {

	static Scanner sc=new Scanner(System.in);
	static boolean[][]map;
	static boolean[]visit;
	static int n,res;
	public static void main(String[] args) {
	
		int tc=sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			
			n=sc.nextInt();
			map=new boolean[n+1][n+1];
			res=0;
			int m=sc.nextInt();
			
			for (int i = 0; i < m; i++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				map[a][b]=true;
				map[b][a]=true;
			}
			
			visit=new boolean[n+1];
			for (int i = 1; i <=n; i++) {
				dfs(i,1);
			}
			
			System.out.println("#"+t+" "+res);
		}
	}
	
	private static void dfs(int cur, int cnt) {
		
		visit[cur]=true;
				
		for (int i = 1; i <=n; i++) {
			if(!visit[i] && map[cur][i]) {
				dfs(i,cnt+1);
			}
		}
		
		visit[cur]=false;
		res=Math.max(res, cnt);
	}
}
