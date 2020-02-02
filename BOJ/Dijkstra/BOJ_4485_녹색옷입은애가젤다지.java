import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_4485_녹색옷입은애가젤다지 {

	static Scanner sc=new Scanner(System.in);
	static int n;
	static Comparator<point>comp;
	static int[][]dir= {{-1,0},{0,-1},{0,1},{1,0}};
	
	public static void main(String[] args) {
	
		int tc=1;
		comp=new Comparator<point>() {

			@Override
			public int compare(point o1, point o2) {
				// TODO Auto-generated method stub
				return o1.val-o2.val;
			}
		};
		
		
		while(true) {
			n=sc.nextInt();
			if(n==0)
				break;
			
			int[][]map=new int[n][n];
			int[][]dp=new int[n][n];
			boolean[][]visit=new boolean[n][n];
			Queue<point> pq=new PriorityQueue<point>(comp);
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j]=sc.nextInt();
				}
			}
			
			for (int i = 0; i < n; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE);
			}
			
			dp[0][0]=map[0][0];
			pq.add(new point(0, 0, dp[0][0]));
			
			while(!pq.isEmpty()) {
				point p=pq.poll();
				visit[p.x][p.y]=true;
				
				if(p.x==n-1 && p.y==n-1)
					break;
				
				for (int i = 0; i < dir.length; i++) {
					int dx=p.x+dir[i][0];
					int dy=p.y+dir[i][1];
					
					if(dx>=0 && dy>=0 && dx<n && dy<n && !visit[dx][dy]) {
						int tmp1=dp[dx][dy];
						int tmp2=dp[p.x][p.y]+map[dx][dy];
						dp[dx][dy]=Math.min(tmp1, tmp2);
						if(tmp1!=dp[dx][dy])
							pq.add(new point(dx, dy, dp[dx][dy]));
					}
						
				}
			}
			
			System.out.println("Problem "+tc+": "+dp[n-1][n-1]);
			tc++;
			
		}
	}
}

class point{
	int x,y,val;
	
	public point(int x, int y, int val) {
		this.x=x;
		this.y=y;
		this.val=val;
	}
}