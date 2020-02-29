import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_보물섬 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static int r,c;
	static int[][]dir= {{-1,0},{0,-1},{1,0},{0,1}};
	static char[][]map;
	
	public static void main(String[] args) throws IOException {
	
		StringTokenizer st=new StringTokenizer(br.readLine());
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		map=new char[r][c];
		
		int res=Integer.MIN_VALUE;
		
		for (int i = 0; i < r; i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if(map[i][j]=='L') {
					res=Math.max(res, bfs(i,j));
				}
			}
		}
		System.out.println(res-1);
	}
	
	public static int bfs(int x, int y) {
		int cnt=0;
		boolean[][]visit=new boolean[r][c];
		Queue<point> tmp=new LinkedList<point>();
		
		visit[x][y]=true;
		tmp.add(new point(x, y));
		
		while(!tmp.isEmpty()) {
			int loop=tmp.size();
			
			for (int i = 0; i < loop; i++) {
				point p=tmp.poll();
				for (int j = 0; j < dir.length; j++) {
					int nx=p.x+dir[j][0];
					int ny=p.y+dir[j][1];
					
					if(nx>=0 && ny>=0 && nx<r && ny<c && map[nx][ny]=='L' && !visit[nx][ny]) {
						visit[nx][ny]=true;
						tmp.add(new point(nx, ny));
					}
				}
			}
			cnt++;
		}
		
		return cnt;
	}
}

class point{
	int x,y;
	public point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}


