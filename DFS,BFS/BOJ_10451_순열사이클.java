import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_10451_순열사이클 {

	static Scanner sc=new Scanner(System.in);
	static int[][]map;
	static boolean[]visit;
	static int n;
	
	public static void main(String[] args) {
	
		int tc=sc.nextInt();
		
		for (int i = 0; i < tc; i++) {
			
			n=sc.nextInt();
			map=new int[n+1][n+1];
			visit=new boolean[n+1];
			
			for (int j = 1; j <=n; j++) {
				int p=sc.nextInt();
				map[j][p]=1;
			}
			
			int res=0;
			
			for (int j = 1; j <=n; j++) {
				if(!visit[j]) {
					res++;
//					dfs(j);
					bfs(j);
				}
			}
			
			System.out.println(res);
		}
	}
	
	public static void dfs(int st) {
		
		visit[st]=true;
		
		for (int i = 1; i <=n; i++) {
			if(map[st][i]==1 && !visit[i])
				dfs(i);
		}
	}
	
	public static void bfs(int st) {
		
		Queue<Integer> tmp= new LinkedList<Integer>();
		tmp.add(st);
		
		while(!tmp.isEmpty()) {
			int p=tmp.poll();
			visit[p]=true;
			
			for (int i = 1; i <=n; i++) {
				if(map[p][i]==1 && !visit[i])
					tmp.add(i);
			}
		}
	}
}
