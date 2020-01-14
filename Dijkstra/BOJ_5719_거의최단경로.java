import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_5719_거의최단경로 {

	static Scanner sc=new Scanner(System.in);
	static int n;
	static Comparator<point>comp;
	static int[][]map;
	static int[]dp;
	
	public static void main(String[] args) {
		
		comp=new Comparator<point>() {
			@Override
			public int compare(point o1, point o2) {
				// TODO Auto-generated method stub
				return o1.val-o2.val;
			}
		};
		
		while(true) {
			n=sc.nextInt();
			int v=sc.nextInt();
			
			if(n==0 && v==0)
				break;
			
			map=new int[n][n];
			
			int st=sc.nextInt();
			int end=sc.nextInt();
			
			for (int i = 0; i < v; i++) {
				map[sc.nextInt()][sc.nextInt()]=sc.nextInt();
			}
	
			// 최단경로 찾은 후 bfs돌려서 map 지우기
			solve(st, end, true);
			// 이후 최단경로(=거의최단경로) 탐색
			solve(st, end, false);
		}
	}
	
	// 최단경로찾기
	public static void solve(int st, int end, boolean remove) {

		dp=new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[st]=0;
		
		Queue<point>pq=new PriorityQueue<point>(comp);
		pq.add(new point(st, 0));
		
		while(!pq.isEmpty()) {
			point p=pq.poll();
			
			//이 순간 최단경로에 위치한다 -> 최단경로값은 dp에 들어있는 상태
			if(p.num==end) {
				if(remove)
					bfs(end);
				
				break;
			}
			
			for (int i = 0; i < n; i++) {
				if(map[p.num][i]!=0) {
					int tmp1=dp[i];
					int tmp2=dp[p.num]+map[p.num][i];
					dp[i]=Math.min(tmp1, tmp2);
					if(dp[i]!=tmp1) {
						pq.add(new point(i, dp[i]));
					}
				}
			}
		}
		
		if(!remove)
			if(dp[end]>=Integer.MAX_VALUE || dp[end]<=0)
				System.out.println(-1);
			else
				System.out.println(dp[end]);
	}
	
	public static void bfs(int end) {
		Queue<Integer>queue=new LinkedList<Integer>();
		queue.add(end);
		
		while(!queue.isEmpty()) {
			// 도착점 (최초는 end, 그 앞단은 queue에 이전에 add한 i값) 와 연결된 간선 탐색
			int check=queue.poll();
			for (int i = 0; i < n; i++) {
				// 도착지인 check에 간선이 존재하고,
				// bfs이전에 다익스트라 탐색했던 dp[check]는 최단거리
				// dp[check]=dp[i]+map[i][check]인 경우가 연결된 여러 간선 중 최단거리에 해당한다
				// 위 두 조건을 만족하면 map을 갱신하고 다음으로 check해야하는 새로운 위치 i를 queue에 add
				if(map[i][check]!=0 && dp[check]==dp[i]+map[i][check]) {
					map[i][check]=0;
					queue.add(i);
				}
			}
		}
	}
}

class point{
	int num,val;
	
	public point(int num, int val) {
		this.num=num;
		this.val=val;
	}
}