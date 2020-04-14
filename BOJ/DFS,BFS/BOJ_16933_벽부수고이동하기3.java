import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16933_벽부수고이동하기3 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int row,col,k;
	static char[][]map;
	//방문case : 낮/밤,부순횟수,x,y
	static boolean[][][][]visit;
	static int[][]dir= {{-1,0},{0,-1},{0,0},{1,0},{0,1}};
	
	public static void main(String[] args) throws Exception {
		
		// 벽을 부수고 이동하는 경우에는 낮만 가능
		// 벽을 안부수고 이동하면 낮,밤가능
		StringTokenizer st=new StringTokenizer(br.readLine());
		row=Integer.parseInt(st.nextToken());
		col=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		map=new char[row][col];
		// 0/1 : 낮/밤
		visit=new boolean[2][k+1][row][col];
		
		for (int i = 0; i < row; i++)
			map[i]=br.readLine().toCharArray();
		
		solve();
	}
	
	public static void solve() {
		
		PriorityQueue<point>pq=new PriorityQueue<point>(new Comparator<point>() {

			@Override
			public int compare(point o1, point o2) {
				return o1.cost-o2.cost;
			}
		});
		
		pq.add(new point(0, 0, 1, 0));
		visit[0][0][0][0]=true;
		visit[1][0][0][0]=true;
		
		// 0/1 : 낮/밤
		int morning=0;
		while(!pq.isEmpty()) {
			
			// 낮/밤을 구분하기 위해 loop 필요
			int loop=pq.size();
			for (int l = 0; l < loop; l++) {
				point cur=pq.poll();
				
				if(cur.x==row-1 && cur.y==col-1) {
					System.out.println(cur.cost);
					return;
				}
				
				if(cur.limit>k) continue;
				
				for (int i = 0; i < dir.length; i++) {
					int nx=cur.x+dir[i][0];
					int ny=cur.y+dir[i][1];
					
					if(nx<0 || ny<0 || nx>=row || ny>=col) continue;
					
					
					//움직이려는 장소가 벽x -> 낮/밤, limit에 상관없이 이동가능
					if(map[nx][ny]=='0') {
						//(중요) 현재상태에서 움직일 수 있는지 여부
						if(!visit[morning][cur.limit][nx][ny]) {
							visit[morning][cur.limit][nx][ny]=true;
							pq.add(new point(nx, ny, cur.cost+1, cur.limit));
						}
					}
					// 움직이려는 장소가 벽 o
					else {
						// 낮에만 벽을 부수고 이동 가능
						if(morning==0) {
							//방문여부 && limit의 개수가 남아있는 경우에만 이동
							//(중요) cur.lmit+1<=k인 경우에만 벽을 부수고 limit를 증가하여 pq에 담을 수 있다.
							if(cur.limit+1<=k && !visit[morning][cur.limit][nx][ny]) {
								visit[morning][cur.limit][nx][ny]=true;
								pq.add(new point(nx, ny, cur.cost+1, cur.limit+1));
							}
						}
						// 밤이면 제자리에 있는 경우
						else {
							if(i==2) {
								visit[morning][cur.limit][nx][ny]=true;
								pq.add(new point(nx, ny, cur.cost+1, cur.limit));
							}
						}
					}
				}
			}
			
			morning=1-morning;
		}
		
		System.out.println(-1);
	}
}

class point{
	int x,y,cost,limit;
	public point(int x, int y, int cost, int limit) {
		this.x=x;
		this.y=y;
		this.cost=cost;
		this.limit=limit;
	}
}
