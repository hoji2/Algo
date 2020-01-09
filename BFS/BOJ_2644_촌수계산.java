import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2644_촌수계산 {

	static Scanner sc=new Scanner(System.in);
	static Queue<Integer>tmp=new LinkedList<Integer>();
	static int n;
	static boolean isFind=false;

	public static void main(String[] args) {
	
		n=sc.nextInt();

		int[][]map=new int[n+1][n+1];
		boolean []visit=new boolean[n+1];
		
		int st=sc.nextInt();
		int find;
		
		tmp.add(st);
		visit[st]=true;
		find=sc.nextInt();
		
		
		int loop=sc.nextInt();
		
		for (int i = 0; i < loop; i++) {
			int x=sc.nextInt();
			int y=sc.nextInt();
			map[x][y]=1;
			map[y][x]=1;
		}

		int q=bfs(map,visit,find);
		
		if(!isFind)
			System.out.println(-1);
		else
			System.out.println(q);
		
	}
	
	public static int bfs(int [][]map, boolean[]visit, int find) {
		
		int cnt=1;
		
		while(!tmp.isEmpty()) {
			
			int loop=tmp.size();
			for (int i = 0; i < loop; i++) {
				int pre=tmp.poll();
				for (int j = 1; j <= n; j++) {
					if(map[pre][j]==1 && !visit[j]) {
						if(j==find) {
							isFind=true;
							return cnt;
						}
						
						visit[j]=true;
						tmp.add(j);
					}
				}
			}
			
			cnt++;
		}
		
		return cnt;
		
	}
	
	
}
