import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {

	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	// 상 좌 하 우
	static int[][]dir= {{-1,0},{0,-1},{1,0},{0,1}};
	static char[][]map;
	// boolean 배열 필요 x -> 방문한 지점은 map을 바꿔버리자
	static int n;
	static LinkedList<Integer> res=new LinkedList<Integer>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		n=Integer.parseInt(br.readLine());
		map=new char[n][n];
		
		for (int i = 0; i < n; i++) {
			map[i]=br.readLine().toCharArray();
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j]=='1')
//					res.add(dfs(i,j));
					res.add(dfs2(i,j));
//					res.add(bfs(i,j));
			}
		}
		
		res.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		});
		
		res.addFirst(res.size());
		
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}
		
	}
	
	public static int dfs(int x, int y) {
		
		// 방문기록
		int tmp=1;
		map[x][y]='0';
		
		for (int i = 0; i < dir.length; i++) {
			int nx=x+dir[i][0];
			int ny=y+dir[i][1];
			
			if(nx>=0 && ny>=0 && nx<n && ny<n && map[nx][ny]=='1') {
				tmp+=dfs(nx,ny);
			}
		}
		
		return tmp;
	}
	
	public static int dfs2(int x, int y) {
		if(x<0 || y<0 || x>=n || y>=n || map[x][y]=='0')
			return 0;
		
		// 방문한 정점을 visit배열 대신 map배열을 사용
		map[x][y]='0';
		return 1+dfs2(x+1,y)+dfs2(x-1,y)+dfs2(x,y+1)+dfs2(x,y-1);
	}
	
	public static int bfs(int x, int y) {
		
		int tmp=0;
		
		Queue<point> info=new LinkedList<point>();
		info.add(new point(x, y));
		map[x][y]='0';
		
		while(!info.isEmpty()) {
			point p=info.poll();
			tmp++;
					
			for (int i = 0; i < dir.length; i++) {
				int nx=p.x+dir[i][0];
				int ny=p.y+dir[i][1];
				
				if(nx>=0 && ny>=0 && nx<n && ny<n && map[nx][ny]=='1') {
					map[nx][ny]='0';
					info.add(new point(nx, ny));
				}
			}
		}
		return tmp;
	}
}

class point{
	int x,y;
	
	public point(int x, int y) {
		this.x=x;
		this.y=y;
	}
}
