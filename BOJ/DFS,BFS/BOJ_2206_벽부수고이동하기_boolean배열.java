import java.util.*;
import java.io.*;

//https://heekim0719.tistory.com/312
public class BOJ_2206_벽부수고이동하기_boolean배열 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int row,col;
	static int[][]dir={{-1,0},{0,-1},{1,0},{0,1}};
	static char[][]map;
	static boolean[][][]visit;
	
	public static void main(String[] args) throws Exception {
	
		StringTokenizer st=new StringTokenizer(br.readLine());
		row=Integer.parseInt(st.nextToken());
		col=Integer.parseInt(st.nextToken());
		
		map=new char[row][col];
		
		visit=new boolean[2][row][col];
		
		for (int i = 0; i < row; i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		System.out.println(solve());
	}
	public static int solve() {
	
		PriorityQueue<point2>pq=new PriorityQueue<point2>(new Comparator<point2>() {
			@Override
			public int compare(point2 o1, point2 o2) {
				// TODO Auto-generated method stub
				return o1.cost-o2.cost;
			}
		});
		
		pq.add(new point2(0, 0, 1, 0));
		visit[0][0][0]=true;
		visit[1][0][0]=true;
		
		while(!pq.isEmpty()) {
			
			point2 cur=pq.poll();
			if(cur.x==row-1 && cur.y==col-1) {
				return cur.cost;
			}
			for (int i = 0; i < dir.length; i++) {
				int nx=cur.x+dir[i][0];
				int ny=cur.y+dir[i][1];
				
				if(nx<0 || ny<0 || nx>=row || ny>=col) continue;
				
				//벽 x
				if(map[nx][ny]=='0') {
					// 벽을 부셨던 말던 이동할 수 있다.
					// 다음 좌표를 방문한적이 없는 경우만 check
					if(!visit[cur.chance][nx][ny]) {
						visit[cur.chance][nx][ny]=true;
						pq.add(new point2(nx, ny, cur.cost+1, cur.chance));
					}
				}
				//벽 o
				else {
					// 벽을 부시고 들어갈 수 있는 경우 && 다음 좌표를 방문한적이 없는 경우
					if(cur.chance==0 && !visit[1][nx][ny]) {
						// 벽을 부시고(1) nx,ny에 방문을 표시
						visit[1][nx][ny]=true;
						// 다음 상태로 넘길 때 벽을 부셨기에 chance는 1
						pq.add(new point2(nx, ny, cur.cost+1, 1));
					}
				}
			}
		}
		return -1;
	}
}

class point2{
	// 벽을 뚫을 수 있는 chance 변수 필요
	int x,y,cost,chance;
	public point2(int x, int y, int cost, int chance) {
		this.x=x;
		this.y=y;
		this.cost=cost;
		this.chance=chance;
		
	}
}