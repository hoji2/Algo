import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11724_연결요소의개수 {

	static Scanner sc=new Scanner(System.in);
	static int[][]map;
	static boolean[]visit;
	static int n,res=0;
	
	public static void main(String[] args) {
	
		n=sc.nextInt();
		int v=sc.nextInt();
		map=new int[n+1][n+1];
		visit=new boolean[n+1];
		
		for (int i = 0; i < v; i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			map[a][b]=1;
			map[b][a]=1;
		}
		
		for (int i = 1; i <=n; i++) {
			if(!visit[i]) {
				res++;
				dfs(i);
				//bfs(i);
			}
		}
		System.out.println(res);
	}
	
	public static void dfs(int x) {
		for (int i = 1; i <=n; i++) {
			if(map[x][i]==1 && !visit[i]) {
				visit[i]=true;
				dfs(i);
			}
		}
		return;
	}
	
	public static void bfs(int st) {
		
		Queue<Integer> tmp=new LinkedList<Integer>();
		
		tmp.add(st);
		visit[st]=true;
		
		while(!tmp.isEmpty()) {
			int v=tmp.poll();
			for (int i = 1; i <=n; i++) {
				if(map[v][i]==1 && !visit[i]) {
					visit[i]=true;
					tmp.add(i);
				}
			}
		}
	}
	
	
}
