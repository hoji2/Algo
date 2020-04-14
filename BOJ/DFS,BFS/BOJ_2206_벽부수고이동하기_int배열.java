import java.util.*;
import java.io.*;

//https://kim6394.tistory.com/201
public class BOJ_2206_벽부수고이동하기_int배열 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int row,col;
	static int[][]dir={{-1,0},{0,-1},{1,0},{0,1}};
	static char[][]map;
	static int[][]visit;
	
	public static void main(String[] args) throws Exception {
	
		StringTokenizer st=new StringTokenizer(br.readLine());
		row=Integer.parseInt(st.nextToken());
		col=Integer.parseInt(st.nextToken());
		
		map=new char[row][col];
		
		visit=new int[row][col];
		
		for (int i = 0; i < row; i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		for (int i = 0; i < row; i++) {
			Arrays.fill(visit[i], Integer.MAX_VALUE);
		}
		
		System.out.println(solve());
	}
	public static int solve() {
	
		PriorityQueue<point>pq=new PriorityQueue<point>(new Comparator<point>() {
			@Override
			public int compare(point o1, point o2) {
				// TODO Auto-generated method stub
				return o1.cost-o2.cost;
			}
		});
		
		pq.add(new point(0, 0, 1, 0));
		visit[0][0]=0;
		
		while(!pq.isEmpty()) {
			
			point cur=pq.poll();
			if(cur.x==row-1 && cur.y==col-1) {
				return cur.cost;
			}
			for (int i = 0; i < dir.length; i++) {
				int nx=cur.x+dir[i][0];
				int ny=cur.y+dir[i][1];
				
				if(nx<0 || ny<0 || nx>=row || ny>=col) continue;
				
				
				if(visit[nx][ny]<=cur.chance) continue;
				
				if(map[nx][ny]=='0') {
					visit[nx][ny]=cur.chance;
					pq.add(new point(nx, ny, cur.cost+1, cur.chance));
				}else {
					if(cur.chance==0) {
						visit[nx][ny]=cur.chance+1;
						pq.add(new point(nx, ny, cur.cost+1, 1));
					}
				}
			}
		}
		return -1;
	}
}

class point{
	// 벽을 뚫을 수 있는 chance 변수 필요
	int x,y,cost,chance;
	public point(int x, int y, int cost, int chance) {
		this.x=x;
		this.y=y;
		this.cost=cost;
		this.chance=chance;
		
	}
}