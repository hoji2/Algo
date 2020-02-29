import java.util.Scanner;

public class BOJ_2606_바이러스 {

	static Scanner sc=new Scanner(System.in);
	static int n,res=0;
	static int[][]map;
	static boolean visit[];
	
	public static void main(String[] args) {
	
		n=sc.nextInt();
		map=new int[n+1][n+1];
		visit=new boolean[n+1];
		
		int k=sc.nextInt();
		
		for (int i = 0; i < k; i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			map[a][b]=1;
			map[b][a]=1;
		}
		
		visit[1]=true;
		solve(1);
		System.out.println(res);
	}
	
	public static void solve(int i) {
		
		for (int j = 1; j <= n; j++) {
			if(!visit[j] && map[i][j]==1) {
				visit[j]=true;
				res++;
				solve(j);
			}
		}
	}
}
