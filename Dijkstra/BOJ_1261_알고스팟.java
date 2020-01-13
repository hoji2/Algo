import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1261_알고스팟 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		int col=Integer.parseInt(st.nextToken());
		int row=Integer.parseInt(st.nextToken());
		
		char[][]map=new char[row][col];
		int[][]dp=new int[row][col];
		// 4방향 탐색에 필요한 visit배열
		boolean[][]visit=new boolean[row][col];
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if(i==0 && j==0)
					dp[i][j]=0;
				else
					dp[i][j]=Integer.MAX_VALUE;
			}
		}
		
		int [][]dir= {{-1,0},{0,-1},{0,1},{1,0}};
		
		
		for (int i = 0; i < row; i++) {
			st=new StringTokenizer(br.readLine());
			map[i]=st.nextToken().toCharArray();
		}
		
		Queue<point> pq=new PriorityQueue<point>(new Comparator<point>() {

			@Override
			public int compare(point o1, point o2) {
				return o1.val-o2.val;
			}
		});
		
		pq.add(new point(0, 0, 0));
		visit[0][0]=true;
		
		while(!pq.isEmpty()) {

			point p=pq.poll();
			//break 조건 : 도착했을 때 이미 val은 최소값이고 그 최소값을 출력 후 종료
			if(p.x==row-1 && p.y==col-1) {
				System.out.println(p.val);
				break;
			}
				
			for (int i = 0; i < dir.length; i++) {

				int tx=p.x+dir[i][0];
				int ty=p.y+dir[i][1];
				
				if(tx>=0 && ty>=0 && tx<row && ty<col && !visit[tx][ty]) {
					
					// 4방향 방문처리 : 이미 방문했던 곳은 탐색 X
					visit[tx][ty]=true;

					// 다음 장소에 map이 0이면 다음 dp[tx][ty]에 이전 값 dp[p.x][p,y]그대로 넣기
					// dp 배열도 갱신
					if(map[tx][ty]=='0') {
						dp[tx][ty]=dp[p.x][p.y];
						pq.add(new point(tx, ty, dp[tx][ty]));
					}
					// 다음 장소에 map이 1이면 다음 dp[tx][ty]에 이전 값 dp[p.x][p,y]+1(벽) 갱신하여 넣기
					// dp 배열도 갱신
					else {
						int tmp2=dp[p.x][p.y]+1;
						dp[tx][ty]=tmp2;
						pq.add(new point(tx, ty, tmp2));
					}

				}
			}
			
		}
		
	}
}

class point{
	int x, y,val;
	
	public point(int x, int y, int val) {
		this.x=x;
		this.y=y;
		this.val=val;
	}
}